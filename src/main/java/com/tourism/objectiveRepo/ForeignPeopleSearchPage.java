package com.tourism.objectiveRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForeignPeopleSearchPage {

	@FindBy(id = "searchdata")
	private WebElement searchForeignerTicket;

	@FindBy(id = "submit")
	private WebElement submit;

	@FindBy(xpath = "//h5[contains(.,'Visitor Name: ')]")
	private WebElement visitorName;

	public ForeignPeopleSearchPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchForeignerTicket() {
		return searchForeignerTicket;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getVisitorName() {
		return visitorName;
	}
	public void viewClick(WebDriver driver,String name)
	{
		driver.findElement(By.xpath("//td[.='"+name+"']/..//following-sibling::td[5]")).click();
	}

}
