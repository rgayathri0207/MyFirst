package util;


import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentTestInterruptedException;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Reporter {
	@Test
	public void report() {
		
	
	 ExtentHtmlReporter html =new ExtentHtmlReporter("./reports/result.html");
	 html.setAppendExisting(true);
	 ExtentReports extent= new ExtentReports();
	 extent.attachReporter(html);
	 ExtentTest test=extent.createTest("TestCaseName_Tc001","TestDescription");
	 test.assignAuthor("Gayathri");
	 test.assignCategory("Smoke");
	 test.pass("Passed");
	 test.fail("Failed");
	 extent.flush();
	}

}
