package ManageTypeTicketTest;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tourism.objectiveRepo.AddForeignerTicketPage;
import com.tourism.objectiveRepo.AdminProfilePage;
import com.tourism.objectiveRepo.DashboardPage;
import com.tourism.objectiveRepo.LoginPage;
import com.tourism.objectiveRepo.ManageTypeTicketPage;
import com.tourism.objectiveRepo.UpadateTicketTypePage;
import com.tourism.objectiveRepo.ZooManagementSystemPage;
import com.zooview.generics.BaseClass;
import com.zooview.generics.DataBaseUtility;
import com.zooview.generics.ExcelUtility;
import com.zooview.generics.FileUtility;
import com.zooview.generics.JavaUtility;
import com.zooview.generics.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.zooview.generics.ListnerImplementaion.class)
public class ManageTypeTicketTest extends BaseClass {

	@Test
	public  void manageTicket() throws Throwable {
		
		Scanner sc=new Scanner(System.in);
	       System.out.println("press 1 to edit normal adult");
	       System.out.println("press 2 to edit normal child");
	       System.out.println("press 3 to edit foreigner adult");
	       System.out.println("press 4 to edit foreigner child");
	       int no=sc.nextInt();
	       System.out.println("enter the price");
	       String price=sc.next();

		ZooManagementSystemPage z=new ZooManagementSystemPage(driver);
		LoginPage l=new LoginPage(driver);
		DashboardPage d=new DashboardPage(driver);
		AdminProfilePage ap=new AdminProfilePage(driver);
		AddForeignerTicketPage af=new AddForeignerTicketPage(driver);
		ManageTypeTicketPage mtp=new ManageTypeTicketPage(driver);
		UpadateTicketTypePage utp=new UpadateTicketTypePage(driver);
		
		String url=f.getPropertyKeyValue("url");
		String un=f.getPropertyKeyValue("username");
		String pwd=f.getPropertyKeyValue("pwd");
		
		wb.maximizeWindow(driver);
		driver.get(url);
		wb.waitForPageLoadI(driver);
		z.getAdmin().click();
		l.loginToApp(un, pwd);
		d.getAdmin().click();
		d.getProfile().click();
		ap.getLhn().click();
		ap.getManageTypeTicket().click();
		
		 switch (no) {
			case 1: 
				mtp.getNormalAdult().click();
				utp.getTicketCost().sendKeys(Keys.CONTROL+"a");
				utp.getTicketCost().sendKeys(price);
                utp.getSubmitButton().click();				
				break;
			case 2: mtp.getNormalChild().click();
			        utp.getTicketCost().sendKeys(Keys.CONTROL+"a");
			        utp.getTicketCost().sendKeys(price);
                    utp.getSubmitButton().click();				
			break;
			
			case 3: mtp.getForeignerAdult().click();
			        utp.getTicketCost().sendKeys(Keys.CONTROL+"a");
	                utp.getTicketCost().sendKeys(price);
                    utp.getSubmitButton().click();	
			
			break;
			case 4: mtp.getForeignerChild().click();
			        utp.getTicketCost().sendKeys(Keys.CONTROL+"a");
	                utp.getTicketCost().sendKeys(price);
                    utp.getSubmitButton().click();	
			
			break;

			default:
				System.out.println("invalid input");
				
	       }
		   String text = wb.alertText(driver);
		   System.out.println(text);
	       wb.acceptAlert(driver);
	       Assert.assertTrue(text.equalsIgnoreCase("Ticket detail has been Updated."));
	    	   System.out.println("Ticket is added");
	    	   

	}

}
