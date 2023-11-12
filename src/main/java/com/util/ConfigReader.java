package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class ConfigReader {
	
	
	private Properties prop;
	
	/**
	 * This method is to return properties from config,properties file
	 * @return
	 */
	
	public  Properties readProperties() {
		
		prop = new Properties();
		try {
			FileInputStream finputstream = new FileInputStream("./src/test/resources/com/config/config.properties");
			prop.load( finputstream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop ;
	}

}
