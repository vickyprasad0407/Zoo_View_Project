package com.zooview.generics;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
/**
 * This class is used to provide java utility methods
 * @author Mr. Vicky
 *
 */
public class JavaUtility {
/**
 * This method is used to provide java utility methods
 * @return
 */
	public int getRandomNo()
	{
	    Random ram=new Random();
	    return ram.nextInt(500);
	}
	/**
	 * This method is used to return the system date
	 * @return
	 */
	public String getSystemDate()
	{
		java.util.Date dt=new java.util.Date();
		return dt.toString();
	}
	/**
	 * this method is used to get system date and date in format
	 * @return
	 */
	public String getSystemDateAndTimeFormat()
	{
		SimpleDateFormat dateformat=new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
		java.util.Date systemdate=new java.util.Date();
		String getDateAndGetTime=dateformat.format(systemdate);
		return getDateAndGetTime.replaceAll(":", "-");
	}
}
