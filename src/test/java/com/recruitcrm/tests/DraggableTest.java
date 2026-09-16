package com.recruitcrm.tests;

import com.recruitcrm.base.BaseTest;
import com.recruitcrm.pages.HomePage;
import com.recruitcrm.pages.InteractionsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DraggableTest extends BaseTest {

    @Test
    public void verifyDragBoxMovement() {

        HomePage homePage = new HomePage(driver);
        homePage.clickInteractionsCard();

        InteractionsPage interactionsPage = new InteractionsPage(driver);

        interactionsPage.clickDraggable();
        System.out.println(driver.getCurrentUrl());

        Assert.assertTrue(
                interactionsPage.isDraggablePageLoaded(),
                "Draggable page did not open."
        );

        interactionsPage.dragBox();

        Assert.assertTrue(
                interactionsPage.isDragSuccessful(),
                "Drag operation failed."
        );
    }
}