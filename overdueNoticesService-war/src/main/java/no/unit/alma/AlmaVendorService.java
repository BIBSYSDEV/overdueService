package no.unit.alma;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import no.unit.alma.commons.AlmaClient;
import no.unit.alma.vendors.Vendor;
import no.unit.alma.vendors.Vendors;
import org.glassfish.jersey.client.JerseyClientBuilder;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public interface AlmaVendorService {

    class Factory {
        Map<String, AlmaVendorServiceImplementation> vendorServices = new HashMap<>();
        static Config config = ConfigFactory.load();

        public AlmaVendorService get(String bibCode) {
            if (!vendorServices.containsKey(bibCode)) {
                vendorServices.put(bibCode,
                    new AlmaVendorServiceImplementation(
                        new AlmaClient(JerseyClientBuilder.newClient(), config, bibCode))
                );
            }
            return vendorServices.get(bibCode);
        }
    }

    Vendor create(@Nonnull Vendor vendor);

    Vendor read(@Nonnull String vendorId);

    Vendor update(@Nonnull Vendor vendor);

    Vendors searchActive(@Nonnull String query);

    Vendors searchActive(@Nonnull String query, int offset, int limit);

    Vendors searchAll(@Nonnull String query, int offset, int limit);

    String getBibcode();
}
