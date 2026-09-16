package com.recruitcrm.tests;

import com.recruitcrm.base.BaseTest;
import com.recruitcrm.pages.HomePage;
import com.recruitcrm.pages.InteractionsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectableTest extends BaseTest {

    @Test
    public void verifySelectableNavigation() {

        HomePage homePage = new HomePage(driver);
        homePage.clickInteractionsCard();

        InteractionsPage interactionsPage = new InteractionsPage(driver);

        interactionsPage.clickSelectable();

        Assert.assertTrue(
                interactionsPage.isSelectablePageLoaded(),
                "Selectable page did not open."
        );

        interactionsPage.selectCrasJusto();

        Assert.assertTrue(
                interactionsPage.isCrasJustoSelected(),
                "Cras justo was not selected."
        );
    }
}