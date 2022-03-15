package org.pages;

import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pages extends BaseClass {
public Pages() {
PageFactory.initElements(driver, this);
}

@CacheLookup
@FindBy(xpath="//div[@class=\"_4rR01T\"]")
private WebElement mblname;
@FindBy(xpath="//div[@class=\"_30jeq3 _1_WHN1\"]")
private WebElement mblprice;

public  List<WebElement> getMblname() {
	return (List<WebElement>) mblname;
}
public List<WebElement> getMblprice() {
	return (List<WebElement>) mblprice;
}


	
}
