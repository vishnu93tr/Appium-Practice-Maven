package Tests.Ecommerce;

import Base.Base;
import PageObjects.FinalPage;
import PageObjects.HomePage;
import PageObjects.ProductsPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class AddToCartTest extends Base
{
    @Test
    public void  AddToCartTest() throws IOException {
        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        AndroidDriver<AndroidElement> driver=Capabilities("GeneralStoreApp");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            HomePage homePage=new HomePage(driver);
            homePage.yourName.sendKeys("Hello!");
            homePage.LetsShopButton.click();
            ProductsPage productsPage=new ProductsPage(driver);
                    driver
                    .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                        + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
                        + "new UiSelector().text(\"Jordan 6 Rings\"));");
        int size= productsPage.CurrentScreenElements.size();

        for(int i=0;i<size;i++){
            if(productsPage.CurrentScreenElements.get(i).getText().equalsIgnoreCase("Jordan 6 Rings"))
            {
                productsPage.Product.click();
            }
        }
        productsPage.AddToCart.click();
        FinalPage finalPage=new FinalPage(driver);
        try {
            Assert.assertTrue(finalPage.ProductName.getText().equalsIgnoreCase("Jordan 6 Rings"));
        }
        catch (StaleElementReferenceException e)
        {
            e.printStackTrace();
        }
        service.stop();
        }

        }


