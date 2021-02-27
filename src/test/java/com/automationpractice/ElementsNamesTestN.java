package com.automationpractice;

import org.testng.annotations.Test;
import pageObjects.AboutUsPage;
import pageObjects.SearchHomePageElements;

import static org.testng.Assert.assertEquals;

public class ElementsNamesTestN extends BaseTestAbstract {

    /**
    * Check link name of AboutUs page
    */
    @Test
    public void AboutUsLinkName() {

        String actualLinkName = new AboutUsPage(driver).getActualLinkName();
        String expectedLinkName = new AboutUsPage(driver).getExpectedLinkName();

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
}
