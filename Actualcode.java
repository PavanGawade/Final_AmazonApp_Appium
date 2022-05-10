package Amazom_App;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Actualcode extends Desirecap {

	public static void main(String[] args) throws InterruptedException, IOException {
//Start Appium Server by code
		AppiumStart appiumServer = new AppiumStart();
		appiumServer.startServer();
		AndroidDriver<AndroidElement> driver = capabilities("P");
//Open Amazon App	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.Button[@text='Skip sign in']").click();
		Thread.sleep(3000);
// Change country Us to India		
		
		driver.findElementByXPath("//android.widget.ImageView[@content-desc='Navigation panel, button, double tap to open side panel']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Settings']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.findElementByXPath("//android.widget.TextView[@text='Country & Language']").click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.Button[@text='Country/Region: United States']").click();
		Thread.sleep(6000);	
		TouchAction t = new TouchAction(driver);
		WebElement expandList = driver.findElementByXPath("//android.widget.RadioButton[@text='India Amazon.in']");
		t.tap(tapOptions().withElement(element(expandList))).perform();
		Thread.sleep(6000);	
		driver.findElementByAndroidUIAutomator("text(\"Done\")").click();
		Thread.sleep(6000);	
//Search Desired product and add to cart  and add to favorite		
		driver.findElementByXPath("//android.widget.EditText[@text='Search']").click();
		Thread.sleep(4000);
		driver.findElementByXPath("//android.widget.EditText[@text='Search']").sendKeys("Dnyaneshwari");
		Thread.sleep(6000);
		TouchAction t1= new TouchAction(driver); 
		WebElement expandList1 =driver.findElementByXPath("//android.widget.TextView[@text='dnyaneshwari']");
		t1.tap(tapOptions().withElement(element(expandList1))).perform();
		Thread.sleep(3000);	
		driver.findElementByXPath("//android.widget.TextView[@content-desc='4.4 stars 90 customer reviews']").click();
		Thread.sleep(6000);
//Check Pin code delivery		
		driver.findElementByXPath("//android.widget.Button[@text='Enter an Indian pincode']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.amazon.mShop.android.shopping:id/loc_ux_pin_code_text_pt1").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.amazon.mShop.android.shopping:id/loc_ux_pin_code_text_pt1").sendKeys(
		  "411014");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.Button[@text='Apply']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//android.widget.Image[@text='Heart to save an item to your default list']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// To  click Heart icon we need to 1st Login			
		driver.findElementByXPath("//android.widget.EditText[@index='1']").click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElementByXPath("//android.widget.EditText[@index='1']").sendKeys("9168434941");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.Button[@text='Continue']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.EditText[@text='Amazon password']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.EditText[@text='Amazon password']").sendKeys("Pass$5050");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.Button[@text='Sign-In']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.Image[@text='Heart to save an item to your default list']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Add to Cart\"));").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.amazon.mShop.android.shopping:id/action_bar_cart_image").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// Check Whether the selected product added to the Cart or not		
		 boolean o =driver.findElementByXPath("//android.widget.TextView[@text='Sarth Dnyaneshwari [hardcover] Brahmibhut V. Nanamaharaj Sakhare']").isDisplayed();
		 boolean p =driver.findElementByXPath("//android.widget.TextView[@text='Deliver to Pune 411005 ⌵']").isDisplayed();
		 if (o == true && p == true) {
				System.out.println("Item added to the cart and selected Item will deliverd to your pin code ");
			}
		
		
		appiumServer.stopServer();
	}

}
