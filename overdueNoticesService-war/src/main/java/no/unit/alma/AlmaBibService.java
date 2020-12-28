package no.unit.alma;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import no.unit.alma.bibs.Bibs;
import no.unit.alma.commons.AlmaClient;
import org.glassfish.jersey.client.JerseyClientBuilder;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public interface AlmaBibService {

    class Factory {
        Map<String, AlmaBibServiceImplementation> bibServices = new HashMap<>();
        static Config config = ConfigFactory.load();

        public AlmaBibService get(String bibCode) {
            if (!bibServices.containsKey(bibCode)) {
                bibServices.put(bibCode,
                    new AlmaBibServiceImplementation(
                        new AlmaClient(JerseyClientBuilder.newClient(), config, bibCode))
                );
            }
            return bibServices.get(bibCode);
        }
    }

    boolean createLinkedRecord(@Nonnull String mmsId);

    Bibs getBibRecord(String mmsId);

    Bibs getBibRecordByNZmmsId(String nz_mmsId);

}
