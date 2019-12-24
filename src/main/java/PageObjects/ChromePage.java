package PageObjects;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChromePage
{
    public ChromePage(WebDriver driver)
    {
        PageFactory pageFactory=new PageFactory();
        pageFactory.initElements(driver,this);
    }
    @FindBy(name = "q")
    public WebElement ChromeText;
}
