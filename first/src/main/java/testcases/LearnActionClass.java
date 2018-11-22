package testcases;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LearnActionClass extends learnFramework.SeMethods  {
	@Test
	public void action() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(1000);
		Actions ac=new Actions(driver);
		WebElement elect=locateElement("xpath", "//span[@text='Electronics')]");
		WebElement oppo=locateElement("linktext","OPPO");
		ac.moveToElement(elect).moveToElement(oppo).click().perform();	

	}

}
