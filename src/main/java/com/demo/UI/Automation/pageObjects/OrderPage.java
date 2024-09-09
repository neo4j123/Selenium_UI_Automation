package com.demo.UI.Automation.pageObjects;

import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.UI.Automation.abstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {

	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//tbody/tr/td[2]")
	private List<WebElement>products;

	public boolean verifyProductDisplay(final String productName) {
		Boolean match = products.stream().anyMatch(new Predicate<WebElement>() {
			@Override
			public boolean test(WebElement product) {
				return product.getText().equalsIgnoreCase(productName);
			}
		});
		return match;
	}
	
	

}
