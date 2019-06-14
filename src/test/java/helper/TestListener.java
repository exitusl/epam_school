package helper;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;

import java.io.File;
import java.io.IOException;

public abstract class TestListener implements ITestListener {
    WebDriver driver = null;
    String filepath = "\\src\\screens";

    public void takeScreenShot(String methodName, WebDriver driver) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(filepath + methodName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
