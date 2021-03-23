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

    String actualTitle;
    String expectedTitle = "Login - My Store";
    String actualUrl;
    String expectedUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    String actualSignInHeaderButtonName;
    String expectedSignInHeaderButtonName = "Sign in";
    String actualAuthenticationSectionTitle;
    String expectedAuthenticationSectionTitle = "Authentication";
    String actualCreateAnAccountTitleName;
    String expectedCreateAnAccountTitleName = "Create an account";
    String actualCreateAnAccountText;
    String expectedCreateAnAccountText = "Please enter your email address to create an account.";
    String actualCreateAnAccountButtonName;
    String expectedCreateAnAccountButtonName = "Create an account";
    String actualEmailAddressFieldCreateAnAccountName;
    String expectedEmailAddressFieldCreateAnAccountName = "Email address";
    String actualAlreadyRegisteredTitle;
    String expectedAlreadyRegisteredTitle = "Already registered?";
    String actualEmailAddressFieldAlreadyRegisteredName;
    String expectedEmailAddressFieldAlreadyRegisteredName = "Email address";
    String actualPasswordFieldAlreadyRegisteredName;
    String expectedPasswordFieldAlreadyRegisteredName = "Password";
    String actualSignInAlreadyRegisteredButtonName;
    String expectedSignInAlreadyRegisteredButtonName = "Sign in";
    String actualForgotYourPasswordName;
    String expectedForgotYourPasswordName = "Forgot your password?";
    //String email;
    String email = "Auto_" + RandomStringUtils.randomAlphabetic(5) + "mail.com";

    public SignInPage(WebDriver driver) {
        this.driver = driver;

        actualTitle = driver.getTitle();                //get title of Sign in page
        actualUrl = driver.getCurrentUrl();             //get URL for further comparison

        signInHeaderButton = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
        actualSignInHeaderButtonName = signInHeaderButton.getText();  //get name of button

        authenticationSectionTitle = driver.findElement(By.xpath("//h1[text()='Authentication']"));
        actualAuthenticationSectionTitle = authenticationSectionTitle.getText();

        createAnAccountTitle = driver.findElement(By.xpath("//h3[text()='Create an account']"));
        actualCreateAnAccountTitleName = createAnAccountTitle.getText();

        createAnAccountText = driver.findElement(By.xpath("//h3[contains(text(),'Create')]"));
        actualCreateAnAccountText = createAnAccountText.getText();

        createAnAccountButton = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));
        actualCreateAnAccountButtonName = createAnAccountButton.getText();

        emailAddressFieldCreateAnAccount = driver.findElement(By.xpath("//*[@id=\"email_create\"]"));
        actualEmailAddressFieldCreateAnAccountName = emailAddressFieldCreateAnAccount.getText();

        alreadyRegisteredTitle = driver.findElement(By.xpath("//h3[text()='Already registered?']"));
        actualAlreadyRegisteredTitle = alreadyRegisteredTitle.getText();

        emailAddressFieldAlreadyRegistered = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        actualEmailAddressFieldAlreadyRegisteredName = emailAddressFieldAlreadyRegistered.getText();

        passwordFieldAlreadyRegistered = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
        actualPasswordFieldAlreadyRegisteredName = passwordFieldAlreadyRegistered.getText();

        signInAlreadyRegisteredButton = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
        actualSignInAlreadyRegisteredButtonName = signInAlreadyRegisteredButton.getText();

        forgotYourPassword = driver.findElement(By.xpath("//p[contains(@class,'lost')]/a"));
        actualForgotYourPasswordName = forgotYourPassword.getText();
    }

    public SignInPage clickSignInHeaderButton() {
        signInHeaderButton.click();
        return this;
    }

    public String getActualTitle() {
        return actualTitle;
    }

    public String expectedTitle() {
        return expectedTitle;
    }

    public String getActualUrl() {
        return actualTitle;
    }

    public String expectedUrl() {
        return expectedUrl;
    }

    public String getActualSignInHeaderButtonName() {
        return actualSignInHeaderButtonName;
    }

    public String expectedSignInHeaderButtonName() {
        return expectedSignInHeaderButtonName;
    }

    public String getActualAuthenticationSectionTitle() {
        return actualAuthenticationSectionTitle;
    }

    public String expectedAuthenticationSectionTitle() {
        return expectedAuthenticationSectionTitle;
    }

    public String getActualCreateAnAccountTitleName() {
        return actualCreateAnAccountTitleName;
    }

    public String expectedCreateAnAccountTitleName() {
        return expectedCreateAnAccountTitleName;
    }

    public String getActualCreateAnAccountText() {
        return actualCreateAnAccountText;
    }

    public String expectedCreateAnAccountText() {
        return expectedCreateAnAccountText;
    }

    public String getActualCreateAnAccountButtonName() {
        return actualCreateAnAccountButtonName;
    }

    public String expectedCreateAnAccountButtonName() {
        return expectedCreateAnAccountButtonName;
    }

    public String getActualEmailAddressFieldCreateAnAccountName() {
        return actualEmailAddressFieldCreateAnAccountName;
    }

    public String expectedEmailAddressFieldCreateAnAccountName() {
        return expectedEmailAddressFieldCreateAnAccountName;
    }

    public String getActualAlreadyRegisteredTitle() {
        return actualAlreadyRegisteredTitle;
    }

    public String expectedAlreadyRegisteredTitle() {
        return expectedAlreadyRegisteredTitle;
    }

    public String getActualEmailAddressFieldAlreadyRegisteredName() {
        return actualEmailAddressFieldAlreadyRegisteredName;
    }

    public String expectedEmailAddressFieldAlreadyRegisteredName() {
        return expectedEmailAddressFieldAlreadyRegisteredName;
    }

    public String getActualPasswordFieldAlreadyRegisteredName() {
        return actualPasswordFieldAlreadyRegisteredName;
    }

    public String expectedPasswordFieldAlreadyRegisteredName() {
        return expectedPasswordFieldAlreadyRegisteredName;
    }

    public String getActualSignInAlreadyRegisteredButtonName() {
        return actualSignInAlreadyRegisteredButtonName;
    }

    public String expectedSignInAlreadyRegisteredButtonName() {
        return expectedSignInAlreadyRegisteredButtonName;
    }

    public String getActualForgotYourPasswordName() {
        return actualForgotYourPasswordName;
    }

    public String expectedForgotYourPasswordName() {
        return expectedForgotYourPasswordName;
    }

    public SignInPage inputEmail(String email) {
            emailAddressFieldCreateAnAccount.sendKeys(email);
            return this;
        }

}
