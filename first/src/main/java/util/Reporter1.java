package util;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentTestInterruptedException;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Reporter1 {

	public static ExtentHtmlReporter html;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String Testcasename;
	public static String testDesc;
	public static String Author;
	public static String category;
	
	@BeforeSuite
	public void setUp() {
		html =new ExtentHtmlReporter("./reports/result.html");
		html.setAppendExisting(true);
		extent= new ExtentReports();
		extent.attachReporter(html);
	}

	@BeforeMethod
	public void testSetup() {
		test=extent.createTest(Testcasename,testDesc);
		test.assignAuthor(Author);
		test.assignCategory(category);
	}
	/*@Test
	public void report() {
		test.pass("Passed");
		test.fail("Failed");
	}*/
	@AfterSuite
	public void saveReport() {
		extent.flush();
	}

}
