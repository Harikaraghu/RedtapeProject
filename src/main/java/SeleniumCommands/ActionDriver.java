package SeleniumCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;

import config.StartBrowser;

public class ActionDriver extends StartBrowser {
	
	
	public void Type(By Locator, String text, String eleName) throws Exception 
	{
		try {
			driver.findElement(Locator).sendKeys(text);
			StartBrowser.ChildTest.pass("Successfuly typed in : " + eleName + " with Data : " + text,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot()).build());
		} catch (Exception e) {
			driver.findElement(Locator).sendKeys(text);
			StartBrowser.ChildTest.fail("Unable to typed in : " + eleName + " with Data : " + text,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot()).build());
	        StartBrowser.ChildTest.info(e);
	        throw(e);
		}
		
	}
	
	public void Click(By Locator, String eleName) throws Exception 
	{
		try {
			driver.findElement(Locator).click();
			StartBrowser.ChildTest.pass("Successfuly clicked on  : " +eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot()).build());
		} catch (Exception e) {
			StartBrowser.ChildTest.fail("Unable to Clicked on : " + eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot()).build());
			StartBrowser.ChildTest.info(e);
			throw(e);
		}
		
	}
	
	public void Action(By Locator,  String eleName) throws Exception 
	{
		try {
			Actions a  = new Actions(driver);
			a.moveToElement(driver.findElement(Locator)).build().perform();
			StartBrowser.ChildTest.pass("SuccessFuly Mouse-Over  on to  the :  " +eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot()).build());
		} catch (Exception e) {
			StartBrowser.ChildTest.fail("Unable to Mouse-Over  on  to the : " + eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot()).build());
			StartBrowser.ChildTest.info(e);
			throw(e);
		}
		
	}
	
	
	  public void VerifyLoginUserName(By Locator, String Text,  String eleName) throws Exception 
	  { 
		  try { 
			  	 
			  	Assert.assertEquals(driver.findElement(Locator).getText(), Text);
			  	StartBrowser.ChildTest.pass("Successfuly get the text  in  that : " +eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot()).build());
		  	  } catch (Exception e) 
		  	  { 
		  		StartBrowser.ChildTest.fail("Unable get the text  in that : " +eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot()).build());
		  		StartBrowser.ChildTest.info(e);
		  		throw(e);
		  	  }
	   }
	  
	   public void VerifyPageUrl(String Text, String eleName) throws Exception 
	   {
			try {
			     
				 Assert.assertEquals(driver.getCurrentUrl(), Text);
				 StartBrowser.ChildTest.pass("Successfuly get the Url of : " + eleName + " page" , MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot()).build());
			} catch (Exception e) {
				StartBrowser.ChildTest.fail("Unable get the url  of the : " +eleName + " Page ", MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot()).build());
		  		StartBrowser.ChildTest.info(e);
		  		throw(e);
				
			}
	   }
	   
	   public void SelectOption(By Locator, String Text, String eleName) throws Exception 
	   {    
		     try {
		    	 	Select s = new Select(driver.findElement(Locator));
		    	 	s.selectByVisibleText(Text);
		    	 	StartBrowser.ChildTest.pass("SuccessFuly Select the Quantity of  :  " +eleName,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot()).build());
		     	} catch (Exception e) {
		     		StartBrowser.ChildTest.fail("Unable Select the Quantity of  : " +eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot()).build());
			  		StartBrowser.ChildTest.info(e);
			  		throw(e);
				
		     	}
		   
	   }
	
	public String ScreenShot() 
	{
	   return((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);	
	}
}
