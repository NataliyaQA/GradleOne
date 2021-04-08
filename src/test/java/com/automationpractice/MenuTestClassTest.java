package com.automationpractice;

import org.testng.annotations.Test;
import pageObjects.RedirectionUrls;
import pageObjects.SearchHomePageElements;

import static org.testng.Assert.assertEquals;

//9 tests created

public class MenuTestClassTest extends BaseTestAbstractClass {

    /**
     * Check redirection and link of T-Shirt page via T-Shirt submenu of Women menu
     */
    @Test // re-written
    public void mainMenuWomenTopsTshirts() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new SearchHomePageElements(driver).hoverWomen();                               //hover Women tab name
        new SearchHomePageElements(driver).clickOnWomenMenuTshirsOption();             //click on Women tab name

        String womenMenuTshirsOption = new RedirectionUrls(driver).getTshirtsPageUrl();//get URL of new opened page
        String tShirsPageUrl = new RedirectionUrls(driver).tShirtsPageUrl();

        assertEquals(womenMenuTshirsOption, tShirsPageUrl, "URL is correct");  //compare actual and expected result
        System.out.print("'T-Short' page is opened from 'Women'");
    }

    /**
     * Check redirection and link of Blouses page via Top submenu of Women menu
     */
    @Test
    public void mainMenuWomenTopsBlouses() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new SearchHomePageElements(driver).hoverWomen();
        new SearchHomePageElements(driver).clickOnWomenMenuBlousesOption();
        String womenMenuBlousesOption = new RedirectionUrls(driver).getUrlBlouses();   //get URL of new opened page
        String blousesPageUrl = new RedirectionUrls(driver).blousesPageUrl();

        assertEquals(womenMenuBlousesOption, blousesPageUrl, "URL is correct");//compare actual and expected result
        System.out.print("'Blouses' page is opened from 'Women'");
    }

    /**
     * Check redirection and link of CasualDresses page via Dresses submenu of Women menu
     */
    @Test
    public void mainMenuWomenDressesCasualDresses() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new SearchHomePageElements(driver).hoverWomen();
        new SearchHomePageElements(driver).clickOnCasualDressesOption();
        String casualDressesOption = new RedirectionUrls(driver).getUrlCasualDresses();   //get URL of mew opened page
        String casualDressesPageUrl = new RedirectionUrls(driver).casualDressesPageUrl();

        assertEquals(casualDressesOption, casualDressesPageUrl, "URL is correct");//compare actual and expected result
        System.out.print("'Casual Dresses' page is opened from 'Women'");
    }

    /**
     * Check redirection and link of EveningDresses page via Dresses submenu of Women menu
     */
    @Test
    public void mainMenuWomenDressesEveningDresses() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new SearchHomePageElements(driver).hoverWomen();
        new SearchHomePageElements(driver).clickOnEveningDressesOption();
        String eveningDressesOption = new RedirectionUrls(driver).getUrlEveningDresses();   //get URL of mew opened page
        String eveningDressesPageUrl = new RedirectionUrls(driver).eveningDressesPageUrl();

        assertEquals(eveningDressesOption, eveningDressesPageUrl, "URL is correct");//compare actual and expected result
        System.out.print("'Evening Dresses' page is opened from 'Women'");
    }

    /**
     * Check redirection and link of SummerDresses page via Dresses submenu of Women menu
     */
    @Test
    public void mainMenuWomenDressesSummerDresses() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new SearchHomePageElements(driver).hoverWomen();
        new SearchHomePageElements(driver).clickOnSummerDressesOption();
        String summerDressesOption = new RedirectionUrls(driver).getUrlSummerDresses();   //get URL of mew opened page
        String summerDressesPageUrl = new RedirectionUrls(driver).summerDressesPageUrl();

        assertEquals(summerDressesOption, summerDressesPageUrl, "URL is correct");//compare actual and expected result
        System.out.print("'Summer Dresses' page is opened from 'Women'");
    }

    /**
     * Check redirection and link of CasualDresses page via Dresses menu
     */
    @Test
    public void mainMenuDressesCasualDresses() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new SearchHomePageElements(driver).hoverDresses();
        new SearchHomePageElements(driver).clickOnDressesCasualDressesOption();
        String dressesCasualDressesOption = new RedirectionUrls(driver).getUrlCasualDresses(); //get URL of mew opened page
        String dressesCasualDressesPageUrl = new RedirectionUrls(driver).casualDressesPageUrl();

        assertEquals(dressesCasualDressesOption, dressesCasualDressesPageUrl,
                "URL is correct");                                                     //compare actual and expected result
        System.out.print("'Casual Dresses' page is opened from 'Dresses'");
    }

    /**
     * Check redirection and link of EveningDresses page via Dresses menu
     */
    @Test
    public void mainMenuDressesEveningDresses() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new SearchHomePageElements(driver).hoverDresses();
        new SearchHomePageElements(driver).clickOnDressesEveningDressesOption();
        String dressesEveningDressesOption = new RedirectionUrls(driver).getUrlEveningDresses();//get URL of mew opened page
        String dressesEveningDressesPageUrl = new RedirectionUrls(driver).eveningDressesPageUrl();

        assertEquals(dressesEveningDressesOption, dressesEveningDressesPageUrl,
                "URL is correct");                                                      //compare actual and expected result
        System.out.print("'Evening Dresses' page is opened from 'Dresses'");
    }

    /**
     * Check redirection and link of SummerDresses page via Dresses menu
     */
    @Test
    public void mainMenuDressesSummerDresses() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new SearchHomePageElements(driver).hoverDresses();
        new SearchHomePageElements(driver).clickOnDressesSummerDressesOption();
        String dressesSummerDressesOption = new RedirectionUrls(driver).getUrlSummerDresses();//get URL of mew opened page
        String dressesSummerDressesPageUrl = new RedirectionUrls(driver).summerDressesPageUrl();

        assertEquals(dressesSummerDressesOption, dressesSummerDressesPageUrl,
                "URL is correct");                                                    //compare actual and expected result
        System.out.print("'Evening Dresses' page is opened from 'Dresses'");
    }

    /**
     * Check redirection and link of T-Shirts page via T-Shirts menu
     */
    @Test
    public void mainMenuTshirts() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new SearchHomePageElements(driver).clickOnTshirtsButton();
        String tShirtsTab = new RedirectionUrls(driver).getTshirtsPageUrl(); //get URL of new opened page
        String tShirtsTabUrl = new RedirectionUrls(driver).tShirtsPageUrl();

        assertEquals(tShirtsTab, tShirtsTabUrl, "URL is correct");  //compare actual and expected result
        System.out.print("'T-Shirts Tab' page is opened via '-Shirts'");
    }
}


