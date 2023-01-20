package ForeignTicket;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delete_Foreign_Ticket {

	public static void main(String[] args) throws IOException, InterruptedException {

		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String Url = pobj.getProperty("url");
		String User= pobj.getProperty("username");
		String Password= pobj.getProperty("password");
		System.out.println(Url+" "+User+" "+Password);
		
		 FileInputStream fi=new FileInputStream("./src/test/resources/Testdata.xlsx");
	        Workbook wb = WorkbookFactory.create(fi);
	       Sheet sheet = wb.getSheet("create");
	       int row = sheet.getLastRowNum();
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
	       driver.findElement(By.xpath("//span[.='Foreigners Ticket']")).click();
	       driver.findElement(By.linkText("Add Ticket")).click();
	       driver.findElement(By.id(sheet.getRow(11).getCell(0).toString())).sendKeys(sheet.getRow(11).getCell(1).toString());
	       driver.findElement(By.id(sheet.getRow(12).getCell(0).toString())).sendKeys(sheet.getRow(12).getCell(1).toString());
	       driver.findElement(By.id(sheet.getRow(13).getCell(0).toString())).sendKeys(sheet.getRow(13).getCell(1).toString());
	       driver.findElement(By.name("submit")).click();
	       Thread.sleep(3000);
	       
	       WebDriverWait wait=new WebDriverWait(driver, 10);
	       wait.until(ExpectedConditions.alertIsPresent());
	       Alert a=driver.switchTo().alert();
	       String text=a.getText();
	       a.accept();
	       if (text.equalsIgnoreCase("Ticket has been generated"))
	    	   System.out.println("Ticket is generated");
	       else
	    	   System.out.println("Ticket is not generated");
	       Thread.sleep(3000);
	       driver.findElement(By.xpath("//span[.='Foreigners Ticket']")).click();
           driver.findElement(By.linkText("Manage Ticket")).click();
           
           List<WebElement> visitorName = driver.findElements(By.xpath("//td[3]"));
	       boolean flag=false;
	       System.out.println(sheet.getRow(7).getCell(1).toString());
	       for (WebElement e : visitorName) {
			if((e.getText()).equalsIgnoreCase(sheet.getRow(11).getCell(1).toString()))
			{
				
				flag=true;
				
				break;
			}
			
		}
	       if(flag)
	       {
				System.out.println("added foreign ticket is verified on manage foreign ticket page");
				System.out.println("now delete the ticket");
				driver.findElement(By.linkText("Delete")).click();
				Alert a3=driver.switchTo().alert();
			       a3.accept();
			       Alert a4=driver.switchTo().alert();
			       String text3=a.getText();
			       a4.accept();
			       if (text3.equalsIgnoreCase("Data Deleted"))
			    	   System.out.println("Foreign ticket is deleted");
			       else
			    	   System.out.println("Foreign ticket is not deleted");
			       Thread.sleep(9000);
				
				
				
	       }
			else
				System.out.println("foreign ticket is not verified on manage foreign tickrt page");
	}

}