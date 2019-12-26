package Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

public class Base
{
    private static final String ACTIVITY = "com.androidsample.generalstore.MainActivity";
    private static final String PACKAGE = "com.androidsample.generalstore";
    private static AndroidDriver<AndroidElement> driver;
    AppiumDriverLocalService service;
    public static AndroidDriver<AndroidElement> Capabilities(String appName) throws IOException, InterruptedException {
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
            if(device.contains("emulator"))
            {
                StartEmulator();
            }
            capabilities.setCapability("deviceName", device);

            capabilities.setCapability("automationName", "uiautomator2");
            capabilities.setCapability("adbExecTimeout",50000);
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, PACKAGE);
            capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, ACTIVITY);

            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

            System.out.println("setup successful");
            return  driver;

    }
    public AppiumDriverLocalService StartServer()
    {
       boolean status= CheckServerIsRunning(4723);
        if(!status)
        {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        return service;
    }
    public static Boolean CheckServerIsRunning(int port)
    {
        boolean isServerRunning=false;
        ServerSocket serverSocket;
        try
        {
            serverSocket=new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            isServerRunning=true;
            e.printStackTrace();
        }
        finally {
            serverSocket=null;
        }
        return isServerRunning;
    }
    public static void StartEmulator() throws IOException, InterruptedException
    {
        String path=System.getProperty("user.dir")+"\\src\\main\\resources\\startEmulator.bat";
        Runtime.getRuntime().exec(path);
        Thread.sleep(10000);
    }

}
