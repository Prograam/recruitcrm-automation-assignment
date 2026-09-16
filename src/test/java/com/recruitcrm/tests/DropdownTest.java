package com.recruitcrm.tests;

import com.recruitcrm.base.BaseTest;
import com.recruitcrm.pages.HomePage;
import com.recruitcrm.pages.WidgetsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends BaseTest {

    @Test
    public void verifyDropdownSelection() {

        HomePage homePage = new HomePage(driver);
        homePage.clickWidgetsCard();

        WidgetsPage widgetsPage = new WidgetsPage(driver);
        widgetsPage.openSelectMenu();
        widgetsPage.selectBlueValue();

        Assert.assertEquals(widgetsPage.getSelectedValue(), "Blue");
    }
}