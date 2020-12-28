package no.unit.alma;

import no.unit.alma.commons.AlmaClient;
import no.unit.alma.items.Item;
import no.unit.alma.record.HoldingsRecord;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.ResponseProcessingException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class AlmaItemServiceImplementation implements AlmaItemService {

    private static final transient Logger log = LoggerFactory.getLogger(AlmaItemServiceImplementation.class);

    private static final String HOLDINGS = "holdings";
    private static final String ITEMS = "items";
    private static final String BIBS = "bibs";

    private final transient WebTarget bibsTarget;
    private final transient WebTarget itemsTarget;
    private final String context;
    private final String contextValue;



    public AlmaItemServiceImplementation(AlmaClient almaClient) {
        this.bibsTarget = almaClient.getWebTarget().path(BIBS);
        this.itemsTarget = almaClient.getWebTarget().path(ITEMS);
        this.context = almaClient.getContext();
        this.contextValue = almaClient.getContextValue();
    }

    @Override
    public Item updateItemDescription(@Nonnull Item item) {
        log.trace("Update description on item with barcode {} at {}", item.getItemData().getBarcode(), contextValue);

        try {
            return bibsTarget
                .path(item.getBibData().getMmsId())
                .path(HOLDINGS)
                .path(item.getHoldingData().getHoldingId())
                .path(ITEMS)
                .path(item.getItemData().getPid())
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPut(Entity.xml(item))
                .invoke(Item.class);
        } catch (ResponseProcessingException e) {
            String almaErrorMessage = AlmaErrorMessageHandler.getAlmaErrorMessage(e);
            log.error("Could not update description on item with barcode {} at {}, AlmaError({})",
                    item.getItemData().getBarcode(), contextValue, almaErrorMessage);
            throw new WebApplicationException(almaErrorMessage);
        }
    }


    @Override
    public Item getItem(@Nonnull String barcode) {
        if (StringUtils.isEmpty(barcode)) {
            throw new IllegalArgumentException("barcode is empty");
        }
        log.trace("Retrieve item for barcode {} at {}", barcode, contextValue);
        try {
            return itemsTarget
                .queryParam("item_barcode", barcode)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Item.class);
        } catch (ResponseProcessingException e) {
            log.error("Could not retrieve item with barcode {} at {}, AlmaError({})", barcode, contextValue,
                AlmaErrorMessageHandler.getAlmaErrorMessage(e));
            throw new WebApplicationException(AlmaErrorMessageHandler.getAlmaErrorMessage(e));
        }
    }

    @Override
    public Item getItem(@Nonnull String mmsId, @Nonnull String holdingsId, @Nonnull String itemId) {
        if (StringUtils.isEmpty(mmsId)) {
            throw new IllegalArgumentException("mmsId is empty");
        }
        if (StringUtils.isEmpty(holdingsId)) {
            throw new IllegalArgumentException("holdingsId is empty");
        }
        if (StringUtils.isEmpty(itemId)) {
            throw new IllegalArgumentException("itemId is empty");
        }
        log.trace("Get item for mmsId {}, holdingsId {}, itemId {} at {}", mmsId, holdingsId, itemId, contextValue);
        try {
            return bibsTarget
                .path(mmsId)
                .path(HOLDINGS)
                .path(holdingsId)
                .path(ITEMS)
                .path(itemId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Item.class);
        } catch (ResponseProcessingException e) {
            log.error("Could not get item for mmsId {}, holdingsId {}, itemId {} at {}, AlmaError({})",
                    mmsId, holdingsId, itemId, contextValue, AlmaErrorMessageHandler.getAlmaErrorMessage(e));
            throw new WebApplicationException(AlmaErrorMessageHandler.getAlmaErrorMessage(e));
        }
    }

    @Override
    public void deleteItem(@Nonnull String mmsId, @Nonnull String holdingsId, @Nonnull String itemId) {
        if (StringUtils.isEmpty(mmsId)) {
            throw new IllegalArgumentException("mmsId is empty");
        }
        if (StringUtils.isEmpty(holdingsId)) {
            throw new IllegalArgumentException("holdingsId is empty");
        }
        if (StringUtils.isEmpty(itemId)) {
            throw new IllegalArgumentException("itemId is empty");
        }
        log.trace("Delete item for mmsId {}, holdingsId {}, itemId {} at {}", mmsId, holdingsId, itemId, contextValue);
        try {
            bibsTarget
                .path(mmsId)
                .path(HOLDINGS)
                .path(holdingsId)
                .path(ITEMS)
                .path(itemId)
                .queryParam("override", true)
                .queryParam(HOLDINGS, HoldingsRecord.RETAIN.toString())
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildDelete()
                .invoke()
                .close();
        } catch (ResponseProcessingException e) {
            log.error("Could not delete Item with mmmsId {}, holdingsId {}, itemId {} at {}, AlmaError({})",
                    mmsId, holdingsId, itemId, contextValue, AlmaErrorMessageHandler.getAlmaErrorMessage(e));
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
