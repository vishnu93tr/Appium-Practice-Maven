package Tests.Ecommerce;

import Base.Base;
import PageObjects.ChromePage;
import PageObjects.CheckOutPage;
import PageObjects.FormPage;
import PageObjects.ProductsHomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HybridAppTest extends Base
{

    @Test
    public void HybridAppTest() throws IOException, InterruptedException
    {
                AppiumDriverLocalService service=startServer();
                AndroidDriver<AndroidElement> driver=Capabilities("GeneralStoreApp");
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                FormPage formPage =new FormPage(driver);
                formPage.yourName.sendKeys("Hello");
                formPage.LetsShopButton.click();
                ProductsHomePage productsPage=new ProductsHomePage(driver);
                int size=productsPage.ProductList.size();
                for(int i=0;i<size;i++)
                {
                    productsPage.ProductList.get(i).click();
                }
                productsPage.AddToCart.click();
                CheckOutPage checkOutPage =new CheckOutPage(driver);
                checkOutPage.CheckBox.click();
                checkOutPage.ProceedButton.click();
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
