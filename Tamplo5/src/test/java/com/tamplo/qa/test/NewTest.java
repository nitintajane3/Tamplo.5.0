package com.tamplo.qa.test;



import java.io.IOException;
import java.util.ResourceBundle;


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
	initialization();
	
	System.out.println(bulde.getString("url")+ " ur get from magic ");
	  
  }
}
