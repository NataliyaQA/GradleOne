package pageObjects;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
    public WebDriver driver;

    WebElement signInHeaderButton;
    WebElement authenticationSectionTitle;
    WebElement createAnAccountTitle;
    WebElement createAnAccountText;
    WebElement createAnAccountButton;
    WebElement emailAddressFieldCreateAnAccount;
    WebElement errorExistingEmail;
    WebElement alreadyRegisteredTitle;
    WebElement emailAddressFieldAlreadyRegistered;
    WebElement passwordFieldAlreadyRegistered;
    WebElement signInAlreadyRegisteredButton;
    WebElement forgotYourPassword;
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

    public static final String EXPECTED_CREATE_AN_ACCOUNT_TITLE_NAME = "Create an account";

    public static final String EXPECTED_CREATE_AN_ACCOUNT_TEXT = "Please enter your email address to create an account.";

    public static final String EXPECTED_CREATE_AN_ACCOUNT_BUTTON_NAME = "Create an account";

    public static final String EXPECTED_EMAIL_ADDRESS_FIELD_CREATE_AN_ACCOUNT_NAME = "Email address";

    public static final String EXPECTED_ERROR_EXISTING_EMAIL = "An account using this email address has already been " +
            "registered. Please enter a valid password or request a new one.";

    public static final String EXPECTED_ALREADY_REGISTERED_TITLE = "Already registered?";

    public static final String EXPECTED_EMAIL_ADDRESS_FIELD_ALREADY_REGISTERED_NAME = "Email address";

    public static final String EXPECTED_PASSWORD_FIELD_ALREADY_REGISTERED_NAME = "Password";

    public static final String EXPECTED_SIGN_IN_ALREADY_REGISTERED_BUTTON_NAME = "Sign in";

    public static final String EXPECTED_FORGOT_YOUR_PASSWORD_NAME = "Forgot your password?";

    String emailO = "Auto_" + RandomStringUtils.randomAlphabetic(5) + "@mail.com";

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

    public String signInHeaderButtonNameFind(WebDriver driver) {
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
        createAnAccountText = driver.findElement(By.xpath("//h3[contains(text(),'Create')]"));
        return createAnAccountText.getText();
    }

    public String createAnAccountButtonFind(WebDriver driver) {
        createAnAccountButton = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));
        return createAnAccountButton.getText();
    }

    public String emailAddressFieldCreateAnAccountFind(WebDriver driver) {
        emailAddressFieldCreateAnAccount = driver.findElement(By.xpath("//*[@id=\"email_create\"]"));
        return emailAddressFieldCreateAnAccount.getText();
    }

    public String errorMessageIsExist(WebDriver driver) {
        errorExistingEmail = driver.findElement(By.cssSelector("#create_account_error > ol > li"));
        return errorExistingEmail.getText();
    }

    public String alreadyRegisteredTitleFind(WebDriver driver) {
        alreadyRegisteredTitle = driver.findElement(By.xpath("//h3[text()='Already registered?']"));
        return alreadyRegisteredTitle.getText();
    }

    public String emailAddressFieldAlreadyRegisteredFind(WebDriver driver) {
        emailAddressFieldAlreadyRegistered = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        return emailAddressFieldAlreadyRegistered.getText();
    }

    public String passwordFieldAlreadyRegisteredFind(WebDriver driver) {
        passwordFieldAlreadyRegistered = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
        return passwordFieldAlreadyRegistered.getText();
    }

    public String signInAlreadyRegisteredButtonFind(WebDriver driver) {
        signInAlreadyRegisteredButton = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
        return signInAlreadyRegisteredButton.getText();
    }

    public String forgotYourPasswordFind(WebDriver driver) {
        forgotYourPassword = driver.findElement(By.xpath("//p[contains(@class,'lost')]/a"));
        return forgotYourPassword.getText();
    }

    public SignInPage clickSignInHeaderButton() {
        signInHeaderButton = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
        signInHeaderButton.click();
        return this;
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

    //Overloading
    public SignInPage inputEmail(String email) {
        emailAddressFieldCreateAnAccount = driver.findElement(By.xpath("//*[@id='email_create']"));
        emailAddressFieldCreateAnAccount.sendKeys(email);
        return this;
    }
}
