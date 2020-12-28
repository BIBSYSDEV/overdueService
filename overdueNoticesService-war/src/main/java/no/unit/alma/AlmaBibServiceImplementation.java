package no.unit.alma;

import no.unit.alma.bibs.Bib;
import no.unit.alma.bibs.Bibs;
import no.unit.alma.commons.AlmaClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.ResponseProcessingException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class AlmaBibServiceImplementation implements AlmaBibService {

    private static final String BIBS_PATH = "bibs";
    public static final String EMPTY_STRING = "";
    //query parameters
    static final String EXPAND_PARAM = "expand";
    static final String VIEW_PARAM = "view";
    static final String MMS_ID_PARAM = "mms_id";
    static final String NZ_MMS_ID_PARAM = "nz_mms_id";
    static final String REPRESENTATION_ID_PARAM = "representation_id";
    static final String HOLDINGS_ID_PARAM = "holdings_id";
    static final String IE_ID_PARAM = "ie_id";
    static final String FROM_NZ_MMS_ID_PARAM = "from_nz_mms_id";
    //query parameter values
    static final String VIEW_PARAMETER_P_AVAIL = "p_avail";
    static final String EXPAND_PARAMETER_FULL = "full";

    private final transient WebTarget webTarget;
    private final String context;
    private final String contextValue;

    private static final transient Logger log = LoggerFactory.getLogger(AlmaBibServiceImplementation.class);


    public AlmaBibServiceImplementation(AlmaClient almaClient) {
        this.webTarget = almaClient.getWebTarget().path(BIBS_PATH);
        this.context = almaClient.getContext();
        this.contextValue = almaClient.getContextValue();
    }

    @Override
    public boolean createLinkedRecord(@Nonnull String mmsId) {
        if (StringUtils.isEmpty(mmsId)) {
            throw new IllegalArgumentException("mmsId is empty");
        }
        log.trace("Create linked record for mmsId {} at {}", mmsId, contextValue);
        try {
            Bib linkedRecord = webTarget
                .queryParam(FROM_NZ_MMS_ID_PARAM, mmsId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(new Bib()))
                .invoke(Bib.class);
            return linkedRecord != null;
        } catch (ResponseProcessingException e) {
            throw new WebApplicationException(AlmaErrorMessageHandler.getAlmaErrorMessage(e));
        }
    }

    @Override
    public Bibs getBibRecord(String mmsId) {
        if (StringUtils.isEmpty(mmsId)) {
            throw new IllegalArgumentException("mmsId is empty");
        }
        log.trace("get bibRecord for mmsId {} at {}", mmsId, contextValue);
        try {

            return
                webTarget.queryParam(MMS_ID_PARAM, mmsId)
                    .queryParam(IE_ID_PARAM, EMPTY_STRING)
                    .queryParam(HOLDINGS_ID_PARAM, EMPTY_STRING)
                    .queryParam(REPRESENTATION_ID_PARAM, EMPTY_STRING)
                    .queryParam(NZ_MMS_ID_PARAM, EMPTY_STRING)
                    .queryParam(VIEW_PARAM, VIEW_PARAMETER_P_AVAIL)
                    .queryParam(EXPAND_PARAM, EXPAND_PARAMETER_FULL)
                    .request()
                    .accept(MediaType.APPLICATION_XML)
                    .buildGet()
                    .invoke(Bibs.class);


        } catch (ResponseProcessingException e) {
            throw new WebApplicationException(AlmaErrorMessageHandler.getAlmaErrorMessage(e));
        }
    }

    @Override
    public Bibs getBibRecordByNZmmsId(String nz_mmsId) {
        if (StringUtils.isEmpty(nz_mmsId)) {
            throw new IllegalArgumentException("mmsId is empty");
        }
        log.trace("get bibRecord for mmsId {} at {}", nz_mmsId, contextValue);
        try {

            return
                webTarget.queryParam(MMS_ID_PARAM, EMPTY_STRING)
                    .queryParam(IE_ID_PARAM, EMPTY_STRING)
                    .queryParam(HOLDINGS_ID_PARAM, EMPTY_STRING)
                    .queryParam(REPRESENTATION_ID_PARAM, EMPTY_STRING)
                    .queryParam(NZ_MMS_ID_PARAM, nz_mmsId)
                    .queryParam(VIEW_PARAM, VIEW_PARAMETER_P_AVAIL)
                    .queryParam(EXPAND_PARAM, EXPAND_PARAMETER_FULL)
                    .request()
                    .accept(MediaType.APPLICATION_XML)
                    .buildGet()
                    .invoke(Bibs.class);


        } catch (ResponseProcessingException e) {
            throw new WebApplicationException(AlmaErrorMessageHandler.getAlmaErrorMessage(e));
        }
    }

    public String getContext() {
        return context;
    }

    public String getContextValue() {
        return contextValue;
    }


}
