package com.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.SignInPage;

import java.util.List;

//40 tests, 35 new
public class CreateAnAccountTest extends BaseTestAbstractClass {
    String stringUrlMainPage = "http://automationpractice.com/index.php";
    String stringUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    SignInPage signInPage = new SignInPage(driver);

    @Test //passed
    public void checkClickSignInMainPage() {
        driver.get(stringUrlMainPage);

        signInPage.clickSignInHeaderButton();
        String actualUrl = signInPage.actualUrlFind(driver);
        String expectedUrl = signInPage.EXPECTED_URL;

        Assert.assertEquals(actualUrl, expectedUrl);
        System.out.println("Expected Url is correct");
        driver.quit();
    }

    @Test //passed
    public void checkClickSignInAccountPage() throws InterruptedException {
        driver.get(stringUrl);
        Thread.sleep(5000);

        signInPage.clickSignInHeaderButton();
        String actualUrl = signInPage.actualUrlFind(driver);
        String expectedUrl = signInPage.EXPECTED_URL;

        Assert.assertEquals(actualUrl, expectedUrl);
        System.out.println("Expected Url is correct");
        driver.quit();
    }

    @Test //passed
    public void signInButtonNameMainPage() {
        driver.get(stringUrlMainPage);

        String actual = signInPage.signInHeaderButtonNameFind();
        String expected = signInPage.EXPECTED_SIGN_IN_HEADER_BUTTON_NAME;

        Assert.assertEquals(actual, expected);
        driver.quit();
    }

    @Test //passed
    public void signInButtonNameAccountPage() {
        driver.get(stringUrl);

        String actual = signInPage.signInHeaderButtonNameFind();
        String expected = signInPage.EXPECTED_SIGN_IN_HEADER_BUTTON_NAME;

        Assert.assertEquals(actual, expected);
        driver.quit();
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
        driver.quit();
    }

    @Test //passed
    public void authenticationSectionName() {
        driver.get(stringUrl);

        String actual = signInPage.authenticationSectionTitleFind(driver);
        String expected = signInPage.EXPECTED_AUTHENTICATION_SECTION_TITLE;

        Assert.assertEquals(actual, expected.toUpperCase());
        driver.quit();
    }

    @Test //passed
    public void createAnAccountSectionName() {
        driver.get(stringUrl);

        String actual = signInPage.createAnAccountTitleFind(driver);
        String expected = signInPage.EXPECTED_CREATE_AN_ACCOUNT_TITLE_NAME;

        Assert.assertEquals(actual, expected);
        driver.quit();
    }

    @Test //passed
    public void createAnAccountSectionText() {
        driver.get(stringUrl);

        String actual = signInPage.createAnAccountTextFind(driver);
        String expected = signInPage.EXPECTED_CREATE_AN_ACCOUNT_TEXT;

        Assert.assertEquals(actual, expected);
        driver.quit();
    }

    @Test //passed
    public void emailFieldCreateAnAccountName() {
        driver.get(stringUrl);

        String actualName = signInPage.emailAddressFieldCreateAnAccountTitle(driver);
        String expectedName = signInPage.EXPECTED_EMAIL_ADDRESS_FIELD_CREATE_AN_ACCOUNT_NAME;

        Assert.assertEquals(actualName, expectedName);
        System.out.print("The title of email Address Field is " + '"'
                + signInPage.EXPECTED_EMAIL_ADDRESS_FIELD_CREATE_AN_ACCOUNT_NAME + '"');
        driver.quit();
    }

    @Test //works
    public void emailInputWithOneNew() {
        String stringUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        driver.get(stringUrl);

        SignInPage signInPage = new SignInPage(driver);

        signInPage.emailAddressFieldCreateAnAccountFind(driver);
        signInPage.inputEmail();
        signInPage.createAnAccountButtonClick();
        driver.quit();
    }

    @Test // works
    public void emailInput() throws InterruptedException {
        String stringUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        driver.get(stringUrl);

        new SignInPage(driver).emailAddressFieldCreateAnAccountFind(driver);
        new SignInPage(driver).inputEmail();
        new SignInPage(driver).createAnAccountButtonClick();
        driver.quit();
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
        driver.quit();
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
        driver.quit();
    }

