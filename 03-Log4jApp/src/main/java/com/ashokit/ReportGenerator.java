package com.ashokit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


 
public class ReportGenerator 
{
	
//intialize the logger object	
private static final Logger logger=Logger.getLogger(ReportGenerator.class);
	
	
    public static void main( String[] args )
    {
      
    	//Basic configuration
    	BasicConfigurator.configure();
    	
    	logger.trace("this is trace msg");//trace level
    	logger.debug("this is debug msg");//debug level
    	logger.info("this is info msg");//info level
    	logger.warn("this is warn msg");//warn level
    	logger.error("this is error msg");//error level
    	logger.fatal("this is  fatal msg");//fatal levl
    	
    	
    	
    }
}
