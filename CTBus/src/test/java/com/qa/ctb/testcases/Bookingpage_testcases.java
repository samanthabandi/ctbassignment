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

public class Bookingpage_testcases extends Base {

	Bookingpage bp;
	String date;

	public Bookingpage_testcases() throws IOException {
		super();

	}

	@BeforeTest
	public void init() throws InterruptedException {
		browserinit();

	}

	@Test
	public void search() throws IOException, ParseException {
		try {

			System.out.println(driver.getTitle());
			System.out.println("search method starts");
			bp = new Bookingpage(driver);
			bp.departurecityname();
			bp.arrivalcityname();
			bp.passengercount(2);
			bp.datepicker("8/05/2019");
			searchmethod();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void searchmethod() throws InterruptedException {
		
		System.out.println("Entered in to search method");
		WebElement e = driver.findElement(By.xpath("//*[@id=\'expressBus\']/div[1]/div[6]/div/button"));
		if (e.isDisplayed()) {
			Thread.sleep(2000);
			Actions action = new Actions(driver);
			action.moveToElement(e);
			WebElement afterhover = driver.findElement(By.xpath("//*[ends-with(@class,'hvr-grow-shadow')]"));
           if(afterhover.isDisplayed())
        	   afterhover.click();
           else
        	   System.out.println("not found");
		}
	}
}
