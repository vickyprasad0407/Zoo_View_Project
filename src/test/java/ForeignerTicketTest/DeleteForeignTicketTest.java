package ForeignerTicketTest;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tourism.objectiveRepo.AddForeignerTicketPage;
import com.tourism.objectiveRepo.AdminProfilePage;
import com.tourism.objectiveRepo.DashboardPage;
import com.tourism.objectiveRepo.LoginPage;
import com.tourism.objectiveRepo.ManageForeignerTicketPage;
import com.tourism.objectiveRepo.PrintForeignTicketPage;
import com.tourism.objectiveRepo.ZooManagementSystemPage;
import com.zooview.generics.BaseClass;
import com.zooview.generics.DataBaseUtility;
import com.zooview.generics.ExcelUtility;
import com.zooview.generics.FileUtility;
import com.zooview.generics.JavaUtility;
import com.zooview.generics.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
//@Listeners(com.zooview.generics.ListnerImplementation.class)
public class DeleteForeignTicketTest extends BaseClass {

	@Test
	public void deleteForeignerTicket()throws Throwable {

	    ZooManagementSystemPage z=new ZooManagementSystemPage(driver);
		LoginPage l=new LoginPage(driver);
		DashboardPage d=new DashboardPage(driver);
		AdminProfilePage ap=new AdminProfilePage(driver);
		AddForeignerTicketPage af=new AddForeignerTicketPage(driver);
		ManageForeignerTicketPage mf=new ManageForeignerTicketPage(driver);
		PrintForeignTicketPage pf=new PrintForeignTicketPage(driver);
		
		
		String url=f.getPropertyKeyValue("url");
		String un=f.getPropertyKeyValue("username");
		String pwd=f.getPropertyKeyValue("pwd");
		System.out.println(ex.getExcelProperty(11,1));
		
		wb.maximizeWindow(driver);
		driver.get(url);
		wb.waitForPageLoadI(driver);
		z.getAdmin().click();
		l.loginToApp(un, pwd);
		d.getAdmin().click();
		d.getProfile().click();
		ap.getLhn().click();
		//Thread.sleep(1000);
		ap.getForeignerTicket().click();
		//Thread.sleep(3000);
		ap.getManageForeignerTicket().click();
	    List<WebElement> visitorList = mf.getVisitorNames();
	    boolean flag=false;
	    
	    for (WebElement e : visitorList) {
            
	    	if((e.getText()).equalsIgnoreCase(ex.getExcelProperty(11, 1)))
			{
	    		System.out.println(e.getText());
				flag=true;
				break;
			}
		}
	    if(flag)
	       {
	    	System.out.println("added foreign ticket is verified on manage foreign ticket page");
			System.out.println("now delete the ticket");
			mf.deleteClick(driver, ex.getExcelProperty(11, 1));
			wb.acceptAlert(driver);
			String text = wb.alertText(driver);
			wb.acceptAlert(driver);
			
		       if (text.equalsIgnoreCase("Data Deleted"))
		    	   System.out.println("Foreign ticket is deleted");
		       else
		    	   System.out.println("Foreign ticket is not deleted");				
	       }
			else
				System.out.println("Foreign ticket is not verified on manage foreign tickrt page");
         

	}

}
