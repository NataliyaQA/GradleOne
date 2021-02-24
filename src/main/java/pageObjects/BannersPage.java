package pageObjects;

import logs.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BannersPage {
    public WebDriver driver;

    WebElement firstBanner;
    WebElement secondBanner;
    WebElement thirdBanner;
    WebElement firstBannerButton;
    WebElement secondBannerButton;
    WebElement thirdBannerButton;
    WebElement rightArrowButton;
    WebElement leftArrowButton;
    WebElement staticBannerOne;
    WebElement staticBannerTwo;
    WebElement staticBannerThree;
    WebElement staticBannerFour;
    WebElement staticBannerFive;
    WebElement staticBannerSix;
    WebElement staticBannerSeven;
    WebElement staticBannerTop;

    String buttonNameOne;
    String buttonNameTwo;
    String buttonNameThree;
    String expectedButtonName = "SHOP NOW !";

    String expectedUrl = "https://www.prestashop.com/en?utm_source=v16_homeslider";
    String currentUrl;

    /**
     * method for search all elements by xPath, getText, getCurrentUrl and for definitions of variables
     * @param driver search for elements
     */
    public BannersPage(WebDriver driver) {
        this.driver = driver;

        firstBanner = driver.findElement(By.xpath("//img[contains(@src,\"sample-1.jpg\")]\n"));
        firstBannerButton = driver.findElement(By.xpath("//img[contains(@src,'sample-1.jpg')]/ancestor::li[@class='homeslider-container']/div//button\n")); //1t banner button

        secondBanner = driver.findElement(By.xpath("//img[contains(@src,\"sample-2.jpg\")]\n")); //2d Carrousel Banner
        secondBannerButton = driver.findElement(By.xpath("//img[contains(@src,'sample-2.jpg')]/ancestor::li[@class='homeslider-container']/div//button\n")); //2d banner button

        thirdBanner = driver.findElement(By.xpath("//img[contains(@src,\"sample-3.jpg\")]\n")); //3d Carrousel Banner
        thirdBannerButton = driver.findElement(By.xpath("//img[contains(@src,'sample-3.jpg')]/ancestor::li[@class='homeslider-container']/div//button\n")); //3d banner button

        rightArrowButton = driver.findElement(By.xpath("//a[@class='bx-next']")); //right arrow button
        leftArrowButton = driver.findElement(By.xpath("//a[@class='bx-prev']")); //left arrow button

        buttonNameOne = firstBannerButton.getText(); //get name of 1st button
        buttonNameTwo = secondBannerButton.getText(); //get name of 2d button
        buttonNameThree = thirdBannerButton.getText(); //get name of 3d button

        staticBannerOne = driver.findElement(By.xpath("//img[contains(@src,'img1')]"));
        staticBannerTwo = driver.findElement(By.xpath("//img[contains(@src,'img2')]"));
        staticBannerThree = driver.findElement(By.xpath("//img[contains(@src,'img3')]"));
        staticBannerFour = driver.findElement(By.xpath("//img[contains(@src,'img4')]"));
        staticBannerFive = driver.findElement(By.xpath("//img[contains(@src,'img5')]"));
        staticBannerSix = driver.findElement(By.xpath("//img[contains(@src,'img6')]"));
        staticBannerSeven = driver.findElement(By.xpath("//img[contains(@src,'img7')]"));
        staticBannerTop = driver.findElement(By.xpath("//img[@class='img-responsive']"));

        currentUrl = driver.getCurrentUrl(); //get URL after redirection
    }

    /**
     * method for element hover
     * @param hoverElement hoverOverElement general
     * @return instance of page (this)
     */
    public BannersPage hoverOverElement (WebElement hoverElement) {
        Log.log("Banner is hovered");
        Actions actions = new Actions(driver);

        actions.moveToElement(hoverElement);
        actions.perform();
        return this;
    }

    /**
     * method for 1st banner button hover
     * @return instance of page
     */
    public BannersPage hoverFirstBannerButton () {
        Log.log("1st banner is hovered");
        hoverOverElement(firstBannerButton);
        return this;
    }

    /**
     * method for 2d banner button hover
     * @return instance of page (this)
     */
    public BannersPage hoverSecondBannerButton () {
        hoverOverElement(secondBannerButton);
        return this;
    }

    /**
     * method for 3d banner button hover
     * @return instance of page (this)
     */
    public BannersPage hoverThirdBannerButton () {
        hoverOverElement(thirdBannerButton);
        return this;
    }

    /**
     * method for all click actions
     * @param clickElement click on elements general
     * @return instance of page (this)
     */
    public BannersPage clickAction (WebElement clickElement) {
        clickElement.click();
        return this;
    }

    /**
     * method for click on 1st banner button action
     * @return instance of page (this)
     */
    public BannersPage clickOnFirstBannerButton() {
        clickAction(firstBannerButton);
        return this;
    }

    /**
     * method for click on 2d banner button action
     * @return instance of page (this)
     */
    public BannersPage clickOnSecondBannerButton() {
        clickAction(secondBannerButton);
        return this;
    }

    /**
     * method for click on 3d banner button action
     * @return instance of page (this)
     */
    public BannersPage clickOnThirdBannerButton() {
        clickAction(thirdBannerButton);
        return this;
    }

    /**
     * method for click on right button action
     * @return instance of page (this)
     */

    public BannersPage clickOnRightArrowButton() {
        clickAction(rightArrowButton);
        return this;
    }

    /**
     * method for click on left button action
     * @return instance of page (this)
     */
    public BannersPage clickOnLeftArrowButton() {
        clickAction(leftArrowButton);
        return this;
    }

    /**
     * method for getting actual name of button on the 1st banner
     * @return instance of page (this)
     */
    public String getButtonNameOne() {
        return buttonNameOne;
    }

    /**
     * method for getting actual name of button on the 2d banner
     * @return instance of page (this)
     */
    public String getButtonNameTwo() {
        return buttonNameTwo;
    }

    /**
     * method for getting actual name of button on the 3d banner
     * @return instance of page (this)
     */
    public String getButtonNameThree() {
        return buttonNameThree;
    }

    /**
     * method for getting expected name of button on the banners
     * @return instance of page (this)
     */
    public String getExpectedButtonName() {
        return expectedButtonName;
    }

    /**
     * method for getting current URL of page
     * @return instance of page (this)
     */
    public String getCurrentUrl() {
        return currentUrl;
    }

    /**
     * method for getting expected URL of page
     * @return instance of page (this)
     */
    public String getExpectedUrl() {
        return expectedUrl;
    }
}


