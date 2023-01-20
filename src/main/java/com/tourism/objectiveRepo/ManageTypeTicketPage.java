package com.tourism.objectiveRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageTypeTicketPage {

	@FindBy(xpath = "(//td[4])[1]")
	private WebElement normalAdult;
	
	@FindBy(xpath = "(//td[4])[2]")
	private WebElement normalChild;
	
	@FindBy(xpath = "(//td[4])[3]")
	private WebElement foreignerAdult;
	
	@FindBy(xpath = "(//td[4])[4]")
	private WebElement foreignerChild;
	
	public ManageTypeTicketPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getNormalAdult() {
		return normalAdult;
	}

	public WebElement getNormalChild() {
		return normalChild;
	}

	public WebElement getForeignerAdult() {
		return foreignerAdult;
	}

	public WebElement getForeignerChild() {
		return foreignerChild;
	}
	
}
