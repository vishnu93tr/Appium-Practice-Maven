package Tests.Ecommerce;

import Base.Base;
import PageObjects.ChromePage;
import PageObjects.FinalPage;
import PageObjects.HomePage;
import PageObjects.ProductsPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HybridAppTest extends Base
{
    @Test
    public void HybridAppTest() throws IOException, InterruptedException {
        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        AndroidDriver<AndroidElement> driver=Capabilities("GeneralStoreApp");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        HomePage homePage=new HomePage(driver);
        homePage.yourName.sendKeys("Hello");
        homePage.LetsShopButton.click();
        ProductsPage productsPage=new ProductsPage(driver);
        int size=productsPage.ProductList.size();
        for(int i=0;i<size;i++)
        {
            productsPage.ProductList.get(i).click();
        }
        productsPage.AddToCart.click();
        FinalPage finalPage=new FinalPage(driver);
        finalPage.CheckBox.click();
        finalPage.ProceedButton.click();
        Thread.sleep(10000);
        Set<String> contextNames =driver.getContextHandles();
        for(String contextName:contextNames)
        {
            System.out.println(contextName);
        }
       driver.context("WEBVIEW_com.androidsample.generalstore");
        ChromePage chromePage=new ChromePage(driver);
        chromePage.ChromeText.sendKeys("hello");
        chromePage.ChromeText.sendKeys(Keys.ENTER);
       driver.pressKey(new KeyEvent(AndroidKey.BACK));
       service.stop();
    }
}
