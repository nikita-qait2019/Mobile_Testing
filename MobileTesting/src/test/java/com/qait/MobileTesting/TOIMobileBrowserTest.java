package com.qait.MobileTesting;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class TOIMobileBrowserTest {

	WebDriver driver;
	 

	@Test
	public void verifyTitle() {
		// Created object of DesiredCapabilities class.
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// Set android deviceName desired capability. Set your device name.
		capabilities.setCapability("deviceName", "emulator-5554");
		// Set BROWSER_NAME desired capability. It’s Android in our case here.
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		// Set android VERSION desired capability. Set your mobile device’s OS version.
		capabilities.setCapability(CapabilityType.VERSION, "9.0");
		// Set android platformName desired capability. It’s Android in our case here.
		capabilities.setCapability("platformName", "Android");
		// Set your application’s appPackage if you are using any other app.
		// capabilities.setCapability("appPackage", "com.android.chrome");
		capabilities.setCapability("appActivity", "org.chromium.chrome.browser.document.ChromeLauncherActivity");
		// It will launch app in android device.
		try {
			driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get("https://m.timesofindia.com");
			String actualTitle = driver.getTitle();
			String expectedTitle = "News, Breaking News, National news, Latest Bollywood News, Sports News, Business News & Political News | Times of India";
			Assert.assertEquals(expectedTitle, actualTitle, "Wrong title");
			driver.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}