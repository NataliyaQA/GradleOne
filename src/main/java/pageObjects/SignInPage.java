package pageObjects;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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


//    public static final String FIRSTNAME_FIELD = "First name";
//    public static final String LASTNAME_FIELD = "Last name";
//    public static final String EMAIL_FIELD = "Email";
//    public static final String PASSWORD_FIELD = "Password";

    public static final String REGISTER_BUTTON = "Register";

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

    //"1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31";

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
            + "\n" +"You must register at least one phone number."
            + "\n" + "lastname is required."
            + "\n" + "firstname is required."
            + "\n" + "email is required."
            + "\n" + "passwd is required."
            + "\n" + "id_country is required."
            + "\n" + "address1 is required."
            + "\n" + "city is required."
            + "\n" + "Country cannot be loaded with address->id_country"
            + "\n" + "Country is invalid";

    //constructor
    public SignInPage(WebDriver driver) {
        this.driver = driver;

        //emailO = "Auto_" + RandomStringUtils.randomAlphabetic(5) + "@mail.com";
    }

    //methods
    public String actualTitleFind(WebDriver driver) { //get title of Sign in page
        pageTitle = driver.getTitle();
        return pageTitle;
    }

    public String actualUrlFind(WebDriver driver) {  //get URL for further comparison
        pageUrl = driver.getCurrentUrl();
        return pageUrl;
    }

    public String signInHeaderButtonNameFind() {
        signInHeaderButton = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
        return signInHeaderButton.getText();
    }

    public String authenticationSectionTitleFind(WebDriver driver) {
        authenticationSectionTitle = driver.findElement(By.xpath("//h1[text()='Authentication']"));
        return authenticationSectionTitle.getText();
    }

    public String createAnAccountTitleFind(WebDriver driver) {
        createAnAccountTitle = driver.findElement(By.xpath("//h3[text()='Create an account']"));
        return createAnAccountTitle.getText();
    }

    public String createAnAccountTextFind(WebDriver driver) {
        createAnAccountText = driver.findElement(By.xpath("//div[@class='form_content clearfix']" +
                "/p[contains(text(),'Please')]"));
        return createAnAccountText.getText();
    }

    public String createAnAccountButtonFind(WebDriver driver) {
        createAnAccountButton = driver.findElement(By.xpath("//*[@id='SubmitCreate']/span"));
        return createAnAccountButton.getText();
    }

    public String emailAddressFieldCreateAnAccountFind(WebDriver driver) {
        emailAddressFieldCreateAnAccount = driver.findElement(By.xpath("//*[@id='email_create']"));
        return emailAddressFieldCreateAnAccount.getText();
    }

    public String emailAddressFieldCreateAnAccountTitle(WebDriver driver) {
        emailAddressFieldCreateAnAccountTitle = driver.findElement(By.xpath("//*[@id='create-account_form']" +
                "//child::div[2]/label"));
        return emailAddressFieldCreateAnAccountTitle.getText();
    }

    public String errorMessageIsExist(WebDriver driver) {
        errorExistingEmail = driver.findElement(By.cssSelector("#create_account_error > ol > li"));
        return errorExistingEmail.getText();
    }

    public String invalidEmail(WebDriver driver) {
        invalidEmailMessageCreateAnAccount = driver.findElement(By.xpath("//li[text()='Invalid email address.']"));
        return invalidEmailMessageCreateAnAccount.getText();
    }

    public String alreadyRegisteredTitleFind(WebDriver driver) {
        alreadyRegisteredTitle = driver.findElement(By.xpath("//h3[text()='Already registered?']"));
        return alreadyRegisteredTitle.getText();
    }

    public String emailAddressFieldAlreadyRegisteredFind(WebDriver driver) {
        emailAddressFieldAlreadyRegistered = driver.findElement(By.xpath("//*[@id='email']"));
        return emailAddressFieldAlreadyRegistered.getText();
    }

    public String emailAddressFieldAlreadyRegisteredTitle(WebDriver driver) {
        emailAddressFieldAlreadyRegistered = driver.findElement(By.xpath("//*[@id='login_form']//child::div[1]/label"));
        return emailAddressFieldAlreadyRegistered.getText();
    }

    public String passwordFieldAlreadyRegisteredFind(WebDriver driver) {
        passwordFieldAlreadyRegistered = driver.findElement(By.xpath("//*[@id='passwd']"));
        return passwordFieldAlreadyRegistered.getText();
    }

    public String passwordFieldAlreadyRegisteredName(WebDriver driver) {
        passwordFieldAlreadyRegistered = driver.findElement(By.xpath("//*[@id=\"login_form\"]/div/div[2]/label"));
        return passwordFieldAlreadyRegistered.getText();
    }

    public String signInAlreadyRegisteredButtonFind(WebDriver driver) {
        signInAlreadyRegisteredButton = driver.findElement(By.xpath("//*[@id='SubmitLogin']/span"));
        return signInAlreadyRegisteredButton.getText();
    }

    public void signInAlreadyRegisteredButtonClick() {
        signInAlreadyRegisteredButton = driver.findElement(By.xpath("//*[@id='SubmitLogin']/span"));
        signInAlreadyRegisteredButton.click();
    }

    public String forgotYourPasswordFind(WebDriver driver) {
        forgotYourPassword = driver.findElement(By.xpath("//p[contains(@class,'lost')]/a"));
        return forgotYourPassword.getText();
    }

    public void clickSignInHeaderButton() {
        signInHeaderButton = driver.findElement(By.xpath("//a[@title='Log in to your customer account']")); //
        signInHeaderButton.click();
    }

    public SignInPage createAnAccountButtonClick() {
        createAnAccountButton = driver.findElement(By.xpath("//*[@id='SubmitCreate']/span"));
        createAnAccountButton.click();
        return this;
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

    public String invalidMessageAlreadyRegisteredFirstText(WebDriver driver) {
        invalidMessageAlreadyRegisteredFirst = driver.findElement(By.xpath("//div[@class='alert alert-danger']/p"));
        return invalidMessageAlreadyRegisteredFirst.getText();
    }

    public String invalidMessageAlreadyRegisteredSecondText(WebDriver driver) {
        invalidMessageAlreadyRegisteredSecond = driver.findElement(By.xpath("//div[@id='center_column']//child::li"));
        return invalidMessageAlreadyRegisteredSecond.getText();
    }

    public String createAnAccountPersonalInfoTitle(WebDriver driver) {
        createAnAccountPersonalInfoTitle = driver.findElement(By.xpath("//h1[text()='Create an account']"));
        return createAnAccountPersonalInfoTitle.getText();
    }

    public String yourPersonalInfoSectionTitle() {
        yourPersonalInfoSectionTitle = driver.findElement(By.xpath("//h3[text()='Your personal information']"));
        return yourPersonalInfoSectionTitle.getText();
    }

    public String yourPersonalInfoTitle() {
        yourPersonalInfoTitle = driver.findElement(By.xpath("//div[@class='clearfix']/label"));
        return yourPersonalInfoTitle.getText();
    }

    //General
    public Boolean isDisplayed(WebElement webElement) {
        displayedStatus = webElement.isDisplayed();
        return displayedStatus;
    }

    public Boolean mrRadioButtonDisplayed() {
        mrRadioButton = driver.findElement(By.xpath("//*[@id='id_gender1']"));
        Boolean displayed = isDisplayed(mrRadioButton);
        return displayed;
    }

    public Boolean mrsRadioButtonDisplayed() {
        mrsRadioButton = driver.findElement(By.xpath("//*[@id='id_gender2']"));
        Boolean displayed = isDisplayed(mrsRadioButton);
        return displayed;
    }

    //General
    public Boolean isEnabled(WebElement webElement) {
        enabledStatus = webElement.isEnabled();
        return enabledStatus;
    }

    public Boolean mrRadioButtonEnabled() {
        mrRadioButton = driver.findElement(By.xpath("//*[@id='id_gender1']"));
        Boolean enabled = isEnabled(mrRadioButton);
        return enabled;
    }

    public Boolean mrsRadioButtonEnabled() {
        mrsRadioButton = driver.findElement(By.xpath("//*[@id='id_gender2']"));
        Boolean enabled = isEnabled(mrsRadioButton);
        return enabled;
    }

    //General
    public void clickAction(WebElement clickElement) {
        clickElement.click();
    }

    public void clickMrRadioButton() {
        mrRadioButton = driver.findElement(By.xpath("//*[@id='id_gender1']"));
        clickAction(mrRadioButton);
    }

    public void clickMrsRadioButton() {
        mrsRadioButton = driver.findElement(By.xpath("//*[@id='id_gender2']"));
        clickAction(mrsRadioButton);
    }

    //General
    public Boolean selectedStatus(WebElement webElement) {
        selectedStatus = webElement.isSelected();
        return selectedStatus;
    }

    public Boolean selectedStatusMr() {
        mrRadioButton = driver.findElement(By.xpath("//*[@id='id_gender1']"));
        Boolean status = selectedStatus(mrRadioButton);
        return status;
    }

    public Boolean selectedStatusMrs() {
        mrsRadioButton = driver.findElement(By.xpath("//*[@id='id_gender2']"));
        Boolean status = selectedStatus(mrsRadioButton);
        return status;
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
        registerButton = driver.findElement(By.xpath("//button[@id='submitAccount']"));
        clickAction(registerButton);
    }

    public boolean emptyField() {
        emailField = driver.findElement(By.xpath("//*[@id='email']"));
        if (emailField.getAttribute("value").isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public String valueOfEmailFieldHomePage() {
        emailField = driver.findElement(By.xpath("//*[@id='email_create']"));
        String value = emailField.getAttribute("value");
        return value;
    }

    public String valueOfEmailField() {
        emailField = driver.findElement(By.xpath("//*[@id='email']"));
        String value = emailField.getAttribute("value");
        return value;
    }

    public void deleteValue() {
        emailField = driver.findElement(By.xpath("//*[@id='email']"));
        emailField.clear();
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
        errorAlert = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
        return errorAlert;
    }

    // is not verified
    public String alertText(WebElement errorAlert) {
        Alert confirmation = driver.switchTo().alert();
        String alertText = confirmation.getText();
        return alertText;
    }
}

