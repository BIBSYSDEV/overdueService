package no.unit.alma;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import no.bibsys.appl.legalDeposit.HoldingsRecordBean;
import no.unit.alma.commons.AlmaClient;
import no.unit.alma.holding.Holding;
import org.glassfish.jersey.client.JerseyClientBuilder;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public interface AlmaHoldingService {

    class Factory {
        Map<String, AlmaHoldingServiceImplementation> holdingServices = new HashMap<>();
        static Config config = ConfigFactory.load();

        public AlmaHoldingService get(String bibCode) {
            if (!holdingServices.containsKey(bibCode)) {
                holdingServices.put(bibCode,
                    new AlmaHoldingServiceImplementation(
                        new AlmaClient(JerseyClientBuilder.newClient(), config, bibCode))
                );
            }
            return holdingServices.get(bibCode);
        }
    }

    Holding updateHolding(@Nonnull String mmsId, @Nonnull Holding holding);

    Holding getHolding(@Nonnull String mmsId, @Nonnull String holdingsId);

    Optional<HoldingsRecordBean> getHoldingsRecordBean(@Nonnull String mmsId, @Nonnull String almaLibraryCode);
}
