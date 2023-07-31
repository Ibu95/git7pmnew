package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Home_Base {

	public static WebDriver driver;

	public static void launch(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		} else if (browser.equalsIgnoreCase("incognito")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions c = new ChromeOptions();
			c.addArguments("--incognito");
			driver = new ChromeDriver(c);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		}

	}

	public static void sendData(String locator, String attribute, String data) {
		if (locator.equalsIgnoreCase("id")) {
			driver.findElement(By.id(attribute)).sendKeys(data);
		} else if (locator.equalsIgnoreCase("name")) {
			driver.findElement(By.name(attribute)).sendKeys(data);
		} else if (locator.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(attribute)).sendKeys(data);
		} else if (locator.equalsIgnoreCase("tagname")) {
			driver.findElement(By.tagName(attribute)).sendKeys(data);
		} else if (locator.equalsIgnoreCase("classname")) {
			driver.findElement(By.className(attribute)).sendKeys(data);
		} else if (locator.equalsIgnoreCase("linktext")) {
			driver.findElement(By.linkText(attribute)).sendKeys(data);
		} else if (locator.equalsIgnoreCase("partiallinktext")) {
			driver.findElement(By.partialLinkText(attribute)).sendKeys(data);
		} else if (locator.equalsIgnoreCase("cssselector")) {
			driver.findElement(By.cssSelector(attribute)).sendKeys(data);
		}

	}

	public static void clickEle(String locator, String attribute) {
		if (locator.equalsIgnoreCase("id")) {
			driver.findElement(By.id(attribute)).click();
		} else if (locator.equalsIgnoreCase("name")) {
			driver.findElement(By.name(attribute)).click();
		} else if (locator.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(attribute)).click();
		} else if (locator.equalsIgnoreCase("tagname")) {
			driver.findElement(By.tagName(attribute)).click();
		} else if (locator.equalsIgnoreCase("classname")) {
			driver.findElement(By.className(attribute)).click();
		} else if (locator.equalsIgnoreCase("linktext")) {
			driver.findElement(By.linkText(attribute)).click();
		} else if (locator.equalsIgnoreCase("partiallinktext")) {
			driver.findElement(By.partialLinkText(attribute)).click();
		} else if (locator.equalsIgnoreCase("cssselector")) {
			driver.findElement(By.cssSelector(attribute)).click();
		}

	}

	public static void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

	public static Sheet getMySheet(String path, String name) throws IOException {
		Workbook w = new XSSFWorkbook(new FileInputStream(new File(path)));
		Sheet sheet = w.getSheet(name);
		return sheet;
	}

	public static String getData(Sheet sheet, int row, int cell) {
		
		String value ="";
		Row r = sheet.getRow(row);
		Cell c = r.getCell(cell);

		CellType cellType = c.getCellType();
		switch (cellType) {
		case STRING:
			value = c.getStringCellValue();
			break;

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(c)) {
				value= new SimpleDateFormat("dd-MM-yyyy").format(c.getDateCellValue());
			} else {
				value = String.valueOf((long)c.getNumericCellValue());
			}

			break;

		}
		return value;

	}

}
