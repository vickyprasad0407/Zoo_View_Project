package com.practiceWeb_package;

import java.awt.Desktop.Action;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMTBus {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Actions a=new Actions(driver);
		a.moveByOffset(30, 30).click().perform();
		driver.findElement(By.xpath("//span[text()='Buses']")).click();
		String from="Kolkata";
		//Thread.sleep(10000);
        driver.findElement(By.id("fromCity")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'"+from+"')])[1]")).click();
		String to="Siliguri";
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(to);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[contains(text(),'"+to+"')])[1]")).click();
		String date="Sat Mar 04 2023";
		while(true)
		{
			try
			{
				driver.findElement(By.xpath("//div[@aria-label='"+date+"']")).click();
				break;
			}
			catch(NoSuchElementException e)
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		driver.findElement(By.id("search_button")).click();
		driver.findElement(By.xpath("//img[@class='primoCloseIcon']")).click();
		//List<WebElement> busList = driver.findElements(By.xpath("//div[@class='bus-card']/descendant::div[4]/span[1]"));
		List<WebElement> busList = driver.findElements(By.xpath("//span[@class='latoBlack font22 blackText appendRight15']"));
        for (WebElement e : busList) {
			System.out.println(e.getText());
		}
        driver.close();
	}

}
