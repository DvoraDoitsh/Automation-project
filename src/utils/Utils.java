package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class Utils {
	public String readProperty(String key) {
		String value = "";
		try (InputStream input = new FileInputStream("./src/data/configuration.properties")){
			Properties prop = new Properties();
			//load a properties file
			prop.load(input);
			value = prop.getProperty(key);
		} catch (Exception e) {		
		}		
		return value;
	}
}
