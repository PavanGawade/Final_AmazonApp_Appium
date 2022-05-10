package Amazom_App;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
public class Desirecap extends AppiumStart {
	public static AndroidDriver<AndroidElement> capabilities(String Device)throws MalformedURLException, InterruptedException {	
		File appDir = new File("src");
		File app = new File(appDir, "Amazon_shopping.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		if (Device.equals("P")) {
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pavan");
		} else if (Device.equals("R")) {
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		}
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		AndroidDriver<AndroidElement> driver;
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		Thread.sleep(5000);
		
		
		return driver;	
	}

}