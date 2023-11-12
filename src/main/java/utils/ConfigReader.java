package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import constants.DataConstants;

public class ConfigReader {

	private static final Properties systemProps = new Properties();
	private static final Logger LOGGER = LogManager.getLogger(ConfigReader.class);
	
	
	private static void loadSystemProps() throws IOException {
		synchronized (systemProps) {
			if (systemProps.isEmpty()) {
				LOGGER.info("Loading system properties");
				try (FileInputStream fis = new FileInputStream(new File(DataConstants.SYSTEM_PROP_PATH))) {
					systemProps.load(fis);
				}
			}
		}
	}

	public static String getProperty(String key) throws IOException {
		loadSystemProps();
		return systemProps.getProperty(key);
	}

}
