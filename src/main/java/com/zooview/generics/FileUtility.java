package com.zooview.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This class provide information about the properties file
 * @author Mr. vicky
 *
 */
public class FileUtility {
	/**
	 * This method is used to read the excel data
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyKeyValue(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstant.path);
		Properties p=new Properties();
		p.load(fis);
		String data=p.getProperty(key);
		return data;
	}

}
