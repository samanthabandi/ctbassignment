package com.qa.ctb.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.ctb.Base.Base;
import com.qa.ctb.objectpages.Selecttrippage;

public class Selecttrip_testcases extends Base{
	
	Selecttrippage sp;
	Bookingpage_testcases bpt;
	
	public Selecttrip_testcases() throws IOException
	{
		super();
		
	}
	
	@BeforeTest
	public void init() throws InterruptedException
	{
		browserinit();
		
	}
	
	
	
	

}
