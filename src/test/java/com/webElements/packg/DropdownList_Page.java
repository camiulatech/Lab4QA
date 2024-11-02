package com.webElements.packg;


import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.project.pom.Base;

public class DropdownList_Page extends Base {

	By dropdownList_Passengers = By.name("passCount");
	By dropdownList_DepartingFrom = By.name("fromPort");

	By singInPage = By.xpath("//img[@src='images/banner2.gif']");
	By userLoginLocator = By.name("userName");
	By passwordLoginLocator = By.name("password");
	By signInBtnLoginLocator = By.name("submit");
	
	By registerLinkLocator = By.linkText("Flights");
	
	By dropdownListBtn = By.id("dropdown-basic");
	By option2 = By.xpath("//*[@id=\"__docusaurus_skipToContent_fallback\"]/div/div/main/div/div/div/div/article/div[2]/div[2]/div[2]/div/div/div/div/a[2]");
	
	
	public DropdownList_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	public void signIn() throws InterruptedException {

		if (isDisplayed(userLoginLocator)) {
			type("camiu", userLoginLocator);
			type("coquito2110", passwordLoginLocator);
			click(signInBtnLoginLocator);
		} else {
			System.out.print("username textbox was not present");
		}

	}

	//1
	public String selectedDropdownList_Passengers() throws InterruptedException {
		
		click(registerLinkLocator);
		Thread.sleep(2000);
		
		WebElement dropdownList = findElement(dropdownList_Passengers);
		List<WebElement> options = dropdownList.findElements(By.tagName("option"));
		for (int i = 0; i < options.size(); i++) {
			if (getText(options.get(i)).equals("4")); {
				click(options.get(i));
			}
		}
		
		String selectedOption = "";
		for (int i = 0; i < options.size(); i++) {
			if(options.get(i).isSelected());
			selectedOption =getText(options.get(i));
		}
		
		return selectedOption;

	}
	
	//2
	public String selectedDropdownList_DepartingFrom() {
		Select selectList = new Select(findElement(dropdownList_DepartingFrom));
		selectList.selectByVisibleText("Paris");
		return getText(selectList.getFirstSelectedOption());
		
	}
	
	public void selectReactDropDownList() throws InterruptedException {
		click(dropdownListBtn);
		Thread.sleep(10000);
		click(option2);
	}
		

}