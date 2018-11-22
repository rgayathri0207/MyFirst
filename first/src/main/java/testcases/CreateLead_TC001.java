package testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class CreateLead_TC001 extends learnFramework.SeMethods {
//	@Parameters ({"browser","url"})
	
	@Test(invocationCount=3,invocationTimeOut=3000/*dataProvider="fetchData"*/ )
	public void createLead(/*String cName,String fName,String lName*/){
		startApp("chrome", "http://leaftaps.com/opentaps");
		WebElement userName=locateElement("id", "username");
		type(userName, "DemoCSR");
		WebElement passWord=locateElement("id", "password");
		type(passWord, "crmsfa");
		WebElement loginButton=locateElement("class", "decorativeSubmit");
		click(loginButton);
		WebElement crm=locateElement("linktext", "CRM/SFA");
		click(crm);
		WebElement createLead=locateElement("linktext", "Create Lead");
		
		click(createLead);WebElement companyName=locateElement("id", "createLeadForm_companyName");
		type(companyName, "DXC");
		WebElement firstName=locateElement("id", "createLeadForm_firstName");
		type(firstName, "Jaya");
		WebElement lastname=locateElement("id", "createLeadForm_lastName");
		type(lastname, "Durga");
		//WebElement source=locateElement("id", "createLeadForm_dataSourceId");
		//selectDropDownUsingText(source, "Conference");
		WebElement createLeadbutton=locateElement("xpath", "//input[@value='Create Lead']");
		click(createLeadbutton);
	}
		@AfterMethod
		public void closeapp(){
			closeBrowser();
		}
		
		
		
	



        
      
	

}
