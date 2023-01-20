package Animals_Details_Module;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import com.zooview.generics.FileUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Animals_Details {

	public static void main(String[] args) throws IOException, InterruptedException, AWTException  {
		// TODO Auto-generated method stub
		//FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties");
		//Properties pobj=new Properties();
		//pobj.load(fis);
		FileUtility fib=new FileUtility();
		String Url = fib.getPropertyKeyValue("url");
		String User= fib.getPropertyKeyValue("username");
		String Password=fib.getPropertyKeyValue("pwd");
		System.out.println(Url+" "+User+" "+Password);
		
		 FileInputStream fi=new FileInputStream("./src/test/resources/Testdata.xlsx");
	        Workbook wb = WorkbookFactory.create(fi);
	       Sheet sheet = wb.getSheet("Sheet1");
	       int row = sheet.getLastRowNum();
	       System.out.println(row);
	       WebDriver driver=WebDriverManager.chromedriver().create();
			
	       driver.manage().window().maximize();
	       driver.get(Url);
	       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	       driver.findElement(By.xpath("//a[.='Admin'][1]")).click();
	       
	       //log in to app
	       driver.findElement(By.id("username")).sendKeys(User);
	       driver.findElement(By.id("password")).sendKeys(Password);
	       driver.findElement(By.id("form_submit")).click();
	       driver.manage().window().maximize();
	       Thread.sleep(1000);
	       driver.findElement(By.xpath("//h4[text()='Admin ']")).click();
	       driver.findElement(By.linkText("Profile")).click();
	       Thread.sleep(10000);
	       driver.findElement(By.xpath("//div[@class='nav-btn pull-left']")).click();
	       driver.findElement(By.xpath("//a[.='Animals Details']")).click();
	       Thread.sleep(1000);
	       driver.findElement(By.xpath("//a[.='Add Animals']")).click();
           
	       for(int i=1;i<=row ;i++)
	       {
	    	   
	    	  String id = sheet.getRow(i).getCell(0).toString();
	    	  //System.out.println(id);
	    	  String key = sheet.getRow(i).getCell(1).toString();
	    	   driver.findElement(By.id(id)).sendKeys(key);
	       }
	       //java.io.File
	      /* WebElement img = driver.findElement(By.id("image"));
	       JavascriptExecutor js=(JavascriptExecutor) driver;
	       js.executeScript("arguments[0].click();",img);
	      StringSelection ss=new StringSelection("Screenshot (1).png");
	       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	       Robot r=new Robot();
	       r.keyPress(KeyEvent.VK_CONTROL);
	       r.keyPress(KeyEvent.VK_V);
           r.keyRelease(KeyEvent.VK_CONTROL);	
           r.keyRelease(KeyEvent.VK_V);
           r.keyPress(KeyEvent.VK_ENTER);*/
	       java.io.File f=new java.io.File("./src/test/resources/download.jpg");
	       String absPath=f.getAbsolutePath();
	       driver.findElement(By.id("image")).sendKeys(absPath);
	       driver.findElement(By.name("submit")).click();
	       Thread.sleep(9000);
	       Alert a=driver.switchTo().alert();
	       String text=a.getText();
	       a.accept();
	       if (text.equalsIgnoreCase("Animal detail has been added."))
	    	   System.out.println("Animal is added");
	       else
	    	   System.out.println("Animals details is not added");
	       driver.findElement(By.xpath("//a[.='Animals Details']")).click();
	       driver.findElement(By.linkText("Manage Animals")).click();
	       List<WebElement> cageNo = driver.findElements(By.xpath("//td[2]"));
	       boolean flag=false;
	       System.out.println(sheet.getRow(2).getCell(1).toString());
	       for (WebElement e : cageNo) {
			if((e.getText()+".0").equalsIgnoreCase(sheet.getRow(2).getCell(1).toString()))
			{
				
				flag=true;
				
				break;
			}
			
		}
	       if(flag)
	       {
				System.out.println("added animals is verified on manage animals page");
				System.out.println("now start editing the data");
				driver.findElement(By.xpath("//td[5]/a[1]")).click();
				driver.findElement(By.id(sheet.getRow(1).getCell(0).toString())).sendKeys("crocodile with mum mum");
				driver.findElement(By.name("submit")).click();
				Alert a1=driver.switchTo().alert();
			       String text1=a.getText();
			       a1.accept();
			       if (text1.equalsIgnoreCase("Animal detail has been Updated."))
			    	   System.out.println("Animal is updated");
			       else
			    	   System.out.println("Animals details is not updated");
			       driver.findElement(By.xpath("//a[.='Animals Details']")).click();
			       driver.findElement(By.linkText("Manage Animals")).click();
			       driver.findElement(By.xpath("//td[5]/a[2]")).click();
			       Alert a2=driver.switchTo().alert();
			       a2.accept();
			       Alert a3=driver.switchTo().alert();
			       String text3=a.getText();
			       a3.accept();
			       if (text3.equalsIgnoreCase("Data Deleted"))
			    	   System.out.println("Animal is data is deleted");
			       else
			    	   System.out.println("Animals details is not deleted");
			       Thread.sleep(3000);
				
	       }
			else
				System.out.println("added animals is not verified on manage animals page");
	       
	}

}
