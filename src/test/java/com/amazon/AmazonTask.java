package com.amazon;


import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.sound.midi.Soundbank;
import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTask {
	
	WebDriver driver;
	
	@BeforeClass //runs once for all tests
	public void setUp() {
		System.out.println("Setting up WebDriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}
	
	@Test
	public void getAllProductsV1() {
		driver.get("https://www.amazon.com/s/ref=nb_sb_noss_1?url=search-alias%3Daps&field-keywords=wooden+spoon");
		List<WebElement> descriptions = driver.findElements(By.xpath("//h2"));
		for (WebElement item : descriptions) {
			System.out.println(item.getText());
		}
		
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='sx-price sx-price-large']"));
		for (WebElement price : prices) {
			System.out.println(price.getText());
		}
		
		System.out.println("------------>Print out descriptions and prices<-------------- ");
		for(int i=0;i<descriptions.size();i++) {
			System.out.println(descriptions.get(i).getText());
			System.out.println(prices.get(i).getText());
			System.out.println("==============================");
			
			
			List<WebElement>wholeItem = driver.findElements(By.xpath("//div[@class = 's-item-container']"));
			
			System.out.println("WholeItems.size(): " + wholeItem.size());
			
			for (WebElement webElement : wholeItem) {
				String d = webElement.findElement(By.tagName("h2")).getText();
				//String p = webElement.findElement(By.xpath("//span[@class='sx-price"))
				
			}
			
			
		}
		
		
	}
	
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
	
}	
