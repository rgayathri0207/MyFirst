package learnFramework;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import cucumber.api.java.sl.Takrat;

public class SeMethods extends util.TestDataSheet implements WdMethods {
	public RemoteWebDriver driver;
	int i =1;
	@Override
	public void startApp(String browser, String url) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(url); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("The browser "+browser+" launched successfully"); 
		takeSnap();
	}

	@Override
	public WebElement locateElement(String locator, String locValue) {
		try {
			switch (locator) {
			case "id": return driver.findElementById(locValue);
			case "name": return driver.findElementByName(locValue);	
			case "xpath": return driver.findElementByXPath(locValue);
			case "class": return driver.findElementByClassName(locValue);
			case "linktext": return driver.findElementByLinkText(locValue);
			}
		} catch (NoSuchElementException e) {
			System.out.println("The element is not found");
		} catch (WebDriverException e) {
			System.out.println("Unknown Exception occured");
		} 
		return null;
	}

	@Override
	public WebElement locateElement(String locValue) {
		//this is only for ID
		return driver.findElementById(locValue);
	}

	@Override
	public void type(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("The data "+data+" enter successfully");
		} catch (WebDriverException e) {
			System.out.println("The data "+data+" not enter successfully");
		} finally {
			takeSnap();
		}
	}

	@Override
	public void click(WebElement ele) {

		try {
			ele.click();
			System.out.println("The element "+ele+" clicked"); 
		} catch (Exception e) {
			System.out.println("Unknown exception occured");
		}finally {
			takeSnap();
		}

	}
	public void clicWithoutSnap(WebElement ele) {
		try {
			ele.click();
			System.out.println("The element "+ele+" clicked"); 
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured");
		}

	}

	@Override
	public String getText(WebElement ele) {
		try {
			String text=ele.getText();
			return text;
		} catch (WebDriverException e) {
			System.out.println("Unknown Exception");
			return null;
		}finally {
			takeSnap();
		}

	}

	public void selectDropDown(WebElement ele, String value,String sel) {
		try {
			Select dd=new Select(ele);
			if(sel.equalsIgnoreCase("text")) {
				dd.selectByVisibleText(value);
			}else if(sel.equalsIgnoreCase("value")) {
				dd.selectByValue(value);
			}else if(sel.equalsIgnoreCase("index")){
				dd.selectByIndex(Integer.parseInt(value));
			}
		}catch (NumberFormatException e) {
			System.out.println("invalid index given");
		}catch (IndexOutOfBoundsException e) {
			System.out.println("Wrong index given");
		}catch(Exception e) {
			System.out.println("Unknown exception occured");
		}finally {
			takeSnap();
		}

	}

	/*@Override
	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			Select dropdown=new Select(ele);
			dropdown.selectByVisibleText(value);
		} catch (WebDriverException e) {
			System.out.println("Unknown Exception occured");

		}finally {
			takeSnap();
		}
	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			Select dropdown=new Select(ele);
			dropdown.selectByIndex(index);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Index is exceeded");	
		}catch(WebDriverException e) {
			System.out.println("Unknown Exception occured");
		}finally {
			takeSnap();
		}
	}*/

	@Override
	public boolean verifyTitle(String expectedTitle) {
		boolean b=false;
		try {
			String title=driver.getTitle();
			
			if(title.equals(expectedTitle)) {
				System.out.println("The title is matched with"+ expectedTitle);
				b=true;
			}else {
				System.out.println("The title is not matched with"+ expectedTitle);
			}
			
		} catch (Exception e) {
			System.out.println("Unknown Exception occured");
		}return b;
	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			if(ele.getText().equals(expectedText)) {
				System.out.println("The textis matched with "+ expectedText);
			}else {
				System.out.println("The text is not matched with "+ expectedText);
			}
		} catch (Exception e) {
			System.out.println("Unknown exception occured");
		}

	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			if(ele.getText().contains(expectedText)) {
				System.out.println("The text is partially matched with "+ expectedText);
			}else {
				System.out.println("The text is not partially matched with "+ expectedText);
			}
		} catch (Exception e) {
			System.out.println("Unknown exception occured");
		}

	}

	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			if(ele.getAttribute(attribute).equals(value)) {
				System.out.println("The value is matched with "+ value);
			}else {
				System.out.println("The value is not matched with "+ value);
			}
		} catch (Exception e) {
			System.out.println("Unknown exception occured");
		}

	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			if(ele.getAttribute(attribute).contains(value)) {
				System.out.println("The value is partially matched with "+ value);
			}else {
				System.out.println("The value is not partially matched with "+ value);
			}
		} catch (Exception e) {
			System.out.println("Unknown exception occured");
		}
	}

	@Override
	public void verifySelected(WebElement ele) {
          try {
			if(ele.isSelected()) {
				  System.out.println("The element "+ele+ " is selected");
			  }
			  else {
				  System.out.println("The element "+ ele+" is not selected");
			  }
		} catch (Exception e) {
		System.out.println("Unknown exxception occured");		}
	}

	@Override
	public void verifyDisplayed(WebElement ele) {
		try {
			if(ele.isDisplayed()) {
				System.out.println("The element "+ele+ " is displayed");
			}else {
				System.out.println("The element "+ ele+ " is not displayed ");
			}
		} catch (Exception e) {
			System.out.println("Unknown exception occured");
		}

	}

	@Override
	public void switchToWindow(int index) {
		try {
			Set<String> sAllwindows=driver.getWindowHandles();
			List<String> lAllwindow= new ArrayList<String>();
			lAllwindow.addAll(sAllwindows);
			driver.switchTo().window(lAllwindow.get(index));
		} catch (NoSuchWindowException e) {
			System.out.println("Window is not available");
		}catch(Exception e){
			System.out.println("Unknown Exception occured");
		
		}finally {
			takeSnap();
		}

	}

	@Override
	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not available");
		}catch(Exception e) {
			System.out.println("Unknown Exception occurred");
		}

	}
	
	public void switchToParentFrame() {
		try {
			driver.switchTo().parentFrame();
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not available");
		}catch(Exception e) {
			System.out.println("Unknown Exception occurred");
		}

	}
	
	public void switchToMainFrame() {
		try {
			driver.switchTo().defaultContent();
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not available");
		}catch(Exception e) {
			System.out.println("Unknown Exception occurred");
		}

	}

	@Override
	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
			System.out.println("Alert accepted");
		} catch (NoAlertPresentException e) {
			System.out.println("Alert is not presented");
		}
	}

	@Override
	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
			System.out.println("Alert dismissed");
		} catch (NoAlertPresentException e) {
			System.out.println("Alert is not presented");
		}


	}

	@Override
	public String getAlertText() {
		String text=null;
		try {
			text= driver.switchTo().alert().getText();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert is not present");
		}
		return text;

	}

	@Override
	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dec = new File("./snaps/img"+i+".png");
		try {
			FileUtils.copyFile(src, dec);
		} catch (IOException e) {
			System.out.println("Unknown Exception occured");
		}
		i++;
	}

	@Override
	public void closeBrowser() {
		driver.close();
	}

	@Override
	public void closeAllBrowsers() {
		driver.quit();
	}

	
	@DataProvider(name="fetchData")
	public String[][] getTestData() throws IOException{
		return getData();
	}
	

}
