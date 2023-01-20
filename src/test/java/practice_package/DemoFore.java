package practice_package;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tourism.objectiveRepo.AddForeignerTicketPage;
import com.zooview.generics.ExcelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoFore {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.get("https://rmgtestingserver/domain/");
		ExcelUtility ex=new ExcelUtility();
		//WebDriver driver=new ChromeDriver();
		AddForeignerTicketPage af=new AddForeignerTicketPage(driver);
		List<WebElement> listOfTbx = af.getTextbox();
		ArrayList<String> al = ex.getParticular( 1, 11, 13);
		for (int i = 0; i < listOfTbx.size(); i++) {
			System.out.println(listOfTbx.get(i));
			System.out.println(listOfTbx.get(i).getText());
		}
		for (int i = 0; i < listOfTbx.size(); i++) {
			listOfTbx.get(i).sendKeys(al.get(i));
		}

	}

}
