package no.bibsys.overdueNotices;

import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OverdueConfig {

	private static class LazyLoader {
		private static final OverdueConfig AUDI_CONFIG_INSTANCE = new OverdueConfig();
	}

	public static final OverdueConfig getInstance() {
		return LazyLoader.AUDI_CONFIG_INSTANCE;
	}


	private Properties properties;

	private Properties apikeys;

	private static final transient Logger log = LoggerFactory.getLogger(OverdueConfig.class);

	private OverdueConfig() {
		super();
		loadProperties();
		loadApiKeys();
	}

	private void loadProperties() {
		properties = new Properties();
		String propertyFileName = "/fasehome/applikasjoner/overdue/overdue.properties";
		try {
			properties.load(new FileReader(propertyFileName));
		} catch (Exception e) {
			log.error("Error loading properties", e);
			throw new RuntimeException("Failed to load properties: " + propertyFileName);
		}

		log.info("Overdue has loaded properties");
	}


	private void loadApiKeys() {
		apikeys = new Properties();
		String propertyFileName = "/fasehome/applikasjoner/almaws/institution.properties";
		try {
			apikeys.load(new FileReader(propertyFileName));
		} catch (Exception e) {
			log.error("Error loading apikey properties", e);
			throw new RuntimeException("Failed to load apikey properties: " + propertyFileName);
		}
	}

	public Map<String, Set<String>> getInventoryMetadataMapping() {
		Map<String, Set<String>> metadataMappings = new HashMap<>();
		Properties mapping = new Properties();
		String propertyFileName = "/fasehome/applikasjoner/audi/inventory_metadata.properties";
		try {
			mapping.load(new FileReader(propertyFileName));
			for (String propertyName : mapping.stringPropertyNames()) {
				String value = mapping.getProperty(propertyName);
				if (value != null) {
					String[] marccodes = value.split(",");
					Set<String> mc = new HashSet<>();
					for (String string : marccodes) {
						mc.add(string.trim());
					}
					metadataMappings.put(propertyName, mc);
				}
			}
		} catch (Exception e) {
			log.error("Error loading loadInventoryMetadataMapping  properties", e);
			throw new RuntimeException("Failed to load loadInventoryMetadataMapping properties: " + propertyFileName);
		}
		return metadataMappings;
	}


	public static void reloadProperties() {
		getInstance().loadProperties();
	}

	public static String getProperty(String propertyName) {
	    return getInstance().properties.getProperty(propertyName);
	}
	
	public static String getProperty(String propertyName, String defaultValue) {
		String value = getInstance().properties.getProperty(propertyName);
		return value != null ? value : defaultValue;
	}


	public static String getApikey(String institutionId) {
		return getInstance().apikeys.getProperty(institutionId);
	}
}
