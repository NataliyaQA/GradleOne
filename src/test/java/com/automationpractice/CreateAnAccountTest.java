package com.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.SignInPage;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//100 tests
public class CreateAnAccountTest extends BaseTestAbstractClass {
    String stringUrlMainPage = "http://automationpractice.com/index.php";
    String stringUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    SignInPage signInPage;

    @BeforeMethod
    void setUpMethod() {
        driver.get(stringUrl);
        signInPage = new SignInPage(driver);
    }

//    @AfterMethod
//    void signOut() {
//        signInPage.signOutButtonClick();
//    }

    @Test  //passed
    public void checkClickSignInMainPage() {
        driver.get(stringUrlMainPage);
        signInPage.clickSignInHeaderButton();
        Assert.assertEquals(signInPage.actualUrlFind(), signInPage.EXPECTED_URL);
        System.out.println("Expected Url is correct");
    }

    @Test  //passed
    public void checkClickSignInAccountPage() throws InterruptedException {
        Thread.sleep(5000);
        signInPage.clickSignInHeaderButton();
        Assert.assertEquals(signInPage.actualUrlFind(), signInPage.EXPECTED_URL);
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

    @Test // works 123
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

    @Test  //passed
    public void emailInputWithOneNew() {
        signInPage.inputEmail().createAnAccountButtonClick();
        Assert.assertEquals(signInPage.authenticationFind(), "Authentication");
    }

    @Test  // passed
    public void emailInputNotEmpty() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertFalse(signInPage.emptyFieldEmail());
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

    @Test  //passed *** corrupted, java.util. had to be added
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
        System.out.println("*********" + index + " " + actual[index] + " " + expected[index]);
    }

    @Test //passed
    public void selectDropDownDaysOption() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        int[] actual = signInPage.dropDownDaysAllOptions();
        int[] expected = signInPage.DROPDOWN_DAYS;

        Assert.assertEquals(actual.length, expected.length, "Compare list length");
        // update with stream
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(actual[i], expected[i]);
        }
    }

    @Test  //passed
    public void selectDropDownDaysOptionOneByOne() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        int[] actual = signInPage.dropDownDaysAllOptions();

        for (int i = 0; i < 31; i++) {
            int tmp = i;
            Assert.assertEquals(actual[i], tmp + 1);
        }
    }

    @Test  //passed. Question: how to check all options value one by one?
    public void selectDropDownDaysOptionByValue() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        signInPage.selectDropDownDaysOptionByValue();
    }

    @Test  // passed *** was corrupted when actual and expected were written separately as variables with List<String>
    public void selectDropDownMonthsAllOptionsByIndex() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        int index = generateRandomIntInRange(0, signInPage.DROPDOWN_MONTHS.size() - 1);
        Assert.assertEquals(signInPage.dropDownMonthsAllOptions().get(index), signInPage.DROPDOWN_MONTHS.get(index));
        System.out.println("*********" + index + " " + signInPage.dropDownMonthsAllOptions().get(index)
                + " " + signInPage.DROPDOWN_MONTHS.get(index));
    }

    @Test  // passed *** corrupted when actual and expected were written separately as variables with List<String>
    public void selectDropDownMonthsAllOption() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        Assert.assertEquals(signInPage.dropDownMonthsAllOptions(), signInPage.DROPDOWN_MONTHS);
        System.out.println("*********" + signInPage.dropDownMonthsAllOptions()
                + " \n " + signInPage.DROPDOWN_MONTHS);
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
        System.out.println("*********" + index + " " + actual[index] + " " + expected[index]);
    }

    @Test  //passed
    public void selectDropDownYearsOption() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        int[] actual = signInPage.dropDownYearsAllOptions();
        int[] expected = signInPage.DROPDOWN_YEARS;

        Assert.assertEquals(actual.length, expected.length, "Compare list length");
        // update with stream
        for (int i = 0; i < expected.length; i++) {
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
        Assert.assertEquals(signInPage.countryDropDownFirstOption(), "-");
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

    @Test  // passed
    public void signUpCheckBoxClickAndSelected() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPage.clickSignUpCheckBox();
        Thread.sleep(5000);
        Assert.assertTrue(signInPage.selectedSignUpCheckBox(), "not correct");
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

    @Test  // passed
    public void selectDropDownStatesAllOptionsByIndex() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        int index = generateRandomIntInRange(0, signInPage.STATES.size() - 1);
        Assert.assertEquals(signInPage.dropDownStatesAllOptions().get(index), signInPage.STATES.get(index));
        System.out.println("*********" + index + " " + signInPage.dropDownStatesAllOptions().get(index)
                + " " + signInPage.STATES.get(index));
    }

    @Test  // passed
    public void selectDropDownStatesAllOption() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        Assert.assertEquals(signInPage.dropDownStatesAllOptions(), signInPage.STATES);
        System.out.println("*********" + signInPage.dropDownStatesAllOptions()
                + " \n " + signInPage.STATES);
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

    /**
     * Check if the system verifies the invalid input in the FirstName field
     *
     * @throws InterruptedException
     * @throws AWTException
     */
    @Test //probably bad design. Question about loop. I'd like to empty all fields one by one and then work only
    // with one field. Should I write if for each field separately
    public void firstNameFieldWithDigits() throws InterruptedException, AWTException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
