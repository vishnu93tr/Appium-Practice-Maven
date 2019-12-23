package Tests.Ecommerce;

import Base.Base;
import PageObjects.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class ToastMessageTest extends Base
{
    @Test
    public void  ToastMessagesTest() throws IOException {
        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        AndroidDriver<AndroidElement> driver=Capabilities("GeneralStoreApp");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        HomePage homePage=new HomePage(driver);
        homePage.LetsShopButton.click();
        String text=homePage.ToastMessage.getAttribute("name");
        Assert.assertEquals(text,"Please enter your name","expected message and actual are not same");
        service.stop();
    }
}
