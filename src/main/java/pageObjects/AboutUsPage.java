package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutUsPage {
    public WebDriver driver;

    WebElement aboutUsLink;
    WebElement returnToHomeButton;

    String actualAboutUsLinkName;
    String expectedLinkName = "About us";
    String actualTitle;
    String expectedTitle = "About us - My Store";
    String actualUrl;
    String expectedUrl = "http://automationpractice.com/index.php?id_cms=4&controller=cms";
    String aboutUs;
    String aboutUsUrl = "http://automationpractice.com/index.php?id_cms=4&controller=cms";
    String actualReturnToHomeButtonName;
    String expectedReturnToHomeButtonName = "Return to home";

    public AboutUsPage(WebDriver driver) {
        this.driver = driver;

        aboutUsLink = driver.findElement(By.xpath("//a[@title='About us']"));
        returnToHomeButton = driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/a"));

        actualTitle = driver.getTitle();                //get title of About Us page
        actualAboutUsLinkName = aboutUsLink.getText();  //get name of link
        actualUrl = driver.getCurrentUrl();             //get URL for further comparison
        actualReturnToHomeButtonName = returnToHomeButton.getText();
    }

    public AboutUsPage clickAboutUsLink() {
        aboutUsLink.click();
        return this;
    }

    public String getActualTitle() {
        return actualTitle;
    }

    public String expectedTitle() {
        return expectedTitle;
    }

    public String getActualLinkName() {
        return actualAboutUsLinkName;
    }

    public String expectedLinkName() {
        return expectedLinkName;
    }

    public String getActualUrl() {
        return actualUrl;
    }

    public String expectedUrl() {
        return expectedUrl;
    }


    public String putAboutUsUrl() {
        driver.get(aboutUsUrl);
        return aboutUs;
    }

    public String getActualReturnToHomeButtonName() {
        return actualReturnToHomeButtonName;
    }

    public String expectedReturnToHomeButtonName() {
        return expectedReturnToHomeButtonName;
    }
}
