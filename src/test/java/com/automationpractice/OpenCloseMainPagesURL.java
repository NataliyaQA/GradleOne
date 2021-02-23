package com.automationpractice;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.RedirectionURLs;
import pageObjects.SearchHomePageElements;

import static org.testng.Assert.assertEquals;

//13 tests created

public class OpenCloseMainPagesURL {
    public static class openAndCloseWebPage extends AbstractClass {

        @Test(priority = 5) // rewrited
        public void HomePage() {

            String actualTitle = new SearchHomePageElements(driver).getActualTitle();
            String expectedTitle = new SearchHomePageElements(driver).getExpectedTitle();

            assertEquals(actualTitle, expectedTitle);
            System.out.println("Test result: 'My Store' title is found and correct"); // logback
            System.out.println("Priority 5");
        }

//        @Test(priority = 4, description = "this test about Women page") //#2
//        public void WomanPage() {
//
//            new RedirectionURLs(driver).womenPageURL(); //put URL into browser the URL bar
//            String title = new SearchHomePageElements(driver).getStringTitle(); //get title of page
//
//            assertEquals(title, "Women - My Store"); // compare an actual result and expected
//            System.out.println("Test result: 'Women - My Store' title is found and correct");
//        }
//
//        @Test(priority = 3)
//        public void WomanPageClick() {
//
//            driver.findElement(By.linkText("Women")).click();
//            String currentUrl = driver.getCurrentUrl();
//            assertEquals(currentUrl, "http://automationpractice.com/index.php?id_category=3&controller=category",
//                    "URL is correct");
//            System.out.println("Priority 3");
//        }
//
//        @Test(priority = 2)
//        public void DressesPageClick() {
//
//            driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
//            String currentUrl = driver.getCurrentUrl();
//            assertEquals(currentUrl, "http://automationpractice.com/index.php?id_category=8&controller=category",
//                    "URL is correct");
//            System.out.println("Priority 2");
//        }
//
//        @Test(priority = 1)
//        public void TshirtsPageClick() {
//
//            driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).click();
//            String currentUrl = driver.getCurrentUrl();
//            assertEquals(currentUrl, "http://automationpractice.com/index.php?id_category=5&controller=category",
//                    "URL is correct");
//            System.out.println("Priority 1");
//        }
//
//        @Test
//        public void ThreeDaysSaleBannerClick() {
//
//            driver.findElement(By.xpath("//*[@id=\"htmlcontent_top\"]/ul/li[1]/a/img")).click();
//            String currentUrl = driver.getCurrentUrl();
//            assertEquals(currentUrl, "https://www.prestashop.com/en", "URL is correct");
//            System.out.println("Three DaysSale Banner redirection");
//        }
//
//        @Test
//        public void SummerCollectionBannerClick() {
//
//            driver.findElement(By.xpath("//*[@id=\"htmlcontent_top\"]/ul/li[2]/a/img")).click();
//            String currentUrl = driver.getCurrentUrl();
//            assertEquals(currentUrl, "https://www.prestashop.com/en", "URL is correct");
//            System.out.println("Summer Collection Banner redirection");
//        }
//
//        @Test
//        public void TopTrendsBannerClick() {
//
//            driver.findElement(By.xpath("//*[@id=\"htmlcontent_home\"]/ul/li[1]/a/img")).click();
//            String currentUrl = driver.getCurrentUrl();
//            assertEquals(currentUrl, "https://www.prestashop.com/en", "URL is correct");
//            System.out.println("Top Trends Banner redirection");
//        }
//
//        @Test
//        public void SunGlassesAndEyeWearBannerClick() {
//
//            driver.findElement(By.xpath("//*[@id=\"htmlcontent_home\"]/ul/li[4]/a/img")).click();
//            String currentUrl = driver.getCurrentUrl();
//            assertEquals(currentUrl, "https://www.prestashop.com/en", "URL is correct");
//            System.out.println("Sun Glasses & Eyewear Banner redirection");
//        }
//
//        @Test
//        public void MenCoatAndJacketsBannerClick() {
//
//            driver.findElement(By.xpath("//*[@id=\"htmlcontent_home\"]/ul/li[2]/a/img")).click();
//            String currentUrl = driver.getCurrentUrl();
//            assertEquals(currentUrl, "https://www.prestashop.com/en", "URL is correct");
//            System.out.println("Men's Coat & Jackets Banner redirection");
//        }
//
//        @Test
//        public void SavvyTrendsHandBagsBannerClick() {
//
//            driver.findElement(By.xpath("//*[@id=\"htmlcontent_home\"]/ul/li[5]/a/img")).click();
//            String currentUrl = driver.getCurrentUrl();
//            assertEquals(currentUrl, "https://www.prestashop.com/en", "URL is correct");
//            System.out.println("Savvy Trends Handbags Banner redirection");
//        }
//
//        @Test
//        public void WomenCoatAndJacketsBannerClick() {
//
//            driver.findElement(By.xpath("//*[@id=\"htmlcontent_home\"]/ul/li[3]/a/img")).click();
//            String currentUrl = driver.getCurrentUrl();
//            assertEquals(currentUrl, "https://www.prestashop.com/en", "URL is correct");
//            System.out.println("Women's Coat & Jackets Banner redirection");
//        }
//
//        @Test //, enabled = false
//        public void LogoClick() {
//
//            driver.findElement(By.xpath("//*[@id=\"header_logo\"]/a/img")).click();
//            String currentUrl = driver.getCurrentUrl();
//            Assert.assertTrue(currentUrl.contains("http://automationpractice.com"));
//            System.out.println("'Home' page redirection");
//        }

    }
}

