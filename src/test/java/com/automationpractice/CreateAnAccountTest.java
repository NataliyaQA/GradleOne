package com.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.SignInPage;

import java.awt.*;
import java.util.List;

//77 tests
public class CreateAnAccountTest extends BaseTestAbstractClass {
    String stringUrlMainPage = "http://automationpractice.com/index.php";
    String stringUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    SignInPage signInPage;

    @BeforeMethod
    void setUpMethod () {
        driver.get(stringUrl);
        signInPage = new SignInPage(driver);
    }

    @Test  //passed
    public void checkClickSignInMainPage() {
        driver.get(stringUrlMainPage);

        signInPage.clickSignInHeaderButton();
        Assert.assertEquals(signInPage.actualUrlFind(driver), signInPage.EXPECTED_URL);
        System.out.println("Expected Url is correct");
    }

    @Test  //passed
    public void checkClickSignInAccountPage() throws InterruptedException {
        Thread.sleep(5000);

        signInPage.clickSignInHeaderButton();
//        String actualUrl = signInPage.actualUrlFind(driver);
//        String expectedUrl = signInPage.EXPECTED_URL;
        Assert.assertEquals(signInPage.actualUrlFind(driver), signInPage.EXPECTED_URL);
        System.out.println("Expected Url is correct");
    }

    @Test //passed
    public void signInButtonNameMainPage() {
        driver.get(stringUrlMainPage);
        Assert.assertEquals(signInPage.signInHeaderButtonNameFind(), signInPage.EXPECTED_SIGN_IN_HEADER_BUTTON_NAME);
    }

    @Test  //passed
    public void signInButtonNameAccountPage() {
        Assert.assertEquals(signInPage.signInHeaderButtonNameFind(), signInPage.EXPECTED_SIGN_IN_HEADER_BUTTON_NAME);
    }

    @Test // works
    public void signInPageTitle() throws InterruptedException {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickSignInHeaderButton(); //works with and without
        Assert.assertEquals(signInPage.actualTitleFind(driver), signInPage.EXPECTED_TITLE);
        System.out.println("You are on Login - My Store");
    }

    @Test //passed
    public void authenticationSectionName() {
        Assert.assertEquals(signInPage.authenticationSectionTitleFind(),
                signInPage.EXPECTED_AUTHENTICATION_SECTION_TITLE.toUpperCase());
    }

    @Test //passed
    public void createAnAccountSectionName() {
        Assert.assertEquals(signInPage.createAnAccountTitleFind(), signInPage.EXPECTED_CREATE_AN_ACCOUNT_TITLE_NAME);
    }

    @Test //passed
    public void createAnAccountSectionText() {
        Assert.assertEquals(signInPage.createAnAccountTextFind(), signInPage.EXPECTED_CREATE_AN_ACCOUNT_TEXT);
    }

    @Test //passed
    public void emailFieldCreateAnAccountName() {
        Assert.assertEquals(signInPage.emailAddressFieldCreateAnAccountTitle(),
                signInPage.EXPECTED_EMAIL_ADDRESS_FIELD_CREATE_AN_ACCOUNT_NAME);
        System.out.print("The title of email Address Field is " + '"'
                + signInPage.EXPECTED_EMAIL_ADDRESS_FIELD_CREATE_AN_ACCOUNT_NAME + '"');
    }

    @Test  //works
    public void emailInputWithOneNew() {
        signInPage.emailAddressFieldCreateAnAccountFind();
        signInPage.inputEmail().createAnAccountButtonClick();
    }

    @Test  // works
    public void emailInput() throws InterruptedException {
        signInPage.emailAddressFieldCreateAnAccountFind();
        signInPage.inputEmail();
        signInPage.createAnAccountButtonClick();
    }

