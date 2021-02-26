package com.automationpractice;

import logs.Log;
import logs.LogType;
import org.testng.annotations.Test;
import pageObjects.BannersPage;
import pageObjects.RedirectionUrls;
import pageObjects.SearchHomePageElements;

import static org.testng.Assert.assertEquals;

//13 tests created

public class OpenCloseMainPagesUrlTest extends BaseTestClass {

    @Test(priority = 5) // re-written
    public void HomePage() {

        String actualTitle = new SearchHomePageElements(driver).getActualTitle();
        String expectedTitle = new SearchHomePageElements(driver).getExpectedTitle();

        assertEquals(actualTitle, expectedTitle);
        Log.log("Test result: 'My Store' title is found and correct", LogType.INFO);
        Log.log("Priority 5", LogType.INFO);
    }

    @Test(priority = 4, description = "this test about Women page") //#2 // re-written without logs
    public void WomanPage() {

        new RedirectionUrls(driver).womenPagePutUrl(); //put URL into browser URL bar
        String actualTitle = new SearchHomePageElements(driver).getActualTitle();
        String expectedWomenPageTitle = new SearchHomePageElements(driver).getExpectedWomenPageTitle(); //get title of page

        assertEquals(actualTitle, expectedWomenPageTitle); // compare an actual result and expected
        System.out.println("Test result: 'Women - My Store' title is found and correct");
    }

    @Test(priority = 3) // re-written without logs
    public void WomanPageClick() {

        //driver.findElement(By.linkText("Women")).click();
        new SearchHomePageElements(driver).clickOnWomenMenuButton();
        String currentUrl = new RedirectionUrls(driver).getWomenPageUrl();
        String expectedUrl = new RedirectionUrls(driver).womenPageUrl();
        assertEquals(currentUrl, expectedUrl, "URL is correct");
        System.out.println("Priority 3");
    }

    @Test(priority = 2) // re-written without logs
    public void DressesPageClick() {

        new SearchHomePageElements(driver).clickOnDressesButton();
        String currentUrl = new RedirectionUrls(driver).getUrlDressesPage();
        String expectedUrl = new RedirectionUrls(driver).dressesPageUrl();
        assertEquals(currentUrl, expectedUrl, "URL is correct");
        System.out.println("Priority 2");
    }

    @Test(priority = 1) // re-written without logs
    public void TshirtsPageClick() {

        new SearchHomePageElements(driver).clickOnTshirtsButton();
        String currentUrl = new RedirectionUrls(driver).getTshirtsPageUrl();
        String expectedUrl = new RedirectionUrls(driver).tShirtsPageUrl();
        assertEquals(currentUrl, expectedUrl, "URL is correct");
        System.out.println("Priority 1");
    }

        @Test // re-written without logs
        public void ThreeDaysSaleBannerClick() {

            new BannersPage(driver).clickOnStaticBannerSix();
            String currentUrl = new RedirectionUrls(driver).getUrlExternalPage();
            String expectedUrl = new RedirectionUrls(driver).externalPageURL();
            assertEquals(currentUrl, expectedUrl, "URL is correct");
            System.out.println("Three DaysSale Banner redirection");
        }

        @Test // failed
        public void SummerCollectionBannerClick() {

            new BannersPage(driver).clickOnStaticBannerSeven();
            String currentUrl = new RedirectionUrls(driver).getUrlExternalPage();
            String expectedUrl = new RedirectionUrls(driver).externalPageURL();
            assertEquals(currentUrl, expectedUrl, "URL is correct");
            System.out.println("Summer Collection Banner redirection");
        }

        @Test
        public void TopTrendsBannerClick() {

            new BannersPage(driver).clickOnStaticBannerOne();
            String currentUrl = new RedirectionUrls(driver).getUrlExternalPage();
            String expectedUrl = new RedirectionUrls(driver).externalPageURL();
            assertEquals(currentUrl, expectedUrl, "URL is correct");
            System.out.println("Top Trends Banner redirection");
        }

        @Test
        public void SunGlassesAndEyeWearBannerClick() {

            new BannersPage(driver).clickOnStaticBannerFour();
            String currentUrl = new RedirectionUrls(driver).getUrlExternalPage();
            String expectedUrl = new RedirectionUrls(driver).externalPageURL();
            assertEquals(currentUrl, expectedUrl, "URL is correct");
            System.out.println("Sun Glasses & Eyewear Banner redirection");
        }

        @Test
        public void MenCoatAndJacketsBannerClick() {

            new BannersPage(driver).clickOnStaticBannerTwo();
            String currentUrl = new RedirectionUrls(driver).getUrlExternalPage();
            String expectedUrl = new RedirectionUrls(driver).externalPageURL();
            assertEquals(currentUrl, expectedUrl, "URL is correct");
            System.out.println("Men's Coat & Jackets Banner redirection");
        }

        @Test
        public void SavvyTrendsHandBagsBannerClick() {

            new BannersPage(driver).clickOnStaticBannerFive();
            String currentUrl = new RedirectionUrls(driver).getUrlExternalPage();
            String expectedUrl = new RedirectionUrls(driver).externalPageURL();
            assertEquals(currentUrl, expectedUrl, "URL is correct");
            System.out.println("Savvy Trends Handbags Banner redirection");
        }

        @Test
        public void WomenCoatAndJacketsBannerClick() {

            new BannersPage(driver).clickOnStaticBannerThree();
            String currentUrl = new RedirectionUrls(driver).getUrlExternalPage();
            String expectedUrl = new RedirectionUrls(driver).externalPageURL();
            assertEquals(currentUrl, expectedUrl, "URL is correct");
            System.out.println("Women's Coat & Jackets Banner redirection");
        }

        @Test //, enabled = false
        public void LogoClick() {

            new BannersPage(driver).clickOnStaticLogo();
            String currentUrl = new RedirectionUrls(driver).getUrlLogoPage();
            String expectedUrl = new RedirectionUrls(driver).logoPageURL();
            assertEquals(currentUrl, expectedUrl, "URL is correct");
            System.out.println("'Home' page redirection");
        }

}

