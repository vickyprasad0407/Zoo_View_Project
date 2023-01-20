package com.tourism.objectiveRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZooManagementSystemPage {

	@FindBy(linkText = "Home ")
	private WebElement home;
	
	@FindBy(linkText = "About")
	private WebElement about;
	
	@FindBy(linkText = "Contact")
	private WebElement contact;
	
	@FindBy(linkText = "Animals")
	private WebElement animals;
	
	//linkText = "Admin"
	//xpath="//a[text()='Admin']"
	@FindAll({@FindBy(xpath="//a[text()='Admin']"),@FindBy(linkText = "Admin")})
	private WebElement admin;
	
	public ZooManagementSystemPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getHome() {
		return home;
	}

	public WebElement getAbout() {
		return about;
	}

	public WebElement getContact() {
		return contact;
	}

	public WebElement getAnimals() {
		return animals;
	}

	public WebElement getAdmin() {
		return admin;
	}

	public void setHome(WebElement home) {
		this.home = home;
	}

	public void setAbout(WebElement about) {
		this.about = about;
	}

	public void setContact(WebElement contact) {
		this.contact = contact;
	}

	public void setAnimals(WebElement animals) {
		this.animals = animals;
	}
	
}
