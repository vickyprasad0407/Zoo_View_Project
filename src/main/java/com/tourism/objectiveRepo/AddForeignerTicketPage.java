package com.tourism.objectiveRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddForeignerTicketPage {

	@FindBy(xpath = "//input [@type='text']")
	private List<WebElement> textbox;
	
	@FindBy(name = "submit")
	private WebElement submit;
	
	public AddForeignerTicketPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getTextbox() {
		return textbox;
	}

	public WebElement getSubmit() {
		return submit;
	}

	

	
	

	
}
