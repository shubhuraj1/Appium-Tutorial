package AppiumTutorialBasics;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class eCommerce_tc_3 extends BaseTest {

    @Test
    public void FillForm() throws InterruptedException {


        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Mohit Kumar");
        driver.hideKeyboard(); // To Hide Keyboard from Screen
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"India\"]")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        //Wait for Page to fully load
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

        List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();

        double totalProductCost = 0;
        for(int i = 0; i < productCount; i++){

            String amountString =  productPrices.get(i).getText() ;
            double amountInt = getFormattedAmount(amountString);
            totalProductCost += amountInt;

        }

        String totalAmountString = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        ;
        Assert.assertEquals(getFormattedAmount(totalAmountString), totalProductCost);

        WebElement tc = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        longPressAction(tc);
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(3000);

        //Hybrid Apps - Apps which has browser integrated



    }
}
