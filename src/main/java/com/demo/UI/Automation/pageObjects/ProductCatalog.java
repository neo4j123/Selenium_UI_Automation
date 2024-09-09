package com.demo.UI.Automation.pageObjects;

import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.UI.Automation.abstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent {

	WebDriver driver;

	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	@CacheLookup
	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By productsBy = By.cssSelector(".mb-3");
	By addToCartBtn = By.cssSelector(".card-body button:last-of-type");
	By toastConatiner = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
	}

	public WebElement getProductByName(final String productName) {
		return getProductList().stream().filter(new Predicate<WebElement>() {
			@Override
			public boolean test(WebElement product) {
				return product.findElement(By.cssSelector("b")).getText().equals(productName);
			}
		}).findFirst().orElse(null);

	}
	
	public void addToCart(String productName) {
		getProductByName(productName).findElement(addToCartBtn).click();
		waitForElementToAppear(addToCartBtn);
		waitForElementToAppear(toastConatiner);
		waitForElementToDisappear(spinner);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
