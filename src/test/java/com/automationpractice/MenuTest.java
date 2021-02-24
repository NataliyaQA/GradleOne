package com.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pageObjects.RedirectionURLs;
import pageObjects.SearchHomePageElements;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

//9 tests created

public class MenuTest extends AbstractClass{
    @Test // re-written
    public void mainMenuWomenTopsTshirts() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new SearchHomePageElements(driver).hoverWomen(); //hover Women tab name
        new SearchHomePageElements(driver).clickOnWomenMenuTshirsOption(); //click on Women tab name

        String womenMenuTshirsOption = new RedirectionURLs(driver).getUrlTshirs(); //get URL of mew opened page
        String tShirsPageURL = new RedirectionURLs(driver).tShirsPageURL();

        assertEquals(womenMenuTshirsOption, tShirsPageURL, "URL is correct"); // compare actual and expected result
        System.out.print("'T-Short' page is opened from 'Women'");
    }

    @Test
    public void mainMenuWomenTopsBlouses() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new SearchHomePageElements(driver).hoverWomen();
        new SearchHomePageElements(driver).clickOnWomenMenuBlousesOption();
        String womenMenuBlousesOption = new RedirectionURLs(driver).getUrlBlouses(); //get URL of mew opened page
        String blousesPageURL = new RedirectionURLs(driver).blousesPageURL();

        assertEquals(womenMenuBlousesOption, blousesPageURL, "URL is correct"); // compare actual and expected result
        System.out.print("'Blouses' page is opened from 'Women'");
    }

    @Test
    public void mainMenuWomenDressesCasualDresses() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new SearchHomePageElements(driver).hoverWomen();
        new SearchHomePageElements(driver).clickOnCasualDressesOption();
        String casualDressesOption = new RedirectionURLs(driver).getUrlCasualDresses(); //get URL of mew opened page
        String casualDressesPageURL = new RedirectionURLs(driver).casualDressesPageURL();

        assertEquals(casualDressesOption, casualDressesPageURL, "URL is correct"); // compare actual and expected result
        System.out.print("'Casual Dresses' page is opened from 'Women'");
    }

    @Test
    public void mainMenuWomenDressesEveningDresses() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new SearchHomePageElements(driver).hoverWomen();
        new SearchHomePageElements(driver).clickOnEveningDressesOption();
        String eveningDressesOption = new RedirectionURLs(driver).getUrlEveningDresses(); //get URL of mew opened page
        String eveningDressesPageURL = new RedirectionURLs(driver).eveningDressesPageURL();

        assertEquals(eveningDressesOption, eveningDressesPageURL, "URL is correct"); // compare actual and expected result
        System.out.print("'Evening Dresses' page is opened from 'Women'");
    }

    @Test
    public void mainMenuWomenDressesSummerDresses() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new SearchHomePageElements(driver).hoverWomen();
        new SearchHomePageElements(driver).clickOnSummerDressesOption();
        String summerDressesOption = new RedirectionURLs(driver).getUrlSummerDresses(); //get URL of mew opened page
        String summerDressesPageURL = new RedirectionURLs(driver).summerDressesPageURL();

        assertEquals(summerDressesOption, summerDressesPageURL, "URL is correct"); // compare actual and expected result
        System.out.print("'Summer Dresses' page is opened from 'Women'");
    }

    @Test
    public void mainMenuDressesCasualDresses() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new SearchHomePageElements(driver).hoverDresses();
        new SearchHomePageElements(driver).clickOnDressesCasualDressesOption();
        String dressesCasualDressesOption = new RedirectionURLs(driver).getUrlCasualDresses(); //get URL of mew opened page
        String dressesCasualDressesPageURL = new RedirectionURLs(driver).casualDressesPageURL();

        assertEquals(dressesCasualDressesOption, dressesCasualDressesPageURL, "URL is correct"); // compare actual and expected result
        System.out.print("'Casual Dresses' page is opened from 'Dresses'");
    }

    @Test
    public void mainMenuDressesEveningDresses() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new SearchHomePageElements(driver).hoverDresses();
        new SearchHomePageElements(driver).clickOnDressesEveningDressesOption();
        String dressesEveningDressesOption = new RedirectionURLs(driver).getUrlEveningDresses(); //get URL of mew opened page
        String dressesEveningDressesPageURL = new RedirectionURLs(driver).eveningDressesPageURL();

        assertEquals(dressesEveningDressesOption, dressesEveningDressesPageURL, "URL is correct"); // compare actual and expected result
        System.out.print("'Evening Dresses' page is opened from 'Dresses'");
    }

    @Test
    public void mainMenuDressesSummerDresses() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new SearchHomePageElements(driver).hoverDresses();
        new SearchHomePageElements(driver).clickOnDressesSummerDressesOption();
        String dressesSummerDressesOption = new RedirectionURLs(driver).getUrlSummerDresses(); //get URL of mew opened page
        String dressesSummerDressesPageURL = new RedirectionURLs(driver).summerDressesPageURL();

        assertEquals(dressesSummerDressesOption, dressesSummerDressesPageURL, "URL is correct"); // compare actual and expected result
        System.out.print("'Evening Dresses' page is opened from 'Dresses'");
    }

    @Test
    public void mainMenuTshirts() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new SearchHomePageElements(driver).clickOnTshirtsButton();
        String tShirtsTab = new RedirectionURLs(driver).getTshirtsTabURL(); //get URL of mew opened page
        String tShirtsTabURL = new RedirectionURLs(driver).tShirtsTabURL();

        assertEquals(tShirtsTab, tShirtsTabURL, "URL is correct"); // compare actual and expected result
        System.out.print("'T-Shirts Tab' page is opened via '-Shirts'");
    }
}


