package com.qualitystream.tutorial;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.webElements.packg.DropdownList_Page;

public class DropDownList_Test {

	private WebDriver driver;
	DropdownList_Page ddLPage;
	
	@Before
	public void setUp() throws Exception {
		
		ddLPage = new DropdownList_Page(driver);
		driver=ddLPage.chromeDriverConnection();
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void testing_classic_DDL() throws InterruptedException {
		ddLPage.visit("https://demo.guru99.com/test/newtours/");

		ddLPage.signIn();;
		
		assertEquals(ddLPage.selectedDropdownList_Passengers(),"4");
		assertEquals(ddLPage.selectedDropdownList_DepartingFrom(),"Paris");
	}
	
	/*
	@Test
	public void test() throws InterruptedException {
		ddLPage.visit("https://react-bootstrap.netlify.app/docs/components/dropdowns");
		ddLPage.selectReactDropDownList();
	}
	*/
	

}
