package com.automationpractice;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.MyAccountPage;
import pageObjects.SignInPage;


// 22 tests
public class MyAccountPageTest extends BaseTestAbstractClass {
    String stringUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    MyAccountPage myAccountPage;
    SignInPage signInPage;

    @BeforeMethod // Question: difference with BeforeTest
    void setUpMethod() throws InterruptedException {
        driver.get(stringUrl);
        myAccountPage = new MyAccountPage(driver);

        Thread.sleep(5000);
        myAccountPage.emailSendKey();
        myAccountPage.passwordSendKey();
        myAccountPage.signInButtonClick();

        //for new registration, takes more time
//        signInPage = new SignInPage(driver);
//        signInPage.inputEmail().createAnAccountButtonClick();
//        Thread.sleep(5000);
//        signInPage.inputValueFirstNameLetters();
//        signInPage.inputValueLastNameLetters();
//        signInPage.inputValueAllowedCompany();
//        signInPage.inputValuePassword("123456");
//        signInPage.inputValueAllowedAddress();
//        signInPage.inputValueAllowedCity();
//        Thread.sleep(5000);
//        signInPage.statesDropDownOptionByValue();
//        Thread.sleep(5000);
//        signInPage.inputValueAllowedZip();
//        signInPage.inputValueAllowedPhone();
//        signInPage.inputValueAllowedMobile();
//        signInPage.clickRegisterButton();
//        Thread.sleep(5000);
    }

    @AfterMethod
    void signOut() {
        myAccountPage.signOutButtonClick();
    }

    @Test //passed
    public void myAccountTitleDisplayed() {
        Assert.assertTrue(myAccountPage.myAccountTitleDisplayed());
    }

    @Test// passed
    public void welcomeTextDisplayed() {
        Assert.assertTrue(myAccountPage.welcomeTextDisplayed());
    }

    @Test //passed
    public void orderHistoryDisplayed() {
        Assert.assertTrue(myAccountPage.orderHistoryDisplayed());
    }

    @Test //passed
    public void creditSlipsDisplayed() {
        Assert.assertTrue(myAccountPage.creditSlipsDisplayed());
    }

    @Test //passed
    public void myAddressDisplayed() {
        Assert.assertTrue(myAccountPage.myAddressDisplayed());
    }

    @Test //passed
    public void personalInfoDisplayed() {
        Assert.assertTrue(myAccountPage.personalInfoDisplayed());
    }

    @Test //passed
    public void wishListDisplayed() {
        Assert.assertTrue(myAccountPage.wishListDisplayed());
    }

    @Test //passed
    public void homeButtonDisplayed() {
        Assert.assertTrue(myAccountPage.homeButtonDisplayed());
    }

    @Test //passed
    public void myAccountTitle() {
        Assert.assertEquals(myAccountPage.myAccountTitleName(), myAccountPage.MY_ACCOUNT_TITLE);
    }

    @Test //passed
    public void welcomeText() {
        Assert.assertEquals(myAccountPage.welcomeTextName(), myAccountPage.WELCOME_TEXT);
    }

    @Test //passed
    public void homeButtonName() {
        Assert.assertEquals(myAccountPage.homeButtonName(), myAccountPage.HOME_BUTTON);
    }

    @Test //passed
    public void orderHistoryName() {
        Assert.assertEquals(myAccountPage.orderHistoryName().toLowerCase(), myAccountPage.ORDER_HISTORY);
    }

    @Test //passed
    public void creditSlipsName() {
        Assert.assertEquals(myAccountPage.creditSlipsName(), myAccountPage.CREDIT_SLIPS);
    }

    @Test //passed
    public void myAddressName() {
        Assert.assertEquals(myAccountPage.myAddressName(), myAccountPage.MY_ADDRESS);
    }

    @Test //passed
    public void personalInfoName() {
        Assert.assertEquals(myAccountPage.personalInfoName(), myAccountPage.PERSONAL_INFO);
    }

    @Test //passed
    public void wishListName() {
        Assert.assertEquals(myAccountPage.wishListName(), myAccountPage.WISH_LIST);
    }

    @Test //passed
    public void homePageUrl() {
        myAccountPage.homeButtonClick();
        Assert.assertEquals(myAccountPage.getUrl(), myAccountPage.HOME_PAGE_URL);
    }

    @Test //passed
    public void orderHistoryUrl() {
        myAccountPage.orderHistoryClick();
        Assert.assertEquals(myAccountPage.getUrl(), myAccountPage.ORDER_HISTORY_URL);
    }

    @Test //passed
    public void creditSlipsUrl() {
        myAccountPage.creditSlipsClick();
        Assert.assertEquals(myAccountPage.getUrl(), myAccountPage.CREDIT_SLIPS_URL);
    }

    @Test //passed
    public void myAddressUrl() {
        myAccountPage.myAddressClick();
        Assert.assertEquals(myAccountPage.getUrl(), myAccountPage.MY_ADDRESS_URL);
    }

    @Test //passed
    public void personalInfoUrl() {
        myAccountPage.personalInfoClick();
        Assert.assertEquals(myAccountPage.getUrl(), myAccountPage.PERSONAL_INFO_URL);
    }

    @Test //passed
    public void wishListUrl() {
        myAccountPage.wishListClick();
        Assert.assertEquals(myAccountPage.getUrl(), myAccountPage.WISH_LIST_URL);
    }
}
