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
	WebElement signinbutton;
	
	@FindBy(xpath="//input[@id='emailIdLoginPage']")
	WebElement emailfield;
	
	@FindBy(xpath="//input[@id='pass']")
	WebElement password;
	
	@FindBy(xpath = "//div[@class='modalFooterInner']")
	WebElement  loginbutton;
	
	
	public HomePage login(String username,String passwrd)
	{
		signinbutton.click();
		emailfield.sendKeys(username);
		password.sendKeys(passwrd);
		loginbutton.click();
		
		return new HomePage();
	}
	
	

}
