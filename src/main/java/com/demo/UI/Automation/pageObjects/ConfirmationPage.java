package com.demo.UI.Automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.UI.Automation.abstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{

WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".hero-primary")
	WebElement confMessage;
	
	public String getConfirmationMessage() {
		return confMessage.getText();
	}
}
