package com.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;
import pageObjects.AboutUsPage;
import pageObjects.SearchHomePageElements;

import static org.testng.Assert.assertEquals;

public class ElementsAndLinksNamesAboutUsTest extends BaseTestAbstract {

    /**
     * Check link name of AboutUs page
     */
    @Test
    public void AboutUsLinkName() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String actualLinkName = new AboutUsPage(driver).getActualLinkName();
        String expectedLinkName = new AboutUsPage(driver).expectedLinkName();

        assertEquals(actualLinkName, expectedLinkName);
        System.out.println("Test result: 'About Us' name of link is found and correct");
    }

    /**
     * Check name of Women menu option on the AboutUs page
     */
    @Test
    public void mainMenuWomenNameAboutUsPage() {

        new AboutUsPage(driver).clickAboutUsLink();

        String actualName = new SearchHomePageElements(driver).getActualWomenMenuName();
        String expectedName = new SearchHomePageElements(driver).expectedWomenName();

        assertEquals(actualName.toLowerCase(), expectedName.toLowerCase(), "Name of menu option is '" + actualName + "'");
    }

    /**
     * Check name of Dresses menu option on the AboutUs page
     */
    @Test
    public void mainMenuDressesNameAboutUsPage() {

        new AboutUsPage(driver).clickAboutUsLink();

        String actualName = new SearchHomePageElements(driver).getActualDressesMenuName();
        String expectedName = new SearchHomePageElements(driver).expectedDressesName();

        assertEquals(actualName.toLowerCase(), expectedName.toLowerCase(), "Name of menu option is '" + actualName + "'");
    }

    /**
     * Check name of T-Shirts menu option on the AboutUs page
     */
    @Test
    public void mainMenuTshirtsNameAboutUsPage() {

        new AboutUsPage(driver).clickAboutUsLink();

        String actualName = new SearchHomePageElements(driver).getActualTshirtsMenuName();
        String expectedName = new SearchHomePageElements(driver).expectedTshirtsName();

        assertEquals(actualName.toLowerCase(), expectedName.toLowerCase(), "Name of menu option is '" + actualName + "'");
    }

    @Test
    public void mainMenuWomenListOfOptionsAboutUsPage() {

        new AboutUsPage(driver).putAboutUsUrl();
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

        new AboutUsPage(driver).putAboutUsUrl();

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

//    @Test //does not work and causes falling of all tests
//    public void returnToHomeButton() {
//        //new AboutUsPage(driver).clickAboutUsLink();
//        new AboutUsPage(driver).putAboutUsUrl();
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        String actualToHome = new AboutUsPage(driver).getActualReturnToHomeButtonName();
//        String expectedToHome = new AboutUsPage(driver).expectedReturnToHomeButtonName();
//        assertEquals(actualToHome, expectedToHome);
//    }
}

