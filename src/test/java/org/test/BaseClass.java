package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	public static WebDriver chromeBrowser() {
		WebDriverManager.chromedriver() .setup();
		driver=new ChromeDriver();
		return driver; 
	}
	public static WebDriver  launchBrowser(String bname) {
		if(bname.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (bname.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if (bname.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		return driver;
	

	}
	public static void urlLaunch(String url) {
		driver .get(url);
		driver .manage(). window().maximize();

	}
	public static void implicitlywait(int a) {
	driver .manage(). timeouts(). implicitlyWait(a, TimeUnit .SECONDS);

}
	public static void sendkeys(WebElement e, String value) {
	e.sendKeys(value);

}	
	public static void click(WebElement e) {
		e.click();

	}
	public static void refresh() {
	driver.navigate().refresh();

	}
	public static String getCurrentUrl() {
		String currentUrl=driver.getCurrentUrl();
		return currentUrl;
	}
	public static String getTitle() {
	String title=driver.getTitle();
	return title;
		
	}
	public static void quit() {
		driver.quit();
		

	}
	public static String  getText(WebElement e) {
		String text=e.getText();
		return text;
	
	}
	public static String getAttribute(WebElement e) {
		String attribute=e.getAttribute("value");
		return attribute;

	}
	public static void moveToElement(WebElement e) {
	Actions a=new Actions(driver);
	a.moveToElement(e).perform();

	}
	 void dragAndDrop(WebElement src, WebElement tar) {
	Actions a=new Actions(driver);
	a.dragAndDrop(src, tar).perform();

	}
	 public static void selectByIndex(WebElement e, int a) {
	 Select s=new Select(e);
     s.selectByIndex(a);
	}
	 public static void DropDown(WebElement e, int i) {
		Select s=new Select(e);
s.selectByIndex(i);
	}

public static void main(String[] args) throws IOException {
	File n=new File("C:\\Users\\91866\\eclipse-workspace\\Maven_class\\Excel\\Book1.xlsx");
FileInputStream s=new FileInputStream(n);
Workbook w=new XSSFWorkbook(s);
Sheet s1=w.getSheet("sheet1");
Row r=s1.getRow(1);
Cell cell=r.getCell(2);
System.out.println(cell);

//type
int type=cell.getCellType();
System.out.println(type);
if(type==1) {
	String value =cell.getStringCellValue();
	System.out.println(value);
}
else {
	if(DateUtil.isCellDateFormatted(cell)) {
		Date dateCellValue=cell.getDateCellValue();
		SimpleDateFormat sd=new SimpleDateFormat("dd-mm-yyyy");
		String value=sd.format(dateCellValue);
System.out.println(value);
	}
	else {double numericCellValue=cell.getNumericCellValue();
	long num=(long)numericCellValue;
	String value=String.valueOf(num);
	System.out.println(value);
	}
}
}
	

	
}

