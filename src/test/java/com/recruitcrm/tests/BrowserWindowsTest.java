package com.recruitcrm.tests;

import com.recruitcrm.base.BaseTest;
import com.recruitcrm.pages.BrowserWindowsPage;
import com.recruitcrm.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserWindowsTest extends BaseTest {

    @Test
    public void verifyBrowserWindowHandling() {

        HomePage homePage = new HomePage(driver);
        homePage.clickAlertsFrameCard();

        BrowserWindowsPage browser = new BrowserWindowsPage(driver);

        browser.clickBrowserWindowsMenu();

        Assert.assertTrue(
                browser.isBrowserWindowsPageLoaded(),
                "Browser Windows page did not open."
        );

        browser.openNewTab();

        Assert.assertTrue(
                browser.isNewTabOpened(),
                "New tab was not opened."
        );
    }
}