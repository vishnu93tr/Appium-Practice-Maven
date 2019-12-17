package Tests.Ecommerce;

import Tests.Ecommerce.Base;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TotalAmount  extends Base
{
    @Test
    public void  TotalAmount() throws MalformedURLException
    {
        List<Double> price_al=new ArrayList<>();
        double sum=0.0;
        AndroidDriver<AndroidElement> driver=Capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello!");
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

      int size=driver.findElementsById("com.androidsample.generalstore:id/productAddCart").size();
      for(int i=0;i<size;i++)
      {
          driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
      }
      driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
      int checkout_size=driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
      for(int i=0;i<checkout_size;i++)
      {
          String price=driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText();
          price_al.add(Double.parseDouble(price.replace("$","")));
      }
      for(Double ref:price_al)
      {
            sum+=ref;
      }
      String final_price=driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
      double final_sum=Double.parseDouble(final_price.replace("$",""));
      Assert.assertEquals(final_sum,sum,"final sum and actual sum are not equal");

      //MOBILE GESTURES
        driver.findElementByClassName("android.widget.CheckBox").click();
        WebElement terms=driver.findElementById("com.androidsample.generalstore:id/termsButton");
        TouchAction touchAction=new TouchAction(driver);
        touchAction.longPress(new LongPressOptions().withElement(new ElementOption().withElement(terms)).withDuration(Duration.ofSeconds(3))).release().perform();
        driver.findElementById("android:id/button1").click();
        driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();


    }
}
