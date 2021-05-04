package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyOrdersPage{
    public WebDriver driver;

    public static final String ORDER_HISTORY = "ORDER HISTORY";
    public static final String ORDER_HISTORY_TEXT = "Here are the orders you've placed since your account was created.";
    public static final String ORDER_HISTORY_NO_ORDERS = "You have not placed any orders.";
    public static final String ORDER_HISTORY_BACK_TO_ACCOUNT = "Back to your account.";
    public static final String ORDER_HISTORY_HOME_BUTTON = "Home";
    public static final String ORDER_HISTORY_NAVIGATION_PAGE_ONE = "My account";
    public static final String ORDER_HISTORY_NAVIGATION_PAGE_TWO = "Order history";
    public static final String ACCOUNT_URL = "http://automationpractice.com/index.php?controller=my-account";
    public static final String HOME_PAGE_URL = "http://automationpractice.com/index.php";

    //Constructor
    public MyOrdersPage(WebDriver driver) {
        this.driver = driver;
    }

    //General
    public String getName(String xPath) {
        return driver.findElement(By.xpath(xPath)).getText();
    }

    public String orderHistoryNavigationOne() {
        return getName("//div[@class='breadcrumb clearfix']/a[2]");
    }

    public String orderHistoryNavigationTwo() {
        return getName("//span[text()='Order history']");
    }
    public String orderHistoryTitle() {
        return getName("//h1[contains(@class,'page')]");
    }

    public String orderHistoryText() {
        return getName("//p[contains(@class,'info-title')]");
    }
    public String orderHistoryNoOrders() {
        return getName("//p[contains(@class,'alert alert-warning')]");
    }

    public String orderHistoryBackToAccountButton() {
        return getName("//*[@id='center_column']/ul/li[1]/a/span"); //re-write
    }

    public String orderHistoryHomeButton() {
        return getName("//*[text()=' Home']");
    }

    //General isDisplayed
    public boolean isDisplayed(String xPath) {
        return driver.findElement(By.xpath(xPath)).isDisplayed();
    }

    public boolean iconHomeIsDisplayed() {
       return isDisplayed("//i[@class='icon-home']");
    }

    public boolean navigationOneIsDisplayed() {
        return isDisplayed("//div[@class='breadcrumb clearfix']/a[2]");
    }

    public boolean navigationTwoIsDisplayed() {
        return isDisplayed("//span[@class='navigation_page']");
    }

    //General click
    public void clickAction(String xPath) {
        driver.findElement(By.xpath(xPath)).click();
    }

    public void clickHomeIcon() {
        clickAction("//i[@class='icon-home']");
    }

    public void clickNavigationOne() {
        clickAction("//div[@class='breadcrumb clearfix']/a[2]");
    }

    public void clickBackToAccount() {
        clickAction("//a[contains(@href,'my-account')]/span/i"); //re-write
    }

    public void clickHomeButton() {
        clickAction("//*[@id='center_column']/ul/li[2]/a/span"); //re-write
    }

    //General URL
    public String getUrl() {
        return driver.getCurrentUrl();
    }

}
