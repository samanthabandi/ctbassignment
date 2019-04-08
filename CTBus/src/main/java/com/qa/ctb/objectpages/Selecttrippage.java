package com.qa.ctb.objectpages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.ctb.Base.Base;

public class Selecttrippage extends Base {

	WebDriver driver;
	String beforexpath, afterxpath, tdxpath;
	int rowcount, colcount;
	List<WebElement> rowele, departuretime, format;
	List<String> list = new ArrayList<String>();
	Set<String> set;
	WebElement it;
	@FindBy(xpath = "//table[contains(@id,'myTable')]//tbody/tr")
	List<WebElement> rows;
	@FindBy(xpath = "//table[contains(@id,'myTable')]//thead/tr[1]/th")
	List<WebElement> cols;

	public Selecttrippage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//display bus operators info based on selected places and date
	public void operatordata() {
		System.out.println("entered in to opertaordata method");
		System.out.println(driver.getCurrentUrl());
		System.out.println("Entered in to operator info page");
		rowcount = rows.size();
		colcount = cols.size();
		System.out.println("Number of rows:" + rowcount);
		System.out.println("Number of columns:" + colcount);
		System.out.println("Available operators are: ");
		for (int i = 2; i < rowcount; i++) {
			rowele = driver.findElements(By.xpath("//table[contains(@id,'myTable')]//tbody/tr[" + i
					+ "]//td//span[contains(@class,'mobileOperator')]"));
			departuretime = driver.findElements(By.xpath(
					"//table[contains(@id,'myTable')]//tbody/tr[" + i + "]//td//p//span[contains(@id,'deptTime')]"));
			for (WebElement it : rowele) {
				for (WebElement dtime : departuretime)
					System.out.println(it.getText() + "\t" + dtime.getText());

				// list.add(it.getText());
			}

		}

		// For each distinct opertaor values
		/*
		 * System.out.println("Set values are as follows"); Set<String> set = new
		 * HashSet<String>(list); for(String s: set) { System.out.println(s); }
		 */

	}
}
