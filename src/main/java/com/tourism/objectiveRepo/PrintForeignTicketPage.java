package com.tourism.objectiveRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrintForeignTicketPage {
	@FindBy (xpath = "//i[contains(@onclick,'CallPrint')]")
	private WebElement print;
	
	public PrintForeignTicketPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPrint() {
		return print;
	}
	

}
