package com.orange.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	
	public static WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		 driver = new ChromeDriver(options);
	}

	@Test
	public void openBrowser() throws InterruptedException {

		// Open the URL Window
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("URL is Opened");

		// Maximize the Window
		driver.manage().window().maximize();
		System.out.println("Window is Maximized");

	}

}
