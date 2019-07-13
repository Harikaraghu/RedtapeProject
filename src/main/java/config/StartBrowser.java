package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StartBrowser {
	public static  WebDriver driver;
	   public static  WebDriverWait WaitDr;
	   static Properties props;
	   ExtentHtmlReporter htmlreporter;
	   public static ExtentReports extent;
	   public static ExtentTest ParentTest;
	   public static ExtentTest ChildTest;
	   
	   public StartBrowser() 
	   {
		   try {
			   props =new Properties();
			   FileInputStream in = new FileInputStream("C:\\Users\\raghu-sai\\RedtapeOnlineShopping\\src\\main\\java\\Utilities\\configurations.Properties");
			   props.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) 
		{
			e.printStackTrace();
		 }
		  
	   }
	   @BeforeTest
	   public void Report() 
	   {
		   htmlreporter = new ExtentHtmlReporter("Reports/MyResult.html");
		   extent = new ExtentReports();
		   extent.attachReporter(htmlreporter);
	   }
	   
	  @BeforeMethod
	  public void MethodGetName(Method method) 
	  {
		  ParentTest = extent.createTest(method.getName());
	  }
	  
	  @BeforeSuite
	  public void beforeClass() {
		if(props.getProperty("browser").contains("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}else if(props.getProperty("browser").contains("firefox")) 
		{
			WebDriverManager.firefoxdriver().arch64().setup();;
			driver= new FirefoxDriver();
		}
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WaitDr = new WebDriverWait(driver,20);
		driver.get(props.getProperty("url"));
	  }
	  

	  @AfterSuite
	  public void afterClass() {
		  driver.quit();
		  extent.flush();
	  }
}
