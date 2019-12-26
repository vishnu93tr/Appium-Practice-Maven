package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsHomePage
{
    public ProductsHomePage(AppiumDriver driver)
    {
        PageFactory pageFactory=new PageFactory();
        pageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
    public List<AndroidElement> ProductList;
    @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
    public AndroidElement AddToCart;
    @AndroidFindBy(id="com.androidsample.generalstore:id/productName")
    public List<AndroidElement> CurrentScreenElements;
    @AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
    public AndroidElement Product;




}
