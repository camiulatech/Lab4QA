package com.qualitystream.tutorial;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class SignIn_Test {

	private WebDriver driver;
	SignInPage signInPage;

	@Before
	public void setUp() throws Exception {
		signInPage = new SignInPage(driver);
		driver = signInPage.chromeDriverConnection();
		signInPage.visit("https://www.demo.guru99.com/test/newtours/index.php");
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		signInPage.SignIn();
		Thread.sleep(2000);
		assertTrue(signInPage.isHomePageDisplayed());
	}

}
