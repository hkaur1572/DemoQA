package firstmavenproject.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolsQA {
	WebDriver driver;

	@BeforeMethod
	public void Beforetest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/");

		driver.manage().window().maximize();

	}

@Test(priority=1)
//@Ignore
	public void test() {
		
		
		String tittleOfPage=driver.getTitle();
		System.out.println("Tittle of the Page "+tittleOfPage);
		Assert.assertEquals(tittleOfPage, "ToolsQA");
		
	}
	@Test(priority=2)
	//@Ignore
	public void clickElementsOnHome() {
		
		
	WebElement element =driver.findElement(By.cssSelector("div[class='card-up']"));
	
	element.click();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//System.out.println();
		
	}

	@AfterTest
	public void Aftertest() {

		driver.close();
try {
	Thread.sleep(50000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
