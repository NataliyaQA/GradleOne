package pageObjects;

import org.openqa.selenium.WebDriver;

public class RedirectionURLs {

    public WebDriver driver;

    String womenMenuTshirsOption;
    String tShirsPageURL = "http://automationpractice.com/index.php?id_category=5&controller=category";

    String womenMenuBlousesOption;
    String blousesPageURL = "http://automationpractice.com/index.php?id_category=7&controller=category";

    String casualDressesOption;
    String casualDressesPageURL = "http://automationpractice.com/index.php?id_category=9&controller=category";

    String eveningDressesOption;
    String eveningDressesPageURL = "http://automationpractice.com/index.php?id_category=10&controller=category";

    String summerDressesOption;
    String summerDressesPageURL = "http://automationpractice.com/index.php?id_category=11&controller=category";

    String tShirtsTab;
    String tShirtsTabURL = "http://automationpractice.com/index.php?id_category=5&controller=category";

    String womenPage;
    String womenPageURL = "http://automationpractice.com/index.php?id_category=3&controller=category";

    String dressesPage;
    String dressesPageURL = "http://automationpractice.com/index.php?id_category=8&controller=category";

    String tShirtsPage;
    String tShirtsPageURL = "http://automationpractice.com/index.php?id_category=5&controller=category";

    String externalPage;
    String externalPageUrl = "https://www.prestashop.com/en?utm_source=v16_homeslider";

    public RedirectionURLs(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrlTshirs() {
        return womenMenuTshirsOption = driver.getCurrentUrl();
    }

    public String tShirsPageURL() {
        return tShirsPageURL;
    }

    public String getUrlBlouses() {
        return womenMenuBlousesOption = driver.getCurrentUrl();
    }

    public String blousesPageURL() {
        return blousesPageURL;
    }

    public String getUrlCasualDresses() {
        return casualDressesOption = driver.getCurrentUrl();
    }

    public String casualDressesPageURL() {
        return casualDressesPageURL;
    }

    public String getUrlEveningDresses() {
        return eveningDressesOption = driver.getCurrentUrl();
    }

    public String eveningDressesPageURL() {
        return eveningDressesPageURL;
    }

    public String getUrlSummerDresses() {
        return summerDressesOption = driver.getCurrentUrl();
    }

    public String summerDressesPageURL() {
        return summerDressesPageURL;
    }

    public String getTshirtsTabURL() {
        return tShirtsTab = driver.getCurrentUrl();
    }

    public String tShirtsTabURL() {
        return tShirtsTabURL;
    }

    public String womenPageURL() {
        driver.get(womenPageURL);
        return womenPage;
    }

    public String getUrlExternalPage() {
        return externalPage = driver.getCurrentUrl();
    }

    public String externalPageURL() {
        return externalPageUrl;
    }
}
