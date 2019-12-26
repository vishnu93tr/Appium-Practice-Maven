package Tests.Ecommerce;

import Base.Base;
import PageObjects.FormPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ToastMessageTest extends Base
{
    @Test
    public void  ToastMessagesTest() throws IOException, InterruptedException {
        AppiumDriverLocalService service=startServer();
        AndroidDriver<AndroidElement> driver=Capabilities("GeneralStoreApp");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        FormPage formPage =new FormPage(driver);
        formPage.LetsShopButton.click();
        String text= formPage.ToastMessage.getAttribute("name");
        Assert.assertEquals(text,"Please enter your name","expected message and actual are not same");
        service.stop();
    }
}
