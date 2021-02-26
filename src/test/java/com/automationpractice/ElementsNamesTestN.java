package com.automationpractice;

import org.testng.annotations.Test;
import pageObjects.AboutUsPage;

import static org.testng.Assert.assertEquals;

public class ElementsNamesTestN extends BaseTestClass {

    @Test //About Us link name check
    public void AboutUsLinkName() {

        String actualLinkName = new AboutUsPage(driver).getActualLinkName();
        String expectedLinkName = new AboutUsPage(driver).getExpectedLinkName();

        assertEquals(actualLinkName, expectedLinkName);
        System.out.println("Test result: 'About Us' name of link is found and correct");
    }
}
