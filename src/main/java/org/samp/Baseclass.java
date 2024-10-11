package org.samp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass  {
	public static WebDriver driver;

	public static void launchBorwser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

	}

	public static void windowMaximize() {
		driver.manage().window().maximize();
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void pageTitel() {
		String title = driver.getTitle();
		System.out.println(title);

	}

	public static void pageUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void passText(String tex, WebElement ele) {
		ele.sendKeys(tex);
	}

	public static void closeEntireBrowser() {
		driver.quit();
	}

	public static void clickbtn(WebElement ele) {
		ele.click();
	}

	private static void screenshot(String imgname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;

		File imge = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("location+imgname.png");
		FileUtils.copyFile(imge, f);

	}

	public static Actions a;

	public static void moveThecursor(WebElement targetWebElement) {
		a = new Actions(driver);
		a.moveToElement(targetWebElement).perform();

	}

	public static void dragDrop(WebElement drawebElement, WebElement dropElement) {
		a = new Actions(driver);
		a.dragAndDrop(drawebElement, dropElement).perform();
	}

	public static JavascriptExecutor ja;

	public static void scrollthepage(WebElement tarElement) {
		ja = (JavascriptExecutor) driver;
		ja.executeScript("arguments[0].scrollIntoView(true)", tarElement);
	}

	public static void scroll(WebElement element) {
		ja = (JavascriptExecutor) driver;
		ja.executeScript("arguments[0].scrollIntoView(false)", element);

	}

	public static void excelRead(String sheetName, int rowNum, int cellnum) throws IOException {
		File f = new File("excellocation.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new SXSSFWorkbook();
		Sheet mysheet = wb.getSheet("data");
		Row r = mysheet.getRow(rowNum);
		Cell c = r.getCell(cellnum);
		int cellType = c.getCellType();

		String value = "";
		if (cellType == 1) {
			String Value = c.getStringCellValue();
		}

		else if (DateUtil.isCellDateFormatted(c)) {
			Date dd = c.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat(value);
			String value1 = s.format(dd);
		} else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			String valueOf = String.valueOf(l);
		}
	}

	public static void createNewExcalFile(int rowNum, int cellNum, String writeDate) throws IOException {
		File f = new File("C:\\Users\\admin\\eclipse-workspace\\base\\new excel\\newfile.xlsx");
		// FileInputStream fis =new FileInputStream(f);
		Workbook w = new XSSFWorkbook();
		Sheet newsheet = w.createSheet("Datas");
		Row newrow = newsheet.createRow(rowNum);
		Cell newcell = newrow.createCell(cellNum);
		newcell.setCellValue(writeDate);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);

	}

	public static void createcell(int getRow, int crecell, String newData) throws IOException {
		File f = new File("C:\\Users\\admin\\eclipse-workspace\\base\\new excel\\newfile.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Datas");
		Row r = s.getRow(getRow);
		Cell c = r.createCell(crecell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}

	public static void createRow(int creRow, int crecell, String newData) throws IOException {
		File f = new File("C:\\Users\\admin\\eclipse-workspace\\base\\new excel\\newfile.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Datas");
		Row r = s.createRow(creRow);
		Cell c = r.createCell(crecell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

	}

	public static void updateDateToparticularcell(int getTheRow, int getThecell, String exisitingData,
			String writeNewData) throws IOException {

		File f = new File("Excel location.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Datas");
		Row r = s.createRow(getTheRow);
		Cell c = r.createCell(getThecell);
		String str = c.getStringCellValue();
		if (str.equals(exisitingData)) {
			c.setCellValue(writeNewData);

			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);

		}
	}
}