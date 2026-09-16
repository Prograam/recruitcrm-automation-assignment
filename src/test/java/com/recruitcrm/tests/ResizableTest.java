package com.recruitcrm.tests;

import com.recruitcrm.base.BaseTest;
import com.recruitcrm.pages.HomePage;
import com.recruitcrm.pages.InteractionsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResizableTest extends BaseTest {

    @Test
    public void verifyResizableBox() {

        HomePage homePage = new HomePage(driver);
        homePage.clickInteractionsCard();

        InteractionsPage interactionsPage = new InteractionsPage(driver);

        interactionsPage.clickResizable();

        Assert.assertTrue(interactionsPage.isResizablePageLoaded());

        interactionsPage.resizeBox();

        Assert.assertTrue(interactionsPage.isBoxResized());
    }
}