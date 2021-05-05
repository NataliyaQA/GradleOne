package com.automationpractice;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.MyAccountPage;

//15 tests

public class AddProductToTheCartTest extends BaseTestAbstractClass {
    String stringUrlMainPage = "http://automationpractice.com/index.php";
    CartPage cartPage;
    MyAccountPage myAccountPage;

    @BeforeMethod
    void setUpMethod() throws InterruptedException {
        driver.get(stringUrlMainPage);
        cartPage = new CartPage(driver);
    }

//    @AfterMethod
//    void signOut() {
//        myAccountPage.signOutButtonClick();
//    }

    @Test
    public void findFadedShortSleeveTshirts() {
        Assert.assertTrue(cartPage.fadedShortSleeveTshirtsDisplayed(), "product is not found");
    }

    @Test
    public void findBlouse() {
        Assert.assertTrue(cartPage.blouseDisplayed(), "product is not found");
    }

    @Test
    public void findPrintedDress() {
        Assert.assertTrue(cartPage.printedDressDisplayed(), "product is not found");
    }

    @Test
    public void findPrintedDressTwo() {
        Assert.assertTrue(cartPage.printedDressTwoDisplayed(), "product is not found");
    }

    @Test
    public void findPrintedSummerDress() {
        Assert.assertTrue(cartPage.printedSummerDressDisplayed(), "product is not found");
    }

    @Test
    public void findPrintedSummerDressTwo() {
        Assert.assertTrue(cartPage.printedSummerDressTwoDisplayed(), "product is not found");
    }

    @Test
    public void findPrintedChiffonDress() {
        Assert.assertTrue(cartPage.printedChiffonDressDisplayed(), "product is not found");
    }

    @Test
        public void addToCartProductFromPlp() throws InterruptedException {
        cartPage.hoverFadedShortSleeve();
        Thread.sleep(5000);

        cartPage.clickAddToCart();
        Thread.sleep(5000);
        Assert.assertEquals(cartPage.alertTextAddToCart(), cartPage.ADD_TO_CART_MODAL);
    }

    @Test
    public void addToCartFromPdp() throws InterruptedException {
        cartPage.clickProductOne();
        Thread.sleep(1000);

        cartPage.clickAddToCartFromPdp();
        Thread.sleep(5000);
        Assert.assertEquals(cartPage.alertTextAddToCart(), cartPage.ADD_TO_CART_MODAL);
    }

    @Test
    public void addToCartFromPdpSix() throws InterruptedException {
        cartPage.clickProductOne();
        Thread.sleep(1000);

        cartPage.clickPlusFive();

        Thread.sleep(5000);
        cartPage.clickAddToCartFromPdp();
        Thread.sleep(7000);
        Assert.assertEquals(cartPage.alertTextThereAreInTheCart(), cartPage.THERE_ARE_IN_THE_CART);
        System.out.println(cartPage.alertTextThereAreInTheCart());
    }

    @Test
    public void priceTwoProducts() throws InterruptedException {
        cartPage.clickProductOne();
        Thread.sleep(1000);

        cartPage.clickPlus();
        Thread.sleep(5000);
        cartPage.clickAddToCartFromPdp();
        Thread.sleep(7000);

        Assert.assertEquals(cartPage.textToDigitsTotalAddedProduct(), cartPage.textToDigitsPrice() * 2);
    }

    @Test //The bug: "Continue Shopping" button does not work
    public void priceTwoDifferentProducts() throws InterruptedException {
        cartPage.clickProductOne();
        Thread.sleep(1000);
        cartPage.clickPlus();
        Thread.sleep(5000);
        float firstPrice = cartPage.textToDigitsPrice() * 2;
        cartPage.clickAddToCartFromPdp();
        Thread.sleep(5000);

        cartPage.clickContinueShopping();
        Thread.sleep(7000);
        cartPage.clickProductTwo();
        Thread.sleep(1000);
        cartPage.clickPlus();
        Thread.sleep(5000);
        float secondPrice = cartPage.textToDigitsPrice() * 2;
        cartPage.clickAddToCartFromPdp();
        Thread.sleep(5000);

        Assert.assertEquals(cartPage.textToDigitsTotalAddedProduct(), (firstPrice + secondPrice));
    }

    @Test
    public void priceTwoDifferentProductsTwo() throws InterruptedException {
        cartPage.clickProductOne();
        Thread.sleep(1000);
        cartPage.clickPlus();
        Thread.sleep(5000);
        float firstPrice = cartPage.textToDigitsPrice() * 2;
        cartPage.clickAddToCartFromPdp();
        Thread.sleep(5000);
        cartPage.clickCrossIcon();

        cartPage.clickLogo();
        Thread.sleep(7000);

        cartPage.clickProductTwo();
        Thread.sleep(1000);
        cartPage.clickPlus();
        Thread.sleep(5000);
        float secondPrice = cartPage.textToDigitsPrice() * 2;
        cartPage.clickAddToCartFromPdp();
        Thread.sleep(5000);
        //System.out.println(cartPage.textToDigitsTotalAddedProducts());

        Assert.assertEquals(cartPage.textToDigitsTotalAddedProducts(), (firstPrice + secondPrice));
    }
}
