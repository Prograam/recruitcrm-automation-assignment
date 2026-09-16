package com.recruitcrm.tests;

import com.recruitcrm.base.BaseTest;
import com.recruitcrm.pages.AlertsFramesPage;
import com.recruitcrm.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {

    @Test
    public void verifyAlertsHandling() {

        HomePage homePage = new HomePage(driver);
        homePage.clickAlertsFrameCard();

        AlertsFramesPage alerts = new AlertsFramesPage(driver);

        alerts.clickAlertsMenu();

        alerts.acceptSimpleAlert();

        alerts.acceptTimerAlert();

        alerts.dismissConfirmAlert();

        Assert.assertTrue(
                alerts.getConfirmResult().contains("Cancel"),
                "Confirm alert was not dismissed."
        );

        alerts.enterPrompt("Rohan");

        Assert.assertTrue(
                alerts.getPromptResult().contains("Rohan"),
                "Prompt alert text not matched."
        );
    }
}