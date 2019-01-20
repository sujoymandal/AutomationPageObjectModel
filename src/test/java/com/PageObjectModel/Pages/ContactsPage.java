package com.PageObjectModel.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.PageObjectModel.Base.BasePage;

public class ContactsPage extends BasePage{
	
	//doing through egit
	public void createNewContact(){
		
		driver.switchTo().frame("mainpanel");
		Actions action=new Actions(driver);
		WebElement contact=driver.findElement(By.xpath("//a[text()='Contacts']"));
		WebElement newContact=driver.findElement(By.xpath("//a[text()='New Contact']"));
		action.moveToElement(contact).moveToElement(newContact).click().build().perform();;
		WebElement firstName=driver.findElement(By.id("first_name"));
		enteringValue(firstName,"abc");
		WebElement lastName=driver.findElement(By.id("surname"));
		enteringValue(lastName,"xyz");
		tearDown();
	}

}
