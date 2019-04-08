package com.qa.ctb.testcases;

import org.testng.TestNG;

public class TestRunner {
	
	static TestNG testng;

	public static void main(String[] args) {
		 
		testng = new TestNG();
		testng.setTestClasses(new Class[] {Bookingpage_testcases.class});
        testng.run();
	}

}
