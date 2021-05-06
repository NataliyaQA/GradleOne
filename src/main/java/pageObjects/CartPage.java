package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

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
        return isDisplayed("//span[text()='(empty)']");
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

    public void doubleClickElement() {
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
        clickPlusSeveralTimes("//i[@class='icon-plus']");
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
        clickElement("//span[text()='Add to cart']");
    }

    public void clickProductOne() {
        clickElement("//ul[@id='homefeatured']//a[@class='product-name'and contains(@title,'Faded')]");
    }

    public void clickProductTwo() {
        clickElement("//ul[@id='homefeatured']/li[3]/div/div[2]/h5/a");
    }

    public void clickContinueShopping() {
        clickElement("//span[@class='continue btn btn-default button exclusive-medium']");
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
        clickElement("//i[@class='icon-plus']");
    }
    public void clickCrossIconCart() {
        clickElement("//a[@class='ajax_cart_block_remove_link']");
    }

    //General alert
    public String getText(String xPath) {
        return driver.findElement(By.xpath(xPath)).getText();
    }

    public String alertTextAddToCart() {
        return getText("//*[@id='layer_cart']/div[1]");
    }

    public String alertTextThereAreInTheCart() {
        return getText("//span[@class='ajax_cart_product_txt_s  unvisible']");
    }

    //General
    public float textToDigits(String xPath) {
        //DecimalFormat df = new DecimalFormat("#.00");
        return Float.parseFloat(driver.findElement(By.xpath(xPath)).getText()
                .replace("$", ""));
    }

    public float textToDigitsPrice() {
        return textToDigits("//*[@id='our_price_display']");
    }

    public float textToDigitsTotalAddedProduct() {
        return textToDigits("//span[@id='layer_cart_product_price']");
    }

    public float textToDigitsTotalAddedProducts() {
        return textToDigits("//*[@id='layer_cart']/div[1]/div[2]/div[1]/span");
    }
}
