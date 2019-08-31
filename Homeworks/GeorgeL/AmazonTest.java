public class AmazonTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/com/boratech/resources/chromedriver");
		WebDriver driver = new ChromeDriver();	

		String expectedURL = "https://www.amazon.com/";
		driver.get(expectedURL);
		
//		System.out.println(driver.getTitle());
//		Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more

		String actualTitle = driver.getTitle();
		String actualURL = driver.getCurrentUrl();
		if (actualTitle.startsWith("Amazon.com") && actualURL.equals(expectedURL)) {
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Lego");
			driver.findElement(By.id("twotabsearchtextbox")).submit();
		
		// Solution 1
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("Lego");	
		searchBox.submit();
		
		// Solution 2
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Lego");
//		driver.findElement(By.xpath("//*[@class='nav-input'][@type='submit']")).click();
		
		Keywords.waitFor(1);
		
		searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.clear();
		searchBox.sendKeys("Hotwheels Marvel Avengers");
		searchBox.submit();
		
		} else {
			System.out.println("Something is not correct");
		}
		
		driver.close();
		driver.quit();
		
	}

}