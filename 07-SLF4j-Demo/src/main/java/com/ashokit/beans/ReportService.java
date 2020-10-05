package com.ashokit.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportService {
	
	private static final  Logger logger=LoggerFactory.getLogger(ReportService.class);
	
	public static void generateReport(){
		
		logger.info("**generateReport() method started**");
		
		System.out.println("report getting generated");
		
		logger.info("**generateReport() method ended**");
		
	}
	
	

}
