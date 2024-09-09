package com.demo.UI.Automation.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.UI.Automation.TestComponents.BaseTest;
import com.demo.UI.Automation.TestComponents.Retry;

public class LoginErrorValidatiosTest extends BaseTest {

	@Test(dataProvider = "getData", retryAnalyzer = Retry.class)
	public void validateErrorMessage_Login(HashMap<String, String> data) throws IOException {

		lp.loginToApp(data.get("email"), data.get("password"));
		Assert.assertEquals("Incorrct email or password.", lp.getErrorMessage());

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(
				System.getProperty("user.dir") + "\\src\\test\\resources\\data\\purchaseOrder.json");
		return new Object[][] { { data.get(1) } };
	}
}
