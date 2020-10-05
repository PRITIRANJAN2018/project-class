package com.ashokit;

import java.io.File;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class ReportGenerator 
{
	
//intialize the logger object	
private static final Logger logger=Logger.getLogger(ReportGenerator.class);
	
	
    public static void main( String[] args )
    {
      //intialize the log4j
   PropertyConfigurator.configure(System.getProperty("user.dir")+ File.separator+"log4j.properties");
    	
    	logger.trace("this is trace msg");//trace level
    	logger.debug("this is debug msg");//debug level
    	logger.info("this is info msg");//info level
    	logger.warn("this is warn msg");//warn level
    	logger.error("this is error msg");//error level
    	logger.fatal("this is  fatal msg");//fatal levl
    	
    	
    	
    }
}
