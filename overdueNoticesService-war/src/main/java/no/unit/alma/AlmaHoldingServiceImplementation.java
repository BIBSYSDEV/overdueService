package no.unit.alma;

import no.bibsys.appl.legalDeposit.HoldingsRecordBean;
import no.unit.alma.commons.AlmaClient;
import no.unit.alma.holding.Holding;
import no.unit.alma.holdings.Holdings;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.ResponseProcessingException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

public class AlmaHoldingServiceImplementation implements AlmaHoldingService {

    private static final transient Logger log = LoggerFactory.getLogger(AlmaHoldingServiceImplementation.class);
    private static final String BIBS = "bibs";
    private static final String HOLDINGS = "holdings";
    private final transient WebTarget webTarget;
    private final String context;
    private final String contextValue;

    public AlmaHoldingServiceImplementation(AlmaClient almaClient) {
        this.webTarget = almaClient.getWebTarget().path(BIBS);
        this.context = almaClient.getContext();
        this.contextValue = almaClient.getContextValue();
    }

    @Override
    public Holding updateHolding(@Nonnull String mmsId, @Nonnull Holding holding) {
        if (StringUtils.isEmpty(mmsId)) {
            throw new IllegalArgumentException("mmsId is empty");
        }
        log.trace("Update holding (Id={}) for mmsId {} at {}", holding.getHoldingId(), mmsId, contextValue);
        try {
            return webTarget
                .path(mmsId)
                .path(HOLDINGS)
                .path(holding.getHoldingId())
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPut(Entity.xml(holding))
                .invoke(Holding.class);
        } catch (ResponseProcessingException e) {
            throw new WebApplicationException(AlmaErrorMessageHandler.getAlmaErrorMessage(e));
        }
    }

    @Override
    public Holding getHolding(@Nonnull String mmsId, @Nonnull String holdingsId) {
        if (StringUtils.isEmpty(mmsId)) {
            throw new IllegalArgumentException("mmsId is empty");
        }
        if (StringUtils.isEmpty(mmsId)) {
            throw new IllegalArgumentException("holdingsId is empty");
        }
        if (StringUtils.isEmpty(mmsId)) {
            throw new IllegalArgumentException("bibCode is empty");
        }
        log.trace("Get holding (Id={}) for mmsId {} at {}", holdingsId, mmsId, contextValue);
        try {
            return webTarget
                .path(mmsId)
                .path(HOLDINGS)
                .path(holdingsId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Holding.class);

        } catch (ResponseProcessingException e) {
            throw new WebApplicationException(AlmaErrorMessageHandler.getAlmaErrorMessage(e));
        }
    }

    @Override
    public Optional<HoldingsRecordBean> getHoldingsRecordBean(@Nonnull String mmsId, @Nonnull String almaLibraryCode) {
        if (StringUtils.isEmpty(mmsId)) {
            throw new IllegalArgumentException("mmsId is empty");
        }
        if (StringUtils.isEmpty(almaLibraryCode)) {
            throw new IllegalArgumentException("almaLibraryCode is empty");
        }
        return retrieveHoldingId(mmsId, almaLibraryCode)
            .map(holdingsId -> getHolding(mmsId, holdingsId))
            .map(holding -> new HoldingsRecordBean(almaLibraryCode, mmsId, holding));
    }

    private Optional<String> retrieveHoldingId(@Nonnull String mmsId, @Nonnull String almaLibraryCode) {
        log.trace("Retrieve holding for mmsId {}, library {} at {}", mmsId, almaLibraryCode, contextValue);
        try {
            Holdings holdings = webTarget
                .path(mmsId)
                .path(HOLDINGS)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Holdings.class);
            if (holdings != null) {
                for (no.unit.alma.holdings.Holding holding : holdings.getHoldings()) {
                    if (almaLibraryCode.equals(holding.getLibrary().getValue())) {
                        return Optional.of(holding.getHoldingId());
                    }
                }
            }
            log.debug("Could not find HoldingsRecord for " + mmsId);
            return Optional.empty();
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
