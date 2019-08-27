package com.boratech.seleniumtest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Amazonhw {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "src/com/boratech/resources/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver ();
		
		driver.get("https://www.amazon.com/"); 
		
		
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.clear();
		searchBox.sendKeys("cup");
		searchBox.submit();
		

		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		
		

		List<WebElement> itemId = driver.findElements(By.xpath("//[@div='data-asin']"));
		List<WebElement> itemName = driver.findElements(By.xpath("//a[@class='a-link-normal a-text-normal']"));
		List<WebElement> itemPrices = driver.findElements(By.xpath("//a[@class='a-price']"));

	
		System.out.println(itemId.size());
		
		for (int i = 0; i < itemId.size(); i++) {
			System.out.println((i+1) + " - " + itemId.get(i).getText());
			
			
			for (WebElement Name : itemName) {
	
			System.out.println(Name.getText());
			
			}
	
			for (WebElement Prices : itemPrices) {
				
		
			System.out.println(Prices.getText());
			
		}
	
		
		
			
	
		}
		


		driver.close();
		
		driver.quit();
		
	}
}

