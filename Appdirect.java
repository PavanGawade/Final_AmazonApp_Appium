package Amazom_App;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Appdirect extends AppiumStart {
	public static AndroidDriver<AndroidElement> capabilities(String Device) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		
		if (Device.equals("P")) {
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Pavan");
		} else if (Device.equals("R")) {
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		}
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");		
		
		dc.setCapability("appPackage", "com.amazon.mShop.android.shopping");
		dc.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		AndroidDriver<AndroidElement> driver;
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		Thread.sleep(5000);	
		
		
		return driver; 
	}
}
