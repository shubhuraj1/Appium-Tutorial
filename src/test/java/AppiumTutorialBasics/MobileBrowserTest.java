package AppiumTutorialBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest {


    @Test
    public void browserTest() {

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
        driver.findElement(By.xpath("//a[@routerlink='/products']")).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
        String devopstext = driver.findElement(By.cssSelector("a[href*='products/3")).getText();
        Assert.assertEquals(devopstext, "Devops");
        
;


    }
}
