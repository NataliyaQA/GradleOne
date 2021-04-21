package com.automationpractice.carrouselTest;

import logs.Log;
import logs.LogType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BannersPage;
import pageObjects.RedirectionUrls;

import static org.testng.Assert.assertEquals;

//4 tests created

public class CarrouselBannerTest extends BaseTestCarrouselTest {

    @Test (enabled=false)
    //re-wrote  + question (why we return to the initial page and make there verification, why don't do it on redirection page?)
    public void firstCarrouselBanner() {
        new BannersPage(driver).hoverFirstBannerButton(); //hover button on 1st banner
        Log.log("The mouse found the button on the first carrousel", LogType.ERROR);

        String buttonNameOne = new BannersPage(driver).getButtonNameOne();
        String expectedButtonName = new BannersPage(driver).getExpectedButtonName();

        Assert.assertTrue(expectedButtonName.toLowerCase().contains(buttonNameOne.toLowerCase()),
                "Name of button is correct");
        Log.log("Name of the button is correct", LogType.INFO);

        new BannersPage(driver).clickOnFirstBannerButton();

        String currentUrl = new RedirectionUrls(driver).getUrlExternalPage();
        String expectedUrl = new RedirectionUrls(driver).externalPageURL();
        assertEquals(currentUrl, expectedUrl, "URL is correct");
        Log.log("First link from carrousel is correct", LogType.WARNING);
    }

    @Test (enabled=false) //re-wrote
    public void goToSecondCarrouselBanner() {
        new BannersPage(driver).clickOnRightArrowButton();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new BannersPage(driver).hoverSecondBannerButton(); //hover button on 2st banner
        Log.log("The mouse found the button on the 2d carrousel", LogType.INFO);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String buttonNameTwo = new BannersPage(driver).getButtonNameTwo();
        String expectedButtonName = new BannersPage(driver).getExpectedButtonName();

        Assert.assertEquals(buttonNameTwo, expectedButtonName, "Name of button is correct");
        Log.log("Name of the button is correct", LogType.INFO);
    }

    @Test (enabled=false) //re-wrote + question about verification of redirected banner
    public void UseArrowsGoRightGoLeftBanner() throws InterruptedException {
        new BannersPage(driver).clickOnRightArrowButton();
        Log.log("The mouse found the right arrow button on the first carrousel", LogType.INFO);

        Thread.sleep(1000);

        new BannersPage(driver).clickOnLeftArrowButton();
        Log.log("The mouse found the left arrow button on the second carrousel", LogType.INFO);

        Thread.sleep(1000);

        Log.log("We returned to 1st banner", LogType.INFO);
    }

    @Test //re-wrote
    public void goToThirdCarrouselBanner() {

        new BannersPage(driver).clickOnRightArrowButton();
        Log.log("The mouse found the right arrow button on the 2d carrousel", LogType.INFO);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new BannersPage(driver).clickOnRightArrowButton();
        Log.log("The mouse found the right arrow button on the 3d carrousel", LogType.INFO);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String buttonNameThree = new BannersPage(driver).getButtonNameThree();
        String expectedButtonName = new BannersPage(driver).getExpectedButtonName();

        Assert.assertEquals(buttonNameThree, expectedButtonName, "Name of button is correct");
        Log.log("Name of the button is correct", LogType.INFO);

        new BannersPage(driver).clickOnThirdBannerButton();

        String currentUrl = new RedirectionUrls(driver).getUrlExternalPage();
        String expectedUrl = new RedirectionUrls(driver).externalPageURL();
        assertEquals(currentUrl, expectedUrl, "URL is correct");
        Log.log("First link from carrousel is correct", LogType.INFO);
    }
}
