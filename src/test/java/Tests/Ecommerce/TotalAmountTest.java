package Tests.Ecommerce;

import Base.Base;
import PageObjects.FinalPage;
import PageObjects.HomePage;
import PageObjects.ProductsPage;
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
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TotalAmountTest  extends Base
{
    @Test
    public void  TotalAmountTest() throws IOException {
        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        List<Double> price_al=new ArrayList<>();
        double sum=0.0;
        AndroidDriver<AndroidElement> driver=Capabilities("GeneralStoreApp");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        HomePage homePage=new HomePage(driver);
        homePage.yourName.sendKeys("Hello!");
        homePage.LetsShopButton.click();
        ProductsPage productsPage=new ProductsPage(driver);
        int size=productsPage.ProductList.size();
      for(int i=0;i<size;i++)
      {
          productsPage.ProductList.get(i).click();
      }
      productsPage.AddToCart.click();
        FinalPage finalPage=new FinalPage(driver);
        int checkout_size=finalPage.productPrice.size();
      for(int i=0;i<checkout_size;i++)
      {
          String price=finalPage.productPrice.get(i).getText();
          price_al.add(Double.parseDouble(price.replace("$","")));
      }
      for(Double ref:price_al)
      {
            sum+=ref;
      }
        String final_price=finalPage.TotalAmount.getText();
        double final_sum=Double.parseDouble(final_price.replace("$",""));
      Assert.assertEquals(final_sum,sum,"final sum and actual sum are not equal");

        finalPage.CheckBox.click();
        WebElement terms= finalPage.TermsButton;
        TouchAction touchAction=new TouchAction(driver);
        touchAction.longPress(new LongPressOptions().withElement(new ElementOption().withElement(terms)).withDuration(Duration.ofSeconds(3))).release().perform();
        finalPage.CloseTermsandConditions.click();
        finalPage.ProceedButton.click();
        service.stop();

    }
}
