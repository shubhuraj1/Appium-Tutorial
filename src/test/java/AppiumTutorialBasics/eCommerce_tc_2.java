package AppiumTutorialBasics;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class eCommerce_tc_2 extends BaseTest {

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
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
        int productsCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for(int i=0;i<productsCount; i++) {
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        //Wait for Page to fully load

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

        String expectedProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(expectedProduct, "Jordan 6 Rings");

    }
}