//        if (signInPage.emptyFieldFirstName() == false) {
//            signInPage.deleteValueFirstName();
//        } else if (signInPage.emptyFieldLastName() != true) {
//            signInPage.deleteValueLastName();
//        } else if (signInPage.emptyFieldPassword() == false) {
//            signInPage.deleteValuePassword();
//        } else {
        Assert.assertTrue(signInPage.deleteValueFirstName(), "Verify that FirstName is empty");
        signInPage.inputValueFirstNameDigits();
        signInPage.clickAnyWhere();
        Assert.assertTrue(signInPage.redSign());
    }


    /**
     * Check if the system verifies the correctness of input in the FirstName field
     *
     * @throws InterruptedException
     * @throws AWTException
     */
    @Test //passed
    public void firstNameFieldWithLetters() throws InterruptedException, AWTException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertTrue(signInPage.deleteValueFirstName(), "Verify that FirstName is empty");
            signInPage.inputValueFirstNameLetters();
            signInPage.clickAnyWhere();
            Assert.assertTrue(signInPage.greenSign());
        }

    /**
     * Check if the system verifies the invalid input in the LastName field
     *
     * @throws InterruptedException
     * @throws AWTException
     */
    @Test //passed
    public void lastNameFieldWithDigits() throws InterruptedException, AWTException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertTrue(signInPage.deleteValueLastName(), "Verify that LastName is empty");
            signInPage.inputValueLastNameDigits();
            signInPage.clickAnyWhere();
            Assert.assertTrue(signInPage.redSign());
        }

    /**
     * Check if the system verifies the correctness of input in the LastName field
     *
     * @throws InterruptedException
     * @throws AWTException
     */
    @Test //passed
    public void lastNameFieldWithLetters() throws InterruptedException, AWTException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        Assert.assertTrue(signInPage.deleteValueLastName(), "Verify that LastName is empty");
            signInPage.inputValueLastNameLetters();
            signInPage.clickAnyWhere();
            Assert.assertTrue(signInPage.greenSign());
        }

    /**
     * Check if the system verifies the invalid input in the Email field
     *
     * @throws InterruptedException
     * @throws AWTException
     */
    @Test //passed
    public void emailFieldWithAlphaNumeric() throws InterruptedException, AWTException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        if (signInPage.emptyFieldEmail() == false) {
            signInPage.deleteValueEmail();
        }
        signInPage.inputValueAlphaNumericEmail();
        signInPage.clickAnyWhere();
        Assert.assertTrue(signInPage.redSign());
    }

    @Test //passed
    public void emailFieldWithLetters() throws InterruptedException, AWTException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        if (signInPage.emptyFieldEmail() == false) {
            signInPage.deleteValueEmail();
        }
        signInPage.inputValueAlphaNumericEmail();
        signInPage.clickAnyWhere();
        Assert.assertTrue(signInPage.redSign());
    }

    @Test //passed
    public void emailFieldWithCorrectEmail() throws InterruptedException, AWTException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        if (signInPage.emptyFieldEmail() == false) {
            signInPage.deleteValueEmail();
        }
        signInPage.inputEmailAuthorization();
        signInPage.clickAnyWhere();
        Assert.assertTrue(signInPage.greenSign());
    }

    @Test
    public void firstNameFieldsAreEqual() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPage.inputValueFirstNameLetters();
        Assert.assertEquals(signInPage.valueOfFirstNameOneField(),
                signInPage.valueOfFirstNameTwoField());
        System.out.println("first field" + "\n" + (signInPage.valueOfFirstNameOneField()
                + "\n" + "second field" + "\n" + (signInPage.valueOfFirstNameOneField())));
    }

    @Test
    public void lastNameFieldsAreEqual() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPage.inputValueLastNameLetters();
        Assert.assertEquals(signInPage.valueOfLastNameOneField(),
                signInPage.valueOfLastNameTwoField());
        System.out.println("first field" + "\n" + (signInPage.valueOfLastNameOneField()
                + "\n" + "second field" + "\n" + (signInPage.valueOfLastNameOneField())));
    }

    @Test //passed
    public void companyFieldAllowed() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPage.inputValueFirstNameLetters();
        signInPage.inputValueLastNameLetters();
        signInPage.inputValuePassword("123456");
        signInPage.inputValueAllowedAddress();
        signInPage.inputValueAllowedCity();
        signInPage.statesDropDownOptionByValue();
        signInPage.inputValueAllowedZip();
        signInPage.inputValueAllowedPhone();
        signInPage.inputValueAllowedMobile();

        signInPage.inputValueAllowedCompany();
        signInPage.clickRegisterButton();
        Assert.assertEquals(signInPage.actualUrlFind(), signInPage.MY_ACCOUNT_URL);

        System.out.println("result" + "\n" + (signInPage.actualUrlFind()));
    }

    @Test //passed
    public void customerAccountDisplayed() throws InterruptedException {
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
        signInPage.inputValueAllowedZip();
        signInPage.inputValueAllowedPhone();
        signInPage.inputValueAllowedMobile();

        String actual = signInPage.valueOfFirstNameOneField() + ' ' + signInPage.valueOfLastNameOneField();

        signInPage.clickRegisterButton();
        Thread.sleep(5000);
        Assert.assertTrue(signInPage.customerAccount());
        Assert.assertEquals(actual,
                signInPage.customerAccountText());

    }

    @Test //passed
    public void companyFieldNotAllowed() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPage.inputValueFirstNameLetters();
        signInPage.inputValueLastNameLetters();
        signInPage.inputValuePassword("123456");
        signInPage.inputValueNotAllowedCompany();
        signInPage.inputValueAllowedAddress();
        signInPage.inputValueAllowedCity();
        signInPage.statesDropDownOptionByValue();
        signInPage.inputValueAllowedZip();
        signInPage.inputValueAllowedPhone();
        signInPage.inputValueAllowedMobile();

        signInPage.clickRegisterButton();
        Assert.assertTrue(signInPage.errorInput());
        Assert.assertEquals(signInPage.errorInputIsInvalid(),
                "company is invalid.");
        System.out.println("Company field" + "\n" + (signInPage.errorInputIsInvalid()));
    }

    @Test // Question with stream AQA#28
    public void firstNameFieldNotAllowedError() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);
        signInPage.clickRegisterButton();
        List<String> fullSetOfErrors = signInPage.getListOfOptions("//*[@id='center_column']/div/ol");
        //fullSetOfErrors.forEach(System.out::println);

        List<String> filteredList = new ArrayList<>();
        for(String errors : filteredList) {
            if(errors.contains("firstname"));
            System.out.println(filteredList);
        }


