package com.recruitcrm.tests;

import com.recruitcrm.base.BaseTest;
import com.recruitcrm.pages.ElementsPage;
import com.recruitcrm.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyTextBoxFormSubmission() {

        HomePage homePage = new HomePage(driver);
        homePage.clickElementsCard();

        ElementsPage elementsPage = new ElementsPage(driver);

        Assert.assertTrue(elementsPage.isElementsPageLoaded());

        elementsPage.clickTextBox();

        elementsPage.fillTextBoxForm(
                "Rohan Sahu",
                "rohan@gmail.com",
                "Bangalore",
                "Permanent Bangalore");

        elementsPage.clickSubmit();

        Assert.assertEquals(
                elementsPage.getSubmittedName(),
                "Name:Rohan Sahu");

        Assert.assertEquals(
                elementsPage.getSubmittedEmail(),
                "Email:rohan@gmail.com");

        Assert.assertEquals(
                elementsPage.getSubmittedCurrentAddress(),
                "Current Address :Bangalore");

        Assert.assertEquals(
                elementsPage.getSubmittedPermanentAddress(),
                "Permananet Address :Permanent Bangalore");
    }
}