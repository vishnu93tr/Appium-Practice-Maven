package Tests.Ecommerce;

import Tests.Ecommerce.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Ecommerce_tc_1_Test extends Base
{
    @Test
    public void  test1Test() throws MalformedURLException
    {
        AndroidDriver<AndroidElement> driver=Capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello!");
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
    }
}
