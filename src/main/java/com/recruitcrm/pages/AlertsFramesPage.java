package com.recruitcrm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class AlertsFramesPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public AlertsFramesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private final By alertsMenu =
            By.xpath("//span[normalize-space()='Alerts']");

    private final By alertButton =
            By.id("alertButton");

    private final By timerAlertButton =
            By.id("timerAlertButton");

    private final By confirmButton =
            By.id("confirmButton");

    private final By promptButton =
            By.id("promtButton");

    private final By confirmResult =
            By.id("confirmResult");

    private final By promptResult =
            By.id("promptResult");

    public void clickAlertsMenu() {
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(alertsMenu));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", menu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menu);
    }

    public void acceptSimpleAlert() {
        wait.until(ExpectedConditions.elementToBeClickable(alertButton)).click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void acceptTimerAlert() {
        wait.until(ExpectedConditions.elementToBeClickable(timerAlertButton)).click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void dismissConfirmAlert() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton)).click();
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
    }

    public String getConfirmResult() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmResult)).getText();
    }

    public void enterPrompt(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(promptButton)).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(text);
        alert.accept();
    }

    public String getPromptResult() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(promptResult)).getText();
    }

    public void switchToNewWindow(By buttonLocator) {
        String parent = driver.getWindowHandle();

        wait.until(ExpectedConditions.elementToBeClickable(buttonLocator)).click();

        wait.until(d -> d.getWindowHandles().size() > 1);

        Set<String> windows = driver.getWindowHandles();

        for (String w : windows) {
            if (!w.equals(parent)) {
                driver.switchTo().window(w);
                break;
            }
        }
    }

    public void switchBack(String parent) {
        driver.close();
        driver.switchTo().window(parent);
    }
}