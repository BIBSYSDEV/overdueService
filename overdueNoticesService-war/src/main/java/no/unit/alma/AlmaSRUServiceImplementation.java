package no.unit.alma;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import no.bibsys.alma.sru.SRUClient;
import no.bibsys.alma.sru.SRUClientException;
import no.bibsys.appl.legalDeposit.ResultBean;
import no.bibsys.appl.legalDeposit.configuration.Configuration;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;

public class AlmaSRUServiceImplementation implements AlmaSRUService {

    private static final transient Logger log = LoggerFactory.getLogger(AlmaSRUServiceImplementation.class);
    private final SRUClient sruClient;

    public AlmaSRUServiceImplementation() {
        this(SRUClient.newBuilder().basePath(Configuration.ALMA_SRU_BASE_PATH).build());
    }

    public AlmaSRUServiceImplementation(SRUClient sruClient) {
        this.sruClient = sruClient;
    }

    private String searchRetrieveSRU(String cql, int maximumNumberOfRecords) {
        String result;
        try {
            ResultBean resultBean = ResultBean.fromSru(sruClient.search(cql, maximumNumberOfRecords));
            XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
            xstream.alias("result", ResultBean.class);
            result = (xstream.toXML(resultBean));
        } catch (SRUClientException e) {
            log.error(e.getMessage(), e);
            result = String.format("{\"error: %s\"}", e.getMessage());
        }
        return result;
    }

    @Override
    public String retrieveRecords(String title, String author, String isbnOrIssn, String mmsMaterialType, int maximumNumberOfRecords) {
        if (StringUtils.isEmpty(title) && StringUtils.isEmpty(author) && StringUtils.isEmpty(isbnOrIssn)) {
            throw new IllegalArgumentException("title, author or isbn must be given");
        }

        String cql = "";
        if (StringUtils.isNotEmpty(title)) {
            cql = "alma.title = \"" + title + "\"";
        }

        if (StringUtils.isNotEmpty(author)) {
            if ((!cql.isEmpty())) {
                cql += " AND ";
            }
            cql += "alma.creator = \"" + author + "\"";
        }

        if (StringUtils.isNotEmpty(isbnOrIssn)) {
            if ((!cql.isEmpty())) {
                cql += " AND ";
            }
            cql += "alma.isbn = \"" + isbnOrIssn + "\"";
            cql += " OR alma.issn = \"" + isbnOrIssn + "\"";
        }

        if (!(StringUtils.isEmpty(mmsMaterialType) || mmsMaterialType.equals("undefined"))) {
            if ((!cql.isEmpty())) {
                cql += " AND ";
            }
            if (mmsMaterialType.length() == 5) {
                cql += "alma.mms_material_type = \"" + mmsMaterialType.substring(0, 2) + "\"";
                cql += " OR alma.mms_material_type = \"" + mmsMaterialType.substring(3, 4) + "\"";
            } else {
                cql += "alma.mms_material_type = \"" + mmsMaterialType + "\"";
            }
        }
//            cql += " AND NOT alma.category_of_material = \"c\""; // physical description <> electronic resource
        cql += " sortBy alma.main_pub_date/sort.descending";

        String sruRecordAsJson = this.searchRetrieveSRU(cql, maximumNumberOfRecords);
        log.trace("SRU record for title={}, author={}, isbnOrIssn={}, mmsMaterialType={}\n{}",
            title, author, isbnOrIssn, mmsMaterialType, sruRecordAsJson);
        return sruRecordAsJson;
    }

    @Override
    public String retrieveRecords(String title, String author, String isbnOrIssn, String mmsMaterialType) {
        return retrieveRecords(title, author, isbnOrIssn, mmsMaterialType, 50);
    }

    @Override
    public String retrieveRecord(@Nonnull String mmsId) {
        String sruRecordAsJson = this.searchRetrieveSRU("alma.mms_id=" + mmsId, 50);
        log.trace("SRU record for mmsId {}\n{}", mmsId, sruRecordAsJson);
        return sruRecordAsJson;
    }
}
