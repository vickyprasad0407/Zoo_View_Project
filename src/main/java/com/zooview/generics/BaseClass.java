package com.zooview.generics;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.tourism.objectiveRepo.DashboardPage;
import com.tourism.objectiveRepo.LoginPage;
import com.tourism.objectiveRepo.ZooManagementSystemPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public  WebDriver driver;
	public DataBaseUtility db=new DataBaseUtility();
	public ExcelUtility ex=new ExcelUtility();
	public FileUtility f=new FileUtility();
	public JavaUtility jv=new JavaUtility();
	public WebDriverUtility wb=new WebDriverUtility();
  //public static WebDriver ddriver=driver;
	public static WebDriver ddriver;//adarsh
	
	@BeforeSuite
	public void configDb() throws SQLException
	{
		//db.connectToDB();
		System.out.println("----connect to database-------");
	}
    //@Parameters("BROWSER")
	@BeforeClass
	public void configBC() throws IOException
	{
		String BROWSER=f.getPropertyKeyValue("browser");
		String URL=f.getPropertyKeyValue("url");
		if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
		    driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("microsoftedge")) {
			WebDriverManager.edgedriver().setup();
		    driver=new EdgeDriver();
		}
		ddriver=driver;
		wb.maximizeWindow(driver);
		driver.get(URL);
		System.out.println("----launch the browser-----");
	}
	@BeforeMethod
	public void configBM() throws Throwable
	{
		String USERNAME=f.getPropertyKeyValue("username");
		String PWD=f.getPropertyKeyValue("pwd");
		LoginPage lp=new LoginPage(driver);
		ZooManagementSystemPage z=new ZooManagementSystemPage(driver);
		z.getAdmin().click();
		lp.loginToApp(USERNAME, PWD);
		System.out.println("----login to app----");
	}
	@AfterMethod
	public void configAM()
	{
		DashboardPage dp=new DashboardPage(driver);
		dp.getAdmin().click();
		dp.setLogout();
		System.out.println("---logout to the browser------");
	}
	@AfterClass
	public void configAC() throws InterruptedException
	{
		driver.quit();
		System.out.println("----closing the browser-----");
	}
	@AfterSuite
	public void disconnectDB() throws SQLException
	{
		//db.closeDBConnection();
		System.out.println("----closing the database connection------");
	}
	

}
