package com.recruitcrm.tests;

import com.recruitcrm.base.BaseTest;
import com.recruitcrm.pages.ElementsPage;
import com.recruitcrm.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {

    @Test
    public void verifyButtonsFunctionality() {

        HomePage homePage = new HomePage(driver);
        homePage.clickElementsCard();

        ElementsPage elementsPage = new ElementsPage(driver);

        Assert.assertTrue(elementsPage.isElementsPageLoaded());

        elementsPage.clickButtonsMenu();

        elementsPage.performDoubleClick();
        Assert.assertEquals(
                elementsPage.getDoubleClickMessage(),
                "You have done a double click");

        elementsPage.performRightClick();
        Assert.assertEquals(
                elementsPage.getRightClickMessage(),
                "You have done a right click");

        elementsPage.performDynamicClick();
        Assert.assertEquals(
                elementsPage.getDynamicClickMessage(),
                "You have done a dynamic click");
    }
}