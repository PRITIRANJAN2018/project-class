
package com.ashokit.beans;

import java.net.URL;

public class MyApp {
	
	
	public static void main(String[] args) {
		
		/* Object resource = MyApp.class.getResource("/logging.properties"); */
		
		/*
		 * String path =
		 * MyApp.class.getClassLoader().getResource("/logging.properties").getFile();
		 * 
		 * System.out.println("java.util.logging.config.file",path);
		 */
		ReportService.generateReport();
		
		
		
	}

}
