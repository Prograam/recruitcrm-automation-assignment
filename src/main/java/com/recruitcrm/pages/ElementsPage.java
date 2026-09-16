package com.recruitcrm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ElementsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By textBoxMenu = By.id("item-0");
    private By checkBoxMenu = By.id("item-1");

    private By fullName = By.id("userName");
    private By email = By.id("userEmail");
    private By currentAddress = By.id("currentAddress");
    private By permanentAddress = By.id("permanentAddress");
    private By submitButton = By.id("submit");

    private By outputName = By.id("name");
    private By outputEmail = By.id("email");
    private By outputCurrentAddress =
            By.xpath("//p[@id='currentAddress']");
    private By outputPermanentAddress =
            By.xpath("//p[@id='permanentAddress']");

    private By homeToggle =
            By.xpath("//span[normalize-space()='Home']/ancestor::li[1]//button[@title='Toggle']");

    private By documentsToggle =
            By.xpath("//span[normalize-space()='Documents']/ancestor::li[1]//button[@title='Toggle']");

    private By documentsCheckBox =
            By.xpath("//span[normalize-space()='Documents']/preceding-sibling::span[contains(@class,'rct-checkbox')]");

    private By resultSection = By.id("result");

    //ration button automation
    private By radioButtonMenu = By.id("item-2");

    private By yesRadio = By.xpath("//label[@for='yesRadio']");

    private By radioResult = By.className("text-success");

    // web tables
    private By webTablesMenu = By.id("item-3");
    private By addButton = By.id("addNewRecordButton");

    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By userEmailField = By.id("userEmail");
    private By age = By.id("age");
    private By salary = By.id("salary");
    private By department = By.id("department");

    private By submitRecord = By.id("submit");
    // buttons
    private By buttonsMenu = By.id("item-4");

    private By doubleClickBtn = By.id("doubleClickBtn");
    private By rightClickBtn = By.id("rightClickBtn");
    private By dynamicClickBtn = By.xpath("//button[text()='Click Me']");

    private By doubleClickMsg = By.id("doubleClickMessage");
    private By rightClickMsg = By.id("rightClickMessage");
    private By dynamicClickMsg = By.id("dynamicClickMessage");


    public boolean isElementsPageLoaded() {
        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(textBoxMenu))
                .isDisplayed();
    }

    public void clickTextBox() {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(textBoxMenu));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);

        pause();
    }

    public void fillTextBoxForm(String name,
                                String userEmail,
                                String currentAddr,
                                String permanentAddr) {

        WebElement nameField =
                wait.until(ExpectedConditions.visibilityOfElementLocated(fullName));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", nameField);

        pause();

        nameField.sendKeys(name);

        driver.findElement(email).sendKeys(userEmail);
        driver.findElement(currentAddress).sendKeys(currentAddr);
        driver.findElement(permanentAddress).sendKeys(permanentAddr);

        pause();
    }

    public void clickSubmit() {

        WebElement button =
                wait.until(ExpectedConditions.presenceOfElementLocated(submitButton));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", button);

        pause();

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", button);

        pause();
    }

    public String getSubmittedName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(outputName))
                .getText();
    }

    public String getSubmittedEmail() {
        return driver.findElement(outputEmail).getText();
    }

    public String getSubmittedCurrentAddress() {
        return driver.findElement(outputCurrentAddress).getText();
    }

    public String getSubmittedPermanentAddress() {
        return driver.findElement(outputPermanentAddress).getText();
    }

    public void clickCheckBox() {

        WebElement element =
                wait.until(ExpectedConditions.elementToBeClickable(checkBoxMenu));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);

        pause();
    }

    public void expandHome() {
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(homeToggle));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        wait.until(ExpectedConditions.elementToBeClickable(element));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);

        pause();
    }

    public void selectDocuments() {
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(documentsCheckBox));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        wait.until(ExpectedConditions.elementToBeClickable(element));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);

        pause();
    }

    public void expandDocuments() {
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(documentsToggle));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        wait.until(ExpectedConditions.elementToBeClickable(element));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);

        pause();
    }

    public boolean isDocumentsSelectionDisplayed() {

        String result = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(resultSection))
                .getText()
                .toLowerCase();

        return result.contains("documents")
                && result.contains("workspace")
                && result.contains("react")
                && result.contains("angular")
                && result.contains("veu")
                && result.contains("office")
                && result.contains("public")
                && result.contains("private")
                && result.contains("classified")
                && result.contains("general");
    }
    public void clickRadioButtonMenu() {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(radioButtonMenu));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);

        pause();
    }

    public void selectYesRadio() {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(yesRadio));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);

        pause();
    }

    public String getSelectedRadioText() {
        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(radioResult))
                .getText();
    }
    public void clickWebTables() {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(webTablesMenu));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        element.click();
        pause();
    }

    public void clickAddButton() {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(addButton));

        element.click();
        pause();
    }

    public void addEmployee(String fName,
                            String lName,
                            String email,
                            String empAge,
                            String empSalary,
                            String dept) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName))
                .sendKeys(fName);

        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(userEmailField).sendKeys(email);
        driver.findElement(age).sendKeys(empAge);
        driver.findElement(salary).sendKeys(empSalary);
        driver.findElement(department).sendKeys(dept);

        WebElement button = driver.findElement(submitRecord);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", button);

        button.click();
        pause();
    }
    public boolean isEmployeePresent(String firstNameValue,
                                     String lastNameValue) {

        By employee = By.xpath(
                "//div[@role='row' and .//div[text()='" + firstNameValue +
                        "'] and .//div[text()='" + lastNameValue + "']]");

        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(employee))
                .isDisplayed();
    }
    public void clickButtonsMenu() {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(buttonsMenu));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        element.click();
        pause();
    }
    public void performDoubleClick() {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(doubleClickBtn));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        new Actions(driver)
                .doubleClick(element)
                .perform();

        pause();
    }
    public void performRightClick() {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(rightClickBtn));

        new Actions(driver)
                .contextClick(element)
                .perform();

        pause();
    }
    public void performDynamicClick() {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(dynamicClickBtn));

        element.click();

        pause();
    }
    public String getDoubleClickMessage() {
        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(doubleClickMsg))
                .getText();
    }

    public String getRightClickMessage() {
        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(rightClickMsg))
                .getText();
    }

    public String getDynamicClickMessage() {
        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(dynamicClickMsg))
                .getText();
    }

    private void pause() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}