package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FinalPage
{
    public FinalPage(AppiumDriver driver)
    {
        PageFactory pageFactory=new PageFactory();
        pageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    public List<AndroidElement> productPrice ;
   @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
   public AndroidElement TotalAmount;
   @AndroidFindBy(className = "android.widget.CheckBox")
   public AndroidElement CheckBox;
   @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
   public AndroidElement TermsButton;
   @AndroidFindBy(id = "android:id/button1")
   public AndroidElement CloseTermsandConditions;
   @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
   public AndroidElement ProceedButton;
    @AndroidFindBy(id="com.androidsample.generalstore:id/productName")
    public AndroidElement ProductName;
}
