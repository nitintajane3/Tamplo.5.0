package com.tamplo.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tamplo.qa.testbase.TestBase;

import net.bytebuddy.asm.Advice.This;

public class LoginPage extends TestBase
{
	
	
	
	public LoginPage() throws IOException 
	{
		PageFactory.initElements(driver , this);
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath ="//button[@class='btn small btn-secondary ng-binding']")
	WebElement signinbuttonmac;
	
	@FindBy(xpath="//a[@class='btn btn-secondary-outline-sm mar-right-8 mar-left-8']")
	WebElement signinbutton;
	
	@FindBy(xpath="//input[@id='signin_email']")
	WebElement emailfield;
	
	@FindBy(xpath="//input[@id='signin_password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@id='signin-submit']")
	WebElement  loginbutton;
	
	
	public HomePage login(String username,String passwrod) throws IOException
	{
		signinbutton.click();
		emailfield.sendKeys(username);
		password.sendKeys(passwrod);
		loginbutton.click();
		
		return new HomePage();
	}
	
	

}
