package com.qa.ctb.objectpages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.ctb.Base.Base;

public class Bookingpage extends Base {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//input[contains(@placeholder,'Enter Departure City')]")
	WebElement departurecity;

	@FindBy(xpath = "//input[contains(@class,'form-control to_field onewayTo ui-autocomplete-input')]")
	WebElement arrivalcity;

	@FindBy(xpath = "//div[contains(@class,'dd-select')]")
	WebElement passengerselect;

	@FindBy(xpath = "//a[contains(@title,'Prev')]")
	WebElement prev;

	@FindBy(xpath = "//a[contains(@title,'Next')]")
	WebElement next;

	@FindBy(id = "datepickerExpressBus")
	WebElement datepicker;

	@FindBy(xpath = "//div[contains(@class,'ui-datepicker-title')]")
	WebElement curdate;

	@FindBy(xpath = "//a[contains(@class,'ui-state-default')]")
	List<WebElement> datesdiv;

	@FindBy(xpath = "//button[contains(@type,'submit')]")
	WebElement searchbutton;

	public Bookingpage(WebDriver driver) throws IOException {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	// Selecting departure city
	public void departurecityname() {
		departurecity.sendKeys("kua");
		departurecity.sendKeys(Keys.ARROW_DOWN);
		selectoptionwithtext(prop.getProperty("Departurecity"));
	}

	public void selectoptionwithtext(String s) {
		try {

			WebElement autoOptions = driver.findElement(By.id("ui-id-1"));
			wait.until(ExpectedConditions.visibilityOf(autoOptions));
			List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
			for (WebElement option : optionsToSelect) {
				//System.out.println(option.getText());
				String text = option.getText();
				if (text.contains(s)) {
					System.out.println("Trying to select: " + text);
					WebElement w = option.findElement(By.tagName("span"));
					//System.out.println(w.getText());
					w.click();
					break;
				}
			}

		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	// Selecting arrival city

	public void arrivalcityname() {
		if (arrivalcity.isEnabled()) {
			arrivalcity.sendKeys(prop.getProperty("Arrivalcity"));

		} else
			System.out.println("Arrival city is in disabled mode");
	}

	// Selecting passenger count

	public void passengercount() {

		passengerselect.click();
		List<WebElement> li = passengerselect.findElements(By.xpath("//label[contains(@class,'dd-option-text')]"));
		for (WebElement loop : li) {
			String count = loop.getText();
			if (count.matches(prop.getProperty("Passengercount"))) {
				loop.click();
				break;
			}
		}

	}
//selecting date of journey 
	public void datepicker(String datetoset) throws Exception {
		// clicking on current date
		datepicker.click();
		String targetdate = datetoset;
		String currentdate = curdate.getText();
		Date setdate = new SimpleDateFormat("dd/MM/yyyy").parse(targetdate);
		Date currdate = new SimpleDateFormat("MMM yyyy").parse(currentdate);
		int month_diff = Months
				.monthsBetween(new DateTime(currdate).withDayOfMonth(1), new DateTime(setdate).withDayOfMonth(1))
				.getMonths();

		if (month_diff < 0)
			System.out.println("Paste dates are not allowed to select");

		else {
			for (int i = 0; i < month_diff; i++) {
				next.click();
				if (i > 4) {
					System.out.println("prebooking allowed only for up to 4 months");
					break;
				}
			}

		}

		String day;
		day = new SimpleDateFormat("dd").format(setdate);
		int daytoselect = Integer.parseInt(day);
		//System.out.println("day to select is: " + daytoselect);
		Iterator<WebElement> it = datesdiv.iterator();

		while (it.hasNext()) {
			WebElement n = it.next();
			String s = n.getText();
			int d = Integer.parseInt(s);
			if (daytoselect == d) {
				n.click();
				break;
			}
		}

	}

	// Search button access
	public void searchmethod() {
		System.out.println("Entered in to search method");
		Actions action = new Actions(driver);
		action.moveToElement(searchbutton);
		action.doubleClick().build().perform();
		arrivalcityname();
		arrivalcity.sendKeys(Keys.ARROW_DOWN);
		arrivalcity.sendKeys(Keys.TAB);
		datepicker.sendKeys(Keys.TAB);
		action.moveToElement(searchbutton);
		action.doubleClick().build().perform();
	}

}
