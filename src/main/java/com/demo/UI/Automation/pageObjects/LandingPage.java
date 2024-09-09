package com.demo.UI.Automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.UI.Automation.abstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(id = "userEmail")
	WebElement userEmail;

	@CacheLookup
	@FindBy(id = "userPassword")
	WebElement userPasswd;

	@CacheLookup
	@FindBy(id = "login")
	WebElement loginBtn;
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;

	public ProductCatalog loginToApp(String email, String pass) {
		userEmail.sendKeys(email);
		userPasswd.sendKeys(pass);
		loginBtn.click();
		return new ProductCatalog(driver);
	}
	
	public void goToLandingPage() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	public String getErrorMessage() {
		waitForElementToAppear(errorMessage);
		return errorMessage.getText();
	}

}
