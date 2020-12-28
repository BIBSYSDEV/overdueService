package no.unit.alma;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import no.unit.alma.commons.AlmaClient;
import no.unit.alma.items.Item;
import org.glassfish.jersey.client.JerseyClientBuilder;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public interface AlmaItemService {

    class Factory {

        Map<String, AlmaItemServiceImplementation> itemServices = new HashMap<>();

        public Factory() {
        }

        static Config config = ConfigFactory.load();

        public AlmaItemService get(String bibcode) {
            if (!itemServices.containsKey(bibcode)) {
                itemServices.put(bibcode,
                    new AlmaItemServiceImplementation(new AlmaClient(JerseyClientBuilder.newClient(), config, bibcode)));
            }
            return itemServices.get(bibcode);
        }

    }

    Item updateItemDescription(@Nonnull Item item);

    Item getItem(@Nonnull String barcode);

    Item getItem(@Nonnull String mmsId, @Nonnull String holdingsId, @Nonnull String itemId);

    void deleteItem(@Nonnull String mmsId, @Nonnull String holdingsId, @Nonnull String itemId);

}
