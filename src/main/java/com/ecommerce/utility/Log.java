/**
 * 
 */
package com.ecommerce.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @author Admin
 *
 */
public class Log {
	



     // private===== cannot be assessed by child class or other class
	// static=== can be accessed by using with class
	//no need to create object of class (class.name of static method or variable)
    private static Logger logger =LogManager.getLogger(Log.class.getName());
	public static void startTestCase(String testCaseName){		  
		logger.info("============"+testCaseName+" TEST START============");
	     	 
	}
	
	public static void endTestCase(String testCaseName){
		logger.info("============"+testCaseName+" TEST END============");
		 }
	
	// Need to create below methods, so that they can be called  

	 public static void info(String message) {

		 logger.info(message);

			}

	 public static void warn(String message) {

		 logger.warn(message);

		}

	 public static void error(String message) {

		 logger.error(message);

		}

	 public static void fatal(String message) {

		 logger.fatal(message);

		}

	 public static void debug(String message) {

		 logger.debug(message);

		}
	
}

	
