package com.tamplo.qa.test;



import java.io.IOException;
import java.util.ResourceBundle;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.tamplo.qa.testbase.TestBase;


public class NewTest extends TestBase
{
	
	ResourceBundle bulde = ResourceBundle.getBundle("com.tamplo.qa.config.config");
 

public NewTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

@Test
  public void f() throws IOException 
  {
	
	
	
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\git\\Tamplo.5.0\\Tamplo5\\drivers\\geckodriver.exe");
	FirefoxDriver driver1 = new FirefoxDriver();
	driver1.manage().window().maximize();
	driver1.getTitle();
	driver1.manage().deleteAllCookies();
	driver1.get(prob.getProperty("url"));
	
	System.out.println(bulde.getString("url")+ " ur get from magic ");
	  
  }
}
