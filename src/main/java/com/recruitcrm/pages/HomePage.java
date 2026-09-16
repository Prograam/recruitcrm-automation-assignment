package com.recruitcrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By elementsCard = By.xpath("//h5[normalize-space()='Elements']");
    private final By widgetsCard = By.xpath("//h5[normalize-space()='Widgets']");
    private final By interactionsCard = By.xpath("//h5[normalize-space()='Interactions']");
    private final By alertsFrameCard =
            By.xpath("//h5[normalize-space()='Alerts, Frame & Windows']");


    private void clickCard(By locator) {
        WebElement card = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", card);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", card);

        pause();
    }

    public void clickElementsCard() {
        clickCard(elementsCard);
    }

    public void clickWidgetsCard() {
        clickCard(widgetsCard);
    }

    public void clickInteractionsCard() {
        clickCard(interactionsCard);
    }
    public void clickAlertsFrameCard() {
        clickCard(alertsFrameCard);
    }

    private void pause() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}