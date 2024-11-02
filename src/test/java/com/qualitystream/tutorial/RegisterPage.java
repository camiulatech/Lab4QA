package com.qualitystream.tutorial;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.project.pom.Base;

public class RegisterPage extends Base{
	
	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("	/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img\r\n");
	
	By usernameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPasswordLocator = By.cssSelector("input[name = 'confirmPassword']");
	
	By registerBtnLocator = By.name("submit");
	
	By registeredMessage = By.tagName("font");

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void registerUser() throws InterruptedException {
		click(registerLinkLocator);
		Thread.sleep(2000);
		
		if(isDisplayed(registerPageLocator)) {
			type("camiu", usernameLocator);
			type("coquito2110", passwordLocator);
			type("coquito2110", confirmPasswordLocator);
			
			click(registerBtnLocator);	
		}
		else {
			System.out.print("Register Pages was not found");
		}			

	}
	
	public String registeredMessage() {
		List<WebElement> fonts = findElements(registeredMessage);
		return getText(fonts.get(5));
		}

}
