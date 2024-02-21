package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.MyExtentReport;
import utilities.Utilites_1;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MyListeners implements ITestListener {
    ExtentReports extentReport;
    ExtentTest extentTest;
    public  RemoteWebDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
        extentTest=extentReport.createTest(result.getName());
        extentTest.log(Status.INFO,result.getName()+" is Started Executing");
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS,result.getName()+" is Executed Successfully");
        System.out.println(result.getName()+" is Executed  got Successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        RemoteWebDriver driver;
        String destinationScreenshot;
        try {
            driver = (RemoteWebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        try {
            destinationScreenshot=Utilites_1.caputureScreenshot(driver, result.getName());
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        extentTest.addScreenCaptureFromPath(destinationScreenshot);
        extentTest.log(Status.INFO,result.getThrowable());
        extentTest.log(Status.FAIL, result.getName()+"got Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.INFO,result.getThrowable());
        extentTest.log(Status.SKIP, result.getName()+" is Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        try {
            extentReport=MyExtentReport.generateExtentReport();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
    extentReport.flush();
        try {
            Desktop.getDesktop().browse(new File(System.getProperty("user.dir")+"\\test-output\\ExtendReport\\extent.html").toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
