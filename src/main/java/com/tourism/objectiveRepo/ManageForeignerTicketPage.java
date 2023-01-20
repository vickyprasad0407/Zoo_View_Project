package com.tourism.objectiveRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageForeignerTicketPage {
	
    //(//td[.='simon']/..//following-sibling::td[5]/a)[1]
	//td[5]/a[1]
	@FindBy(xpath = "td[5]/a[1]")
	private List<WebElement> viewClick;
	
	//(//td[.='simon']/..//following-sibling::td[5]/a)[2]
	@FindBy(xpath = "//td[5]/a[2]")
	private List<WebElement> deleteClick;
	
	@FindBy(xpath = "//td[2]")
	private List<WebElement> ticketID;
	
	@FindBy(xpath = "//td[1]")
	private List<WebElement> serialNO;
	
	@FindBy(xpath = "//td[4]")
	private List<WebElement> ticketDate;
	
	@FindBy(xpath = "//td[3]")
	private List<WebElement> visitorNames;
	
	@FindBy(linkText = "View")
	private WebElement onlyView;
	
	
	public ManageForeignerTicketPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getViewClick() {
		return viewClick;
	}

	public List<WebElement> getDeleteClick() {
		return deleteClick;
	}

	public List<WebElement> getTicketID() {
		return ticketID;
	}

	public List<WebElement> getSerialNO() {
		return serialNO;
	}

	public List<WebElement> getTicketDate() {
		return ticketDate;
	}

	public List<WebElement> getVisitorNames() {
		return visitorNames;
	}

	public WebElement getOnlyView() {
		return onlyView;
	}
	public void viewClick(WebDriver driver,String name)
	{
		driver.findElement(By.xpath("(//td[.='"+name+"']/..//following-sibling::td[5]/a)[1]")).click();
	}
	public void deleteClick(WebDriver driver,String name)
	{
		driver.findElement(By.xpath("(//td[.='simon']/..//following-sibling::td[5]/a)[2]")).click();
	}
	
}
