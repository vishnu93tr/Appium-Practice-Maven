package Tests.Ecommerce;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class AddToCartTest extends Base
{
    @Test
    public void  AddToCartTest() throws MalformedURLException
    {
        AndroidDriver<AndroidElement> driver=Capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/nameField")));
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello!");
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

                    driver
                    .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                        + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
                        + "new UiSelector().text(\"Jordan 6 Rings\"));");
        int size= driver.findElementsById("com.androidsample.generalstore:id/productName").size();
        for(int i=0;i<size;i++){
            if(driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText().equalsIgnoreCase("Jordan 6 Rings"))
            {
                driver.findElementById("com.androidsample.generalstore:id/productAddCart").click();
            }
        }
       driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        try {
            Assert.assertTrue(driver.findElementById("com.androidsample.generalstore:id/productName").getText().equalsIgnoreCase("Jordan 6 Rings"));
        }
        catch (StaleElementReferenceException e)
        {
            System.out.println("catch block");
            System.out.println(driver.findElementById("com.androidsample.generalstore:id/productName").getText());
            Assert.assertTrue(driver.findElementById("com.androidsample.generalstore:id/productName").getText().equalsIgnoreCase("Jordan 6 Rings"));
        }
        }
        }