    @Test //passed
    public void invalidEmailMessageWhenEmailEmpty() throws InterruptedException {

        driver.get(stringUrl);

        signInPage.createAnAccountButtonClick();

        String actualText = signInPage.invalidEmail(driver);
        String expectedText = signInPage.INVALID_EMAIL;

        Thread.sleep(5000);

        Assert.assertEquals(actualText, expectedText);
        System.out.println("The text of message is " + '"' + signInPage.INVALID_EMAIL + '"');
        driver.quit();
    }

    @Test //passed
    // I want to add put from ContextMap. Main idea is: input a new generated email and then check it in the list of all emails
    public void emailInputWithPut() {

        String stringUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        driver.get(stringUrl);

        new SignInPage(driver).emailAddressFieldCreateAnAccountFind(driver);
        new SignInPage(driver).inputEmail();
        //put....
        new SignInPage(driver).createAnAccountButtonClick();
        driver.quit();
    }

    @Test //passed
    public void createAnAccountButtonName() {
        driver.get(stringUrl);

        String actual = signInPage.createAnAccountButtonFind(driver);
        String expected = signInPage.EXPECTED_CREATE_AN_ACCOUNT_BUTTON_NAME;

        Assert.assertEquals(actual, expected);
        driver.quit();
    }

    @Test //passed
    public void alreadyRegisteredSectionName() {
        driver.get(stringUrl);

        String actual = signInPage.alreadyRegisteredTitleFind(driver);
        String expected = signInPage.EXPECTED_ALREADY_REGISTERED_TITLE;

        Assert.assertEquals(actual, expected);
        driver.quit();
    }

    @Test //passed
    public void emailFieldAlreadyRegisteredName() {
        driver.get(stringUrl);

        String actual = signInPage.emailAddressFieldAlreadyRegisteredTitle(driver);
        String expected = signInPage.EXPECTED_EMAIL_ADDRESS_FIELD_ALREADY_REGISTERED_NAME;

        Assert.assertEquals(actual, expected);
        driver.quit();
    }

    @Test //passed
    public void passwordFieldAlreadyRegisteredName() {
        driver.get(stringUrl);

        String actual = signInPage.passwordFieldAlreadyRegisteredName(driver);
        String expected = signInPage.EXPECTED_PASSWORD_FIELD_ALREADY_REGISTERED_NAME;

        Assert.assertEquals(actual, expected);
        driver.quit();
    }

    @Test //passed
    public void signInButtonAlreadyRegisteredName() {
        driver.get(stringUrl);

        String actual = signInPage.signInAlreadyRegisteredButtonFind(driver);
        String expected = signInPage.EXPECTED_SIGN_IN_ALREADY_REGISTERED_BUTTON_NAME;

        Assert.assertEquals(actual, expected);
        driver.quit();
    }

    @Test //passed
    public void signInButtonClick() throws InterruptedException {
        driver.get(stringUrl);

        signInPage.clickSignInHeaderButton();
        Thread.sleep(5000);
        driver.quit();
    }

    @Test //passed
    public void forgotYourPasswordButtonName() {
        driver.get(stringUrl);

        String actual = signInPage.forgotYourPasswordFind(driver);
        String expected = signInPage.EXPECTED_FORGOT_YOUR_PASSWORD_NAME;

        Assert.assertEquals(actual, expected);
        driver.quit();
    }

