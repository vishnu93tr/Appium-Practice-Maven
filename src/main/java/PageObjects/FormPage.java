package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class FormPage
{
    public FormPage(AppiumDriver driver)
    {
        PageFactory pageFactory=new PageFactory();
        pageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    public AndroidElement yourName;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    public AndroidElement LetsShopButton;
    @AndroidFindBy(xpath="//android.widget.Toast[1]")
    public AndroidElement ToastMessage;
}
