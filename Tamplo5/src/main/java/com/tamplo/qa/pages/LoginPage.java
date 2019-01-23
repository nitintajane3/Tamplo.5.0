package com.tamplo.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tamplo.qa.testbase.TestBase;

import net.bytebuddy.asm.Advice.This;
import sun.awt.datatransfer.DataTransferer.ReencodingInputStream;

public class LoginPage extends TestBase
{
	
	
	
	public LoginPage() throws IOException 
	{
		PageFactory.initElements(driver , this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath ="//button[@class='btn small btn-secondary ng-binding']")
	WebElement signinbuttonmac;
	
	@FindBy(xpath="//button[@class='btn small btn-secondary ng-binding']")
	WebElement signinbutton;
	
	@FindBy(xpath="//input[@id='emailIdLoginPage']")
	WebElement emailfield;
	
	@FindBy(xpath="//input[@id='pass']")
	WebElement password;
	
	@FindBy(xpath = "//button[@id='submitButton']")
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
