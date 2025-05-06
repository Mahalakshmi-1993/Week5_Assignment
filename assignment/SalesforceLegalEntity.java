package week5.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SalesforceLegalEntity extends ProjectSpecifiedMethod{
	@Test
	public void legalEntity() throws InterruptedException{
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Legal Entities");
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("Testleaf");
		driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys("Salesforce");
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//button[@aria-label='Status']")).click();
		//Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value']"));
		driver.executeScript("arguments[0].click()", element);
		driver.findElement(By.xpath("//span[text()='Active']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String text = driver.findElement(By.xpath("//div[@data-name='Name']")).getText();
		System.out.println("Alert message "+text);
		
	}

}
