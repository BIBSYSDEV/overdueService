package no.unit.alma;

import no.unit.alma.commons.AlmaClient;
import no.unit.alma.vendors.Vendor;
import no.unit.alma.vendors.Vendors;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.ResponseProcessingException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class AlmaVendorServiceImplementation implements AlmaVendorService {

    private static final transient Logger log = LoggerFactory.getLogger(AlmaVendorServiceImplementation.class);
    public static final String VENDORS_PATH = "vendors";
    public static final String ACQUISITION_PATH = "acq";
    private final transient WebTarget webTarget;
    private final String context;
    private final String contextValue;

    public AlmaVendorServiceImplementation(AlmaClient almaClient) {
        this.webTarget = almaClient.getWebTarget().path(ACQUISITION_PATH);
        this.context = almaClient.getContext();
        this.contextValue = almaClient.getContextValue();
    }


    @Override
    public Vendor create(@Nonnull Vendor vendor) {
        checkIfEmpty(vendor.getCode(), "vendor.getCode is null or empty");
        log.trace("Create vendor {} at {}", vendor.getCode(), contextValue);
        try {
            return webTarget
                .path(VENDORS_PATH)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(vendor))
                .invoke(Vendor.class);
        } catch (ResponseProcessingException e) {
            throw new WebApplicationException(AlmaErrorMessageHandler.getAlmaErrorMessage(e));
        }
    }

    @Override
    public Vendor read(@Nonnull String vendorIdentifier) {
        checkIfEmpty(vendorIdentifier, "vendorId is empty");
        log.trace("Read vendor with id {} at {}", vendorIdentifier, contextValue);
        try {
            return webTarget
                .path(VENDORS_PATH)
                .path(vendorIdentifier)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Vendor.class);
        } catch (ResponseProcessingException e) {
            throw new WebApplicationException(AlmaErrorMessageHandler.getAlmaErrorMessage(e));
        }
    }

    @Override
    public Vendor update(@Nonnull Vendor vendor) {
        checkIfEmpty(vendor.getCode(), "vendor.getCode is null or empty");
        log.trace("Update vendor with code {} at {}", vendor.getCode(), contextValue);
        try {
            return webTarget
                .path(VENDORS_PATH)
                .path(vendor.getCode())
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPut(Entity.xml(vendor))
                .invoke(Vendor.class);
        } catch (ResponseProcessingException e) {
            throw new WebApplicationException(AlmaErrorMessageHandler.getAlmaErrorMessage(e));
        }
    }

    @Override
    public Vendors searchActive(@Nonnull String query) {
        return search(query, "ACTIVE", 0, 100);
    }

    @Override
    public Vendors searchActive(@Nonnull String query, int offset, int limit) {
        return search(query, "ACTIVE", offset, limit);
    }

    @Override
    public Vendors searchAll(@Nonnull String query, int offset, int limit) {
        return search(query, "ALL", offset, limit);
    }

    @Override
    public String getBibcode() {
        return contextValue;
    }

    private Vendors search(@Nonnull String query, @Nonnull String status, int offset, int limit) {
        checkIfEmpty(query, "query is empty");
        checkIfEmpty(status, "status is empty");
        log.trace("Retrieving vendors matching query {} with status {} (offset: {}, limit: {}) at {}",
            query, status, offset, limit, contextValue);
        try {
            WebTarget vendorsTarget = webTarget.path(VENDORS_PATH);
            if (StringUtils.isEmpty(query) && StringUtils.isEmpty(status)) {
                return vendorsTarget
                    .request()
                    .accept(MediaType.APPLICATION_XML)
                    .buildGet()
                    .invoke(Vendors.class);
            }
            vendorsTarget = vendorsTarget
                .queryParam("status", StringUtils.isEmpty(status) ? "ALL" : status)
                .queryParam("type", "material_supplier");
            if (StringUtils.isNotEmpty(query)) {
                vendorsTarget = vendorsTarget.queryParam("q", query);
            }
            if (limit > -1) {
                vendorsTarget = vendorsTarget.queryParam("limit", limit);
            }
            if (offset > 0) {
                vendorsTarget = vendorsTarget.queryParam("offset", offset);
            }
            return vendorsTarget
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Vendors.class);
        } catch (ResponseProcessingException e) {
            throw new WebApplicationException(AlmaErrorMessageHandler.getAlmaErrorMessage(e));
        }
    }

    private void checkIfEmpty(String code, String errorMessage) {
        if (StringUtils.isEmpty(code)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public String getContext() {
        return context;
    }


    public String getContextValue() {
        return contextValue;
    }

}
