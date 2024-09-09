package com.demo.UI.Automation.pageObjects;

import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.UI.Automation.abstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css = ".cartSection h3")
	private List<WebElement>cardProducts;
	
	
	public boolean verifyProductDisplay(final String productName) {
		Boolean match = cardProducts.stream().anyMatch(new Predicate<WebElement>() {
			@Override
			public boolean test(WebElement product) {
				return product.getText().equalsIgnoreCase(productName);
			}
		});
		return match;
	}
	
	public CheckOutPage goToCheckOut() {
		checkoutEle.click();
		return new CheckOutPage(driver);
		
	}

}