//        Assert.assertTrue(signInPage.errorInput());
//        Assert.assertEquals(signInPage.errorInputIsInvalid(),
//                "company is invalid.");
//        System.out.println("Company field" + "\n" + (signInPage.errorInputIsInvalid()));
    }

    @Test //passed
    public void addressFieldNotAllowed() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPage.inputValueFirstNameLetters();
        signInPage.inputValueLastNameLetters();
        signInPage.inputValuePassword("123456");
        signInPage.inputValueAllowedCompany();
        signInPage.inputValueAllowedCity();
        signInPage.statesDropDownOptionByValue();
        signInPage.inputValueAllowedZip();
        signInPage.inputValueAllowedPhone();
        signInPage.inputValueAllowedMobile();

        signInPage.inputValueNotAllowedAddress();
        signInPage.clickRegisterButton();
        Assert.assertTrue(signInPage.errorInput());
        Assert.assertEquals(signInPage.errorInputIsInvalid(),
                "address1 is invalid.");
        System.out.println("Address field" + "\n" + (signInPage.errorInputIsInvalid()));
    }

    @Test //passed
    public void cityFieldNotAllowed() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPage.inputValueFirstNameLetters();
        signInPage.inputValueLastNameLetters();
        signInPage.inputValuePassword("123456");
        signInPage.inputValueAllowedCompany();
        signInPage.inputValueAllowedAddress();
        signInPage.statesDropDownOptionByValue();
        signInPage.inputValueAllowedZip();
        signInPage.inputValueAllowedPhone();
        signInPage.inputValueAllowedMobile();

        signInPage.inputValueNotAllowedCity();
        signInPage.clickRegisterButton();
        Assert.assertTrue(signInPage.errorInput());
        Assert.assertEquals(signInPage.errorInputIsInvalid(),
                "city is invalid.");
        System.out.println("City field" + "\n" + (signInPage.errorInputIsInvalid()));
    }

    @Test //passed
    public void statesFieldNotAllowed() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPage.inputValueFirstNameLetters();
        signInPage.inputValueLastNameLetters();
        signInPage.inputValuePassword("123456");
        signInPage.inputValueAllowedCompany();
        signInPage.inputValueAllowedAddress();
        signInPage.inputValueAllowedCity();
        signInPage.inputValueAllowedZip();
        signInPage.inputValueAllowedPhone();
        signInPage.inputValueAllowedMobile();

        signInPage.statesDropDownOptionFirst();
        signInPage.clickRegisterButton();
        Assert.assertTrue(signInPage.errorInputRequiresDisplayed());
        Assert.assertEquals(signInPage.errorInputRequires(),
                "This country requires you to choose a State.");
        System.out.println("City field" + "\n" + (signInPage.errorInputRequires()));
    }

    @Test //passed
    public void phoneFieldNotAllowed() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPage.inputValueFirstNameLetters();
        signInPage.inputValueLastNameLetters();
        signInPage.inputValuePassword("123456");
        signInPage.inputValueAllowedCompany();
        signInPage.inputValueAllowedAddress();
        signInPage.statesDropDownOptionByValue();
        signInPage.inputValueAllowedZip();
        signInPage.inputValueAllowedCity();
        signInPage.inputValueAllowedMobile();

        signInPage.inputValueNotAllowedPhone();
        signInPage.clickRegisterButton();
        Assert.assertTrue(signInPage.errorInput());
        Assert.assertEquals(signInPage.errorInputIsInvalid(),
                "phone is invalid.");
        System.out.println("Phone field" + "\n" + (signInPage.errorInputIsInvalid()));
    }

    @Test //passed
    public void phoneFieldsEmpty() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPage.inputValueFirstNameLetters();
        signInPage.inputValueLastNameLetters();
        signInPage.inputValuePassword("123456");
        signInPage.inputValueAllowedCompany();
        signInPage.inputValueAllowedAddress();
        signInPage.inputValueAllowedCity();
        signInPage.statesDropDownOptionByValue();
        signInPage.inputValueAllowedZip();

        signInPage.clickRegisterButton();
        Assert.assertTrue(signInPage.errorInputEmptyField());
        Assert.assertEquals(signInPage.errorInputEmptyFieldError(),
                "You must register at least one phone number.");
        System.out.println("Phone field" + "\n" + (signInPage.errorInputEmptyFieldError()));
    }

    @Test //passed
    public void phoneFieldsEmptyText() throws InterruptedException {
        signInPage.inputEmail().createAnAccountButtonClick();
        Thread.sleep(5000);

        signInPage.clickRegisterButton();
        Assert.assertTrue(signInPage.errorInputEmptyPhoneTextDisplayed());
        Assert.assertEquals(signInPage.errorInputEmptyPhoneText(),
                "You must register at least one phone number.");
        System.out.println("Phone field text" + "\n" + (signInPage.errorInputEmptyPhoneText()));
    }
}
