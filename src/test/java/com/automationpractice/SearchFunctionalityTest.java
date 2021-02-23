package com.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.SearchHomePageElements;
import pageObjects.SearchResultProductList;
import java.util.concurrent.TimeUnit;

//1 test created

public class SearchFunctionalityTest {
    public static class searchProducts {

        private String searchQuery = "Faded Short Sleeve T-shirts";

        public WebDriver getDriver() {
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("http://automationpractice.com/");
            return driver;
        }

        @Test
        public void searchProduct() {
            WebDriver driver = getDriver();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            new SearchHomePageElements(driver).inputText(searchQuery).clickOnSearchButton();

            String firstProductName = new SearchResultProductList(driver).getFirstProductName();

            Assert.assertTrue(firstProductName.toLowerCase().contains(searchQuery.toLowerCase()),
                    "Search Key is present in First Search Result");
            System.out.println("You did it. Well done");
        }
    }
}
