package no.unit.alma;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import no.unit.alma.acquisitions.PoLine;
import no.unit.alma.acquisitions.PoLines;
import no.unit.alma.commons.AlmaClient;
import no.unit.alma.items.Item;
import org.glassfish.jersey.client.JerseyClientBuilder;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface AlmaPOLineService {

    class Factory {
        Map<String, AlmaPOLineServiceImplementation> polineServices = new HashMap<>();
        static Config config = ConfigFactory.load();

        public AlmaPOLineService get(String bibCode) {
            if (!polineServices.containsKey(bibCode)) {
                polineServices.put(bibCode,
                    new AlmaPOLineServiceImplementation(
                        new AlmaClient(JerseyClientBuilder.newClient(), config, bibCode))
                );
            }
            return polineServices.get(bibCode);
        }

    }

    PoLine create(@Nonnull PoLine poLine);

    PoLine get(@Nonnull String id);

    Item receiveItem(@Nonnull String itemId, @Nonnull String poLineNumber);

    PoLine update(@Nonnull PoLine poLine);

    void delete(@Nonnull PoLine poLine);

    PoLines search(@Nonnull String query);

    PoLines search(@Nonnull String query, int offset, int limit, @Nullable String library, @Nullable String orderBy);

    PoLines searchCancelled(@Nonnull String query, int offset, int limit);

    PoLines searchActive(@Nonnull String query, int offset, int limit, @Nullable String library, @Nullable String orderBy, boolean expand);

    List<PoLines> readAllActive();
}
