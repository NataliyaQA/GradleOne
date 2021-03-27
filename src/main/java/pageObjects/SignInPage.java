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

    public static final String INVALID_MESSAGE_ALREADY_REGISTERED_FIRST = "There is 1 error" ;

    public static final String INVALID_EMAIL_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_IS = "Invalid email address.";

    public static final String INVALID_EMAIL_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_EMPTY = "An email address required.";

    public static final String INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_IS = "Invalid password.";

    public static final String INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_EMPTY = "Password is required.";

    public static final String INVALID_PASSWORD_MESSAGE_ALREADY_REGISTERED_SECOND_WHEN_MISMATCHED = "Authentication" +
            " failed.";

    String emailO = "Auto_" + RandomStringUtils.randomAlphabetic(5) + "@mail.com";
    String emailInvalid = "qwe@g";
    String passwordIncorrect = "123";
    String passwordCorrect = "zzz123";

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

    //Overloading
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
}
