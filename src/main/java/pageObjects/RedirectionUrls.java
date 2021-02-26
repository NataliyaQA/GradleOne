package pageObjects;

import org.openqa.selenium.WebDriver;

public class RedirectionUrls {

    public WebDriver driver;
    String womenPage;
    String womenPageUrl = "http://automationpractice.com/index.php?id_category=3&controller=category";

    String tShirsPage;
    String tShirtsPageUrl = "http://automationpractice.com/index.php?id_category=5&controller=category";

    String womenMenuBlousesOption;
    String blousesPageUrl = "http://automationpractice.com/index.php?id_category=7&controller=category";

    String casualDressesOption;
    String casualDressesPageUrl = "http://automationpractice.com/index.php?id_category=9&controller=category";

    String eveningDressesOption;
    String eveningDressesPageUrl = "http://automationpractice.com/index.php?id_category=10&controller=category";

    String summerDressesOption;
    String summerDressesPageUrl = "http://automationpractice.com/index.php?id_category=11&controller=category";

    String dressesPage;
    String dressesPageUrl = "http://automationpractice.com/index.php?id_category=8&controller=category";

    String externalPage;
    String externalPageUrl = "https://www.prestashop.com/en";

    String logoPage;
    String logoPageUrl = "http://automationpractice.com/index.php";

    public RedirectionUrls(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrlDressesPage() {
        return dressesPage = driver.getCurrentUrl();
    }

    public String dressesPageUrl() {
        return dressesPageUrl;
    }

    public String getUrlBlouses() {
        return womenMenuBlousesOption = driver.getCurrentUrl();
    }

    public String blousesPageUrl() {
        return blousesPageUrl;
    }

    public String getUrlCasualDresses() {
        return casualDressesOption = driver.getCurrentUrl();
    }

    public String casualDressesPageUrl() {
        return casualDressesPageUrl;
    }

    public String getUrlEveningDresses() {
        return eveningDressesOption = driver.getCurrentUrl();
    }

    public String eveningDressesPageUrl() {
        return eveningDressesPageUrl;
    }

    public String getUrlSummerDresses() {
        return summerDressesOption = driver.getCurrentUrl();
    }

    public String summerDressesPageUrl() {
        return summerDressesPageUrl;
    }

    public String getTshirtsPageUrl() {
        return tShirsPage = driver.getCurrentUrl();
    }

    public String tShirtsPageUrl() {
        return tShirtsPageUrl;
    }

    public String getWomenPageUrl() {
        return womenPage = driver.getCurrentUrl();
    }

    public String womenPageUrl() {
        return womenPageUrl;
    }

    public String womenPagePutUrl() {
        driver.get(womenPageUrl); //put URL into browser URL bar
        return womenPage;
    }

    public String getUrlExternalPage() {
        return externalPage = driver.getCurrentUrl();
    }

    public String externalPageURL() {
        return externalPageUrl;
    }

    public String getUrlLogoPage() {
        return logoPage = driver.getCurrentUrl();
    }

    public String logoPageURL() {
        return logoPageUrl;
    }
}
