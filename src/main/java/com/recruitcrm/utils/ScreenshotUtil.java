package com.recruitcrm.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtil {

    public static String capture(WebDriver driver, String testName) {

        File source = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        String path = "test-output/screenshots/" + testName + ".png";

        File destination = new File(path);

        destination.getParentFile().mkdirs();

        try {
            Files.copy(source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}