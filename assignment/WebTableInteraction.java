package week5.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableInteraction {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
		fromStation.clear();
		fromStation.sendKeys("MAS",Keys.ENTER);
		WebElement toStation = driver.findElement(By.id("txtStationTo"));
		toStation.clear();
		toStation.sendKeys("MDU",Keys.ENTER);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		List<WebElement> trainName = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//tr/td[2]"));
		for(int i=0;i<trainName.size();i++) {
			String text=trainName.get(i).getText();
			System.out.println("Train Names :"+text);
		}
		List<String> list=new ArrayList<String>();
		for(WebElement name:trainName) {
			String text1=name.getText();
			list.add(text1);
			System.out.println(text1);
		}
		Set<String> trains=new HashSet<String>(list);
		if(list.size()==trains.size()) {
			System.out.println("No Duplicates in Train");		
		}
		else {
			System.out.println("Duplicates Found");
		}
		}

}
