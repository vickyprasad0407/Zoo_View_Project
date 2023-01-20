package ForeignerTicketTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tourism.objectiveRepo.AddForeignerTicketPage;
import com.tourism.objectiveRepo.AdminProfilePage;
import com.tourism.objectiveRepo.DashboardPage;
import com.tourism.objectiveRepo.LoginPage;
import com.tourism.objectiveRepo.ZooManagementSystemPage;
import com.zooview.generics.BaseClass;
import com.zooview.generics.DataBaseUtility;
import com.zooview.generics.ExcelUtility;
import com.zooview.generics.FileUtility;
import com.zooview.generics.IpathConstant;
import com.zooview.generics.JavaUtility;
import com.zooview.generics.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
//@Listeners(com.zooview.generics.ListnerImplementation.class)
public class AddForeignTicketTest extends BaseClass {
	
	@Test
	public  void addForeignTicket() throws Throwable {
			
		ZooManagementSystemPage z=new ZooManagementSystemPage(driver);
		LoginPage l=new LoginPage(driver);
		DashboardPage d=new DashboardPage(driver);
		AdminProfilePage ap=new AdminProfilePage(driver);
		AddForeignerTicketPage af=new AddForeignerTicketPage(driver);
		
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
		Thread.sleep(1000);
		ap.getForeignerTicket().click();
		Thread.sleep(3000);
		ap.getAddForeignerTicket().click();
		List<WebElement> listOfTbx = af.getTextbox();
		ArrayList<String> al = ex.getParticular( 1, 11, 13);
		for (int i = 0; i < listOfTbx.size(); i++) {
			listOfTbx.get(i).sendKeys(al.get(i));
		}
		af.getSubmit().click();
		wb.acceptAlert(driver);
		ap.getLhn().click();
		ap.getForeignerTicket().click();
		ap.getManageForeignerTicket().click();
		
	}
}
