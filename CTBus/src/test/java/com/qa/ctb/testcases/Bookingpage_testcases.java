package com.qa.ctb.testcases;

import org.testng.annotations.Test;
import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.BeforeTest;
import com.qa.ctb.Base.Base;
import com.qa.ctb.objectpages.Bookingpage;
import com.qa.ctb.objectpages.Selecttrippage;

public class Bookingpage_testcases extends Base {

	Bookingpage bp;
	String date;
	Selecttrippage strip;

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

			System.out.println("Title of Booking page:" + driver.getTitle());
			bp = new Bookingpage(driver);
			bp.departurecityname();
			bp.arrivalcityname();
			bp.passengercount();
			bp.datepicker(prop.getProperty("Dateofjurny"));
			bp.searchmethod();
			strip = new Selecttrippage(driver);
			strip.operatordata();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
