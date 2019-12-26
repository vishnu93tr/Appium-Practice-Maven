package Tests.Ecommerce;

import Base.Base;
import PageObjects.CheckOutPage;
import PageObjects.FormPage;
import PageObjects.ProductsHomePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TotalAmountTest  extends Base
{
    @Test
    public void  TotalAmountTest() throws IOException, InterruptedException {
        AppiumDriverLocalService service=StartServer();
        List<Double> price_al=new ArrayList<>();
        double sum=0.0;
        AndroidDriver<AndroidElement> driver=Capabilities("GeneralStoreApp");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        FormPage formPage =new FormPage(driver);
        formPage.yourName.sendKeys("Hello!");
        formPage.LetsShopButton.click();
        ProductsHomePage productsHomePage =new ProductsHomePage(driver);
        int size= productsHomePage.ProductList.size();
      for(int i=0;i<size;i++)
      {
          productsHomePage.ProductList.get(i).click();
      }
      productsHomePage.AddToCart.click();
        CheckOutPage checkOutPage =new CheckOutPage(driver);
        int checkout_size= checkOutPage.productPrice.size();
      for(int i=0;i<checkout_size;i++)
      {
          String price= checkOutPage.productPrice.get(i).getText();
          price_al.add(Double.parseDouble(price.replace("$","")));
      }
      for(Double ref:price_al)
      {
            sum+=ref;
      }
        String final_price= checkOutPage.TotalAmount.getText();
        double final_sum=Double.parseDouble(final_price.replace("$",""));
      Assert.assertEquals(final_sum,sum,"final sum and actual sum are not equal");

        checkOutPage.CheckBox.click();
        WebElement terms= checkOutPage.TermsButton;
        TouchAction touchAction=new TouchAction(driver);
        touchAction.longPress(new LongPressOptions().withElement(new ElementOption().withElement(terms)).withDuration(Duration.ofSeconds(3))).release().perform();
        checkOutPage.CloseTermsandConditions.click();
        checkOutPage.ProceedButton.click();
        service.stop();

    }
}
