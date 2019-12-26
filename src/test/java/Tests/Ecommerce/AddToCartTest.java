package Tests.Ecommerce;

import Base.Base;
import PageObjects.CheckOutPage;
import PageObjects.FormPage;
import PageObjects.ProductsHomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.json.JSONObject;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class AddToCartTest extends Base
{
    @BeforeTest
    public void killAllNodes() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Thread.sleep(3000);
    }
    String scrollElement="com.androidsample.generalstore:id/rvProductList";
    @Test(dataProvider = "dp")
    public void  AddToCartTest(String name,String json_case) throws IOException, InterruptedException
    {
            JSONObject jsonObject=new JSONObject(json_case);
            AppiumDriverLocalService service=startServer();
            AndroidDriver<AndroidElement> driver=Capabilities("GeneralStoreApp");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            FormPage formPage =new FormPage(driver);
            formPage.yourName.sendKeys(jsonObject.getString("name"));
            formPage.LetsShopButton.click();
            ProductsHomePage productsHomePage =new ProductsHomePage(driver);
            Utilities utilities=new Utilities(driver);
            utilities.Scroll(scrollElement,jsonObject.getString("texttoscroll"));
            int size= productsHomePage.CurrentScreenElements.size();

            for(int i=0;i<size;i++){
                if(productsHomePage.CurrentScreenElements.get(i).getText().equalsIgnoreCase(jsonObject.getString("texttoscroll")))
                {
                    productsHomePage.Product.click();
                }
            }
            productsHomePage.AddToCart.click();
            CheckOutPage checkOutPage =new CheckOutPage(driver);
            try {
                Assert.assertTrue(checkOutPage.ProductName.getText().equalsIgnoreCase(jsonObject.getString("AssertText")));
            }
            catch (StaleElementReferenceException e)
            {
                System.out.println(checkOutPage.ProductName.getText().equalsIgnoreCase(jsonObject.getString("AssertText")));
                Assert.assertTrue(checkOutPage.ProductName.getText().equalsIgnoreCase(jsonObject.getString("AssertText")));
                e.toString();
            }
        service.stop();
        }
    @DataProvider
    public Object[][] dp() {
        Object[][] obj = getCases("testcases/AddToCart.json");
        for(int p=0;p<obj.length;p++)
        {
            JSONObject js = new JSONObject(obj[p][1].toString());
            obj[p][1] = js.toString();
        }
        return obj;
    }

}





