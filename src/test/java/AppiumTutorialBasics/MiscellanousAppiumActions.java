package AppiumTutorialBasics;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MiscellanousAppiumActions extends BaseTest{

    @Test
    public void Miscellaneous(){

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();

        DeviceRotation landScape = new DeviceRotation(0,0,90); // To Rotate the Device Screen to Landscape
        driver.rotate(landScape);

        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");
        driver.findElement(By.id("android:id/edit")).sendKeys("MohitWifi");
        driver.findElements(By.className("android.widget.Button")).get(1).click();

    }


}
