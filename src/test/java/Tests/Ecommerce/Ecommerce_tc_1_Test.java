package Tests.Ecommerce;

import Base.Base;
import PageObjects.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Ecommerce_tc_1_Test extends Base
{
    @Test
    public void  basic() throws IOException
    {
        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        AndroidDriver<AndroidElement> driver=Capabilities("GeneralStoreApp");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        HomePage homePage=new HomePage(driver);
        homePage.yourName.sendKeys("Hello!");
        homePage.LetsShopButton.click();

        service.stop();
    }
}
