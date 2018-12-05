package com.tamplo.qa.pages;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tamplo.qa.testbase.TestBase;

public class LoginTest extends TestBase
{
	LoginPage loginPage ;
	HomePage homePage;

	public LoginTest() throws IOException 
	{
		super();
		System.out.println("parent ");
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void initialiseBrowser() throws IOException
	{
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test
	public void loginTestone() throws IOException
	{
		homePage = loginPage.login(prob.getProperty("username"), prob.getProperty("password"));
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		
	}
	
	
}
