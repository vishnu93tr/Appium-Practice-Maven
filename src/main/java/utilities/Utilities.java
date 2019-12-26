package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities
{
    AndroidDriver<AndroidElement> driver;
    public Utilities(AndroidDriver driver)
    {
        this.driver=driver;
    }
    public void Scroll(String resourceId,String textToScroll)
    {
                    driver
                .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                        + ".resourceId(\""+resourceId+"\")).scrollIntoView("
                        + "new UiSelector().text(\""+textToScroll+"\"));");
    }
}
