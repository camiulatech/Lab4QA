package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchTests {

	private WebDriver driver;
	
	By videoLinkLocator = By.cssSelector("a[href=\'https://www.youtube.com/watch?v=R_hh3jAqn8M']");
			
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void testGooglePage() {
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.clear();
		searchbox.sendKeys("quality-stream Introduccion a la Automatizacion de Pruebas de Software");
		searchbox.submit();
		
		//Implicit wait
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Explicit Wait
		//WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//ewait.until(ExpectedConditions.titleContains("quality-stream"));
		//		assertEquals("quality-stream Introduccion a la Automatizacion de Pruebas de Software - Buscar con Google", driver.getTitle());

		
		//Fluent Wait ajax -> asincronas, + control pq se puede establecer tiempo max
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		WebElement video = fwait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(videoLinkLocator);
			}
		}
		);
		
		assertTrue(driver.findElement(videoLinkLocator).isDisplayed());
		
	}
	
	@After
	public void tearDown() {
		//driver.quit();
	}
	
}
