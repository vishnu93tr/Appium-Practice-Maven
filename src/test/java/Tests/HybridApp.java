package Tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HybridApp  extends Base
{
    @Test
    public void HybridApp() throws MalformedURLException, InterruptedException {
        AndroidDriver<AndroidElement> driver=Capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello!");
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        int size=driver.findElementsById("com.androidsample.generalstore:id/productAddCart").size();
        for(int i=0;i<size;i++)
        {
            driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
        }
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        driver.findElementByClassName("android.widget.CheckBox").click();
        driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
        Thread.sleep(10000);
        Set<String> contextNames =driver.getContextHandles();
        for(String contextName:contextNames)
        {
            System.out.println(contextName);
        }
       driver.context("WEBVIEW_com.androidsample.generalstore");
       driver.findElement(By.name("q")).sendKeys("hello");
       driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
       driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
}
