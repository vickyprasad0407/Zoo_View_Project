//create a project and verify using jdbc
package practice_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyApiProjectUsingDatabase {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=WebDriverManager.chromedriver().create();
		//WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver:8084/");
		Thread.sleep(5000);
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys("bruna");
		driver.findElement(By.name("createdBy")).sendKeys("vicky");
		WebElement status = driver.findElement(By.name("status"));
		Select s=new Select(status);
		s.selectByValue("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
	}

}
