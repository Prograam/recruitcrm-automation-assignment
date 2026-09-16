package com.recruitcrm.tests;

import com.recruitcrm.base.BaseTest;
import com.recruitcrm.pages.ElementsPage;
import com.recruitcrm.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest extends BaseTest {

    @Test
    public void verifyDocumentsCheckBoxSelection() {

        HomePage homePage = new HomePage(driver);
        homePage.clickElementsCard();

        ElementsPage elementsPage = new ElementsPage(driver);

        Assert.assertTrue(elementsPage.isElementsPageLoaded());

        elementsPage.clickCheckBox();
        elementsPage.expandHome();
        elementsPage.expandDocuments();
        elementsPage.selectDocuments();

        Assert.assertTrue(elementsPage.isDocumentsSelectionDisplayed());
    }
}