package com.recruitcrm.tests;

import com.recruitcrm.base.BaseTest;
import com.recruitcrm.pages.ElementsPage;
import com.recruitcrm.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest {

    @Test
    public void verifyYesRadioButtonSelection() {

        HomePage homePage = new HomePage(driver);
        homePage.clickElementsCard();

        ElementsPage elementsPage = new ElementsPage(driver);

        Assert.assertTrue(elementsPage.isElementsPageLoaded());

        elementsPage.clickRadioButtonMenu();

        elementsPage.selectYesRadio();

        Assert.assertEquals(
                elementsPage.getSelectedRadioText(),
                "Yes");
    }
}