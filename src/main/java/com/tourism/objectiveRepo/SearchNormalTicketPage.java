package com.tourism.objectiveRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchNormalTicketPage {
	
	@FindBy(id = "searchdata")
	private WebElement searchNormalTicket;
	
	@FindBy(id = "submit")
	private WebElement submit;
	
	@FindBy(xpath = "//h5[contains(.,'Visitor Name: ')]")
	private WebElement visitorName;
	
	public SearchNormalTicketPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchNormalTicket() {
		return searchNormalTicket;
	}

	public WebElement getSubmit() {
		return submit;
	}
	public void viewTicket(WebDriver driver,String name)
	{
		driver.findElement(By.xpath("//td[.='"+name+"']/..//following-sibling::td[5]")).click();
	}

	public WebElement getVisitorName() {
		return visitorName;
	}
	

}
