package utillities;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenCapture {

    private static final Logger LOGGER = LogManager.getLogger(ScreenCapture.class);
    public static void getScreenShot(WebDriver driver) {
        //Generating the file name with timestamp
        String fileName = new SimpleDateFormat("yyyy-MM-HH-mm-ss").format(new Date());

        // Capturing the screenshot and saving in the directory called screenshot in he project directory

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(screenshotFile, new File("screenshot/" + fileName + ".png"));
        } catch (Exception e) {
            LOGGER.error("ScreenShot Exception is: " + e.getMessage());
        }
    }
}
