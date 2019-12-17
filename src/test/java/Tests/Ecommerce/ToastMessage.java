package Tests.Ecommerce;

import Tests.Ecommerce.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class ToastMessage extends Base
{
    @Test
    public void  ToastMessages() throws MalformedURLException
    {
        AndroidDriver<AndroidElement> driver=Capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

       String text= driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");

        System.out.println(text);

        Assert.assertEquals(text,"Please enter your name","expected message and actual are not same");
    }
}
