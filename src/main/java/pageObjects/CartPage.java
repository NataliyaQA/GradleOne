package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.ThreadSleep;

import java.awt.*;

public class CartPage {
    public WebDriver driver;

    //Constants
    public final String BUTTON_ADD_TO_CART = "Add to cart";
    public final String THERE_ARE_IN_THE_CART = "There are 6 items in your cart.";
    public final String ADD_TO_CART_MODAL = "Product successfully added to your shopping cart\n" +
            "Faded Short Sleeve T-shirts\n" +
            "Orange, S\n" +
            "Quantity 1\n" +
            "Total $16.51\n" +
            "There is 1 item in your cart.\n" +
            "Total products $16.51\n" +
            "Total shipping  $2.00\n" +
            "Total $18.51\n" +
            "Continue shopping\n" +
            "Proceed to checkout";

    //Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    //Methods

    public void waiterWrapperLocatedBy(String xPath) {
        ThreadSleep.waitForElementLocatedBy(driver, By.xpath(xPath));
    }

    public void waiterWrapperForElement(String xPath) {
        WebElement button = driver.findElement(By.xpath(xPath));
        ThreadSleep.waitForElement(driver, button);
    }

    //General isDisplayed
    public boolean isDisplayed(String xPath) {
        return driver.findElement(By.xpath(xPath)).isDisplayed() ? true : false;
    }

    public boolean fadedShortSleeveTshirtsDisplayed() {
        return isDisplayed("//ul[@id='homefeatured']//a[@class='product-name'and contains(@title,'Faded')]");
    }

    public boolean blouseDisplayed() {
        return isDisplayed("//ul[@id='homefeatured']//a[@class='product-name'and contains(@title,'Blouse')]");
    }

    public boolean printedDressDisplayed() {
        return isDisplayed("//ul[@id='homefeatured']/li[3]/div/div[2]/h5/a");
    }

    public boolean printedDressTwoDisplayed() {
        return isDisplayed("//ul[@id='homefeatured']/li[4]/div/div[2]/h5/a");
    }

    public boolean printedSummerDressDisplayed() {
        return isDisplayed("//ul[@id='homefeatured']/li[5]/div/div[2]/h5/a");
    }

    public boolean printedSummerDressTwoDisplayed() {
        return isDisplayed("//ul[@id='homefeatured']/li[6]/div/div[2]/h5/a");
    }

    public boolean printedChiffonDressDisplayed() {
        return isDisplayed("//ul[@id='homefeatured']//a[@class='product-name'and contains(@title,'Chiffon')]");
    }

    public boolean addToCartDisplayed() {
        return isDisplayed("//*[@id='homefeatured']/li[1]/div/div[2]/div[2]/a[1]/span");
    }

    public boolean cartEmptyDisplayed() {
        String xPath = "//span[text()='(empty)']";
        //waiterWrapperForElement(xPath);
        return isDisplayed(xPath);
    }

    public boolean crossIconDisplayed() {
        return isDisplayed("//a[@class='ajax_cart_block_remove_link']");
    }

