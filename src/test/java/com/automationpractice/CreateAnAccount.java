package com.automationpractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.SignInPage;

public class CreateAnAccount extends BaseTestAbstract{

    @Test // works
    public void createAnAccountTitle() throws InterruptedException {
        String stringUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        driver.get(stringUrl);

        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickSignInHeaderButton(); //works with and without

        String actualTitle = signInPage.actualTitleFind(driver);
        String expectedTitle = signInPage.EXPECTED_TITLE;

        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("You are on Login - My Store");
    }

    @Test //works
    public void emailInputWithOneNew() {
        String stringUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        driver.get(stringUrl);

        SignInPage signInPage = new SignInPage(driver);

        signInPage.emailAddressFieldCreateAnAccountFind(driver);
        signInPage.inputEmail();
        signInPage.createAnAccountButtonClick();
    }

    @Test // works
    public void emailInput() throws InterruptedException {
        String stringUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        driver.get(stringUrl);

        new SignInPage(driver).emailAddressFieldCreateAnAccountFind(driver);
        new SignInPage(driver).inputEmail();
        new SignInPage(driver).createAnAccountButtonClick();

    }

    @Test // works
    public void emailInputSameEmail() throws InterruptedException {
        String stringUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        driver.get(stringUrl);

        SignInPage signInPage = new SignInPage(driver);
        Thread.sleep(5000);
        String email = "qwe@gmail.com";

        signInPage.inputEmail(email);
        signInPage.createAnAccountButtonClick();
        Thread.sleep(5000);

//        driver.get(stringUrl);
//        SignInPage signInPageTwo = new SignInPage(driver);
//        signInPageTwo.inputEmail(email);
//        Thread.sleep(5000);
//        signInPage.createAnAccountButtonClick();
//        Thread.sleep(5000);

        // 2d part
        Thread.sleep(5000);
        String actual = signInPage.errorMessageIsExist(driver);
        String expected = signInPage.EXPECTED_ERROR_EXISTING_EMAIL;

        Assert.assertEquals(actual, expected);
        System.out.println("An account using this email address has already been registered. " +
                "Please enter a valid password or request a new one.");

    }

    @Test // I want to add put from ContextMap
    public void emailInputWithPut() {

        String stringUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        driver.get(stringUrl);

        new SignInPage(driver).emailAddressFieldCreateAnAccountFind(driver);
        new SignInPage(driver).inputEmail();
        //put....
        new SignInPage(driver).createAnAccountButtonClick();
    }

}
