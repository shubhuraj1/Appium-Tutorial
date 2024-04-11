package AppiumTutorialBasics;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MiscellanousAppiumActions extends BaseTest{

    @Test
    public void Miscellaneous(){

        //App Package & App Activity(To Directly Open a Page of App //command to get package and activity: adb shell dumpsys window | find "mCurrentFocus"
        Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
        //driver.startActivity(activity); // No More in Appium, Depcriated

        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
                "intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"
        ));

        //driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        //driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();

        DeviceRotation landScape = new DeviceRotation(0,0,90); // To Rotate the Device Screen to Landscape
        driver.rotate(landScape);

        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");
        driver.setClipboardText("Rahul Wifi"); // to copy text to clipboard
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText()); // to retrieve text from clipboard
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));  // To Send any key press to app
        driver.findElements(By.className("android.widget.Button")).get(1).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));  // To Send any key to app
        driver.pressKey(new KeyEvent(AndroidKey.HOME)); // To Send any key to app

    }


}
