package com.orange.keyword;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.orange.base.Baseclass;

public class KeywordDriven extends Baseclass {

	public KeywordDriven() throws IOException {
		super();
	}

	public WebDriver driver;
	public Properties prop;
	public static Workbook book;
	public static Sheet sheet;
	public WebElement element;

	public final String Sheetpath="C:\\Users\\rachanam\\eclipse-workspace\\KeywordDriven\\src\\main\\java\\com\\orange\\excel\\KeywordDriven.xlsx";

	public void startExceution(String Sheetname) {
		String Locatorname = null;
		String LocatorValue = null;

		FileInputStream file = null;

		try {
			file = new FileInputStream(Sheetpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(Sheetname);
		int k =0;
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			try {
				String LocatorColVal= sheet.getRow(i+1).getCell(k+1).toString().trim();
				if(!LocatorColVal.equalsIgnoreCase("NA")) {
					Locatorname = LocatorColVal.split("-")[0].trim();
					System.out.println(Locatorname);
					LocatorValue = LocatorColVal.split("-")[1].trim();
					System.out.println(LocatorValue);

				}
				String action = sheet.getRow(i+1).getCell(k+2).toString().trim();
				System.out.println(action);
				String value = sheet.getRow(i+1).getCell(k+3).toString().trim();
				System.out.println(value);
				
				switch(action) {
				case "Open Browser":
						Baseclass base =new Baseclass();
						if(value.isEmpty() || value.equals("NA")) {
							base.initialization();
					}
					break;

				case "Enter Url":
					if(value.isEmpty() || value.equals("NA")) {
						driver.get(prop.getProperty("url"));
					}else {
						driver.get(value);
					}
					break;
				}
			
				switch(Locatorname) {
				case "id":
					element = driver.findElement(By.id(LocatorValue));
					if(action.equalsIgnoreCase("sendkeys")) {
						element.clear();
						element.sendKeys(value);
					}else if(action.equalsIgnoreCase("click")) {
						element.click();
					}
					Locatorname = null;
					break;

				case "name":
					element = driver.findElement(By.name(LocatorValue));
					if(action.equalsIgnoreCase("sendkeys")) {
						element.clear();
						element.sendKeys(value);
					}else if(action.equalsIgnoreCase("click")) {
						element.click();
					}
					Locatorname = null;
					break;

				case "xpath":
					element = driver.findElement(By.xpath(LocatorValue));
					if(action.equalsIgnoreCase("sendkeys")) {
						element.clear();
						element.sendKeys(value);
					}else if(action.equalsIgnoreCase("click")) {
						element.click();
					}
					Locatorname = null;
					break;

				default:
					break;
				}
			}catch(Exception e) {
			
			}
		}
	}

}
