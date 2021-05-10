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
    WebElement womenMenuTshirsOption;
    WebElement womenMenuBlousesOption;

    WebElement womenMenuDressesSubMenu;
    WebElement casualDressesOption;
    WebElement eveningDressesOption;
    WebElement summerDressesOption;

    WebElement dressesButton;
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
    String expectedWomenName = "WOMEN";
    String actualWomenMenuTopsSubMenuName;
    String expectedWomenMenuTopsSubMenuName = "TOPS";
    String actualWomenMenuTshirsOptionName;
    String expectedWomenMenuTshirsOptionName = "T-shirts";
    String actualWomenMenuBlousesOptionName;
    String expectedWomenMenuBlousesOptionName = "Blouses";
    String actualWomenMenuDressesSubMenuName;
    String expectedWomenMenuDressesSubMenuName = "DRESSES";
    String actualCasualDressesOptionName;
    String expectedCasualDressesOptionName = "Casual Dresses";
    String actualEveningDressesOptionName;
    String expectedEveningDressesOptionName = "Evening Dresses";
    String actualSummerDressesOptionName;
    String expectedSummerDressesOptionName = "Summer Dresses";

    String actualDressesMenuName;
    String expectedDressesName = "DRESSES";

    String actualTshirtsMenuName;
    String expectedTshirtsName = "T-SHIRTS";

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
        //popularButton = driver.findElement(By.xpath("//a[contains(@class,'homefeatured')]"));
        //bestSellersButton = driver.findElement(By.xpath("//a[contains(@class,'blockbestsellers')]"));

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
        actualDressesMenuName = dressesButton.getText();
        actualTshirtsMenuName = tShirtsButton.getText();
        actualWomenMenuTopsSubMenuName = womenMenuTopsSubMenu.getText();
        actualWomenMenuTshirsOptionName = womenMenuTshirsOption.getText();
        actualWomenMenuBlousesOptionName = womenMenuBlousesOption.getText();
        actualWomenMenuDressesSubMenuName = womenMenuDressesSubMenu.getText();
        actualCasualDressesOptionName = casualDressesOption.getText();
        actualEveningDressesOptionName = eveningDressesOption.getText();
        actualSummerDressesOptionName = summerDressesOption.getText();

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

    public SearchHomePageElements clickAction(WebElement clickElement) {
        clickElement.click();
        return this;
    }

    public SearchHomePageElements clickOnSearchButton() {
        clickAction(searchButton);
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

    public SearchHomePageElements hoverTopsSubMenu() {
        hoverOverElement(womenMenuTopsSubMenu);
        return this;
    }

    public SearchHomePageElements hoverTshirtsSubMenu() {
        hoverOverElement(womenMenuTshirsOption);
        return this;
    }

    public SearchHomePageElements hoverBlousesSubMenu() {
        hoverOverElement(womenMenuBlousesOption);
        return this;
    }

    public SearchHomePageElements hoverDressesSubMenu() {
        hoverOverElement(womenMenuDressesSubMenu);
        return this;
    }

    public SearchHomePageElements hoverWomenCasualDressesOption() {
        hoverOverElement(casualDressesOption);
        return this;
    }

    public SearchHomePageElements hoverWomenEveningDressesOption() {
        hoverOverElement(eveningDressesOption);
        return this;
    }

    public SearchHomePageElements hoverWomenSummerDressesOption() {
        hoverOverElement(summerDressesOption);
        return this;
    }

    public SearchHomePageElements hoverDresses() {
        hoverOverElement(dressesButton);
        return this;
    }

    public SearchHomePageElements hoverDressesCasualDressesOption() {
        hoverOverElement(dressesCasualDressesOption);
        return this;
    }

    public SearchHomePageElements hoverDressesEveningDressesOption() {
        hoverOverElement(dressesEveningDressesOption);
        return this;
    }

    public SearchHomePageElements hoverDressesSummerDressesOption() {
        hoverOverElement(dressesSummerDressesOption);
        return this;
    }

    public SearchHomePageElements hoverTshirts() {
        hoverOverElement(tShirtsButton);
        return this;
    }

    /**
     * method click on the logo
     * @return instance of page (this)
     */
    public SearchHomePageElements clickOnStaticLogo() {
        clickAction(logoButton);
        return this;
    }

    public void clickOnWomenMenuButton() {
        clickAction(womenButton);
    }

    public SearchHomePageElements clickOnWomenMenuTshirsOption() {
        clickAction(womenMenuTshirsOption);
        return this;
    }

    public SearchHomePageElements clickOnWomenMenuBlousesOption() {
        clickAction(womenMenuBlousesOption);
        return this;
    }

    public SearchHomePageElements clickOnCasualDressesOption() {
        clickAction(casualDressesOption);
        return this;
    }

    public SearchHomePageElements clickOnEveningDressesOption() {
        clickAction(eveningDressesOption);
        return this;
    }

    public SearchHomePageElements clickOnSummerDressesOption() {
        clickAction(summerDressesOption);
        return this;
    }

    public SearchHomePageElements clickOnDressesCasualDressesOption() {
        clickAction(dressesCasualDressesOption);
        return this;
    }

    public SearchHomePageElements clickOnDressesEveningDressesOption() {
        clickAction(dressesEveningDressesOption);
        return this;
    }

    public SearchHomePageElements clickOnDressesSummerDressesOption() {
        clickAction(summerDressesOption);
        return this;
    }

    public SearchHomePageElements clickOnDressesButton() {
        clickAction(dressesButton);
        return this;
    }

    public SearchHomePageElements clickOnTshirtsButton() {
        clickAction(tShirtsButton);
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

    public String getActualWomenMenuTopsSubMenuName() {
        return actualWomenMenuTopsSubMenuName;
    }

    public String expectedWomenMenuTopsSubMenuName() {
        return expectedWomenMenuTopsSubMenuName;
    }

    public String getActualWomenMenuTshirsOptionName() {
        return actualWomenMenuTshirsOptionName;
    }

    public String expectedWomenMenuTshirsOptionName() {
        return expectedWomenMenuTshirsOptionName;
    }

    public String getActualWomenMenuBlousesOptionName() {
        return actualWomenMenuBlousesOptionName;
    }

    public String expectedWomenMenuBlousesOptionName() {
        return expectedWomenMenuBlousesOptionName;
    }

    public String getActualWomenMenuDressesSubMenuName() {
        return actualWomenMenuDressesSubMenuName;
    }

    public String expectedWomenMenuDressesSubMenuName() {
        return expectedWomenMenuDressesSubMenuName;
    }

    public String getActualCasualDressesOptionName() {
        return actualCasualDressesOptionName;
    }

    public String expectedCasualDressesOptionName() {
        return expectedCasualDressesOptionName;
    }

    public String getActualEveningDressesOptionName() {
        return actualEveningDressesOptionName;
    }

    public String expectedEveningDressesOptionName() {
        return expectedEveningDressesOptionName;
    }

    public String getActualSummerDressesOptionName() {
        return actualSummerDressesOptionName;
    }

    public String expectedSummerDressesOptionName() {
        return expectedSummerDressesOptionName;
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



    String stringUrl = "http://automationpractice.com/index.php?id_cms=4&controller=cms";

    public void putAboutUsUrl() {
        driver.get(stringUrl);
    }



}
