package week5.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass{

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro phone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		//driver.findElement(By.xpath("//div[text()='oneplus 9 pro phone'][1]")).click();
		WebElement priceFirstEle = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		String priceofFirstProduct = priceFirstEle.getText();
		System.out.println("Price of the first product :"+priceofFirstProduct);
		Actions mouseHover=new Actions(driver);
		WebElement ratingElement = driver.findElement(By.xpath("(//i[@class='a-icon a-icon-star-small a-star-small-4-5'])[1]"));
		mouseHover.moveToElement(ratingElement).perform();
		Thread.sleep(3000);
		WebElement ratingEle1 = driver.findElement(By.xpath("//h2[@id='acr-popover-title']"));
		String rating = ratingEle1.getText();
		System.out.println("Customer ratings for first displayed product : "+rating);
		driver.findElement(By.xpath("//span[contains(text(),'OnePlus')]")).click();
		Set<String> allWindows=driver.getWindowHandles();
		System.out.println("All Windows :"+allWindows);
		List<String> allAddress=new ArrayList<String>(allWindows);
		driver.switchTo().window(allAddress.get(1));
		driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//span[@class='nav-cart-icon nav-sprite']")).click();
		WebElement totalAmountEle = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']"));
		String totalAmount = totalAmountEle.getText();
		System.out.println("Subtotal :"+totalAmount);
		driver.close();
		driver.switchTo().window(allAddress.get(0));
		driver.close();
		
		
		
		
		
	}

}
