package com.automationpractice;

import org.testng.annotations.Test;
import pageObjects.AboutUsPage;
import static org.testng.Assert.assertEquals;

public class PagesUrlN extends AbstractClass{

    @Test
    public void AboutUsLinkUrl() {

        new AboutUsPage(driver).clickAboutUsLink();

        String actualUrl = new AboutUsPage(driver).getActualUrl();
        String expectedUrl = new AboutUsPage(driver).getExpectedUrl();

        assertEquals(actualUrl, expectedUrl);
        System.out.println("Test result: 'About Us' URL is found and correct");
    }

}
