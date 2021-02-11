package com.pratian.SauceDemo.Automation.FileHandling;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public final class PropertyManager {

	
	
	public static String getProperty(String PropName) throws IOException {
		
		FileReader filereader=new FileReader("App.properties");
		Properties properties=new Properties();
		properties.load(filereader);
		return properties.getProperty(PropName);		
		
	}
	

	
}
