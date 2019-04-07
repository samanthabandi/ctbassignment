package com.qa.ctb.testcases;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.ctb.Base.Base;
import com.qa.ctb.objectpages.Bookingpage;
import com.qa.ctb.objectpages.Selecttrippage;

public class Bookingpage_testcases extends Base {

	Bookingpage bp;
	String date;
	Selecttrippage strip ;
	

	public Bookingpage_testcases() throws IOException {
		super();

	}

	@BeforeTest
	public void init() throws InterruptedException {
		browserinit();

	}

	@Test
	public  void search() throws IOException, ParseException {
		try {

			System.out.println(driver.getTitle());
			System.out.println("search method starts");
			bp = new Bookingpage(driver);
			bp.departurecityname();
			bp.arrivalcityname();
			bp.passengercount(2);
			bp.datepicker("8/05/2019");
			bp.searchmethod();
			strip =new Selecttrippage(driver);
			strip.operatordata();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			}
 
	
}
