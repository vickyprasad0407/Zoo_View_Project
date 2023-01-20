package com.zooview.generics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
/**
 * This class is used to provide information about webdriver specific methods
 * @author Mr. Vicky
 *
 */
public class WebDriverUtility {
/**
 * This method is used to maximize the window
 * @param driver
 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to load the pages for implicitly wait method
	 * @param driver
	 */
	public void waitForPageLoadI(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * this method is used to check the visibility of element by explicit wait
	 * @param driver
	 * @param element
	 */
	public void elementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method is used to select element by using value of select class
	 * @param element
	 * @param value
	 */
	public void select(WebElement element,String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * this method is used to select element by using index of select class
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * this method is used to select the element by visible text of select class
	 * @param visible
	 * @param element
	 */
	public void select(String visible,WebElement element)
	{
		Select s=new Select(element);
		s.selectByVisibleText(visible);
	}
	/**
	 * this method is used to move the mouse pointerto particular location
	 * @param driver
	 * @param target
	 */
	public void mouseHover(WebDriver driver,WebElement target)
	{
		Actions a=new Actions(driver);
		a.moveToElement(target).perform();;
	}
	/**
	 * this method is used for drag and drop the element 
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void drag(WebDriver driver,WebElement src,WebElement dest)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(src, dest).perform();;
	}
	/**
	 * this method is used for double click
	 * @param driver
	 */
	public void doubleclk(WebDriver driver)//use full method name like click not clk
	{
		Actions a=new Actions(driver);
		a.doubleClick();
	}
	/**
	 * this method is used for right click by using action class
	 * @param driver
	 */
	public void rhtClick(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.contextClick().perform();
	}
	/**
	 * this method is used for right click at target location
	 * @param driver
	 * @param target
	 */
	public void rhtClick(WebDriver driver,WebElement target)
	{
		Actions a=new Actions(driver);
		a.contextClick(target).perform();
	}
	/**
	 *this method is used for clicking enter  using action class
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * this method is used for clicking enter  using robot class
	 * @param driver
	 * @throws AWTException
	 */
	public void enterKey(WebDriver driver) throws AWTException
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	/**
	 * this method is used for switching from one frame to another frame using index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * this method is used for switching from one frame to another frame using string value
	 * @param driver
	 * @param nameorId
	 */
	public void switchToFrame(WebDriver driver, String nameorId)
	{
		driver.switchTo().frame(nameorId);
	}
	/**
	 * this method is used for switching from one frame to another frame using webelement
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver,WebElement address)
	{
		driver.switchTo().frame(address);
	}
	/**
	 * this method is used to click on ok button on alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public String alertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	/**
	 * this method is used to click on cancel button on alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this method is used to verify the element on other page
	 * @param driver
	 * @param partTitle
	 */
	public void switchToDriver(WebDriver driver,String partTitle)
	{
		Set<String> window = driver.getWindowHandles();
		Iterator<String> itr=window.iterator();
		while(itr.hasNext())
		{
			String winId=itr.next();
			String currWindTitle=driver.switchTo().window(winId).getTitle();
			if (currWindTitle.contains(partTitle))
			{
				System.out.println("switching to current window");
				break;
			}
		}
	}
	/**
	 * this method is used to take the screen shot
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public static String getStringShot(WebDriver driver,String screenShotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		java.io.File src= ts.getScreenshotAs(OutputType.FILE);
		String path="./src/test/resources/"+screenShotName+".png";
		java.io.File dest=new java.io.File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}
	/**
	 * this method is used to scroll to particular element
	 * @param driver
	 * @param ele
	 */
	public void scrollBarAction(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=ele.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",ele);
		//js.executeScript("argument[0].scrollIntoView()", ele);
	}
}
