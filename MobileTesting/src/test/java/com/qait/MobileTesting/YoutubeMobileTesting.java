package com.qait.MobileTesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class YoutubeMobileTesting {
	AndroidDriver<MobileElement> driver;

	@BeforeClass
	public void setUp() throws MalformedURLException{
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "9"); 
		capabilities.setCapability("deviceName","Emulator");
		capabilities.setCapability("platformName","Android");
	 
	   
	   capabilities.setCapability("appPackage", "com.google.android.youtube");
	// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity","com.google.android.apps.youtube.app.application.Shell$HomeActivity"); // This is Launcher activity of your app (you can get it from apk info app)
	//Create RemoteWebDriver instance and connect to the Appium server
	 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
	   driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
	}
	@Test
	public void rough() {
		System.out.println(".....................Yeaahhhh Youtube...........");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		MobileElement play=driver.findElementByAccessibilityId("Search");
		System.out.println(play);
		play.click();
		driver.findElement(By.id("com.google.android.youtube:id/search_edit_text")).sendKeys("tomorrowland");
		driver.findElement(By.id("com.google.android.youtube:id/text")).click();
	}
	
	@AfterClass
	public void teardown(){
		//close the app
		//driver.quit();
	}
	}