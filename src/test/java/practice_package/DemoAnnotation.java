package practice_package;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DemoAnnotation {

	@BeforeSuite
	public void openDB()
	{
		Reporter.log("open database connection", true);
	}
	@AfterSuite
	public void closeDB()
	{
		Reporter.log("close database connection", true);
	}
	@BeforeClass
	public void openBrowser()
	{
		Reporter.log("open to the application", true);
	}
	@AfterClass
	public void closeBrowser()
	{
		Reporter.log("close to the application", true);
	}
	@BeforeMethod
	public void login()
	{
		Reporter.log("login to the application", true);
	}
	@AfterMethod
	public void logout()
	{
		Reporter.log("logout of the application", true);
	}
	
	@Test    //default priority is 0
	public void addAnimals()
	{
		Reporter.log("add animals", true);
	}
	@Test(priority=-1)
	public void manageTicket()
	{
		Reporter.log("manage ticket", true);
	}
}