    @Test //passed
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
        driver.quit();
    }

    @Test //passed
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
        driver.quit();
    }

    @Test //passed
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
        driver.quit();
    }

    @Test //passed
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
        driver.quit();
    }

    @Test //passed
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
        driver.quit();
    }

    @Test //passed
    public void createAnAccountPersonalInfoTitle() throws InterruptedException {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        String actual = signInPage.createAnAccountPersonalInfoTitle(driver);
        String expected = signInPage.CREATE_AN_ACCOUNT_PERSONAL_INFO_TITLE;

        Assert.assertEquals(actual, expected);
        driver.quit();
    }

    @Test //passed
    public void yourPersonalInfoSectionTitle() {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();

        String actual = signInPage.yourPersonalInfoSectionTitle();
        String expected = signInPage.YOUR_PERSONAL_INFO_SECTION_TITLE;

        Assert.assertEquals(actual, expected);
        driver.quit();
    }

    @Test //passed
    public void yourPersonalInfoTitle() {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();

        String actual = signInPage.yourPersonalInfoTitle();
        String expected = signInPage.YOUR_PERSONAL_INFO_TITLE;

        Assert.assertEquals(actual, expected);
        driver.quit();
    }

    @Test //passed
    public void mrRadioButtonDisplayed() {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();

        Assert.assertTrue(signInPage.mrRadioButtonDisplayed());
        driver.quit();
    }

    @Test
    public void mrRadioButtonEnabled() {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();
        signInPage.mrRadioButtonEnabled();
        Assert.assertTrue(signInPage.mrRadioButtonEnabled());
        driver.quit();
    }

    @Test //passed
    public void mrsRadioButtonDisplayed() {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();

        Assert.assertTrue(signInPage.mrsRadioButtonDisplayed());
        driver.quit();
    }

    @Test //passed
    public void mrsRadioButtonEnabled() {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();

        Assert.assertTrue(signInPage.mrsRadioButtonEnabled());
        driver.quit();
    }

    @Test //passed
    public void selectedStatusMrRadioButton() throws InterruptedException {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        signInPage.clickMrRadioButton();

        Assert.assertTrue(signInPage.selectedStatusMr());
        driver.quit();
    }

    @Test //passed
    public void selectedStatusMrsRadioButton() throws InterruptedException {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        signInPage.clickMrsRadioButton();

        Assert.assertTrue(signInPage.selectedStatusMrs());
        driver.quit();
    }

    @Test //passed
    public void selectDropDown() throws InterruptedException {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        //selecting the dropdown element by locating its id
        Select select = new Select(driver.findElement(By.xpath("//*[@id='days']")));

        //Get list of web elements of the dropdown
        List<WebElement> lst = select.getOptions();

        //Looping through the options and printing dropdown options
        System.out.println("The dropdown options are:");
        for (WebElement options : lst)
            System.out.println(options.getText());

        //Selecting the option as '4'-- selectByIndex
        System.out.println("Select the Option by Index 4");
        select.selectByIndex(4);
        System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

        //Selecting the option as '-'-- selectByVisibleText
        System.out.println("Select the Option by Text -");
        select.selectByVisibleText("-");
        System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

        //Selecting an option by its value
        System.out.println("Select the Option by value 6");
        select.selectByValue("6");
        System.out.println("Select value is: " + select.getFirstSelectedOption().getText());
        driver.quit();
    }

    @Test
    public void selectDropDownDaysAll() throws InterruptedException {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        int[] actual = signInPage.dropDownDaysAllOptions();
        int[] expected = signInPage.DROPDOWN_DAYS;
        int index = generateRandomIntInRange(0, expected.length - 1);
        Assert.assertEquals(actual, expected);
        Assert.assertEquals(actual[index], expected[index]);
        System.out.println("*********" + index + " " + actual[index]  + " " + expected[index]);
        driver.quit();
    }

    @Test //passed
    public void selectDropDownDaysOption() throws InterruptedException {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        int[] actual = signInPage.dropDownDaysAllOptions();
        int[] expected = signInPage.DROPDOWN_DAYS;

        Assert.assertEquals(actual.length, expected.length, "Compare list length");
        // update with stream
        for (int i=0; i < expected.length; i++) {
            Assert.assertEquals(actual[i], expected[i]);
        }
        driver.quit();
    }

    @Test //passed
    public void selectDropDownDaysOptionOneByOne() throws InterruptedException {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        int[] actual = signInPage.dropDownDaysAllOptions();

        for (int i=0; i < 31; i++) {
            int tmp = i;
            Assert.assertEquals(actual[i], tmp+1);
        }
        driver.quit();
    }

    @Test //passed. Question: how to check all options value one by one?
    public void selectDropDownDaysOptionByValue() throws InterruptedException {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPage.selectDropDownDaysOptionByValue();
        driver.quit(); //question
    }

    @Test // passed
    public void selectDropDownMonthsAllOptions() throws InterruptedException {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        List<String> actual = signInPage.dropDownMonthsAllOptions();
        List<String> expected = signInPage.DROPDOWN_MONTHS;
        int index = generateRandomIntInRange(0, expected.size() - 1);
        Assert.assertEquals(actual.get(index), expected.get(index));
        System.out.println("*********" + index + " " + actual.get(index)  + " " + expected.get(index));
        driver.quit();
    }

    @Test // passed
    public void selectDropDownMonthsOneOption() throws InterruptedException {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        List<String> actual = signInPage.dropDownMonthsAllOptions();
        List<String> expected = signInPage.DROPDOWN_MONTHS;
        Assert.assertEquals(actual, expected);
        System.out.println("*********" + actual + " \n " +  expected);
        driver.quit();
    }

    @Test
    public void selectDropDownYearsAll() throws InterruptedException {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        int[] actual = signInPage.dropDownYearsAllOptions();
        int[] expected = signInPage.DROPDOWN_YEARS;
        int index = generateRandomIntInRange(0, expected.length - 1);
        Assert.assertEquals(actual, expected);
        Assert.assertEquals(actual[index], expected[index]);
        System.out.println("*********" + index + " " + actual[index]  + " " + expected[index]);
        driver.quit();
    }

    @Test //passed
    public void selectDropDownYearsOption() throws InterruptedException {
        driver.get(stringUrl);

        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        int[] actual = signInPage.dropDownYearsAllOptions();
        int[] expected = signInPage.DROPDOWN_YEARS;

        Assert.assertEquals(actual.length, expected.length, "Compare list length");
        // update with stream
        for (int i=0; i < expected.length; i++) {
            Assert.assertEquals(actual[i], expected[i]);
        }
        driver.quit();
    }

    @Test //passed
    public void checkEmailFieldIfNotEmpty() throws InterruptedException {
        driver.get(stringUrl);
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        boolean actual = signInPage.emptyField();
        boolean expected = false;
        Assert.assertEquals(actual, expected);


        System.out.println(signInPage.emptyField());
    }

    @Test //passed
    public void checkEmailFieldValue() throws InterruptedException {
        driver.get(stringUrl);
        signInPage.inputEmail();
        Thread.sleep(5000);
        String newEmail = signInPage.valueOfEmailFieldHomePage();

        signInPage.createAnAccountButtonClick();
        Thread.sleep(5000);

        String actual = signInPage.valueOfEmailField();
        String expected = newEmail;
        Assert.assertEquals(actual, expected);

        System.out.println(signInPage.valueOfEmailField());
    }

    @Test //passed
    public void deleteValue() throws InterruptedException {
        driver.get(stringUrl);
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPage.deleteValue();

        boolean actual = signInPage.emptyField();
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }

    @Test //passed
    public void countryDropDownFirstOption() throws InterruptedException {
        driver.get(stringUrl);
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPage.countryDropDownFirstOption();
    }

    @Test //passed
    public void errorAlertIs() throws InterruptedException {
        driver.get(stringUrl);
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPage.deleteValue();
        signInPage.countryDropDownFirstOption();
        signInPage.clickRegisterButton();

        WebElement errorAlert = signInPage.errorAlert();
        Assert.assertTrue(errorAlert.isDisplayed());
    }

    @Test //passed
    public void errorAlertText() throws InterruptedException {
        driver.get(stringUrl);
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPage.deleteValue();
        signInPage.countryDropDownFirstOption();
        signInPage.clickRegisterButton();

        WebElement errorAlert = signInPage.errorAlert();
        String actual = errorAlert.getText();
        System.out.println("result:" + "\n" + actual);

        Assert.assertEquals(actual, signInPage.ALERT_ERROR);
    }

    @Test
    public void signUpCheckBoxEnabled() throws InterruptedException {
        driver.get(stringUrl);
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        Assert.assertTrue(signInPage.signUpCheckBox());
        driver.quit();
    }

    @Test //passed
    public void signUpCheckBoxClickAndSelected() throws InterruptedException {
        driver.get(stringUrl);
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPage.clickSignUpCheckBox();
        Thread.sleep(5000);
        signInPage.selectedSignUpCheckBox();
        driver.quit();
    }

    @Test
    public void signUpCheckBoxName() throws InterruptedException {
        driver.get(stringUrl);
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        String actual = signInPage.signUpCheckBoxName();
        String expected = signInPage.SIGNUP_CHECKBOX;

        Assert.assertEquals(actual, expected, "signUpCheckBoxName is not correct");
        driver.quit();
    }

    @Test
    public void offersCheckBoxEnabled() throws InterruptedException {
        driver.get(stringUrl);
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        Assert.assertTrue(signInPage.offersCheckBox());
        driver.quit();
    }

    @Test
    public void offersCheckBoxName() throws InterruptedException {
        driver.get(stringUrl);
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        String actual = signInPage.offersCheckBoxName();
        String expected = signInPage.OFFERS_CHECKBOX;

        Assert.assertEquals(actual, expected, "offersCheckBoxName is not correct");
        driver.quit();
    }

    @Test //passed
    public void offersCheckBoxClickAndSelected() throws InterruptedException {
        driver.get(stringUrl);
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPage.clickOffersCheckBox();
        Thread.sleep(5000);
        signInPage.selectedOffersCheckBox();
        driver.quit();
    }
}


