package pageObjects;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SignInPage {
    public WebDriver driver;

    WebElement signInHeaderButton;
    WebElement authenticationSectionTitle;
    WebElement createAnAccountTitle;
    WebElement createAnAccountText;
    WebElement createAnAccountButton;
    WebElement emailAddressFieldCreateAnAccount;
    WebElement emailAddressFieldCreateAnAccountTitle;
    WebElement errorExistingEmail;
    WebElement invalidEmailMessageCreateAnAccount;
    WebElement alreadyRegisteredTitle;
    WebElement emailAddressFieldAlreadyRegistered;
    WebElement passwordFieldAlreadyRegistered;
    WebElement signInAlreadyRegisteredButton;
    WebElement forgotYourPassword;
    WebElement invalidMessageAlreadyRegisteredFirst;
    WebElement invalidMessageAlreadyRegisteredSecond;
    WebElement createAnAccountPersonalInfoTitle;
    WebElement yourPersonalInfoSectionTitle;
    WebElement yourPersonalInfoTitle;
    WebElement mrRadioButton;
    WebElement mrsRadioButton;

    WebElement firstNameField;
    WebElement lastNameField;
    WebElement emailField;
    WebElement passwordField;
    WebElement country;

    WebElement registerButton;

    WebElement errorAlert;

    WebElement dropDownDays;

    WebElement signUpCheckBox;
    WebElement offersCheckBox;

    WebElement newsLetterLink;
    WebElement enterYourEmailField;
    WebElement enterYourEmailButton;
    WebElement followUsLink;
    WebElement facebookIcon;
    WebElement twitterIcon;
    WebElement youTubeIcon;
    WebElement gmailIcon;

    String pageTitle;
    String pageUrl;

    public static final String EXPECTED_TITLE = "Login - My Store";
    public static final String EXPECTED_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    public static final String EXPECTED_SIGN_IN_HEADER_BUTTON_NAME = "Sign in";
    public static final String EXPECTED_AUTHENTICATION_SECTION_TITLE = "Authentication";
    public static final String EXPECTED_CREATE_AN_ACCOUNT_TITLE_NAME = "CREATE AN ACCOUNT";
    public static final String EXPECTED_CREATE_AN_ACCOUNT_TEXT = "Please enter your email address to create an account.";
    public static final String EXPECTED_CREATE_AN_ACCOUNT_BUTTON_NAME = "Create an account";
    public static final String EXPECTED_EMAIL_ADDRESS_FIELD_CREATE_AN_ACCOUNT_NAME = "Email address";
    public static final String EXPECTED_ERROR_EXISTING_EMAIL = "An account using this email address has already been " +
            "registered. Please enter a valid password or request a new one.";
    public static final String INVALID_EMAIL = "Invalid email address.";
    public static final String EXPECTED_ALREADY_REGISTERED_TITLE = "ALREADY REGISTERED?";
    public static final String EXPECTED_EMAIL_ADDRESS_FIELD_ALREADY_REGISTERED_NAME = "Email address";
    public static final String EXPECTED_PASSWORD_FIELD_ALREADY_REGISTERED_NAME = "Password";
    public static final String EXPECTED_SIGN_IN_ALREADY_REGISTERED_BUTTON_NAME = "Sign in";
    public static final String EXPECTED_FORGOT_YOUR_PASSWORD_NAME = "Forgot your password?";
    public static final String INVALID_MESSAGE_ALREADY_REGISTERED_FIRST = "There is 1 error";
    public static final String INVALID_EMAIL_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_IS = "Invalid email address.";
    public static final String INVALID_EMAIL_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_EMPTY = "An email address required.";
    public static final String INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_IS = "Invalid password.";
    public static final String INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_EMPTY = "Password is required.";
    public static final String INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_MISMATCHED = "Authentication" +
            " failed.";
    public static final String CREATE_AN_ACCOUNT_PERSONAL_INFO_TITLE = "CREATE AN ACCOUNT";
    public static final String YOUR_PERSONAL_INFO_SECTION_TITLE = "YOUR PERSONAL INFORMATION";
    public static final String YOUR_PERSONAL_INFO_TITLE = "Title";
    public static final String COUNTRY = "Country";


    public static final String FIRSTNAME_FIELD = "First name *";
    public static final String LASTNAME_FIELD = "Last name *";
    public static final String EMAIL_FIELD = "Email *";
    public static final String PASSWORD_FIELD = "Password *";
    public static final String PASSWORD_FIELD_HELP_TEXT = "(Five characters minimum)";
    public static final String DATE_OF_BIRTH_FIELD = "Date of Birth";
    public static final String YOUR_ADDRESS_SECTION = "Your address";
    public static final String COMPANY_FIELD = "Company";
    public static final String ADDRESS_FIELD = "Address *";
    public static final String ADDRESS_HELP_TEXT = "Street address, P.O. Box, Company name, etc.";
    public static final String CITY_FIELD = "City *";
    public static final String COUNTRY_FIELD = "Country *";
    public static final String ADDITIONAL_INFORMATION_FIELD = "Additional information";
    public static final String ADDITIONAL_INFORMATION_HELP_TEXT = "You must register at least one phone number.";
    public static final String HOME_PHONE_FIELD = "Home phone";
    public static final String MOBILE_PHONE_FIELD = "Mobile phone *";
    public static final String ASSIGN_ADDRESS_ALIAS_FIELD = "Assign an address alias for future reference. *";
    public static final String ASSIGN_ADDRESS_ALIAS_VALUE = "My address";

    public static final String REGISTER_BUTTON = "Register";
    public static final String REQUIRED_TEXT = "*Required field";

    boolean displayedStatus;
    boolean enabledStatus;
    boolean selectedStatus;

    String emailO = "Auto_" + RandomStringUtils.randomAlphabetic(5) + "@mail.com";
    String emailInvalid = "qwe@g";
    String passwordIncorrect = "123";
    String passwordCorrect = "zzz123";
//    String textFieldAlphabetic = RandomStringUtils.randomAlphabetic(5);
//    String testFieldAlphaNumeric = RandomStringUtils.randomAlphanumeric(5);
//    String testField = RandomStringUtils.random(15, 6, 10, true, true);

    public static final int[] DROPDOWN_DAYS = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};

    public static final List<String> DROPDOWN_MONTHS = Arrays.asList("-", "January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December");

    public static final int[] DROPDOWN_YEARS = {2021, 2020, 2019, 2018, 2017, 2016, 2015, 2014, 2013, 2012, 2011,
            2010, 2009, 2008, 2007, 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997, 1996, 1995, 1994,
            1993, 1992, 1991, 1990, 1989, 1988, 1987, 1986, 1985, 1984, 1983, 1982, 1981, 1980, 1979, 1978, 1977,
            1976, 1975, 1974, 1973, 1972, 1971, 1970, 1969, 1968, 1967, 1966, 1965, 1964, 1963, 1962, 1961, 1960,
            1959, 1958, 1957, 1956, 1955, 1954, 1953, 1952, 1951, 1950, 1949, 1948, 1947, 1946, 1945, 1944, 1943,
            1942, 1941, 1940, 1939, 1938, 1937, 1936, 1935, 1934, 1933, 1932, 1931, 1930, 1929, 1928, 1927, 1926,
            1925, 1924, 1923, 1922, 1921, 1920, 1919, 1918, 1917, 1916, 1915, 1914, 1913, 1912, 1911, 1910, 1909,
            1908, 1907, 1906, 1905, 1904, 1903, 1902, 1901, 1900};

    public static final String ALERT_ERROR = "There are 10 errors"
            + "\n" + "You must register at least one phone number."
            + "\n" + "lastname is required."
            + "\n" + "firstname is required."
            + "\n" + "email is required."
            + "\n" + "passwd is required."
            + "\n" + "id_country is required."
            + "\n" + "address1 is required."
            + "\n" + "city is required."
            + "\n" + "Country cannot be loaded with address->id_country"
            + "\n" + "Country is invalid";

    public static final String SIGNUP_CHECKBOX = "Sign up for our newsletter!";
    public static final String OFFERS_CHECKBOX = "Receive special offers from our partners!";

    //constructor
    public SignInPage(WebDriver driver) {
        this.driver = driver;
        //emailO = "Auto_" + RandomStringUtils.randomAlphabetic(5) + "@mail.com";
    }

    //methods
    public String actualTitleFind(WebDriver driver) { //get title of Sign in page
        return driver.getTitle();
    }

    public String actualUrlFind(WebDriver driver) {  //get URL for further comparison
        return driver.getCurrentUrl();
    }

    //General getName
    public String getName(String xPath) {
        return driver.findElement(By.xpath(xPath)).getText();
    }

    public String signInHeaderButtonNameFind() {
        return getName("//a[@title='Log in to your customer account']");
    }

    public String authenticationSectionTitleFind() {
        return getName("//h1[text()='Authentication']");
    }

    public String createAnAccountTitleFind() {
        return getName("//h3[text()='Create an account']");
    }

    public String createAnAccountTextFind() {
        return getName("//div[@class='form_content clearfix']" +
                "/p[contains(text(),'Please')]");
    }

    public String createAnAccountButtonFind() {
        return getName("//*[@id='SubmitCreate']/span");
    }

    public String emailAddressFieldCreateAnAccountFind() {
        return getName("//*[@id='email_create']");
    }

    public String emailAddressFieldCreateAnAccountTitle() {
        return getName("//*[@id='create-account_form']" +
                "//child::div[2]/label");
    }

    public String errorMessageIsExist() {
        return getName("//div[@id='create_account_error']/ol/li");
    }

    public String invalidEmail() {
        return getName("//li[text()='Invalid email address.']");
    }

    public String alreadyRegisteredTitleFind() {
        return getName("//h3[text()='Already registered?']");
    }

    public String emailAddressFieldAlreadyRegisteredFind() {
        return getName("//*[@id='email']");
    }

    public String emailAddressFieldAlreadyRegisteredTitle() {
        return getName("//*[@id='login_form']//child::div[1]/label");
    }

    public String passwordFieldAlreadyRegisteredFind() {
        return getName("//*[@id='passwd']");
    }

    public String passwordFieldAlreadyRegisteredName() {
        return getName("//*[@id='login_form']/div/div[2]/label");
    }

    public String signInAlreadyRegisteredButtonFind() {
        return getName("//*[@id='SubmitLogin']/span");
    }

    public void signInAlreadyRegisteredButtonClick() {
        clickAction("//*[@id='SubmitLogin']/span");
    }

    public String forgotYourPasswordFind() {
        return getName("//p[contains(@class,'lost')]/a");
    }

    public void clickSignInHeaderButton() {
        clickAction("//a[@title='Log in to your customer account']");
    }

    public void createAnAccountButtonClick() {
        clickAction("//*[@id='SubmitCreate']/span");
    }

    public SignInPage inputEmail() {
        emailAddressFieldCreateAnAccount = driver.findElement(By.xpath("//*[@id='email_create']"));
        emailAddressFieldCreateAnAccount.sendKeys(emailO);
        return this;
    }

    public SignInPage inputEmailCreateAnAccount(String email) {
        emailAddressFieldCreateAnAccount = driver.findElement(By.xpath("//*[@id='email_create']"));
        emailAddressFieldCreateAnAccount.sendKeys(email);
        return this;
    }

    public SignInPage inputEmailInvalidCreateAnAccount() {
        emailAddressFieldCreateAnAccount = driver.findElement(By.xpath("//*[@id='email_create']"));
        emailAddressFieldCreateAnAccount.sendKeys(emailInvalid);
        return this;
    }

    public SignInPage inputEmailInvalidAlreadyRegistered() {
        emailAddressFieldAlreadyRegistered = driver.findElement(By.xpath("//*[@id='email']"));
        emailAddressFieldAlreadyRegistered.sendKeys(emailInvalid);
        return this;
    }

    public SignInPage inputEmailAlreadyRegistered(String email) {
        emailAddressFieldAlreadyRegistered = driver.findElement(By.xpath("//*[@id='email']"));
        emailAddressFieldAlreadyRegistered.sendKeys(email);
        return this;
    }

    //Overloading
    public SignInPage inputPasswordAlreadyRegistered(String password) {
        passwordFieldAlreadyRegistered = driver.findElement(By.xpath("//*[@id='passwd']"));
        passwordFieldAlreadyRegistered.sendKeys(password);
        return this;
    }

    public SignInPage inputPasswordAlreadyRegistered() {
        passwordFieldAlreadyRegistered = driver.findElement(By.xpath("//*[@id='passwd']"));
        passwordFieldAlreadyRegistered.sendKeys();
        return this;
    }

    public SignInPage inputPasswordInvalidAlreadyRegistered() {
        passwordFieldAlreadyRegistered = driver.findElement(By.xpath("//*[@id='passwd']"));
        passwordFieldAlreadyRegistered.sendKeys(passwordIncorrect);
        return this;
    }

    public String invalidMessageAlreadyRegisteredFirstText() {
        return getName("//div[@class='alert alert-danger']/p");
    }

    public String invalidMessageAlreadyRegisteredSecondText() {
        return getName("//div[@id='center_column']//child::li");
    }

    public String createAnAccountPersonalInfoTitle() {
        return getName("//h1[text()='Create an account']");
    }

    public String yourPersonalInfoSectionTitle() {
        return getName("//h3[text()='Your personal information']");
    }

    public String yourPersonalInfoTitle() {
        return getName("//div[@class='clearfix']/label");
    }

    //General isDisplayed
    public Boolean isDisplayed(WebElement webElement) {
        displayedStatus = webElement.isDisplayed();
        return displayedStatus;
    }

    public Boolean mrRadioButtonDisplayed() {
        return isDisplayed(driver.findElement(By.xpath("//label[@for='id_gender1']")));
    }

    public Boolean mrsRadioButtonDisplayed() {
        return isDisplayed(driver.findElement(By.xpath("//label[@for='id_gender2']")));
        //the same
//        mrsRadioButton = driver.findElement(By.xpath("//*[@id='id_gender2']"));
//        Boolean displayed = isDisplayed(mrsRadioButton);
//        return displayed;
    }

    //General isEnabled
