package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import constants.DataConstants;

public class ConfigReader {

	private static final Properties systemProps = new Properties();

	private static void loadSystemProps() throws IOException {
		synchronized (systemProps) {
			if (systemProps.isEmpty()) {
				System.out.println("Loading system properties");
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
