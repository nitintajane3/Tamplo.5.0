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
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.tamplo.qa.utils.TestUtils;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prob;
	
	
	public TestBase() throws IOException
	{
		
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
		
		if(browsername.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Tamplo5\\drivers\\chromedriver.exe");
			driver =  new ChromeDriver();
			
		}else 
			if (browsername.equals("firefox")) 
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\git\\Tamplo.5.0\\Tamplo5\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}else 
			
		if (browsername.equals("ie")) 
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Admin\\git\\Tamplo.5.0\\Tamplo5\\drivers\\IEDriverServer.exe");
			
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGELOAD, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT, TimeUnit.SECONDS);
		
		driver.get(prob.getProperty("url"));
		
	}
	
	
}
