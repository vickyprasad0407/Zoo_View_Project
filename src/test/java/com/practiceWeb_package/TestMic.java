package com.practiceWeb_package;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMic {

	public static void main(String[] args) throws InterruptedException, AWTException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
	    driver.get("https://mictests.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.id("mic-launcher")).click();
	    Robot r=new Robot();
	    r.keyPress(KeyEvent.VK_TAB);
	    Thread.sleep(1000);
	    r.keyPress(KeyEvent.VK_TAB);
	    Thread.sleep(1000);
	    r.keyPress(KeyEvent.VK_ENTER);
	    WebDriverWait wait=new WebDriverWait(driver, 40);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Testing failed')]")));
	    String text = driver.findElement(By.xpath("//li[contains(text(),'Testing failed')]")).getText();
	    System.out.println(text);
	    driver.close();
	}

}
