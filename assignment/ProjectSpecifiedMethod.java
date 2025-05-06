package week5.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class ProjectSpecifiedMethod {
	ChromeDriver driver;
	@BeforeMethod
	public void preCondition() {
		driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("bhuvanesh.moorthy@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Testleaf@2025");
		driver.findElement(By.id("Login")).click();
}
	public void postConditions() {
		driver.close();
	}

}
