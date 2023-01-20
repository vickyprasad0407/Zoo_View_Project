package practice_package;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automat {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
       WebDriver driver=WebDriverManager.chromedriver().create();
       driver.get("http://rmgtestingserver/domain/Zoo_Management_System/");
       driver.findElement(By.linkText("Admin")).click();
       driver.findElement(By.id("username")).sendKeys("admin");
       driver.findElement(By.id("password")).sendKeys("Test@123");
       driver.findElement(By.id("form_submit")).click();
       
       driver.findElement(By.xpath("//h4[.='Admin ']")).click();
       Thread.sleep(2000);
       driver.findElement(By.linkText("Profile")).click();
       driver.findElement(By.xpath("//div[@class='nav-btn pull-left']")).click();
       Thread.sleep(3000);
        driver.findElement(By.xpath("//a[.='Animals Details']")).click();;
      // JavascriptExecutor j=(JavascriptExecutor)driver;
     //j
      // driver.findElement(By.linkText("Add Animals")).click();
       
	}

}
