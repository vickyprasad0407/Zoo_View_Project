package practice_package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	@Test(dataProvider = "data")
	public void travel(String from,String to,int price)
	{
		System.out.println("from "+from+" to "+to+" price "+price);
	}
	@DataProvider
	public Object[][] data()
	{
		Object [][] ob=new Object[3][3];
		ob[0][0]="Banglore";
		ob[0][1]="Bankkok";
		ob[0][2]=1500;
		ob[1][0]="delhi";
		ob[1][1]="kolkata";
		ob[1][2]=2000;
		ob[2][0]="MUMBAI";
		ob[2][1]="DELHI";
		ob[2][2]=5000;
		return ob; 
		
	}
}
