package com.tourism.objectiveRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminProfilePage {

	@FindBy(xpath = "//div[@class='nav-btn pull-left']")
	private WebElement lhn;
	
	@FindBy(xpath = "//span[text()='Animals Details']")
	private WebElement animalsdts;
	
	@FindBy(linkText = "Add Animals")
	private WebElement addAnimals;
	
	@FindBy(linkText = "Manage Animals")
	private WebElement manageAnimals;
	
	@FindBy(partialLinkText = "Manage Type Ticket")
	private WebElement manageTypeTicket;
	
	@FindBy(xpath = "//a[.='Normal Ticket']")
	private WebElement normalTicket;
	
	@FindBy(linkText = "Add Ticket")
	private WebElement addNormalTicket;
	
	@FindBy(linkText = "Manage Ticket")
	private WebElement manageNormalTicket;
	
	@FindBy(xpath = "//span[.='Foreigners Ticket']")
	private WebElement foreignerTicket;
	
	@FindBy(linkText = "Add Ticket")
	private WebElement addForeignerTicket;
	
	@FindBy(linkText = "Manage Ticket")
	private WebElement manageForeignerTicket;
	
	@FindBy(xpath = "//span[.='Page']")
	private WebElement page;
	
	@FindBy(linkText = "About Us")
	private WebElement aboutus;
	
	@FindBy (linkText = "Contact Us")
	private WebElement contactus;
	
	@FindBy(xpath = "//span[.='Reports']")
	private WebElement reports;
	
	@FindBy (linkText = "Normal People Report")
	private WebElement normalPeopleReport;
	
	@FindBy(linkText = "Foreigner People Report")
	private WebElement foreignPeopleReport;
	
	@FindBy(xpath = "//span[.='Search']")
	private WebElement search;
	
	@FindBy(linkText = "Normal Ticket Search")
	private WebElement normalTicketSearch;
	
	@FindBy(linkText = "Foreigner Ticket Search")
	private WebElement foreignTicketSearch;
	
	public AdminProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLhn() {
		return lhn;
	}

	public WebElement getAnimalsdts() {
		return animalsdts;
	}

	public WebElement getAddAnimals() {
		return addAnimals;
	}

	public WebElement getManageAnimals() {
		return manageAnimals;
	}

	public WebElement getManageTypeTicket() {
		return manageTypeTicket;
	}

	public WebElement getNormalTicket() {
		return normalTicket;
	}

	public WebElement getAddNormalTicket() {
		return addNormalTicket;
	}

	public WebElement getManageNormalTicket() {
		return manageNormalTicket;
	}

	public WebElement getForeignerTicket() {
		return foreignerTicket;
	}

	public WebElement getAddForeignerTicket() {
		return addForeignerTicket;
	}

	public WebElement getManageForeignerTicket() {
		return manageForeignerTicket;
	}

	public WebElement getPage() {
		return page;
	}

	public WebElement getAboutus() {
		return aboutus;
	}

	public WebElement getContactus() {
		return contactus;
	}

	public WebElement getReports() {
		return reports;
	}

	public WebElement getNormalPeopleReport() {
		return normalPeopleReport;
	}

	public WebElement getForeignPeopleReport() {
		return foreignPeopleReport;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getNormalTicketSearch() {
		return normalTicketSearch;
	}

	public WebElement getForeignTicketSearch() {
		return foreignTicketSearch;
	}
	
	
}
