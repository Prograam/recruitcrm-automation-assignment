package com.recruitcrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BrowserWindowsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BrowserWindowsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By browserWindowsMenu =
            By.xpath("//span[text()='Browser Windows']");

    private final By newTabButton =
            By.id("tabButton");

    public void clickBrowserWindowsMenu() {
        WebElement menu = wait.until(
                ExpectedConditions.elementToBeClickable(browserWindowsMenu));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", menu);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", menu);
    }

    public boolean isBrowserWindowsPageLoaded() {
        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(newTabButton))
                .isDisplayed();
    }

    public void openNewTab() {
        String parent = driver.getWindowHandle();

        wait.until(ExpectedConditions.elementToBeClickable(newTabButton)).click();

        wait.until(d -> d.getWindowHandles().size() > 1);

        Set<String> windows = driver.getWindowHandles();

        for (String w : windows) {
            if (!w.equals(parent)) {
                driver.switchTo().window(w);
                break;
            }
        }
    }

    public boolean isNewTabOpened() {
        return driver.getCurrentUrl().contains("sample");
    }
}