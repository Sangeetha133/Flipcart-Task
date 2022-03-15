package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	
//	public static WebDriver browserLaunch() {
//		WebDriverManager.chromedriver().setup();
//		 driver = new ChromeDriver();
//		 return driver;
//	}
//	
	public static WebDriver browserLaunch(String browserName) {
//		
//		if(browserName.equals("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//			}
//		else if (browserName.equals("firefox")) {
//			WebDriverManager.firefoxdriver();
//		driver = new FirefoxDriver();
//			
//		}
//		return driver;
		
		switch (browserName) {	
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			
			default:
			break;
			}
return driver;
}
//url
	public static void urlLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		}

	//wait
	public static void implicitWait(long sec) {
				driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
				}
	  //get current url
	public static  String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;		
		}
	//get title
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
		}
	
	//quit
	public void quit() {
		driver.quit();
		}

	//sendkeys
	public static void sendKeys(WebElement e,String user) {
	 e.sendKeys(user);
	
		}
	
	//gettext
	public static String getText(WebElement e) {
	String text = e.getText();
	return text;
	}
	//get attributes
	public static String getAtrributes(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;
}
	//click
	public static void buttonClick(WebElement e) {
		e.click();
		}
	
	//actions
	//MovetoElement
	public static void movetoElement(WebElement e) {
		Actions a = new Actions (driver);
		a.moveToElement(e).perform();
		}
	//drag and drop
	public static void dragAndDrop(WebElement src,WebElement des) {
		Actions a = new Actions (driver);
		a.dragAndDrop(src, des).perform();
	}
	
	//doubleclick
		public static  void doubleClick(WebElement e) {
			Actions a = new Actions (driver);
			a.doubleClick(e).perform();
		}
		//right click
		public static void rightClick(WebElement e) {
			Actions a = new Actions (driver);
			a.contextClick(e).perform();
			}
//select
	//select by index
	public static void selectbyIndex(WebElement e,int index) {
	Select s = new Select(e);
	s.selectByIndex(index);
	}
	//deselectByIndex
	public  static void deselectByIndex(WebElement e,String value) {
		Select s = new Select(e);
		s.deselectByValue(value);
		}

	//deselectAll
	public static void deselectAll(WebElement e) {
		Select s = new Select(e);
		s.deselectAll();

	}
	//select by value
	public static void selectByValue(WebElement e,String value) {
		Select s = new Select(e);
s.selectByValue(value);
	}
	//select by visible text
	public static void selectByText(WebElement e,String value) {
		Select s = new Select(e);
		s.selectByVisibleText(value);
}
	//takeScreenshot
	public static File takeScreenshot() throws IOException  {
		TakesScreenshot tk= (TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\Lenovo\\eclipse-workspace\\MavenProjectt\\src\\test\\resources\\screenshots\\flipkart.png");
		FileUtils.copyFile(src, des);
		return des;
		}
//switchtoWindow
	//currentWindowId
	public static String currentWindowId( ) {
		String currentWindowId = driver.getWindowHandle();
		return currentWindowId;
		}
	//get all windowIds
	
	public static  Set<String> getallwindowIds() {
	Set<String> getallwindowIds = driver.getWindowHandles();
	return getallwindowIds;	
	}	
	//switchtoWindow
	
	public static List<String> switchtoWindow() {
		List<String> li = new ArrayList<>();
		li.addAll(getallwindowIds());
		driver.switchTo().window(li.get(1));
		return li;
		}
	
	
	
	//findElement
	public static WebElement findElement(String locatorName,String Locator) {
		WebElement e = null;
		if(locatorName.equals("id")) {
			e= driver.findElement(By.id(Locator));}
	
		else if(locatorName.equals("name")) {
			e=driver.findElement(By.name(Locator));
		
		}
		else if (locatorName.equals("xpath")) {
			e=driver.findElement(By.xpath(Locator));
 			
		}
		else if (locatorName.equals("className")) {
			e=driver.findElement(By.className(Locator));
		}
		return e;
		
}
	//Excel
	public static String getExcel(String fileName, String sheetName,int sheetRow,int sheetCell) throws IOException {
		File loc = new File("C:\\Users\\Lenovo\\eclipse-workspace\\MavenProjectt\\src\\test\\resources\\sangeetha.xlsx");
		FileInputStream fi = new FileInputStream(loc);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s =w.getSheet("Sheet1");
		Row r=s.getRow(3);
        Cell c= r.getCell(3);
		String value;
	int type = c.getCellType();
	
	if(type==1) {
		 value = c.getStringCellValue();
		}
	else {
		if(DateUtil.isCellDateFormatted(c)) {
			Date date = c.getDateCellValue();
			SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yyy");
			 value = sf.format(date);
		
		}
		else {
			double num = c.getNumericCellValue();
			long ln = (long) num;
			 value = String.valueOf(ln);
			
		}
		}
	return value;
}

	
	
	
	
}
	
	
	

