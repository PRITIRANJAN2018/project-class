package com.ashokit;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class ReportGenerator 
{

	//intialize the logger object	
	private static final Logger logger=Logger.getLogger(ReportGenerator.class);



	public static void main( String[] args )
	{
		//intialize the log4j
		PropertyConfigurator.configure(ReportGenerator.class.getResource("/log4j.properties"));
		///05-app/log4j.properties
		logger.trace("this is trace msg");//trace level
		logger.debug("this is debug msg");//debug level
		logger.info("this is info msg");//info level
		logger.warn("this is warn msg");//warn level
		logger.error("this is error msg");//error level
		logger.fatal("this is  fatal msg");//fatal levl
		System.out.println("Done!!");

	}
}
