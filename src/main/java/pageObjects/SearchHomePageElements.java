package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchHomePageElements {

    public WebDriver driver;

    WebElement searchQueryTop;
    WebElement searchButton;

    WebElement womenButton;
    WebElement womenMenuTopsSubMenu;
    WebElement womenMenuDressesSubMenu;
    WebElement womenMenuTshirsOption;
    WebElement womenMenuBlousesOption;

    WebElement dressesButton;
    WebElement casualDressesOption;
    WebElement eveningDressesOption;
    WebElement summerDressesOption;

    WebElement dressesCasualDressesOption;
    WebElement dressesEveningDressesOption;
    WebElement dressesSummerDressesOption;

    WebElement tShirtsButton;
    WebElement cartButton;
    WebElement contactUsButton;
    WebElement signInButton;
    WebElement logoButton;
    WebElement popularButton;
    WebElement bestSellersButton;

    String actualWomenMenuName;
    String expectedWomenName;
    String actualDressesMenuName;
    String expectedDressesName;
    String actualTshirtsMenuName;
    String expectedTshirtsName;

    String expectedHomePageTitle = "My Store";
    String expectedWomenPageTitle = "Women - My Store";
    String actualTitle;

    public SearchHomePageElements(WebDriver driver) {
        this.driver = driver;

        searchQueryTop = driver.findElement(By.xpath("//input[contains(@class,'search')]"));
        searchButton = driver.findElement(By.xpath("//input[contains(@class,'search')]" +
                "/ancestor::div[@class='container']//button"));
        cartButton = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
        contactUsButton = driver.findElement(By.xpath("//a[@title='Contact Us']"));
        signInButton = driver.findElement(By.xpath("//a[contains(@title,'Log in')]"));
        logoButton = driver.findElement(By.xpath("//img[contains(@class,'logo')]"));
        popularButton = driver.findElement(By.xpath("//a[contains(@class,'homefeatured')]"));
        bestSellersButton = driver.findElement(By.xpath("//a[contains(@class,'blockbestsellers')]"));

        womenButton = driver.findElement(By.xpath("//a[@title='Women']/parent::li")); //
        womenMenuTopsSubMenu = driver.findElement(By.xpath("//a[@title='Women']/following::a[@title='Tops']"));
        womenMenuTshirsOption = subMenuWomenTops("T-shirts");
        womenMenuBlousesOption = subMenuWomenTops("Blouses");

        womenMenuDressesSubMenu = driver.findElement(By.xpath("//ul[contains(@class,'submenu')]/li" +
                "/a[@title='Dresses']"));
        casualDressesOption = subMenuWomenDresses("Casual Dresses");
        eveningDressesOption = subMenuWomenDresses("Evening Dresses");
        summerDressesOption = subMenuWomenDresses("Summer Dresses");


        dressesButton = driver.findElement(By.xpath("//ul[contains(@class,'sf-menu')]/li/a[@title='Dresses']"));
        dressesCasualDressesOption = subMenuDresses("Casual Dresses");
        dressesEveningDressesOption = subMenuDresses("Evening Dresses");
        dressesSummerDressesOption = subMenuDresses("Summer Dresses");

        tShirtsButton = driver.findElement(By.xpath("//ul[contains(@class,'sf-menu')]/li/a[@title='T-shirts']"));

        actualTitle = driver.getTitle();

        actualWomenMenuName = womenButton.getText();
        expectedWomenName = "Women";

        actualDressesMenuName = dressesButton.getText();
        expectedDressesName = "Dresses";

        actualTshirtsMenuName = tShirtsButton.getText();
        expectedTshirtsName = "T-Shirts";
    }

    public WebElement subMenuWomenTops(String titleOne) {
        return driver.findElement(By.xpath("//ul[contains(@class,'submenu')]/li//a[@title='" + titleOne + "']"));
    }

    public WebElement subMenuWomenDresses(String titleTwo) {
        return driver.findElement(
                By.xpath("//a[@title='Women']/following-sibling::ul[contains(@class,'submenu')]" +
                        "//a[@title='" + titleTwo + "']"));
    }

    public WebElement subMenuDresses(String titleThree) {
        return driver.findElement(By.xpath("//ul[contains(@class,'submenu')]/li/a[@title='" + titleThree + "']"));
    }

    public SearchHomePageElements clickOnSearchButton() {
        searchButton.click();
        return this;
    }

    public SearchHomePageElements inputText(String searchQuery) {
        searchQueryTop.sendKeys(searchQuery);
        return this;
    }

    public SearchHomePageElements hoverOverElement(WebElement hoverElement) {
        Actions actions = new Actions(driver);

        actions.moveToElement(hoverElement);
        actions.perform();
        return this;
    }

    public SearchHomePageElements hoverWomen() {
        hoverOverElement(womenButton);
        return this;
    }

    public SearchHomePageElements hoverDresses() {
        hoverOverElement(dressesButton);
        return this;
    }

    /**
     * method click on the logo
     * @return instance of page (this)
     */
    public SearchHomePageElements clickOnStaticLogo() {
        logoButton.click();
        return this;
    }

    public SearchHomePageElements clickOnWomenMenuButton() {
        womenButton.click();
        return this;
    }

    public SearchHomePageElements clickOnWomenMenuTshirsOption() {
        womenMenuTshirsOption.click();
        return this;
    }

    public SearchHomePageElements clickOnWomenMenuBlousesOption() {
        womenMenuBlousesOption.click();
        return this;
    }

    public SearchHomePageElements clickOnCasualDressesOption() {
        casualDressesOption.click();
        return this;
    }

    public SearchHomePageElements clickOnEveningDressesOption() {
        eveningDressesOption.click();
        return this;
    }

    public SearchHomePageElements clickOnSummerDressesOption() {
        summerDressesOption.click();
        return this;
    }

    public SearchHomePageElements clickOnDressesCasualDressesOption() {
        dressesCasualDressesOption.click();
        return this;
    }

    public SearchHomePageElements clickOnDressesEveningDressesOption() {
        dressesEveningDressesOption.click();
        return this;
    }

    public SearchHomePageElements clickOnDressesSummerDressesOption() {
        summerDressesOption.click();
        return this;
    }

    public SearchHomePageElements clickOnDressesButton() {
        dressesButton.click();
        return this;
    }

    public SearchHomePageElements clickOnTshirtsButton() {
        tShirtsButton.click();
        return this;
    }

    public String getActualTitle() {
        return actualTitle;
    }

    public String getExpectedTitle() {
        return expectedHomePageTitle;
    }

    public String getExpectedWomenPageTitle() {
        return expectedWomenPageTitle;
    }

    public String getActualWomenMenuName() {
        return actualWomenMenuName;
    }

    public String expectedWomenName() {
        return expectedWomenName;
    }

    public String getActualDressesMenuName() {
        return actualDressesMenuName;
    }

    public String expectedDressesName() {
        return expectedDressesName;
    }

    public String getActualTshirtsMenuName() {
        return actualTshirtsMenuName;
    }

    public String expectedTshirtsName() {
        return expectedTshirtsName;
    }
}
