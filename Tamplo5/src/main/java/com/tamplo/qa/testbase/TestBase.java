package com.tamplo.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tamplo.qa.utils.TestUtils;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prob;
	
	
	public TestBase() throws IOException
	{
		System.out.println("parent class constructor");
		try {
			
			prob = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/tamplo/qa/config/config.properties");
			prob.load(ip);
		} catch (FileNotFoundException r) 
		{
		r.printStackTrace();
			// TODO: handle exception
		}
		catch (IOException r) 
		{
			r.printStackTrace();
		}
	}

	public static void  initialization() 
	{
		
		String browsername = prob.getProperty("browser");
		
		if(browsername.equals("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Tamplo5\\drivers\\chromedriver.exe");
			driver =  new ChromeDriver();
			
		}else 
			if (browsername.equals("firefox")) 
			{
				System.setProperty("webdriver.gecko,driver", "");
				driver = new FirefoxDriver();
			}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGELOAD, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT, TimeUnit.SECONDS);
		
		driver.get(prob.getProperty("url"));
		
	}
	
	
}
