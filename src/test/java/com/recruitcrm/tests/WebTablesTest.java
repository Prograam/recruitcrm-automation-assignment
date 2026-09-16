package com.recruitcrm.tests;

import com.recruitcrm.base.BaseTest;
import com.recruitcrm.pages.ElementsPage;
import com.recruitcrm.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTablesTest extends BaseTest {

    @Test
    public void verifyAddEmployee() {

        HomePage homePage = new HomePage(driver);
        homePage.clickElementsCard();

        ElementsPage elementsPage = new ElementsPage(driver);

        Assert.assertTrue(elementsPage.isElementsPageLoaded());

        elementsPage.clickWebTables();
        elementsPage.clickAddButton();

        elementsPage.addEmployee(
                "Rohan",
                "Sahu",
                "rohan@test.com",
                "24",
                "50000",
                "QA");

        Assert.assertTrue(
                elementsPage.isEmployeePresent("Rohan", "Sahu"));
    }
}