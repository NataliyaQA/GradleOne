package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pageObjects.objects.ProductObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class SortBy {
    public WebDriver driver;

    //Constants
    public static final String ALERT_ADD_TO_WISHLIST= "You must be logged in to manage your wishlist.";
    public static final String ALERT_ADDED_TO_WISHLIST= "Added to your wishlist.";

    //Constructor
    public SortBy(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    // General create list of elements
    public List<ProductObject> getListOfAllElementsInitial(String xPath) {
        List<ProductObject> products = new ArrayList<>();
        List<WebElement> elementName = driver.findElements(By.xpath(xPath));
        List<String> texts = elementName
                .stream()
                .map(WebElement::getText)
                .collect(toList());

        for (String takeTextOfEach : texts) {
            String getTitleString = Arrays.asList(takeTextOfEach.split("\n")).get(0);
            String getPrice = Arrays.asList(takeTextOfEach.split("\n")).get(1);

            products.add(new ProductObject(getTitleString, convertToFloatPrice(getPrice)));
        }
        System.out.println("**********");
        return products;
    }

    public float convertToFloatPrice(String price) {
        return Float.parseFloat(price
                .replace("$", "")
                .replace("30.51 -5%", "")
                .replace("20.50 -20%", ""));
    }


    //public List<ProductObject> create
    public List<ProductObject> getListOfAllElementsWomenPageInitial() {
        return getListOfAllElementsInitial("//*[@id='center_column']/ul/li");
    }

//    //General create a new list of elements after sorting
//    public List<ProductObject> getListOfAllElementsSecond(String xPath) {
//        List<ProductObject> products2 = new ArrayList<>();
//        List<WebElement> elementName = driver.findElements(By.xpath(xPath));
//        List<String> texts = elementName
//                .stream()
//                .map(WebElement::getText)
//                .collect(toList());
//
//        for (String takeTextOfEach : texts) {
//            List<String> separateItems = Arrays.asList(takeTextOfEach.split("\n"));
//            String getTitleString = separateItems.get(0);
//
//            products2.add(new ProductObject(getTitleString));
//        }
//        System.out.println("**********");
//        products2.stream().forEach(System.out::println);
//        return products2;
//    }
//
    public List<ProductObject> getListOfAllElementsWomenPageSecond() {
        return getListOfAllElementsInitial("//*[@id='center_column']/ul/li");
    }

//    // General create list of elements Price
//    public List<String> getListOfAllElementsPrice(String xPath) {
//        List<WebElement> elementName = driver.findElements(By.xpath(xPath));
//        List<String> texts = elementName
//                .stream()
//                .map(WebElement::getText)
//                .collect(toList());
//        return texts;
//    }
//
//    public List<String> getListOfAllElementsWomenPagePrice() {
//        return getListOfAllElementsInitial("//*[@id='center_column']/ul/li");
//    }

    //General select sort option
    public void selectValueFromDropDown(String xPath, String value) {
        Select dropDown = new Select(driver.findElement(By.xpath(xPath)));
        dropDown.selectByVisibleText(value);
    }

    public void selectValueDropDownPriceLowest() {
        selectValueFromDropDown("//*[@id='selectProductSort']", "Price: Lowest first");
    }

    public void selectValueDropDownPriceHighest() {
        selectValueFromDropDown("//*[@id='selectProductSort']", "Price: Highest first");
    }

    public void selectValueDropDownNameAZ() {
        selectValueFromDropDown("//*[@id='selectProductSort']", "Product Name: A to Z");
    }

    public void selectValueDropDownNameZA() {
        selectValueFromDropDown("//*[@id='selectProductSort']", "Product Name: Z to A");
    }

    public void selectValueDropDownInStock() {
        selectValueFromDropDown("//*[@id='selectProductSort']", "In stock");
    }

    public void selectValueDropDownReferenceOne() {
        selectValueFromDropDown("//*[@id='selectProductSort']", "Reference: Lowest first");
    }

    public void selectValueDropDownReferenceTwo() {
        selectValueFromDropDown("//*[@id='selectProductSort']", "Reference: Highest first");
    }

    //General is enabled
    public boolean elementIsEnabled(String xPath) {
        return driver.findElement(By.xpath(xPath)).isEnabled();
    }

    public boolean viewGridIconIsEnabled() {
       return elementIsEnabled("//i[@class='icon-th-large']");
    }

    public boolean viewListIconIsEnabled() {
       return elementIsEnabled("//i[@class='icon-th-list']");
    }

    public boolean alertAddToWishListIsEnabled() {
       return elementIsEnabled("//p[contains(text(),'You must')]");
    }

    public boolean alertAddedToWishListIsEnabled() {
       return elementIsEnabled("//p[contains(text(),'Added to your wishlist.')]");
    }

    //General is Displayed
    public boolean elementIsDisplayed(String xPath) {
       return driver.findElement(By.xpath(xPath)).isDisplayed();
    }
    public boolean alertAddToWishListIsDisplayed() {
       return elementIsDisplayed("//p[contains(text(),'You must')]");
    }

    //General hover
    public void hoverElement1(String xPath) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(xPath))).perform();
    }

    public void hoverFirstProduct() {
        hoverElement1("//a[contains(text(),'Faded Short Sleeve T-shirts')]");
    }

    public void hoverThirdProduct() {
        hoverElement1("//ul[@id='homefeatured']/li[3]/div/div[2]/h5/a");
    }

    //General click
    public void elementClick(String xPath) {
        driver.findElement(By.xpath(xPath)).click();
    }

    public void addToWishListOneClick() {
        elementClick("//a[@class='addToWishlist wishlistProd_1']");
    }

    public void addToWishListThreeClick() {
        elementClick("//a[@class='addToWishlist wishlistProd_3']");
    }

    public void addToCompareOneClick() {
        elementClick("//a[@class='add_to_compare' and @data-id-product='1']");
    }
    public void addToCompareThreeClick() {
        elementClick("//a[@class='add_to_compare' and @data-id-product='3']");
    }

    public void closeAlertAddToWishListClick() {
        elementClick("//a[@title='Close']");
    }

    public void womenButtonClick() {
        elementClick("//a[@title='Women']/parent::li");
    }
    //General alert
    public String getText(String xPath) {
        return driver.findElement(By.xpath(xPath)).getText();
    }

    public String alertTextWishList() {
        return getText("//p[contains(text(),'You must')]");
    }

    public String alertTextWishListAdded() {
        return getText("//p[contains(text(),'Added to your wishlist.')]");
    }

    public String gerUrl() {
       return driver.getCurrentUrl();
    }
}
