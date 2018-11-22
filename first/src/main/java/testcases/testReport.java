package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testReport extends util.Reporter1 {
	@BeforeTest
	public void testcaseSetUp() {
		Testcasename="TestReport_TC001";
		testDesc="Testing the report";
		Author="Gayathri R";
		category="Smoke";
	}
	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		test.pass("passed");
	}
	
	

}
