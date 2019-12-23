package Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class Base
{
    private static final String ACTIVITY = "com.androidsample.generalstore.MainActivity";
    private static final String PACKAGE = "com.androidsample.generalstore";
    private static AndroidDriver<AndroidElement> driver;

    public static AndroidDriver<AndroidElement> Capabilities(String appName) throws IOException {
            Properties properties=new Properties();
            String path=System.getProperty("user.dir")+"\\src\\main\\global.properties";
            FileInputStream fileInputStream=new FileInputStream(path);
            properties.load(fileInputStream);
            properties.get(appName);
            File f = new File("src");
            File fs = new File(f, (String) properties.get(appName));
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", fs.getAbsolutePath());
            capabilities.setCapability("autoGrantPermissions",true);
            String device= (String) properties.get("Device");
            capabilities.setCapability("deviceName", device);

            capabilities.setCapability("automationName", "uiautomator2");
            capabilities.setCapability("adbExecTimeout",50000);
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, PACKAGE);
            capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, ACTIVITY);

            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

            System.out.println("setup successful");
            return  driver;


    }
}
