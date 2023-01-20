package com.tourism.objectiveRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	@FindBy(xpath = "((//div[@class='row'])[1]/div/div/div/div)")
	private List<WebElement> normalPeople;
	
	@FindBy(xpath = "((//div[@class='row'])[2]/div/div/div/div)")
	private List<WebElement> foreignPeople;
	
	@FindBy(xpath = "//h4[text()='Admin ']")
	private WebElement admin;
	
	@FindBy(linkText = "Profile")
	private WebElement profile;
	
	@FindBy(linkText = "Settings")
	private WebElement setting;
	
	@FindAll({@FindBy(linkText = "Log Out"),@FindBy(xpath = "//a[text()='Log Out']")})
	private WebElement logout;
	
	public DashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getNormalPeople() {
		return normalPeople;
	}

	public List<WebElement> getForeignPeople() {
		return foreignPeople;
	}

	public WebElement getAdmin() {
		return admin;
	}

	public WebElement getProfile() {
		return profile;
	}

	public WebElement getSetting() {
		return setting;
	}

	public WebElement getLogout() {
		return logout;
	}

	
	public void setLogout() {
        logout.click();
	}	

}
