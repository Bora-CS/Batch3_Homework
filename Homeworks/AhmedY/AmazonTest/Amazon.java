package com.boratech.seleniumTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.boratech.util.Keywords;

public class Amazon {
	static int totalItem = 0;
	public static void main(String[] args) {
		WebDriver driver =Keywords.startTestOnChrome("https://www.amazon.com/");
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("Shampoo");
		searchBox.submit();
		printer(driver);
		System.out.println("First Page Item " + totalItem);

		
		// next page click
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[7]/div/div/div/ul/li[7]/a")).click();
		Keywords.waitFor(3);
			
		printer(driver);	
		
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[7]/div/div/div/ul/li[7]/a")).click();

		printer(driver);
		Keywords.endTest(driver);
}
	public static void printer(WebDriver driver) {
		List<WebElement> names = driver.findElements(By.cssSelector(".a-size-base-plus.a-color-base.a-text-normal"));
		List<WebElement> symbol = driver.findElements(By.className("a-price-symbol"));
		List<WebElement> wholePrice = driver.findElements(By.className("a-price-whole"));
		List<WebElement> cents = driver.findElements(By.className("a-price-fraction"));
		
		
			for (int i = 0; i < names.size() - 1; i++) {
				String name = names.get(i).getText().isEmpty() ? "Empty Space": names.get(i).getText();
				String symb = "Empty Symbol";
				if (!"Empty Space".equals(name)) {
					symb = symbol.get(i).getText();
					
				}
					System.out.println((totalItem + 1) + ": " + name + "///" + symb
						+ wholePrice.get(i).getText() + "." + cents.get(i).getText());
					totalItem++;
					
					if (totalItem == 100) {
						System.out.println("Reached 1 item");
						return;	
					}
			}
	}
}
