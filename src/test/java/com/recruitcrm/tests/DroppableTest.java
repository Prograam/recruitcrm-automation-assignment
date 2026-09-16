package com.recruitcrm.tests;

import com.recruitcrm.base.BaseTest;
import com.recruitcrm.pages.HomePage;
import com.recruitcrm.pages.InteractionsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DroppableTest extends BaseTest {

    @Test
    public void verifyDragAndDrop() {

        HomePage homePage = new HomePage(driver);
        homePage.clickInteractionsCard();

        InteractionsPage interactionsPage = new InteractionsPage(driver);

        interactionsPage.clickDroppable();

        Assert.assertTrue(
                interactionsPage.isDroppablePageLoaded(),
                "Droppable page did not open."
        );

        interactionsPage.dragToDrop();

        Assert.assertTrue(
                interactionsPage.isDroppedSuccessfully(),
                "Drag and Drop failed."
        );
    }
}