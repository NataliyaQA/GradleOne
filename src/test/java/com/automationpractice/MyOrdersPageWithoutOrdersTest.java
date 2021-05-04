package com.automationpractice;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.MyAccountPage;
import pageObjects.MyOrdersPage;
import pageObjects.SignInPage;

// 15 tests
public class MyOrdersPageWithoutOrdersTest extends BaseTestAbstractClass {
    String pageMyOrdersUrl = "http://automationpractice.com/index.php?controller=history";
    MyOrdersPage myOrdersPage;
    MyAccountPage myAccountPage;

    @BeforeMethod
    void setUpMethod() throws InterruptedException {
        driver.get(pageMyOrdersUrl);
        myAccountPage = new MyAccountPage(driver);
        myOrdersPage = new MyOrdersPage(driver);

//        Thread.sleep(5000);
//        myAccountPage.emailSendKey();
//        myAccountPage.passwordSendKey();
//        myAccountPage.signInButtonClick();
//        myAccountPage.orderHistoryClick();
//        Thread.sleep(5000);

        SignInPage signInPage = new SignInPage(driver);
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        signInPage.inputValueFirstNameLetters();
        signInPage.inputValueLastNameLetters();
        signInPage.inputValueAllowedCompany();
        signInPage.inputValuePassword("123456");
        signInPage.inputValueAllowedAddress();
        signInPage.inputValueAllowedCity();
        Thread.sleep(5000);
        signInPage.statesDropDownOptionByValue();
        Thread.sleep(5000);
        signInPage.inputValueAllowedZip();
        signInPage.inputValueAllowedPhone();
        signInPage.inputValueAllowedMobile();
        signInPage.clickRegisterButton();
        Thread.sleep(5000);

        myAccountPage.orderHistoryClick();
    }

    @AfterMethod
    void signOut() {
        myAccountPage.signOutButtonClick();
    }

    @Test
    public void orderHistoryNavigationOne() {
        Assert.assertEquals(myOrdersPage.orderHistoryNavigationOne(), myOrdersPage.ORDER_HISTORY_NAVIGATION_PAGE_ONE);
    }

    @Test
    public void orderHistoryNavigationTwo() throws InterruptedException {
        //Thread.sleep(5000);
        Assert.assertEquals(myOrdersPage.orderHistoryNavigationTwo(), myOrdersPage.ORDER_HISTORY_NAVIGATION_PAGE_TWO);
    }

    @Test
    public void orderHistoryTitle() {
        Assert.assertEquals(myOrdersPage.orderHistoryTitle(), myOrdersPage.ORDER_HISTORY);
    }

    @Test
    public void orderHistoryText() {
        Assert.assertEquals(myOrdersPage.orderHistoryText(), myOrdersPage.ORDER_HISTORY_TEXT);
    }

    @Test
    public void orderHistoryNoOrdersText() {
        Assert.assertEquals(myOrdersPage.orderHistoryNoOrders(), myOrdersPage.ORDER_HISTORY_NO_ORDERS);
    }

    @Test // re-write xPath in method
    public void orderHistoryBackToAccountButtonName() {
        Assert.assertEquals(myOrdersPage.orderHistoryBackToAccountButton(), myOrdersPage.ORDER_HISTORY_BACK_TO_ACCOUNT);
    }

    @Test
    public void orderHistoryHomeButtonName() {
        Assert.assertEquals(myOrdersPage.orderHistoryHomeButton(), myOrdersPage.ORDER_HISTORY_HOME_BUTTON);
    }

    @Test
    public void iconHomeIsDisplayed() {
        Assert.assertTrue(myOrdersPage.iconHomeIsDisplayed());
    }

    @Test
    public void navigationOneIsDisplayed() {
        Assert.assertTrue(myOrdersPage.navigationOneIsDisplayed());
    }

    @Test
    public void navigationTwoIsDisplayed() {
        Assert.assertTrue(myOrdersPage.navigationTwoIsDisplayed());
    }

    @Test
    public void homeNavigationBreadcrumb() {
        myOrdersPage.clickHomeIcon();
        Assert.assertEquals(myOrdersPage.getUrl(), myOrdersPage.HOME_PAGE_URL);
    }

    @Test
    public void homeNavigationButton() {
        myOrdersPage.clickHomeButton();
        Assert.assertEquals(myOrdersPage.getUrl(), myOrdersPage.HOME_PAGE_URL);
    }

    @Test
    public void myAccountNavigationBreadcrumb() {
       myOrdersPage.clickNavigationOne();
       Assert.assertEquals(myOrdersPage.getUrl(), myOrdersPage.ACCOUNT_URL);
    }

    @Test
    public void myAccountNavigationButton() {
       myOrdersPage.clickBackToAccount();
       Assert.assertEquals(myOrdersPage.getUrl(), myOrdersPage.ACCOUNT_URL);
    }


}
