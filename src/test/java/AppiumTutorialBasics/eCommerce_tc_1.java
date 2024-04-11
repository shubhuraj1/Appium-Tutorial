package AppiumTutorialBasics;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class eCommerce_tc_1 extends BaseTest {

    @Test
    public void FillForm() throws InterruptedException {


        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Mohit Kumar");
        driver.hideKeyboard(); // To Hide Keyboard from Screen
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
        WebElement myCountry = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"India\"]"));
        myCountry.click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        //Toast Message or Error Message you see on Screen, can't be inspected through Appium Inspector but comes with unique identifier:android.widget.Toast
        //String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        //Assert.assertEquals(toastMessage, "Please your name");




    }
}
