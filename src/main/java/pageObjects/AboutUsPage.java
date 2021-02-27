package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutUsPage {
    public WebDriver driver;

    WebElement aboutUsLink;
    String expectedLinkName = "About us";
    String actualLinkName;
    String expectedTitle = "About us - My Store";
    String actualTitle;
    String expectedUrl = "http://automationpractice.com/index.php?id_cms=4&controller=cms";
    String actualUrl;

    public AboutUsPage(WebDriver driver) {
        this.driver = driver;

        aboutUsLink = driver.findElement(By.linkText("About us"));

        actualTitle = driver.getTitle();         //get title of About Us page
        actualLinkName = aboutUsLink.getText();  //get name of link
        actualUrl = driver.getCurrentUrl();      //get URL for further comparison
    }

    public AboutUsPage clickAboutUsLink() {
        aboutUsLink.click();
        return this;
    }

    public String getActualTitle() {
        return actualTitle;
    }

    public String getExpectedTitle() {
        return expectedTitle;
    }

    public String getExpectedLinkName() {
        return expectedLinkName;
    }

    public String getActualLinkName() {
        return actualLinkName;
    }

    public String getExpectedUrl() {
        return expectedUrl;
    }

    public String getActualUrl() {
        return actualUrl;
    }
}
