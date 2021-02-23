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

    String expectedHomePageTitle = "My Store";
    String actualTitle;

    public SearchHomePageElements(WebDriver driver) {
     this.driver = driver;

     searchQueryTop = driver.findElement(By.xpath("//input[contains(@class,'search')]")); //
     searchButton = driver.findElement(By.xpath("//input[contains(@class,'search')]/ancestor::div[@class='container']//button")); //

     womenButton = driver.findElement(By.xpath("//a[@title='Women']/parent::li")); //
     womenMenuTopsSubMenu = driver.findElement(By.xpath("//a[@title='Women']/following::a[@title='Tops']")); //
        //a[@title='Dresses']/preceding::a[@title='Tops'], //a[@title='Tops']
//     womenMenuTshirsOption = driver.findElement(By.xpath("//ul[contains(@class,'submenu')]/li//a[@title='T-shirts']"));//
//        //a[@title='Dresses']/preceding::a[@title='T-shirts']
//     womenMenuBlousesOption = driver.findElement(By.xpath("//ul[contains(@class,'submenu')]/li//a[@title='Blouses']"));//
     womenMenuTshirsOption = subMenuTops("T-shirts");
     womenMenuBlousesOption = subMenuTops("Blouses");

     womenMenuDressesSubMenu = driver.findElement(By.xpath("//ul[contains(@class,'submenu')]/li/a[@title='Dresses']")); //
        //a[@title='Dresses']/preceding::a[@title='Dresses'],
        //a[@title='Women']/following::ul[contains(@class,'submenu')]//a[@title='Dresses']
     casualDressesOption = driver.findElement(By.xpath("//a[@title='Women']/following-sibling::ul[contains(@class,'submenu')]//a[@title='Casual Dresses']"));//
     eveningDressesOption = driver.findElement(By.xpath("//a[@title='Women']/following-sibling::ul[contains(@class,'submenu')]//a[@title='Evening Dresses']"));//
     summerDressesOption = driver.findElement(By.xpath("//a[@title='Women']/following-sibling::ul[contains(@class,'submenu')]//a[@title='Summer Dresses']"));//

     dressesButton = driver.findElement(By.xpath("//ul[contains(@class,'sf-menu')]/li/a[@title='Dresses']"));//
     dressesCasualDressesOption = driver.findElement(By.xpath("//a[@title='Dresses']/following::ul[contains(@class,'submenu')]//a[@title='Casual Dresses']")); //
     dressesEveningDressesOption = driver.findElement(By.xpath("//a[@title='Dresses']/following::ul[contains(@class,'submenu')]//a[@title='Evening Dresses']")); //
     dressesSummerDressesOption = driver.findElement(By.xpath("//a[@title='Dresses']/following::ul[contains(@class,'submenu')]//a[@title='Summer Dresses']")); //

     tShirtsButton = driver.findElement(By.xpath("//ul[contains(@class,'sf-menu')]/li/a[@title='T-shirts']"));//

     actualTitle = driver.getTitle();
    }

    public WebElement subMenuTops (String title){
        return driver.findElement(By.xpath("//ul[contains(@class,'submenu')]/li//a[@title='" + title + "']"));
    }

    public SearchHomePageElements clickOnSearchButton () {
        searchButton.click();
        return this;
    }

    public SearchHomePageElements inputText (String searchQuery) {
        searchQueryTop.sendKeys(searchQuery);
        return this;
    }

    public SearchHomePageElements hoverOverElement (WebElement hoverElement) {
        Actions actions = new Actions(driver);

        actions.moveToElement(hoverElement);
        actions.perform();
        return this;
    }

    public SearchHomePageElements hoverWomen () {
        hoverOverElement(womenButton);
        return this;
    }

    public SearchHomePageElements hoverDresses () {
        hoverOverElement(dressesButton);
        return this;
    }

    public SearchHomePageElements clickOnWomenMenuTshirsOption () {
        womenMenuTshirsOption.click();
        return this;
    }

    public SearchHomePageElements clickOnWomenMenuBlousesOption () {
        womenMenuBlousesOption.click();
        return this;
    }

    public SearchHomePageElements clickOnCasualDressesOption () {
        casualDressesOption.click();
        return this;
    }

    public SearchHomePageElements clickOnEveningDressesOption () {
        eveningDressesOption.click();
        return this;
    }

    public SearchHomePageElements clickOnSummerDressesOption () {
        summerDressesOption.click();
        return this;
    }

    public SearchHomePageElements clickOnDressesCasualDressesOption () {
        dressesCasualDressesOption.click();
        return this;
    }

    public SearchHomePageElements clickOnDressesEveningDressesOption () {
        dressesEveningDressesOption.click();
        return this;
    }

    public SearchHomePageElements clickOnDressesSummerDressesOption () {
        summerDressesOption.click();
        return this;
    }

    public SearchHomePageElements clickOnTshirtsButton () {
        tShirtsButton.click();
        return this;
    }

    public String getActualTitle () {
        return actualTitle;
    }

    public String getExpectedTitle() {
        return expectedHomePageTitle;
    }

}
