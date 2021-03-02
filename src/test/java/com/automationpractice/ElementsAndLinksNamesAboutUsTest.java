package com.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;
import pageObjects.AboutUsPage;
import pageObjects.SearchHomePageElements;

import static org.testng.Assert.assertEquals;

public class ElementsAndLinksNamesAboutUsTest extends BaseTestAbstract {
    AboutUsPage aboutUsPage;

    /**
     * Check link name of AboutUs page
     */
    @Test
    public void AboutUsLinkName() {

        aboutUsPage = new AboutUsPage(driver);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String actualLinkName = aboutUsPage.getActualLinkName();
        String expectedLinkName = aboutUsPage.expectedLinkName();

        assertEquals(actualLinkName, expectedLinkName);
        System.out.println("Test result: 'About Us' name of link is found and correct");
    }

    /**
     * Check name of Women menu option on the AboutUs page
     */
    @Test
    public void mainMenuWomenNameAboutUsPage() {

        aboutUsPage = new AboutUsPage(driver);

        aboutUsPage.clickAboutUsLink();

        String actualName = new SearchHomePageElements(driver).getActualWomenMenuName();
        String expectedName = new SearchHomePageElements(driver).expectedWomenName();

        assertEquals(actualName.toLowerCase(), expectedName.toLowerCase(), "Name of menu option is '" + actualName + "'");
    }

    /**
     * Check name of Dresses menu option on the AboutUs page
     */
    @Test
    public void mainMenuDressesNameAboutUsPage() {

        aboutUsPage = new AboutUsPage(driver);

        aboutUsPage.clickAboutUsLink();

        String actualName = new SearchHomePageElements(driver).getActualDressesMenuName();
        String expectedName = new SearchHomePageElements(driver).expectedDressesName();

        assertEquals(actualName.toLowerCase(), expectedName.toLowerCase(), "Name of menu option is '" + actualName + "'");
    }

    /**
     * Check name of T-Shirts menu option on the AboutUs page
     */
    @Test
    public void mainMenuTshirtsNameAboutUsPage() {

        aboutUsPage = new AboutUsPage(driver);

        aboutUsPage.clickAboutUsLink();

        String actualName = new SearchHomePageElements(driver).getActualTshirtsMenuName();
        String expectedName = new SearchHomePageElements(driver).expectedTshirtsName();

        assertEquals(actualName.toLowerCase(), expectedName.toLowerCase(), "Name of menu option is '" + actualName + "'");
    }

    @Test
    public void mainMenuWomenListOfOptionsAboutUsPage() {
        new SearchHomePageElements(driver).putAboutUsUrl();
        aboutUsPage = new AboutUsPage(driver);

        //aboutUsPage.putAboutUsUrl();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new SearchHomePageElements(driver).hoverWomen();
        new SearchHomePageElements(driver).hoverTopsSubMenu();
        new SearchHomePageElements(driver).hoverTshirtsSubMenu();
        new SearchHomePageElements(driver).hoverBlousesSubMenu();
        new SearchHomePageElements(driver).hoverDressesSubMenu();
        new SearchHomePageElements(driver).hoverWomenCasualDressesOption();
        new SearchHomePageElements(driver).hoverWomenEveningDressesOption();
        new SearchHomePageElements(driver).hoverWomenSummerDressesOption();
    }

    @Test
    public void mainMenuWomenNamesOfOptionsAboutUsPage() {

        aboutUsPage = new AboutUsPage(driver);

        aboutUsPage.putAboutUsUrl();

        new SearchHomePageElements(driver).hoverWomen();

        new SearchHomePageElements(driver).hoverTopsSubMenu();
        String actualNameOne = new SearchHomePageElements(driver).getActualWomenMenuTopsSubMenuName();
        String expectedNameOne = new SearchHomePageElements(driver).expectedWomenMenuTopsSubMenuName();
        assertEquals(actualNameOne, expectedNameOne);

        new SearchHomePageElements(driver).hoverTshirtsSubMenu();
        String actualNameThree = new SearchHomePageElements(driver).getActualWomenMenuTshirsOptionName();
        String expectedNameThree = new SearchHomePageElements(driver).expectedWomenMenuTshirsOptionName();
        assertEquals(actualNameThree, expectedNameThree);

        new SearchHomePageElements(driver).hoverBlousesSubMenu();
        String actualNameFour = new SearchHomePageElements(driver).getActualWomenMenuBlousesOptionName();
        String expectedNameFour = new SearchHomePageElements(driver).expectedWomenMenuBlousesOptionName();
        assertEquals(actualNameFour, expectedNameFour);

        new SearchHomePageElements(driver).hoverDressesSubMenu();
        String actualNameFive = new SearchHomePageElements(driver).getActualWomenMenuDressesSubMenuName();
        String expectedNameFive = new SearchHomePageElements(driver).expectedWomenMenuDressesSubMenuName();
        assertEquals(actualNameFive, expectedNameFive);

        new SearchHomePageElements(driver).hoverWomenCasualDressesOption();
        String actualNameSix = new SearchHomePageElements(driver).getActualCasualDressesOptionName();
        String expectedNameSix = new SearchHomePageElements(driver).expectedCasualDressesOptionName();
        assertEquals(actualNameSix, expectedNameSix);

        new SearchHomePageElements(driver).hoverWomenEveningDressesOption();
        String actualNameSeven = new SearchHomePageElements(driver).getActualEveningDressesOptionName();
        String expectedNameSeven = new SearchHomePageElements(driver).expectedEveningDressesOptionName();
        assertEquals(actualNameSeven, expectedNameSeven);

        new SearchHomePageElements(driver).hoverWomenSummerDressesOption();
        String actualNameEight = new SearchHomePageElements(driver).getActualSummerDressesOptionName();
        String expectedNameEight = new SearchHomePageElements(driver).expectedSummerDressesOptionName();
        assertEquals(actualNameEight, expectedNameEight);
    }

    @Test //does not work and causes falling of all tests
    public void returnToHomeButton() {
        new SearchHomePageElements(driver).putAboutUsUrl();
        aboutUsPage = new AboutUsPage(driver);

        //aboutUsPage.putAboutUsUrl();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String actualToHome = aboutUsPage.getActualReturnToHomeButtonName();
        String expectedToHome = aboutUsPage.expectedReturnToHomeButtonName();
        assertEquals(actualToHome, expectedToHome);

//        start HomePage driver
//        click About us age
//        Init about us page controls
//        compare expect and actual

    }
}

