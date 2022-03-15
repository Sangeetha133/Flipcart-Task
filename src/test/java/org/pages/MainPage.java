package org.pages;

import java.util.Date;

import org.base.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPage extends BaseClass {
@BeforeMethod
private void beforeMethod() {
	Date d = new Date();
	System.out.println("before time"+d);
}
@AfterMethod
private void afterMethod() {
	Date d = new Date();
System.out.println("After time"+d);

}

@BeforeClass
private void beforClass() {
	browserLaunch("chrome");
	
}
@AfterClass
private void afterClass() {
quit();
}
@Test
private void test1() {
	urlLaunch("https://www.flipkart.com/");

}





}
