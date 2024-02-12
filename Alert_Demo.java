package alert.com;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class Alert_Demo {
	
	static WebDriver driver;	
	
	public static void browserlaunch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Alerts.html");
	}
	
	public static void simpleAlert() {
		WebElement simpleAlert = driver.findElement(By.xpath("//button[@onclick='alertbox()']"));
		simpleAlert.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();	
	}
	
	public static void confirmAlert(String confirmation) {
		driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
		driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();
		Alert alert = driver.switchTo().alert();
		if(confirmation.equalsIgnoreCase("accept")) {
			alert.accept();
		}else {
			alert.dismiss();
		}		
	}
	
	public static void promptAlert(String confirmation) {
		driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
		driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Harish");
		if(confirmation.equalsIgnoreCase("accept")) {
			alert.accept();
		}else {
			alert.dismiss();
		}		
	}	

	public static void main(String[] args) throws InterruptedException, IOException {
		browserlaunch();
		simpleAlert();	
		Thread.sleep(2000);
		confirmAlert("accept");
		Thread.sleep(2000);
		promptAlert("accept");
		Thread.sleep(2000);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\inbaraj\\eclipse-workspace\\Selenium_Demo\\src\\alert\\com\\Capture.png");
		FileUtils.copyFile(src, des);
	}

}
