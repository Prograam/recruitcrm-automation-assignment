package com.recruitcrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Point;
import java.time.Duration;

public class InteractionsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public InteractionsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.actions = new Actions(driver);
    }

    private By sortableMenu = By.xpath("//span[normalize-space()='Sortable']");
    private By sortableHeading = By.xpath("//div[@class='main-header' and normalize-space()='Sortable']");
    private By listOne = By.xpath("//div[@id='demo-tabpane-list']//div[text()='One']");
    private By listTwo = By.xpath("//div[@id='demo-tabpane-list']//div[text()='Two']");

    private By selectableMenu = By.xpath("//span[normalize-space()='Selectable']");
    private By selectableHeading = By.xpath("//div[@class='main-header' and normalize-space()='Selectable']");
    private By crasJusto = By.xpath("//li[normalize-space()='Cras justo odio']");

    private By resizableMenu = By.xpath("//span[normalize-space()='Resizable']");
    private By resizableBox = By.id("resizableBoxWithRestriction");
    private By resizeHandle = By.xpath("//div[@id='resizableBoxWithRestriction']/span");

    private final By droppableMenu = By.xpath("//span[normalize-space()='Droppable']");
    private final By dragBox = By.id("draggable");
    private final By dropBox = By.id("droppable");
    // Draggable
    private final By draggableMenu =
            By.xpath("//span[normalize-space()='Dragabble']");


    private final By dragBoxElement = By.id("dragBox");

    private void pause() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void scrollTo(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                element);
    }

    public void clickSortable() {
        scrollTo(sortableMenu);

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(sortableMenu));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

        pause();
    }

    public boolean isSortablePageLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sortableHeading)).isDisplayed();
    }

    public void dragFirstItemToSecond() {
        WebElement first = wait.until(ExpectedConditions.visibilityOfElementLocated(listOne));
        WebElement second = wait.until(ExpectedConditions.visibilityOfElementLocated(listTwo));

        actions.dragAndDrop(first, second).perform();

        pause();
    }

    public void clickSelectable() {
        scrollTo(selectableMenu);

        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(selectableMenu));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);

        pause();
    }

    public boolean isSelectablePageLoaded() {

        wait.until(ExpectedConditions.urlContains("/selectable"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[normalize-space()='Cras justo odio']")));

        return true;
    }

    public void selectCrasJusto() {
        scrollTo(crasJusto);

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(crasJusto));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

        pause();
    }

    public boolean isCrasJustoSelected() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(crasJusto));

        return element.getAttribute("class").contains("active");
    }


    public void clickResizable() {
        WebElement menu = wait.until(
                ExpectedConditions.presenceOfElementLocated(resizableMenu));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", menu);

        wait.until(ExpectedConditions.elementToBeClickable(menu));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", menu);
    }
    public boolean isResizablePageLoaded() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(resizableBox));
            wait.until(ExpectedConditions.visibilityOfElementLocated(resizeHandle));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void resizeBox() {

        WebElement box = wait.until(
                ExpectedConditions.visibilityOfElementLocated(resizableBox));

        WebElement handle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(resizeHandle));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", handle);

        actions.moveToElement(handle)
                .clickAndHold()
                .moveByOffset(120, 80)
                .release()
                .perform();

        wait.until(d ->
                box.getSize().getWidth() > 200);
    }
    public boolean isBoxResized() {

        WebElement box = driver.findElement(resizableBox);

        int width = box.getSize().getWidth();
        int height = box.getSize().getHeight();

        System.out.println("Width = " + width);
        System.out.println("Height = " + height);

        return width > 200 && height > 200;
    }

    public int getResizableWidth() {
        return driver.findElement(resizableBox).getSize().getWidth();
    }

    public int getResizableHeight() {
        return driver.findElement(resizableBox).getSize().getHeight();
    }
    public void clickDroppable() {
        WebElement menu = wait.until(
                ExpectedConditions.presenceOfElementLocated(droppableMenu));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", menu);

        wait.until(ExpectedConditions.elementToBeClickable(menu)).click();
    }

    public boolean isDroppablePageLoaded() {
        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(dragBox))
                .isDisplayed();
    }

    public void dragToDrop() {
        WebElement source = wait.until(
                ExpectedConditions.visibilityOfElementLocated(dragBox));

        WebElement target = wait.until(
                ExpectedConditions.visibilityOfElementLocated(dropBox));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", source);

        actions.dragAndDrop(source, target).perform();
    }

    public boolean isDroppedSuccessfully() {
        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(dropBox))
                .getText()
                .equalsIgnoreCase("Dropped!");
    }
    public void clickDraggable() {

        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(draggableMenu));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", element);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", element);

        wait.until(ExpectedConditions.urlContains("dragabble"));
    }

    public boolean isDraggablePageLoaded() {

        try {
            wait.until(ExpectedConditions.urlContains("dragabble"));

            wait.until(ExpectedConditions.visibilityOfElementLocated(dragBoxElement));

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public void dragBox() {
        WebElement box = wait.until(
                ExpectedConditions.visibilityOfElementLocated(dragBoxElement));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", box);

        Point before = box.getLocation();

        actions.dragAndDropBy(box, 150, 100).perform();

        wait.until(driver ->
                !driver.findElement(dragBoxElement).getLocation().equals(before));
    }

    public boolean isDragSuccessful() {
        Point point = driver.findElement(dragBoxElement).getLocation();
        return point.getX() > 0 && point.getY() > 0;
    }

}