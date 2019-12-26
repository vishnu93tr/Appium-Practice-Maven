package Tests.Ecommerce;

import Base.Base;
import PageObjects.FormPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ToastMessageTest extends Base
{
    @Test(dataProvider = "dp")
    public void  ToastMessagesTest(String name,String json_case) throws IOException, InterruptedException {
        JSONObject jsonObject=new JSONObject(json_case);
        AppiumDriverLocalService service=startServer();
        AndroidDriver<AndroidElement> driver=Capabilities("GeneralStoreApp");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        FormPage formPage =new FormPage(driver);
        formPage.LetsShopButton.click();
        String text= formPage.ToastMessage.getAttribute("name");
        Assert.assertEquals(text,jsonObject.getString("AssertText"),"expected message and actual are not same");
        service.stop();
    }
    @DataProvider
    public Object[][] dp() {
        Object[][] obj = getCases("testcases/ToastMessage.json");
        for(int p=0;p<obj.length;p++)
        {
            JSONObject js = new JSONObject(obj[p][1].toString());
            obj[p][1] = js.toString();
        }
        return obj;
    }
}
