package com.tourism.objectiveRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id = "username")
	private WebElement untbx;
	
	@FindBy(id = "password")
	private WebElement pwtbx;
	
	@FindAll({@FindBy(id = "form_submit"),@FindBy(name = "login")})
	private WebElement submit;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUntbx() {
		return untbx;
	}

	public WebElement getPwtbx() {
		return pwtbx;
	}

	public WebElement getSubmit() {
		return submit;
	}
	
	public void loginToApp(String un,String pwd) throws Throwable
	{
		untbx.sendKeys(un);
		pwtbx.sendKeys(pwd);
		Thread.sleep(2000);
		submit.click();
	}
}
