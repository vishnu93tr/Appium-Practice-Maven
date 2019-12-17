package Tests.Ecommerce;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Base
{
    private static final String ACTIVITY = "com.androidsample.generalstore.MainActivity";
    private static final String PACKAGE = "com.androidsample.generalstore";
    private static AndroidDriver<AndroidElement> driver;

    public static AndroidDriver<AndroidElement> Capabilities(String deviceName) throws MalformedURLException {

            File f = new File("src");
            File fs = new File(f, "General-Store.apk");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", fs.getAbsolutePath());
            capabilities.setCapability("autoGrantPermissions",true);
            if(deviceName.equals("emulator"))
            {
                capabilities.setCapability("deviceName", "Emulator1");
            }
            else if(deviceName.equals("real"))
            {
                capabilities.setCapability("deviceName","Android Device");
            }

            capabilities.setCapability("automationName", "uiautomator2");
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, PACKAGE);
            capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, ACTIVITY);

            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

            System.out.println("setup successful");
            return  driver;


    }
}