//    public Boolean isEnabled(WebElement webElement) {
////        enabledStatus = webElement.isEnabled();
////        return enabledStatus; //the same "return true;"
////        if (webElement.isEnabled()) {
////            return true;
////        }
////        else return false;
//
//        return (webElement.isEnabled()) ? true : false;
//    }

    public boolean isEnabled(String xPath) {
        return (driver.findElement(By.xpath(xPath)).isEnabled()) ? true : false;
    }

    public Boolean mrRadioButtonEnabled() {
        return isEnabled("//*[@id='id_gender1']");
    }

    public Boolean mrsRadioButtonEnabled() {
        return isEnabled("//*[@id='id_gender2']");
    }

    public Boolean signUpCheckBox() {
        return isEnabled("//div[@id='uniform-newsletter']");
    }

    public Boolean offersCheckBox() {
        return isEnabled("//*[@id='optin']");
    }

    public String signUpCheckBoxName() {
        //String xPath = "//*[@id='account-creation_form']/div[1]/div[7]/label"; //the same
        //String xPath = "//*[@id='account-creation_form']/div[1]/div[7]"; //the same
        //String xPath = "//div[@class='checkbox']"; //the sme to the next
        return getName("//div[@class='checkbox']");
    }

    public String offersCheckBoxName() {
        //String xPath = "//*[@id='account-creation_form']/div[1]/div[7]/label"; //the same
        //String xPath = "//*[@id='account-creation_form']/div[1]/div[7]"; //the same
        //String xPath = "//div[@class='checkbox']"; //the sme to the next
        return getName("//label[@for='optin']");
    }

    //General click
    public void clickAction(String xPath) {
        WebElement clickElement = driver.findElement(By.xpath(xPath));
        clickElement.click();
    }

    public void clickMrRadioButton() {
        clickAction("//*[@id='id_gender1']");
    }

    public void clickMrsRadioButton() {
        clickAction("//*[@id='id_gender2']");
    }

    public void clickSignUpCheckBox() {
        clickAction("//*[@id='uniform-newsletter']");
    }

    public void clickOffersCheckBox() {
        clickAction("//*[@id='optin']");
    }

    //General selectedStatus
    public boolean selectedStatus(WebElement webElement) {
        selectedStatus = webElement.isSelected();
        return selectedStatus;
    }

    public boolean selectedStatusMr() {
        return selectedStatus(driver.findElement(By.xpath("//*[@id='id_gender1']")));
    }

    public boolean selectedStatusMrs() {
        return selectedStatus(driver.findElement(By.xpath("//*[@id='id_gender2']")));
    }

    public boolean selectedSignUpCheckBox() {
        return selectedStatus(driver.findElement(By.xpath("//*[@id='uniform-newsletter']")));
    }

    public boolean selectedOffersCheckBox() {
        return selectedStatus(driver.findElement(By.xpath("//*[@id='optin']")));
    }

    //General
    public int[] generalDropDownInt(String xPath) {
        //Find the dropdown element by xPath
        Select select = new Select(driver.findElement(By.xpath(xPath)));
        //Get list of web elements
        List<WebElement> list = select.getOptions();
        list.remove(0);
        List<Integer> bufferListStringToInteger = new ArrayList<>();
        for (WebElement optionOfDropDown : list) {
            bufferListStringToInteger.add(Integer.parseInt(optionOfDropDown.getText()
                    .replaceAll("&nbsp;", "").trim()));
        }
        int[] dropDown = bufferListStringToInteger.stream().mapToInt(i -> i).toArray();
        return dropDown;
    }

    public int[] dropDownDaysAllOptions() {
        return generalDropDownInt("//*[@id='days']");
    }

    public SignInPage selectDropDownDaysOptionByValue() {
        Select select = new Select(driver.findElement(By.xpath("//*[@id='days']")));
        select.selectByValue("6");
        select.getFirstSelectedOption().getText();
        return this;
    }

    public int[] dropDownYearsAllOptions() {
        return generalDropDownInt("//*[@id='years']");
    }

    //General
    public List<String> generalConverterWebElementToList(String xPath) {
        List<WebElement> list = new Select(driver.findElement(By.xpath(xPath))).getOptions();
        List<String> listString = new ArrayList<>();
        for (WebElement optionsOfDropDown : list) {
            listString.add(optionsOfDropDown.getText()
                    .replaceAll("&nbsp;", "").trim());
        }
        return listString;
    }

    public List<String> dropDownMonthsAllOptions() {
        return generalConverterWebElementToList("//*[@id='months']");
    }

    public void clickRegisterButton() {
        clickAction("//button[@id='submitAccount']");
    }

    //General
    public boolean emptyField(String xPath) {
        if (driver.findElement(By.xpath(xPath)).getAttribute("value").isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean emptyFieldEmail() {
        return emptyField("//*[@id='email']");
    }

    public boolean emptyFieldFirstName() {
        return emptyField("//*[@id='customer_firstname']");
    }

    public boolean emptyFieldLastName() {
        return emptyField("//*[@id='customer_lastname']");
    }

    public boolean emptyFieldPassword() {
        return emptyField("//*[@id='passwd']");
    }

    public String valueOfEmailFieldHomePage() {
        return driver.findElement(By.xpath("//*[@id='email_create']"))
                .getAttribute("value");
    }

    public String valueOfEmailField() {
        return driver.findElement(By.xpath("//*[@id='email']")).getAttribute("value");
    }

    //General
    public void deleteValue(String xPath) {
        driver.findElement(By.xpath(xPath)).clear();
    }

    public void deleteValueEmail() {
        deleteValue("//*[@id='email']");
    }

    public void deleteValueFirstName() {
        deleteValue("//*[@id='customer_firstname']");
    }

    public void deleteValueLastName() {
        deleteValue("//*[@id='customer_lastname']");
    }

    public void deleteValuePassword() {
        deleteValue("//*[@id='passwd']");
    }

    public void countryDropDownFirstOption() {
        Actions action = new Actions(driver);
        country = driver.findElement(By.xpath("//*[@id='id_country']"));
        action.moveToElement(country).build().perform();
        country.click();

        Select select = new Select(country);
        select.selectByIndex(0);
    }

    public WebElement errorAlert() {
        return driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
    }

    // is not verified
    public String alertText(WebElement errorAlert) {
        Alert confirmation = driver.switchTo().alert();
        String alertText = confirmation.getText();
        return alertText;
    }

    public String firstNameFieldOneName() {
        return getName("//label[@for='customer_firstname']");
    }

    public String firstNameFieldTwoName() {
        return getName("//label[@for='firstname']");
    }

    public String lastNameFieldTOneName() {
        return getName("//label[@for='customer_lastname']");
    }

    public String lastNameFieldTwoName() {
        return getName("//label[@for='lastname']");
    }

    public String emailFieldName() {
        return getName("//label[@for='email']");
    }

    public String passwordFieldName() {
        return getName("//label[@for='passwd']");
    }

    public String passwordFieldHelpText() {
        return getName("//span[contains(text(),'(Five')]");
    }

    public String dateOfBirthFieldName() {
        return getName("//label[contains(text(),'Date of Birth')]");
    }

    public String yourAddressSectionName() {
        return getName("//*[text()='Your address']");
    }

    public String companyFieldName() {
        return getName("//label[@for='company']");
    }

    public String addressFieldName() {
        return getName("//label[@for='address1']");
    }

    public String addressFieldHelpText() {
        return getName("//span[contains(text(),'Street')]");
    }

    public String cityFieldName() {
        return getName("//label[@for='city']");
    }

    public String countryFieldName() {
        return getName("//label[@for='id_country']");
    }

    public String additionalInfoFieldName() {
        return getName("//label[@for='other']");
    }

    public String additionalInfoHelpText() {
        return getName("//p[contains(text(),'You must')]");
    }

    public String homePhoneFieldName() {
        return getName("//label[@for='phone']");
    }

    public String mobilePhoneFieldName() {
        return getName("//label[@for='phone_mobile']");
    }

    public String assignAliasFieldName() {
        return getName("//label[@for='alias']");
    }

    public String assignAliasFieldValue() {
        return driver.findElement(By.xpath("//*[@id='alias']")).getAttribute("value");
    }

    public String registerButtonName() {
        return getName("//button[@id='submitAccount']");
    }

    public String requiredText() {
        return getName("//span[text()='Required field']");
    }

    public void inputValueFirstName(String value) {
        firstNameField = driver.findElement(By.xpath("//*[@id='customer_firstname']"));
        firstNameField.sendKeys(value);
    }

    public void inputValueLastName(String value) {
        lastNameField = driver.findElement(By.xpath("//*[@id='customer_lastname']"));
        lastNameField.sendKeys(value);
    }

    public void inputValuePassword(String value) {
        passwordField = driver.findElement(By.xpath("//*[@id='passwd']"));
        passwordField.sendKeys(value);
    }

    public void clickAnyWhere() throws AWTException {
        Actions actions = new Actions(driver);
        Robot robot = new Robot();
        robot.mouseMove(50,50);
        actions.click().build().perform();
    }

}
