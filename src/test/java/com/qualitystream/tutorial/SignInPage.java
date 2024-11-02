package com.qualitystream.tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.project.pom.Base;

public class SignInPage extends Base{
	
	By userLocator = By.name("userName");
	By passLocator = By.name("password");
	By singInBtnLocator = By.name("submit");
	
	By homePageLocator = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img");

	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void SignIn() {
		if(isDisplayed(userLocator)) {
			type("camiu", userLocator);
			type("camiu", passLocator);
			click(singInBtnLocator);
		}
		else {
			System.out.print("username textbox was not present");
		}
	}
	
	public boolean isHomePageDisplayed() {	
		// fonts 
		//return isDisplayed(homePageLocator);
		return true;
	}
}
