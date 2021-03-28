package com.automationpractice;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.SignInPage;

import java.util.List;

//36 tests, 31 new
public class CreateAnAccount extends BaseTestAbstract {
    String stringUrlMainPage = "http://automationpractice.com/index.php";
    String stringUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    SignInPage signInPage = new SignInPage(driver);

    @Test
    public void checkClickSignInMainPage() {
        driver.get(stringUrlMainPage);

        signInPage.clickSignInHeaderButton();
        String actualUrl = signInPage.actualUrlFind(driver);
        String expectedUrl = signInPage.EXPECTED_URL;

        Assert.assertEquals(actualUrl, expectedUrl);
        System.out.println("Expected Url is correct");
    }

    @Test
    public void checkClickSignInAccountPage() {
        driver.get(stringUrl);

        signInPage.clickSignInHeaderButton();
        String actualUrl = signInPage.actualUrlFind(driver);
        String expectedUrl = signInPage.EXPECTED_URL;

        Assert.assertEquals(actualUrl, expectedUrl);
        System.out.println("Expected Url is correct");
    }

    @Test
    public void signInButtonNameMainPage() {
        driver.get(stringUrlMainPage);

        String actual = signInPage.signInHeaderButtonNameFind();
        String expected = signInPage.EXPECTED_SIGN_IN_HEADER_BUTTON_NAME;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void signInButtonNameAccountPage() {
        driver.get(stringUrl);

        String actual = signInPage.signInHeaderButtonNameFind();
        String expected = signInPage.EXPECTED_SIGN_IN_HEADER_BUTTON_NAME;

        Assert.assertEquals(actual, expected);
    }

    @Test // works
    public void signInPageTitle() throws InterruptedException {
        String stringUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        driver.get(stringUrl);

        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickSignInHeaderButton(); //works with and without

        String actualTitle = signInPage.actualTitleFind(driver);
        String expectedTitle = signInPage.EXPECTED_TITLE;

        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("You are on Login - My Store");
    }

    @Test
    public void authenticationSectionName() {
        driver.get(stringUrl);

        String actual = signInPage.authenticationSectionTitleFind(driver);
        String expected = signInPage.EXPECTED_AUTHENTICATION_SECTION_TITLE;

        Assert.assertEquals(actual, expected.toUpperCase());
    }

    @Test
    public void createAnAccountSectionName() {
        driver.get(stringUrl);

        String actual = signInPage.createAnAccountTitleFind(driver);
        String expected = signInPage.EXPECTED_CREATE_AN_ACCOUNT_TITLE_NAME;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void createAnAccountSectionText() {
        driver.get(stringUrl);

        String actual = signInPage.createAnAccountTextFind(driver);
        String expected = signInPage.EXPECTED_CREATE_AN_ACCOUNT_TEXT;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void emailFieldCreateAnAccountName() {
        driver.get(stringUrl);

        String actualName = signInPage.emailAddressFieldCreateAnAccountTitle(driver);
        String expectedName = signInPage.EXPECTED_EMAIL_ADDRESS_FIELD_CREATE_AN_ACCOUNT_NAME;

        Assert.assertEquals(actualName, expectedName);
        System.out.print("The title of email Address Field is " + '"'
                + signInPage.EXPECTED_EMAIL_ADDRESS_FIELD_CREATE_AN_ACCOUNT_NAME + '"');
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

        signInPage.inputEmailCreateAnAccount(email);
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

    @Test // Url put and creation of instance of "SignInPage" class moved to current class
    public void invalidEmailMessage() throws InterruptedException {

        driver.get(stringUrl);

        signInPage.inputEmailInvalidCreateAnAccount();
        signInPage.createAnAccountButtonClick();

        String actualText = signInPage.invalidEmail(driver);
        String expectedText = signInPage.INVALID_EMAIL;

        Thread.sleep(5000);

        Assert.assertEquals(actualText, expectedText);
        System.out.println("The text of message is " + '"' + signInPage.INVALID_EMAIL + '"');
    }

    @Test
    public void invalidEmailMessageWhenEmailEmpty() throws InterruptedException {

        driver.get(stringUrl);

        signInPage.createAnAccountButtonClick();

        String actualText = signInPage.invalidEmail(driver);
        String expectedText = signInPage.INVALID_EMAIL;

        Thread.sleep(5000);

        Assert.assertEquals(actualText, expectedText);
        System.out.println("The text of message is " + '"' + signInPage.INVALID_EMAIL + '"');
    }

    @Test
    // I want to add put from ContextMap. Main idea is: input a new generated email and then check it in the list of all emails
    public void emailInputWithPut() {

        String stringUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        driver.get(stringUrl);

        new SignInPage(driver).emailAddressFieldCreateAnAccountFind(driver);
        new SignInPage(driver).inputEmail();
        //put....
        new SignInPage(driver).createAnAccountButtonClick();
    }

    @Test
    public void createAnAccountButtonName() {
        driver.get(stringUrl);

        String actual = signInPage.createAnAccountButtonFind(driver);
        String expected = signInPage.EXPECTED_CREATE_AN_ACCOUNT_BUTTON_NAME;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void alreadyRegisteredSectionName() {
        driver.get(stringUrl);

        String actual = signInPage.alreadyRegisteredTitleFind(driver);
        String expected = signInPage.EXPECTED_ALREADY_REGISTERED_TITLE;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void emailFieldAlreadyRegisteredName() {
        driver.get(stringUrl);

        String actual = signInPage.emailAddressFieldAlreadyRegisteredTitle(driver);
        String expected = signInPage.EXPECTED_EMAIL_ADDRESS_FIELD_ALREADY_REGISTERED_NAME;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void passwordFieldAlreadyRegisteredName() {
        driver.get(stringUrl);

        String actual = signInPage.passwordFieldAlreadyRegisteredName(driver);
        String expected = signInPage.EXPECTED_PASSWORD_FIELD_ALREADY_REGISTERED_NAME;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void signInButtonAlreadyRegisteredName() {
        driver.get(stringUrl);

        String actual = signInPage.signInAlreadyRegisteredButtonFind(driver);
        String expected = signInPage.EXPECTED_SIGN_IN_ALREADY_REGISTERED_BUTTON_NAME;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void signInButtonClick() throws InterruptedException {
        driver.get(stringUrl);

        signInPage.clickSignInHeaderButton();
        Thread.sleep(5000);
    }

    @Test
    public void forgotYourPasswordButtonName() {
        driver.get(stringUrl);

        String actual = signInPage.forgotYourPasswordFind(driver);
        String expected = signInPage.EXPECTED_FORGOT_YOUR_PASSWORD_NAME;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void invalidEmailMessageAlreadyRegistered() throws InterruptedException {
        driver.get(stringUrl);

        signInPage.inputEmailInvalidAlreadyRegistered();
        signInPage.signInAlreadyRegisteredButtonClick();
        Thread.sleep(5000);

        String actualTextFirst = signInPage.invalidMessageAlreadyRegisteredFirstText(driver);
        String expectedTextFirst = signInPage.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST;
        Assert.assertEquals(actualTextFirst, expectedTextFirst);
        System.out.println("The text of message is " + '"'
                + signInPage.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST + '"');

        Thread.sleep(5000);

        String actualTextSecond = signInPage.invalidMessageAlreadyRegisteredSecondText(driver);
        String expectedTextSecond = signInPage.INVALID_EMAIL_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_IS;
        Assert.assertEquals(actualTextSecond, expectedTextSecond);
        System.out.println("The text of message is " + '"'
                + signInPage.INVALID_EMAIL_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_IS + '"');
    }

    @Test
    public void invalidEmptyEmailMessageAlreadyRegistered() throws InterruptedException {
        driver.get(stringUrl);

        signInPage.signInAlreadyRegisteredButtonClick();
        Thread.sleep(5000);

        String actualTextFirst = signInPage.invalidMessageAlreadyRegisteredFirstText(driver);
        String expectedTextFirst = signInPage.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST;
        Assert.assertEquals(actualTextFirst, expectedTextFirst);
        System.out.println("The text of message is " + '"'
                + signInPage.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST + '"');

        Thread.sleep(5000);

        String actualTextSecond = signInPage.invalidMessageAlreadyRegisteredSecondText(driver);
        String expectedTextSecond = signInPage.INVALID_EMAIL_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_EMPTY;
        Assert.assertEquals(actualTextSecond, expectedTextSecond);
        System.out.println("The text of message is " + '"'
                + signInPage.INVALID_EMAIL_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_EMPTY + '"');
    }

    @Test
    public void invalidPasswordMessageAlreadyRegistered() throws InterruptedException {
        driver.get(stringUrl);

        String email = "qwe@gmail.com";
        signInPage.inputEmailAlreadyRegistered(email);
        Thread.sleep(5000);

        signInPage.inputPasswordInvalidAlreadyRegistered();
        signInPage.signInAlreadyRegisteredButtonClick();
        Thread.sleep(5000);

        String actualTextFirst = signInPage.invalidMessageAlreadyRegisteredFirstText(driver);
        String expectedTextFirst = signInPage.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST;
        Assert.assertEquals(actualTextFirst, expectedTextFirst);
        System.out.println("The text of message is " + '"'
                + signInPage.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST + '"');

        Thread.sleep(5000);

        String actualTextSecond = signInPage.invalidMessageAlreadyRegisteredSecondText(driver);
        String expectedTextSecond = signInPage.INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_IS;
        Assert.assertEquals(actualTextSecond, expectedTextSecond);
        System.out.println("The text of message is " + '"'
                + signInPage.INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_IS + '"');
    }

    @Test
    public void missedPasswordMessageAlreadyRegistered() throws InterruptedException {
        driver.get(stringUrl);

        String email = "qwe@gmail.com";
        signInPage.inputEmailAlreadyRegistered(email);
        Thread.sleep(5000);

        //signInPage.inputPasswordInvalidAlreadyRegistered();
        signInPage.signInAlreadyRegisteredButtonClick();
        Thread.sleep(5000);

        String actualTextFirst = signInPage.invalidMessageAlreadyRegisteredFirstText(driver);
        String expectedTextFirst = signInPage.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST;
        Assert.assertEquals(actualTextFirst, expectedTextFirst);
        System.out.println("The text of message is " + '"'
                + signInPage.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST + '"');

        Thread.sleep(5000);

        String actualTextSecond = signInPage.invalidMessageAlreadyRegisteredSecondText(driver);
        String expectedTextSecond = signInPage.INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_EMPTY;
        Assert.assertEquals(actualTextSecond, expectedTextSecond);
        System.out.println("The text of message is " + '"'
                + signInPage.INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_EMPTY + '"');
    }

    @Test
    public void mismatchedPasswordMessageAlreadyRegistered() throws InterruptedException {
        driver.get(stringUrl);

        String email = "qwe@gmail.com";
        signInPage.inputEmailAlreadyRegistered(email);
        Thread.sleep(5000);

        signInPage.inputPasswordAlreadyRegistered(email);
        signInPage.signInAlreadyRegisteredButtonClick();
        Thread.sleep(5000);

        String actualTextFirst = signInPage.invalidMessageAlreadyRegisteredFirstText(driver);
        String expectedTextFirst = signInPage.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST;
        Assert.assertEquals(actualTextFirst, expectedTextFirst);
        System.out.println("The text of message is " + '"'
                + signInPage.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST + '"');

        Thread.sleep(5000);

        String actualTextSecond = signInPage.invalidMessageAlreadyRegisteredSecondText(driver);
        String expectedTextSecond = signInPage.INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_MISMATCHED;
        Assert.assertEquals(actualTextSecond, expectedTextSecond);
        System.out.println("The text of message is " + '"'
                + signInPage.INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_MISMATCHED + '"');
    }

    @Test
    public void createAnAccountPersonalInfoTitle() {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();

        String actual = signInPage.createAnAccountPersonalInfoTitle(driver);
        String expected = signInPage.CREATE_AN_ACCOUNT_PERSONAL_INFO_TITLE;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void yourPersonalInfoSectionTitle() {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();

        String actual = signInPage.yourPersonalInfoSectionTitle();
        String expected = signInPage.YOUR_PERSONAL_INFO_SECTION_TITLE;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void yourPersonalInfoTitle() {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();

        String actual = signInPage.yourPersonalInfoTitle();
        String expected = signInPage.YOUR_PERSONAL_INFO_TITLE;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void mrRadioButtonDisplayed() {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();
        signInPage.mrRadioButtonDisplayed();
        Assert.assertTrue(signInPage.mrRadioButtonDisplayed());
    }

    @Test
    public void mrRadioButtonEnabled() {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();
        signInPage.mrRadioButtonEnabled();
        Assert.assertTrue(signInPage.mrRadioButtonEnabled());
    }

    @Test
    public void mrsRadioButtonDisplayed() {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();
        signInPage.mrsRadioButtonDisplayed();
        Assert.assertTrue(signInPage.mrsRadioButtonDisplayed());
    }

    @Test
    public void mrsRadioButtonEnabled() {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();
        signInPage.mrsRadioButtonEnabled();
        Assert.assertTrue(signInPage.mrsRadioButtonEnabled());
    }

    @Test
    public void selectedStatusMrRadioButton() throws InterruptedException {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        signInPage.clickMrRadioButton();
        signInPage.selectedStatusMr();
        Assert.assertTrue(signInPage.selectedStatusMr());
    }

    @Test
    public void selectedStatusMrsRadioButton() throws InterruptedException {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        signInPage.clickMrsRadioButton();
        signInPage.selectedStatusMrs();
        Assert.assertTrue(signInPage.selectedStatusMrs());
    }


}
