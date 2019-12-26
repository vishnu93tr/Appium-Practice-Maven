package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public interface ListenersTest extends ITestListener {
    void onFinish(ITestContext arg0);

    void onStart(ITestContext arg0);

    void onTestFailedButWithinSuccessPercentage(ITestResult arg0);

    void onTestFailure(ITestResult arg0);

    void onTestSkipped(ITestResult arg0);

    void onTestStart(ITestResult arg0);

    void onTestSuccess(ITestResult arg0);
}
