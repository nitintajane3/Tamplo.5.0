package com.tamplo.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tamplo.qa.testbase.TestBase;

public class HomePage extends TestBase
{

	public HomePage() throws IOException
	{
		
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath ="//li[@class='ng-scope']//a[@class='ng-binding'][contains(text(),'ACTIONS')]")
	WebElement linkaction;
	
	@FindBy(xpath ="//li[@class='ng-scope']//a[@class='ng-binding'][contains(text(),'DAY PLAN')]")
	WebElement linkdayplan;
	
	@FindBy(xpath ="//li[@class='ng-scope']//a[@class='ng-binding'][contains(text(),'MEETINGS')]")
	WebElement linkmeeting;
	
	@FindBy(xpath ="//li[@class='ng-scope']//a[@class='ng-binding'][contains(text(),'PROJECTS')]")
	WebElement linkproject;
	
	@FindBy(xpath ="//li[@class='ng-scope']//a[@class='ng-binding'][contains(text(),'DEPARTMENTS')]")
	WebElement linkdprtment;
	
	@FindBy(xpath ="//ul[@class='mainbannerNavList']//a[@class='ng-binding'][contains(text(),'PERSONAL TASKS')]")
	WebElement linkpersonaltask;
	
	@FindBy(xpath="//span[@class='pageMainHeaderTitle ng-binding']")
	WebElement verifydprtpage;
	
	
	public ActionPage clickOnActionLink()
	{
		linkaction.click();
		
		return new ActionPage();
	}
	
	public void clickOnPersonalTaskLink()
	{
		linkpersonaltask.click();
	}
	
	public void clickOnDayPlanLink()
	{
		linkdayplan.click();
	}
	
	public void clickOnProjectlink() 
	{
		linkproject.click();
	}
	
	public void clickOnDprtmentlink() 
	{
		
		linkdprtment.click();
		
		
	}
	
	public String veryfyDprtmentPage() 
	{
		String dprttitle = verifydprtpage.getText();
		
		return dprttitle;
	}
	
	public void clickOnMettinglink() 
	{
		linkmeeting.click();
	}
	
	

}
