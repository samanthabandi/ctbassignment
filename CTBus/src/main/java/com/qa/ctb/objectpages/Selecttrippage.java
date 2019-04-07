package com.qa.ctb.objectpages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.ctb.Base.Base;

public class Selecttrippage extends Base {

	WebDriver driver;
	String beforexpath, afterxpath, tdxpath;
	int rowcount,colcount;

	@FindBy(xpath = "//*[contains(@id,'mytable')]/thead/tr")
	List<WebElement> rows;
	@FindBy(xpath = "//*[contains(@id,'mytable')]/thead/tr/td")
	List<WebElement> cols;

	public Selecttrippage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void operatordata() {
		System.out.println("entered in to opertaordata method");
		beforexpath = "//*[@id='mytable']/thead/tr[";
		afterxpath = " ]/td[1] ";
		rowcount = rows.size();
		for (int i = 2; i <= rowcount; i++) {
			String tdxpath = beforexpath + i + afterxpath;
			WebElement ele = driver.findElement(By.xpath(tdxpath));
			WebElement oname = ele.findElement(By.xpath("//span[contains(@class,'mobileOperator')]"));
			System.out.println("opertaor list :" +oname.getText());
									
			}
		}

}	
