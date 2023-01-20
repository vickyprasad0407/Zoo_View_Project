package com.zooview.generics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;
/**
 * this class is used to connect with database
 * @author Mr. Vicky
 *
 */
public class DataBaseUtility {
	
	Connection con=null;
	/**
	 * This method is used to connect with databases
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IpathConstant.dbURL, IpathConstant.dbUN, IpathConstant.dbPWD);
	}
	/**
	 * This method is used to compare String data with databases
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String getDBStData(String query,int columnIndex,String expData) throws SQLException
	{
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String actData = result.getString(columnIndex);
			if (actData.equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(expData+" project is created");
			return expData;
		}
		else
		{
			System.out.println("project is not created");
			return "";
		}
	}
	/**
	 * this method is used to compare integer data from the databases
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public Integer getDBIntData(String query,int columnIndex,int expData) throws SQLException
	{
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			int actData = result.getInt(columnIndex);
			if (actData==expData)
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(expData+" project is created");
			return expData;
		}
		else
		{
			System.out.println("project is not created");
			return null;
		}
	}
	/**
	 * This method is used to close the databases connection
	 * @throws SQLException
	 */
	public void closeDBConnection() throws SQLException
	{
		con.close();
	}

}
