package com.tamplo.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tamplo.qa.pages.HomePage;
import com.tamplo.qa.pages.LoginPage;
import com.tamplo.qa.testbase.TestBase;

public class HomePageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	

	public HomePageTest() throws IOException 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		
		loginPage = new LoginPage();
		
		loginPage.login(prob.getProperty("username"), prob.getProperty("password"));
		
	}
	
	
	
	@Test
	public void Test() throws IOException
	{
		homePage = new HomePage();
		
	    homePage.clickOnDprtmentlink();
		
		String dprtmentpage = homePage.veryfyDprtmentPage();
		
		Assert.assertEquals(dprtmentpage, "DEPARTMENTS","Department page not found");
	
		
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	

}