    @Test  // works
    public void emailInputSameEmail() throws InterruptedException {
        Thread.sleep(5000);
        String email = "qwe@gmail.com";

        signInPage.inputEmailCreateAnAccount(email).createAnAccountButtonClick();
        Thread.sleep(5000);

//        driver.get(stringUrl);
//        SignInPage signInPageTwo = new SignInPage(driver);
//        signInPageTwo.inputEmail(email);
//        Thread.sleep(5000);
//        signInPage.createAnAccountButtonClick();
//        Thread.sleep(5000);

        // 2d part
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.errorMessageIsExist(), signInPage.EXPECTED_ERROR_EXISTING_EMAIL);
        System.out.println("An account using this email address has already been registered. " +
                "Please enter a valid password or request a new one.");
    }

    @Test // Url put and creation of instance of "SignInPage" class moved to current class
    public void invalidEmailMessage() throws InterruptedException {
        signInPage.inputEmailInvalidCreateAnAccount().createAnAccountButtonClick();
        Thread.sleep(5000);

        Assert.assertEquals(signInPage.invalidEmail(), signInPage.INVALID_EMAIL);
        System.out.println("The text of message is " + '"' + signInPage.INVALID_EMAIL + '"');
    }

    @Test //passed
    public void invalidEmailMessageWhenEmailEmpty() throws InterruptedException {
        signInPage.createAnAccountButtonClick();
        Thread.sleep(5000);

        Assert.assertEquals(signInPage.invalidEmail(), signInPage.INVALID_EMAIL);
        System.out.println("The text of message is " + '"' + signInPage.INVALID_EMAIL + '"');
    }

    @Test  //passed
    // I want to add put from ContextMap. Main idea is: input a new generated email and then check it in the list of all emails
    public void emailInputWithPut() {
        signInPage.emailAddressFieldCreateAnAccountFind();
        signInPage.inputEmail();
        //put....
        signInPage.createAnAccountButtonClick();
    }

    @Test  //passed
    public void createAnAccountButtonName() {
        Assert.assertEquals(signInPage.createAnAccountButtonFind(), signInPage.EXPECTED_CREATE_AN_ACCOUNT_BUTTON_NAME);
    }

    @Test  //passed
    public void alreadyRegisteredSectionName() {
        Assert.assertEquals(signInPage.alreadyRegisteredTitleFind(), signInPage.EXPECTED_ALREADY_REGISTERED_TITLE);
    }

    @Test //passed
    public void emailFieldAlreadyRegisteredName() {
        Assert.assertEquals(signInPage.emailAddressFieldAlreadyRegisteredTitle(),
                signInPage.EXPECTED_EMAIL_ADDRESS_FIELD_ALREADY_REGISTERED_NAME);
    }

    @Test //passed
    public void passwordFieldAlreadyRegisteredName() {
        Assert.assertEquals(signInPage.passwordFieldAlreadyRegisteredName(),
                signInPage.EXPECTED_PASSWORD_FIELD_ALREADY_REGISTERED_NAME);
    }

    @Test  //passed
    public void signInButtonAlreadyRegisteredName() {
        Assert.assertEquals(signInPage.signInAlreadyRegisteredButtonFind(),
                signInPage.EXPECTED_SIGN_IN_ALREADY_REGISTERED_BUTTON_NAME);
    }

    @Test  //passed
    public void signInButtonClick() throws InterruptedException {
        signInPage.clickSignInHeaderButton();
        Thread.sleep(5000);
    }

    @Test //passed
    public void forgotYourPasswordButtonName() {
        Assert.assertEquals(signInPage.forgotYourPasswordFind(), signInPage.EXPECTED_FORGOT_YOUR_PASSWORD_NAME);
    }

    @Test  //passed
    public void invalidEmailMessageAlreadyRegistered() throws InterruptedException {
        signInPage.inputEmailInvalidAlreadyRegistered().signInAlreadyRegisteredButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.invalidMessageAlreadyRegisteredFirstText(),
                signInPage.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST);
        System.out.println("The text of message is " + '"'
                + signInPage.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST + '"');

        Thread.sleep(5000);

        Assert.assertEquals(signInPage.invalidMessageAlreadyRegisteredSecondText(),
                signInPage.INVALID_EMAIL_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_IS);
        System.out.println("The text of message is " + '"'
                + signInPage.INVALID_EMAIL_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_IS + '"');
    }

    @Test  //passed
    public void invalidEmptyEmailMessageAlreadyRegistered() throws InterruptedException {
        signInPage.signInAlreadyRegisteredButtonClick();
        Thread.sleep(5000);

        Assert.assertEquals(signInPage.invalidMessageAlreadyRegisteredFirstText(),
                signInPage.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST);
        System.out.println("The text of message is " + '"'
                + signInPage.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST + '"');

        Thread.sleep(5000);
        Assert.assertEquals(signInPage.invalidMessageAlreadyRegisteredSecondText(),
                signInPage.INVALID_EMAIL_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_EMPTY);
        System.out.println("The text of message is " + '"'
                + signInPage.INVALID_EMAIL_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_EMPTY + '"');
    }

    @Test  //passed
    public void invalidPasswordMessageAlreadyRegistered() throws InterruptedException {
        String email = "qwe@gmail.com";
        signInPage.inputEmailAlreadyRegistered(email);
        Thread.sleep(5000);

        signInPage.inputPasswordInvalidAlreadyRegistered().signInAlreadyRegisteredButtonClick();
        Thread.sleep(5000);

        Assert.assertEquals(signInPage.invalidMessageAlreadyRegisteredFirstText(),
                signInPage.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST);
        System.out.println("The text of message is " + '"'
                + signInPage.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST + '"');
        Thread.sleep(5000);

        Assert.assertEquals(signInPage.invalidMessageAlreadyRegisteredSecondText(),
                signInPage.INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_IS);
        System.out.println("The text of message is " + '"'
                + signInPage.INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_IS + '"');
    }

    @Test  //passed
    public void missedPasswordMessageAlreadyRegistered() throws InterruptedException {
        String email = "qwe@gmail.com";
        signInPage.inputEmailAlreadyRegistered(email);
        Thread.sleep(5000);

        //signInPage.inputPasswordInvalidAlreadyRegistered();
        signInPage.signInAlreadyRegisteredButtonClick();
        Thread.sleep(5000);

        Assert.assertEquals(signInPage.invalidMessageAlreadyRegisteredFirstText(),
                signInPage.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST);
        System.out.println("The text of message is " + '"'
                + signInPage.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST + '"');
        Thread.sleep(5000);

        Assert.assertEquals(signInPage.invalidMessageAlreadyRegisteredSecondText(),
                signInPage.INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_EMPTY);
        System.out.println("The text of message is " + '"'
                + signInPage.INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_EMPTY + '"');
    }

    @Test  //passed
    public void mismatchedPasswordMessageAlreadyRegistered() throws InterruptedException {
        String email = "qwe@gmail.com";
        signInPage.inputEmailAlreadyRegistered(email);
        Thread.sleep(5000);

        signInPage.inputPasswordAlreadyRegistered(email).signInAlreadyRegisteredButtonClick();
        Thread.sleep(5000);

        Assert.assertEquals(signInPage.invalidMessageAlreadyRegisteredFirstText(),
                signInPage.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST);
        System.out.println("The text of message is " + '"'
                + signInPage.INVALID_MESSAGE_ALREADY_REGISTERED_FIRST + '"');
        Thread.sleep(5000);

        Assert.assertEquals(signInPage.invalidMessageAlreadyRegisteredSecondText(),
                signInPage.INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_MISMATCHED);
        System.out.println("The text of message is " + '"'
                + signInPage.INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_MISMATCHED + '"');
    }

    @Test  //passed
    public void createAnAccountPersonalInfoTitle() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.createAnAccountPersonalInfoTitle(),
                signInPage.CREATE_AN_ACCOUNT_PERSONAL_INFO_TITLE);
    }

    @Test  //passed
    public void yourPersonalInfoSectionTitle() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.yourPersonalInfoSectionTitle(), signInPage.YOUR_PERSONAL_INFO_SECTION_TITLE);
    }

    @Test  //passed
    public void yourPersonalInfoTitle() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.yourPersonalInfoTitle(), signInPage.YOUR_PERSONAL_INFO_TITLE);
    }

    @Test  //passed
    public void mrRadioButtonDisplayed() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertTrue(signInPage.mrRadioButtonDisplayed());
    }

    @Test //passed
    public void mrRadioButtonEnabled() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        signInPage.mrRadioButtonEnabled();
        Thread.sleep(5000);
        Assert.assertTrue(signInPage.mrRadioButtonEnabled());
    }

    @Test  //passed
    public void mrsRadioButtonDisplayed() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertTrue(signInPage.mrsRadioButtonDisplayed());
    }

    @Test  //passed
    public void mrsRadioButtonEnabled() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertTrue(signInPage.mrsRadioButtonEnabled());
    }

    @Test  //passed
    public void selectedStatusMrRadioButton() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        signInPage.clickMrRadioButton();
        Assert.assertTrue(signInPage.selectedStatusMr());
    }

    @Test //passed
    public void selectedStatusMrsRadioButton() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        signInPage.clickMrsRadioButton();

        Assert.assertTrue(signInPage.selectedStatusMrs());
    }

    @Test  //passed
    public void selectDropDown() throws InterruptedException {
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
    }

    @Test
    public void selectDropDownDaysAll() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        int[] actual = signInPage.dropDownDaysAllOptions();
        int[] expected = signInPage.DROPDOWN_DAYS;
        int index = generateRandomIntInRange(0, expected.length - 1);
        Assert.assertEquals(actual, expected);
        Assert.assertEquals(actual[index], expected[index]);
        System.out.println("*********" + index + " " + actual[index]  + " " + expected[index]);
    }

    @Test //passed
    public void selectDropDownDaysOption() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        int[] actual = signInPage.dropDownDaysAllOptions();
        int[] expected = signInPage.DROPDOWN_DAYS;

        Assert.assertEquals(actual.length, expected.length, "Compare list length");
        // update with stream
        for (int i=0; i < expected.length; i++) {
            Assert.assertEquals(actual[i], expected[i]);
        }
    }

    @Test  //passed
    public void selectDropDownDaysOptionOneByOne() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        int[] actual = signInPage.dropDownDaysAllOptions();

        for (int i=0; i < 31; i++) {
            int tmp = i;
            Assert.assertEquals(actual[i], tmp+1);
        }
    }

    @Test  //passed. Question: how to check all options value one by one?
    public void selectDropDownDaysOptionByValue() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        signInPage.selectDropDownDaysOptionByValue();
    }

    @Test  // passed
    public void selectDropDownMonthsAllOptions() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        List<String> actual = signInPage.dropDownMonthsAllOptions();
        List<String> expected = signInPage.DROPDOWN_MONTHS;
        int index = generateRandomIntInRange(0, expected.size() - 1);
        Assert.assertEquals(actual.get(index), expected.get(index));
        System.out.println("*********" + index + " " + actual.get(index)  + " " + expected.get(index));
    }

    @Test  // passed
    public void selectDropDownMonthsOneOption() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        List<String> actual = signInPage.dropDownMonthsAllOptions();
        List<String> expected = signInPage.DROPDOWN_MONTHS;
        Assert.assertEquals(actual, expected);
        System.out.println("*********" + actual + " \n " +  expected);
    }

    @Test
    public void selectDropDownYearsAll() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        int[] actual = signInPage.dropDownYearsAllOptions();
        int[] expected = signInPage.DROPDOWN_YEARS;
        int index = generateRandomIntInRange(0, expected.length - 1);
        Assert.assertEquals(actual, expected);
        Assert.assertEquals(actual[index], expected[index]);
        System.out.println("*********" + index + " " + actual[index]  + " " + expected[index]);
    }

    @Test  //passed
    public void selectDropDownYearsOption() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        int[] actual = signInPage.dropDownYearsAllOptions();
        int[] expected = signInPage.DROPDOWN_YEARS;

        Assert.assertEquals(actual.length, expected.length, "Compare list length");
        // update with stream
        for (int i=0; i < expected.length; i++) {
            Assert.assertEquals(actual[i], expected[i]);
        }
    }

    @Test //passed
    public void checkEmailFieldIfNotEmpty() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.emptyFieldEmail(), false);
        System.out.println(signInPage.emptyFieldEmail());
    }

    @Test //passed
    public void checkEmailFieldValue() throws InterruptedException {
        signInPage.inputEmail();
        Thread.sleep(5000);
        String newEmail = signInPage.valueOfEmailFieldHomePage();

        signInPage.createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.valueOfEmailField(), newEmail);
        System.out.println(signInPage.valueOfEmailField());
    }

    @Test  //passed
    public void deleteEmailValue() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        signInPage.deleteValueEmail();
        Assert.assertEquals(signInPage.emptyFieldEmail(), true);
    }

    @Test  //passed
    public void countryDropDownFirstOption() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        signInPage.countryDropDownFirstOption();
    }

    @Test  //passed
    public void errorAlertIs() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPage.deleteValueEmail();
        signInPage.countryDropDownFirstOption();
        signInPage.clickRegisterButton();
        Thread.sleep(5000);
        WebElement errorAlert = signInPage.errorAlert();
        Assert.assertTrue(errorAlert.isDisplayed());
    }

    @Test  //passed
    public void errorAlertText() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPage.deleteValueEmail();
        signInPage.countryDropDownFirstOption();
        Thread.sleep(5000);
        signInPage.clickRegisterButton();

        WebElement errorAlert = signInPage.errorAlert();
        String actual = errorAlert.getText();
        System.out.println("result:" + "\n" + actual);

        Assert.assertEquals(actual, signInPage.ALERT_ERROR);
    }

    @Test
    public void signUpCheckBoxEnabled() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertTrue(signInPage.signUpCheckBox());
    }

    @Test  //failed without visible reason
    public void signUpCheckBoxClickAndSelected() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPage.clickSignUpCheckBox();
        Thread.sleep(5000);
        Assert.assertTrue(signInPage.selectedSignUpCheckBox());
    }

    @Test //(enabled=false)
    public void signUpCheckBoxName() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.signUpCheckBoxName(), signInPage.SIGNUP_CHECKBOX, "signUpCheckBoxName is not correct");
    }

    @Test
    public void offersCheckBoxEnabled() {
        signInPage.inputEmail().createAnAccountButtonClick();
        Assert.assertTrue(signInPage.offersCheckBox());
    }

    @Test
    public void offersCheckBoxName() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        Assert.assertEquals(signInPage.offersCheckBoxName(),
                signInPage.OFFERS_CHECKBOX, "offersCheckBoxName is not correct");
    }

    @Test //passed
    public void offersCheckBoxClickAndSelected() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPage.clickOffersCheckBox();
        Thread.sleep(5000);
        Assert.assertTrue(signInPage.selectedOffersCheckBox());
    }

    @Test //passed
    public void firsNameOneFieldName() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.firstNameFieldOneName(), signInPage.FIRSTNAME_FIELD);
    }

    @Test
    public void lastNameTwoFieldName() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.lastNameFieldTOneName(), signInPage.LASTNAME_FIELD);
    }

    @Test //passed
    public void firsNameTwoFieldName() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.firstNameFieldTwoName(), signInPage.FIRSTNAME_FIELD);
    }

    @Test //passed
    public void lastNameOneFieldName() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.lastNameFieldTwoName(), signInPage.LASTNAME_FIELD);
    }

    @Test
    public void emailFieldName() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.emailFieldName(), signInPage.EMAIL_FIELD);
    }

    @Test //passed but time to time is failed with different results of field name
    public void passwordFieldName() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.passwordFieldName(), signInPage.PASSWORD_FIELD);
    }

    @Test
    public void passwordFieldHelpText() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.passwordFieldHelpText(), signInPage.PASSWORD_FIELD_HELP_TEXT);
    }

    @Test
    public void dateOfBirthFieldName() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.dateOfBirthFieldName(), signInPage.DATE_OF_BIRTH_FIELD);
    }

    @Test //passed
    public void yourAddressSectionName() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.yourAddressSectionName(), signInPage.YOUR_ADDRESS_SECTION.toUpperCase());
    }

    @Test
    public void companyFieldName() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.companyFieldName(), signInPage.COMPANY_FIELD);
    }

    @Test
    public void addressFieldName() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.addressFieldName(), signInPage.ADDRESS_FIELD);
    }

    @Test
    public void addressFieldHelpText() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.addressFieldHelpText(), signInPage.ADDRESS_HELP_TEXT);
    }

    @Test
    public void cityFieldName() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.cityFieldName(), signInPage.CITY_FIELD);
    }

    @Test
    public void countryFieldName() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.countryFieldName(), signInPage.COUNTRY_FIELD);
    }

    @Test
    public void additionalInfoFieldName() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.additionalInfoFieldName(), signInPage.ADDITIONAL_INFORMATION_FIELD);
    }

    @Test
    public void additionalInfoHelpText() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.additionalInfoHelpText(), signInPage.ADDITIONAL_INFORMATION_HELP_TEXT);
    }

    @Test
    public void homePhoneFieldName() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.homePhoneFieldName(), signInPage.HOME_PHONE_FIELD);
    }

    @Test
    public void mobilePhoneFieldName() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.mobilePhoneFieldName(), signInPage.MOBILE_PHONE_FIELD);
    }

    @Test
    public void assignAliasFieldName() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.assignAliasFieldName(), signInPage.ASSIGN_ADDRESS_ALIAS_FIELD);
    }

    @Test //passed
    public void valueOfAddressAliasField() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.assignAliasFieldValue(), signInPage.ASSIGN_ADDRESS_ALIAS_VALUE);
    }

    @Test
    public void registerButtonName() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.registerButtonName(), signInPage.REGISTER_BUTTON);
    }

    @Test //passed
    public void requiredText() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertEquals(signInPage.requiredText(), signInPage.REQUIRED_TEXT);
    }

    @Test //probably bad design
    public void firstNameFieldWithDigits() throws InterruptedException, AWTException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        String value = "123";
        if (signInPage.emptyFieldFirstName() == false) {
            signInPage.deleteValueFirstName();
        } else if (signInPage.emptyFieldLastName() != true) {
            signInPage.deleteValueLastName();
        } else if (signInPage.emptyFieldPassword() == false) {
            signInPage.deleteValuePassword();
        } else {
            signInPage.inputValueLastName(value);

            Thread.sleep(5000);
            signInPage.clickAnyWhere();
            Thread.sleep(5000);

            Assert.assertTrue(signInPage.isDisplayed(driver
                    .findElement(By.xpath("//div[@class='required form-group form-error']"))));
        }
    }

        @Test //probably bad design
        public void firstNameFieldWithLetters () throws InterruptedException, AWTException {
            signInPage.inputEmail().createAnAccountButtonClick();
            Thread.sleep(5000);
            String value = "qwe";
            if (signInPage.emptyFieldFirstName() == false) {
                signInPage.deleteValueFirstName();
            } else if (signInPage.emptyFieldLastName() != true) {
                signInPage.deleteValueLastName();
            } else if (signInPage.emptyFieldPassword() == false) {
                signInPage.deleteValuePassword();
            } else {
                signInPage.inputValueLastName(value);

                Thread.sleep(5000);
                signInPage.clickAnyWhere();
                Thread.sleep(5000);

                Assert.assertTrue(signInPage.isDisplayed(driver
                        .findElement(By.xpath("//div[@class='required form-group form-ok']"))));
            }
        }

        @Test //probably bad design
        public void lastNameFieldWithDigits () throws InterruptedException, AWTException {
            signInPage.inputEmail().createAnAccountButtonClick();
            Thread.sleep(5000);
            String value = "123";
            if (signInPage.emptyFieldFirstName() == false) {
                signInPage.deleteValueFirstName();
            } else if (signInPage.emptyFieldLastName() != true) {
                signInPage.deleteValueLastName();
            } else if (signInPage.emptyFieldPassword() == false) {
                signInPage.deleteValuePassword();
            } else {
                signInPage.inputValueLastName(value);

                Thread.sleep(5000);
                signInPage.clickAnyWhere();
                Thread.sleep(5000);

                Assert.assertTrue(signInPage.isDisplayed(driver
                        .findElement(By.xpath("//div[@class='required form-group form-error']"))));
            }
        }

        @Test //probably bad design
        public void lastNameFieldWithLetters () throws InterruptedException, AWTException {
            signInPage.inputEmail().createAnAccountButtonClick();
            Thread.sleep(5000);
            String value = "qwe";
            if (signInPage.emptyFieldFirstName() == false) {
                signInPage.deleteValueFirstName();
            } else if (signInPage.emptyFieldLastName() != true) {
                signInPage.deleteValueLastName();
            } else if (signInPage.emptyFieldPassword() == false) {
                signInPage.deleteValuePassword();
            } else {
                signInPage.inputValueLastName(value);

                Thread.sleep(5000);
                signInPage.clickAnyWhere();
                Thread.sleep(5000);

                Assert.assertTrue(signInPage.isDisplayed(driver
                        .findElement(By.xpath("//div[@class='required form-group form-ok']"))));
                Thread.sleep(5000);
            }
        }
    }



