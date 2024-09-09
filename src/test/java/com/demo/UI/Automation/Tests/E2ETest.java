package com.demo.UI.Automation.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.UI.Automation.TestComponents.BaseTest;
import com.demo.UI.Automation.pageObjects.CartPage;
import com.demo.UI.Automation.pageObjects.CheckOutPage;
import com.demo.UI.Automation.pageObjects.ConfirmationPage;
import com.demo.UI.Automation.pageObjects.OrderPage;
import com.demo.UI.Automation.pageObjects.ProductCatalog;

public class E2ETest extends BaseTest {

	@Test(dataProvider = "getData")
	public void productOrderTest(HashMap<String, String> data) throws IOException, InterruptedException {

		ProductCatalog pc = lp.loginToApp(data.get("email"), data.get("password"));
		List<WebElement> products = pc.getProductList();
		pc.addToCart(data.get("product"));
		CartPage cp = pc.goToCartPage();
		Boolean match = cp.verifyProductDisplay(data.get("product"));
		Assert.assertTrue(match);
		CheckOutPage chkOut = cp.goToCheckOut();
		chkOut.selectCountry("India");
		ConfirmationPage cnfPage = chkOut.submitOrder();
		String confirmMessage = cnfPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = { "productOrderTest" })
	public void productErrorValidation() throws IOException {

		String productName = "ADIDAS ORIGINAL";
		ProductCatalog pc = lp.loginToApp("srivastava.akash42@gmail.com", "Automation@123");
		OrderPage op = pc.goToOrderPage();
		Assert.assertTrue(op.verifyProductDisplay(productName));
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(
				System.getProperty("user.dir") + "\\src\\test\\resources\\data\\purchaseOrder.json");
		return new Object[][] { { data.get(0) } };
	}
}
