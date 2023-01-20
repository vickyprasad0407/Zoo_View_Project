package com.tourism.objectiveRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpadateTicketTypePage {
	
	@FindBy(id = "tprice")
	private WebElement ticketCost;
	
	@FindBy(name="submit")
	private WebElement submitButton;
	
	public UpadateTicketTypePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getTicketCost() {
		return ticketCost;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	

}
