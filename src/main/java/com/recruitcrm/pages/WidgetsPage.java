package com.recruitcrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WidgetsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public WidgetsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By widgetsCard = By.xpath("//h5[normalize-space()='Widgets']");
    private By selectMenu = By.xpath("//span[text()='Select Menu']");
    private By oldStyleSelect = By.id("oldSelectMenu");

    public void clickWidgetsCard() {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(widgetsCard));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", element);

        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        pause();
    }

    public void openSelectMenu() {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(selectMenu));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", element);

        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        pause();
    }

    public void selectBlueValue() {
        WebElement dropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(oldStyleSelect));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", dropdown);

        Select select = new Select(dropdown);
        select.selectByVisibleText("Blue");

        pause();
    }

    public String getSelectedValue() {
        Select select = new Select(driver.findElement(oldStyleSelect));
        return select.getFirstSelectedOption().getText();
    }

    private void pause() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}