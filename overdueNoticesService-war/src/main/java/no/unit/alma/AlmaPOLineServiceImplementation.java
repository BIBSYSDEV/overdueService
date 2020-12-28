package no.unit.alma;

import javax.ws.rs.client.Invocation;
import no.unit.alma.acquisitions.Notes;
import no.unit.alma.acquisitions.PoLine;
import no.unit.alma.acquisitions.PoLines;
import no.unit.alma.commons.AlmaClient;
import no.unit.alma.items.Item;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.ResponseProcessingException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class AlmaPOLineServiceImplementation implements AlmaPOLineService {

    private static final transient Logger log = LoggerFactory.getLogger(AlmaPOLineServiceImplementation.class);
    private static final String ACQUISITION_PATH = "acq";
    private static final String POLINES_PATH = "po-lines";
    private static final String ITEMS_PATH = "items";


    public static final String QUERY_PARAM_REASON = "reason";
    public static final String QUERY_PARAM_REASON_LIBRARY_CANCELLED = "LIBRARY_CANCELLED";
    public static final String QUERY_PARAM_COMMENT = "comment";
    public static final String QUERY_PARAM_DEFAULT_CANCELLATION_COMMENT = "*Cancellation via api.";
    public static final String QUERY_PARAM_INFORM_VENDOR = "inform_vendor";
    public static final String QUERY_PARAM_OVERRIDE = "override";
    public static final String QUERY_PARAM_BIB = "bib";
    public static final String QUERY_PARAM_BIB_RETAIN = "retain";
    public static final String QUERY_PARAM_ACQUISITION_METHOD = "acquisition_method";
    public static final String LEGAL_DEPOSIT_LEGAL_DEPOSIT_NOLETTER = "LEGAL_DEPOSIT,LEGAL_DEPOSIT_NOLETTER";
    public static final String QUERY_PARAM_Q = "q";
    public static final String QUERY_PARAM_STATUS = "status";
    public static final String ACTIVE = "ACTIVE";
    public static final String QUERY_PARAM_LIMIT = "limit";
    public static final String QUERY_PARAM_OFFSET = "offset";
    public static final String QUERY_PARAM_ORDER_BY = "order_by";
    public static final String QUERY_PARAM_DIRECTION = "direction";
    public static final String DESC = "desc";
    public static final String QUERY_PARAM_EXPAND = "expand";
    public static final String LOCATIONS_NOTES = "LOCATIONS,NOTES";
    public static final String QUERY_PARAM_LIBRARY = "library";
    public static final String QUERY_PRAM_OP = "op";
    public static final String RECEIVE = "receive";
    public static final String ALMA_ERROR_CODE_ITEM_ALREADY_RECEIVED = "401877";
    public static final String ALMA_ERROR_CODE_WHEN_TRANSACTION_FAILS = "401879";
    public static final String ALMA_ERROR_CODE_STALE_OBJECT_EXCEPTION = "401876";

    private final transient WebTarget acqTarget;
    private final String context;
    private final String contextValue;


    public AlmaPOLineServiceImplementation(AlmaClient almaClient) {
        this.acqTarget = almaClient.getWebTarget().path(ACQUISITION_PATH);
        this.context = almaClient.getContext();
        this.contextValue = almaClient.getContextValue();
    }

    @Override
    public PoLine create(@Nonnull PoLine poLine) {
        log.debug("Create poLine at {}", contextValue);
        PoLine resultPoLine = null;
        String almaErrorMessage = "";
        int maxTries = 3;
        for (int i = 0; i < maxTries; i++) {
            try {
                resultPoLine = invokePostPoLine(poLine);
                log.debug("POLine {} created at {}", resultPoLine.getNumber(), contextValue);
                break;
            } catch (ResponseProcessingException e) {
                String almaErrorCode = AlmaErrorMessageHandler.getAlmaErrorCode(e);
                if (ALMA_ERROR_CODE_STALE_OBJECT_EXCEPTION.equals(almaErrorCode) ||
                    ALMA_ERROR_CODE_WHEN_TRANSACTION_FAILS.equals(almaErrorCode)) {
                    log.debug("Skipping create poline at {}-{} cause of hybernate limbo, AlmaError: {}",
                        poLine.getOwner().getValue(),contextValue, AlmaErrorMessageHandler.getAlmaErrorMessage(e));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException interruptedException) {
                        // ignore
                    }
                } else {
                    almaErrorMessage = AlmaErrorMessageHandler.getAlmaErrorMessage(e);
                    log.error("Could not create poline at {}-{}, AlmaError({}) after {} times",
                        poLine.getOwner().getValue(), contextValue, almaErrorMessage, i);
                    break;
                }
            }
            if (resultPoLine != null) {
                log.debug("run createPoline for-loop {}-times (poline {})", i, resultPoLine.getNumber());
            } else {
                log.debug("run createPoline for-loop {}-times", i);
            }
        }
        if (!almaErrorMessage.isEmpty()) {
            throw new WebApplicationException(almaErrorMessage);
        } else {
            return resultPoLine;
        }
    }

    private PoLine invokePostPoLine(PoLine poLine) {
        return acqTarget
            .path(POLINES_PATH)
            .request()
            .accept(MediaType.APPLICATION_XML)
            .buildPost(Entity.xml(poLine))
            .invoke(PoLine.class);
    }

    @Override
    public PoLine get(@Nonnull String id) {
        if (StringUtils.isEmpty(id)) {
            throw new IllegalArgumentException("id is empty");
        }
        log.trace("Read poLine with id {} at {}", id, contextValue);
        try {
            return acqTarget
                .path(POLINES_PATH)
                .path(id)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(PoLine.class);
        } catch (ResponseProcessingException e) {
            log.error("Could not retrieve item with barcode {} at {}, AlmaError({})", id, contextValue,
                AlmaErrorMessageHandler.getAlmaErrorMessage(e));
            throw new WebApplicationException(AlmaErrorMessageHandler.getAlmaErrorMessage(e));
        }

    }

    @Override
    public PoLine update(@Nonnull PoLine poLine) {
        if (StringUtils.isEmpty(poLine.getNumber())) {
            throw new IllegalArgumentException("poLine.getNumber is empty");
        }
        log.trace("Update poLine {} at {}", poLine.getNumber(), contextValue);
        PoLine resultPoLine = null;
        String almaErrorMessage = "";
        int maxTries = 3;
        for (int i = 0; i < maxTries; i++) {
            try {
                resultPoLine = invokePut(poLine);
                log.debug("POLine {} updated at {}", resultPoLine.getNumber(), contextValue);
                break;
            } catch (ResponseProcessingException e) {
                String almaErrorCode = AlmaErrorMessageHandler.getAlmaErrorCode(e);
                if (ALMA_ERROR_CODE_STALE_OBJECT_EXCEPTION.equals(almaErrorCode) ||
                    ALMA_ERROR_CODE_WHEN_TRANSACTION_FAILS.equals(almaErrorCode)) {
                    log.debug("Skipping update poline at {}-{} cause of hybernate limbo, AlmaError: {}",
                        poLine.getOwner().getValue(),contextValue, AlmaErrorMessageHandler.getAlmaErrorMessage(e));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException interruptedException) {
                        // ignore
                    }
                } else {
                    almaErrorMessage = AlmaErrorMessageHandler.getAlmaErrorMessage(e);
                    log.error("Could not update poline {} at {}, AlmaError({})", poLine.getNumber(), contextValue,
                        AlmaErrorMessageHandler.getAlmaErrorMessage(e));
                    break;
                }
            }
            if (resultPoLine != null) {
                log.debug("run updatePoline for-loop {}-times (poline {})", i, resultPoLine.getNumber());
            } else {
                log.debug("run updatePoline for-loop {}-times", i);
            }
        }
        if (!almaErrorMessage.isEmpty()) {
            throw new WebApplicationException(almaErrorMessage);
        } else {
            return resultPoLine;
        }
    }

    private PoLine invokePut(PoLine poLine) {
        return acqTarget
            .path(POLINES_PATH)
            .path(poLine.getNumber())
            .request()
            .accept(MediaType.APPLICATION_XML)
            .buildPut(Entity.xml(poLine))
            .invoke(PoLine.class);
    }

    @Override
    public void delete(@Nonnull PoLine poLine) {
        if (StringUtils.isEmpty(poLine.getNumber())) {
            throw new IllegalArgumentException("poLine.getNumber is empty");
        }
        String comment = "*Cancellation via legalDeposit-Application.";
        Notes notes = poLine.getNotes();
        if (notes != null && !notes.getNotes().isEmpty()) {
            int size = notes.getNotes().size();
            if (size > 0) {
                comment = notes.getNotes().get(size - 1).getNoteText(); //the last note
            }
        }
        log.trace("Delete poLine {} at {}. Comment: {}", poLine.getNumber(), contextValue, comment);
        try {
            acqTarget
                .path(POLINES_PATH)
                .path(poLine.getNumber())
                .queryParam(QUERY_PARAM_REASON, QUERY_PARAM_REASON_LIBRARY_CANCELLED)
                .queryParam(QUERY_PARAM_COMMENT, QUERY_PARAM_DEFAULT_CANCELLATION_COMMENT)
                .queryParam(QUERY_PARAM_INFORM_VENDOR, false)
                .queryParam(QUERY_PARAM_OVERRIDE, true)
                .queryParam(QUERY_PARAM_BIB, QUERY_PARAM_BIB_RETAIN) // delete or suppress
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildDelete()
                .invoke()
                .close();
        } catch (ResponseProcessingException e) {
            log.error("Could not delete poline {} at {}, AlmaError({})", poLine.getNumber(), contextValue,
                AlmaErrorMessageHandler.getAlmaErrorMessage(e));
            throw new WebApplicationException(AlmaErrorMessageHandler.getAlmaErrorMessage(e));
        }
    }

    @Override
    public PoLines search(@Nonnull String query) {
        return search(query, 0, 50, null, null);
    }

    @Override
    public PoLines search(@Nonnull String query, int offset, int limit, @Nullable String library, @Nullable String orderBy) {
        return search(query, "ALL_WITH_CLOSED", offset, limit, library, orderBy, true);
    }

    @Override
    public PoLines searchCancelled(@Nonnull String query, int offset, int limit) {
        return search(query, "CANCELLED", offset, limit, null, null, true);
    }

    @Override
    public PoLines searchActive(@Nonnull String query, int offset, int limit, @Nullable String library, @Nullable String orderBy, boolean expand) {
        return search(query, "ACTIVE", offset, limit, library, orderBy, expand);
    }

    @Override
    public List<PoLines> readAllActive() {
        log.trace("Retriveving all poLines at {}", contextValue);
        final String q = "";
        final String status = "ACTIVE";
        final String acquisitionMethod = "LEGAL_DEPOSIT,LEGAL_DEPOSIT_NOLETTER";
        int limit = 50;
        int offset = 0;
        List<PoLines> poLinesList = new ArrayList<>();
        try {
            PoLines poLines = this.queryPoLines(q, status, offset, limit, acquisitionMethod, null, null,
                true);
            poLinesList.add(poLines);
            Integer recordCount = poLines.getTotalRecordCount();

            while (recordCount > offset + limit) {
                offset += limit;
                poLinesList.add(this.queryPoLines(q, status, offset, limit, acquisitionMethod, null,
                    null, true));
            }
            return poLinesList;
        } catch (ResponseProcessingException e) {
            log.error("Could not read polines at {}, AlmaError({})", contextValue, AlmaErrorMessageHandler.getAlmaErrorMessage(e));
            throw new WebApplicationException(AlmaErrorMessageHandler.getAlmaErrorMessage(e));
        }
    }

    public PoLines queryPoLines(String q, String status, int offset, int limit, String acquisitionMethod, String
        library, String orderBy, boolean expand) throws ResponseProcessingException {
        WebTarget webTarget = acqTarget
            .path(POLINES_PATH)
            .queryParam(QUERY_PARAM_Q, q)
            .queryParam(QUERY_PARAM_STATUS, status)
            .queryParam(QUERY_PARAM_LIMIT, limit)
            .queryParam(QUERY_PARAM_OFFSET, offset)
            .queryParam(QUERY_PARAM_ACQUISITION_METHOD, acquisitionMethod);
        if (StringUtils.isNotEmpty(orderBy)) {
            webTarget = webTarget
                .queryParam(QUERY_PARAM_ORDER_BY, orderBy)
                .queryParam(QUERY_PARAM_DIRECTION, DESC);
        }
        if (expand) {
            webTarget = webTarget
                .queryParam(QUERY_PARAM_EXPAND, LOCATIONS_NOTES);
        }
        if (StringUtils.isNotEmpty(library)) {
            webTarget = webTarget
                .queryParam(QUERY_PARAM_LIBRARY, library);
        }
        return webTarget
            .request()
            .accept(MediaType.APPLICATION_XML)
            .buildGet()
            .invoke(PoLines.class);
    }

    @Override
    public Item receiveItem(@Nonnull String itemId, @Nonnull String poLineNumber) {
        if (StringUtils.isEmpty(itemId)) {
            throw new IllegalArgumentException("itemId is empty");
        }
        if (StringUtils.isEmpty(poLineNumber)) {
            throw new IllegalArgumentException("poLineId is empty");
        }
        log.debug("Receiving item (Id={}) on poLine (Id={}) at {}", itemId, poLineNumber, contextValue);

        Item resultItem = null;
        String almaErrorMessage = "";
        int maxTries = 3;
        for (int i = 0; i < maxTries; i++) {
            try {
                resultItem = invokeReceiveItem(itemId, poLineNumber);
                log.debug("Item {} received for poline {} at {}", itemId, poLineNumber, contextValue);
                break;
            } catch (ResponseProcessingException e) {
                String almaErrorCode = AlmaErrorMessageHandler.getAlmaErrorCode(e);
                if (ALMA_ERROR_CODE_ITEM_ALREADY_RECEIVED.equals(almaErrorCode) ||
                    ALMA_ERROR_CODE_STALE_OBJECT_EXCEPTION.equals(almaErrorCode) ||
                    ALMA_ERROR_CODE_WHEN_TRANSACTION_FAILS.equals(almaErrorCode)) {
                    log.debug("Item {} on poline {} at {} already received or in hybernate, AlmaError({})", itemId, poLineNumber,
                        contextValue, AlmaErrorMessageHandler.getAlmaErrorMessage(e));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException interruptedException) {
                        // ignore
                    }
                } else {
                    almaErrorMessage = AlmaErrorMessageHandler.getAlmaErrorMessage(e);
                    log.error("Could not receive item {} poline {} at {}, AlmaError({}) after {} times", itemId, poLineNumber,
                        contextValue, almaErrorMessage, i);
                    break;
                }
            }
            log.debug("run receiveItem for-loop {}-times (itemId {})", i, itemId);
        }
        if (!almaErrorMessage.isEmpty()) {
            throw new WebApplicationException(almaErrorMessage);
        } else {
            return resultItem;
        }
    }

    private Item invokeReceiveItem(@Nonnull String itemId, @Nonnull String poLineNumber) {
        return acqTarget
            .path(POLINES_PATH)
            .path(poLineNumber)
            .path(ITEMS_PATH)
            .path(itemId)
            .queryParam(QUERY_PRAM_OP, RECEIVE)
            .request()
            .accept(MediaType.APPLICATION_XML)
            .buildPost(Entity.xml(new Item()))
            .invoke(Item.class);
    }

    public PoLines search(@Nonnull String query, @Nonnull String status, int offset, int limit,
                          @Nullable String library, @Nullable String orderBy, boolean expand) {
        if (StringUtils.isEmpty(status)) {
            throw new IllegalArgumentException("status is null or empty");
        }
        log.trace("Retriveving poLines matching {} with status {} at {}", query, status, contextValue);
        try {
            return this.queryPoLines(query, status, offset, limit,
                "LEGAL_DEPOSIT,LEGAL_DEPOSIT_NOLETTER", library, orderBy, expand);
        } catch (ResponseProcessingException e) {
            log.error("Could not retrieve polines with query {} at {}, AlmaError({})", query, contextValue,
                AlmaErrorMessageHandler.getAlmaErrorMessage(e));
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
