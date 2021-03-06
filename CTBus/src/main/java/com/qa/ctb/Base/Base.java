package com.qa.ctb.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.ctb.utils.Utilities;

public class Base {

	
public   WebDriver driver ;
	
	public static Properties prop;

	public Base() throws IOException {
		prop = new Properties();
		String path = System.getProperty("user.dir");
		FileInputStream fp = new FileInputStream(
				path + "/src/main/java/com/qa/ctb/utils/config.properties");
		prop.load(fp);
	}

	public void browserinit() throws InterruptedException {
		String browsername = prop.getProperty("browser");
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
			driver = new ChromeDriver();
		} 
		//else if(browsername.equalsIgnoreCase("firefox") ){
			//System.setProperty("webdriver.gecko.driver", "C:/DRIVERS/geckdriver.exe");
			
		//}
		else
		{
			System.out.println("browser not specified");
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}
}
