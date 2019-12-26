package Listeners;

import Base.Base;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners implements ListenersTest
{
    @Override
    public void onFinish(ITestContext context)
    {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        Base base=new Base();
        String testname=result.getName();
        try
        {
            base.getScreenshot(testname);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result)
    {

    }
}