    //General hover
    public void hoverElement(String xPath) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(xPath))).perform();
    }

    public void hoverFadedShortSleeve() {
        hoverElement("//a[contains(text(),'Faded Short Sleeve T-shirts')]");
    }

    public void hoverPrintedDress() {
        hoverElement("//ul[@id='homefeatured']/li[3]/div/div[2]/h5/a");
    }

    public void hoverCartDropDown() {
        hoverElement("//a[@title='View my shopping cart']");
    }

    //General double click
    public void doubleClickElement(String xPath) {
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(By.xpath(xPath))).perform();
    }

    public void doubleClickElementFound() {
        doubleClickElement("//i[@class='icon-plus']");
    }

    //General click several times
    public void clickPlusSeveralTimes(String xPath) {
        Actions actions = new Actions(driver);
        int count = 5;
        while(count>0) {
            actions.click(driver.findElement(By.xpath(xPath))).perform();
            count -=1;
        }
    }

    public void clickPlusFive() {
        String xPath = "//i[@class='icon-plus']";
        waiterWrapperForElement(xPath);
        clickPlusSeveralTimes(xPath);
    }

    //General click
    public void clickElement(String xPath) {
        driver.findElement(By.xpath(xPath)).click();
    }

    public void clickAddToCartFirstProduct() {
        clickElement("//*[@id='homefeatured']/li[1]/div/div[2]/div[2]/a[1]/span");
    }
    public void clickAddToCartThirdProduct() {
        clickElement("//*[@id='homefeatured']/li[3]/div/div[2]/div[2]/a[1]/span");
    }

    public void clickAddToCartFromPdp() {
        String xPath = "//span[text()='Add to cart']";
        waiterWrapperForElement(xPath);
        clickElement(xPath);
    }

    public void clickProductOne() {
        clickElement("//ul[@id='homefeatured']//a[@class='product-name'and contains(@title,'Faded')]");
    }

    public void clickProductTwo() {
        clickElement("//ul[@id='homefeatured']/li[3]/div/div[2]/h5/a");
    }

    public void clickContinueShopping() {
        String xPath = "//span[@class='continue btn btn-default button exclusive-medium']";
        waiterWrapperForElement(xPath);
        clickElement(xPath);
    }

    public void clickProceedToCheckout() {
        clickElement("//a[@class='btn btn-default button button-medium']");
    }

    public void clickLogo() {
        clickElement("//img[@class='logo img-responsive']");
    }

    public void clickCrossIcon() {
        clickElement("//span[@class='cross']");
    }

    public void clickContinueShoppingFromCheckout() {
        clickElement("//a[@class='button-exclusive btn btn-default']");
    }

    public void clickPlus() {
        String xPath = "//i[@class='icon-plus']";
        waiterWrapperForElement(xPath);
        clickElement(xPath);
    }

    public void clickCrossIconCart() {
        String xPath = "//a[@class='ajax_cart_block_remove_link']";
        waiterWrapperForElement(xPath);
        clickElement(xPath);
    }

    public void clickAnyWhere() throws AWTException {
        Actions actions = new Actions(driver);
        Robot robot = new Robot();
        robot.mouseMove(50,50);
        actions.click().build().perform();
    }

    //General alert
    public String getText(String xPath) {
        return driver.findElement(By.xpath(xPath)).getText();
    }

    public String alertTextAddToCart() {
        String xPath = "//*[@id='layer_cart']/div[1]";
        waiterWrapperForElement(xPath);
        return getText(xPath);
    }
//
//    public String alertTextThereAreInTheCart() {
//        //String xPath = "//span[@class='ajax_cart_product_txt ']";
//        waiterWrapperForElement("//span[@class='ajax_cart_product_txt ']");
//        return getText("//span[@class='ajax_cart_product_txt ']");
//    }
    public String alertTextThereAreInTheCart() {
        String xPath = "//*[@id='layer_cart']/div[1]/div[2]/h2/span[1]";
        waiterWrapperLocatedBy(xPath);
        return getText(xPath);
    }

//    public String alertTextThereAreInTheCart() {
//        String xPath = "//span[@class='ajax_cart_product_txt ']";
//        AutomationWait.waitVisibleClickable(driver.findElement(By.xpath(xPath)));
//        return getText(xPath);
//    }

    //General
    public float textToDigits(String xPath) {
        //DecimalFormat df = new DecimalFormat("#.00");
        return Float.parseFloat(driver.findElement(By.xpath(xPath)).getText()
                .replace("$", ""));
    }

    public float textToDigitsPrice() {
        String xPath = "//*[@id='our_price_display']";
        waiterWrapperForElement(xPath);
        return textToDigits(xPath);
    }

    public float textToDigitsTotalAddedProduct() {
        String xPath = "//span[@id='layer_cart_product_price']";
        waiterWrapperForElement(xPath);
        return textToDigits(xPath);
    }

    public float textToDigitsTotalAddedProducts() {
        return textToDigits("//*[@id='layer_cart']/div[1]/div[2]/div[1]/span");
    }
}
