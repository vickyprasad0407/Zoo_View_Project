package searchTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tourism.objectiveRepo.AddForeignerTicketPage;
import com.tourism.objectiveRepo.AdminProfilePage;
import com.tourism.objectiveRepo.DashboardPage;
import com.tourism.objectiveRepo.ForeignPeopleSearchPage;
import com.tourism.objectiveRepo.LoginPage;
import com.tourism.objectiveRepo.SearchNormalTicketPage;
import com.tourism.objectiveRepo.ZooManagementSystemPage;
import com.zooview.generics.BaseClass;
import com.zooview.generics.DataBaseUtility;
import com.zooview.generics.ExcelUtility;
import com.zooview.generics.FileUtility;
import com.zooview.generics.JavaUtility;
import com.zooview.generics.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
//@Listeners(com.zooview.generics.ListnerImplementation.class)
public class SearchForeignerTicketTest extends BaseClass {

	@Test//(retryAnalyzer = com.zooview.generics.RetryAnalysisClass.class)
	public  void searchForeignTicketTest() throws Throwable {

		
		ZooManagementSystemPage z=new ZooManagementSystemPage(driver);
		LoginPage l=new LoginPage(driver);
		DashboardPage d=new DashboardPage(driver);
		AdminProfilePage ap=new AdminProfilePage(driver);
		AddForeignerTicketPage af=new AddForeignerTicketPage(driver);
		ForeignPeopleSearchPage fpp=new ForeignPeopleSearchPage(driver);
		
		String url=f.getPropertyKeyValue("url");
		String un=f.getPropertyKeyValue("username");
		String pwd=f.getPropertyKeyValue("pwd");
		
		wb.maximizeWindow(driver);
		driver.get(url);
		wb.waitForPageLoadI(driver);
		Thread.sleep(3000);
		z.getAdmin().click();
		l.loginToApp(un, pwd);
		d.getAdmin().click();
		d.getProfile().click();
		ap.getLhn().click();
		Thread.sleep(1000);
		ap.getSearch().click();
		Assert.fail();
		ap.getForeignTicketSearch().click();
		fpp.getSearchForeignerTicket().sendKeys(ex.getExcelProperty(11, 1));
		fpp.getSubmit().click();
		Thread.sleep(3000);
		fpp.viewClick(driver, ex.getExcelProperty(11, 1));
		String visName = fpp.getVisitorName().getText();
		System.out.println(visName);
		
		Assert.assertTrue(visName.contains(ex.getExcelProperty(11, 1).toString().substring(0, 1).toUpperCase()+ex.getExcelProperty(11, 1).toString().substring(1)));
	}

}
