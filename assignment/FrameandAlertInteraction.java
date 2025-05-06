package week5.assignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameandAlertInteraction {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String text = driver.findElement(By.xpath("//p[text()='You pressed OK!']")).getText();
		if(text.equals("You pressed OK!")) {
			System.out.println("The Action was Performed correctly");
		}
		else {
			System.out.println("Action not clicked");
		}
		
		
		}

}
