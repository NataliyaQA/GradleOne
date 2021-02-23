package com.automationpractice;

import org.testng.annotations.Test;
import pageObjects.AboutUsPage;

import static org.testng.Assert.assertEquals;

public class PagesTitlesTestN extends AbstractClass{

    @Test
    public void AboutUsPageTitle() {

        new AboutUsPage(driver).clickAboutUsLink();

        String actualTitleName = new AboutUsPage(driver).getActualTitle();
        String expectedTitleName = new AboutUsPage(driver).getExpectedTitle();

        assertEquals(actualTitleName, expectedTitleName);
        System.out.println("Test result: 'About us - My Store' name of page is found and correct");
    }
}
