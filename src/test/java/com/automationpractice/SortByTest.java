package com.automationpractice;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.MyAccountPage;
import pageObjects.SortBy;
import pageObjects.objects.ProductObject;
import wrapper.Wrapper;

import java.util.Comparator;
import java.util.List;

public class SortByTest extends BaseTestAbstractClass {
    String stringUrlWomenPage = "http://automationpractice.com/index.php?id_category=3&controller=category";
    SortBy sortBy;
    MyAccountPage myAccountPage;

    @BeforeMethod
    void setUpMethod() throws InterruptedException {
        driver.get(stringUrlWomenPage);
        sortBy = new SortBy(driver);
        myAccountPage = new MyAccountPage(driver);
    }

    @Test //passed
    public void viewGridIconIsEnabled() {
        Assert.assertTrue(sortBy.viewGridIconIsEnabled());
    }

    @Test //failed
    public void viewListIconIsEnabled() {
        Assert.assertFalse(sortBy.viewListIconIsEnabled());
    }

    @Test
    public void addToWishListOneWithoutLogin() {
        sortBy.hoverFirstProduct();
        sortBy.addToWishListOneClick();

        Assert.assertTrue(sortBy.alertAddToWishListIsEnabled());
        Assert.assertEquals(sortBy.alertTextWishList(), sortBy.ALERT_ADD_TO_WISHLIST);
    }

    @Test //Question "no such element"? why isDisplayed does not work
    public void closeToWishListOneWithoutLogin() throws InterruptedException {
        sortBy.hoverFirstProduct();
        sortBy.addToWishListOneClick();

        sortBy.closeAlertAddToWishListClick();
        Thread.sleep(5000);
        //Assert.assertFalse(sortBy.alertAddToWishListIsDisplayed());
        Assert.assertEquals(sortBy.gerUrl(), stringUrlWomenPage);
    }

    @Test
    public void addToWishListOneWithLogin() throws InterruptedException {
        myAccountPage.signInButtonHeaderClick();
        myAccountPage.emailSendKey();
        myAccountPage.passwordSendKey();
        myAccountPage.signInButtonClick();
        Thread.sleep(5000);
        sortBy.womenButtonClick();

        sortBy.hoverFirstProduct();
        sortBy.addToWishListOneClick();

        Assert.assertTrue(sortBy.alertAddedToWishListIsEnabled());
        Assert.assertEquals(sortBy.alertTextWishListAdded(), sortBy.ALERT_ADDED_TO_WISHLIST);
    }

    @Test //Question "no such element"? why isDisplayed does not work
    public void closeToWishListOneWithLogin() throws InterruptedException {
        myAccountPage.signInButtonHeaderClick();
        myAccountPage.emailSendKey();
        myAccountPage.passwordSendKey();
        myAccountPage.signInButtonClick();
        Thread.sleep(5000);
        sortBy.womenButtonClick();

        sortBy.hoverFirstProduct();
        sortBy.addToWishListOneClick();

        sortBy.closeAlertAddToWishListClick();
        Thread.sleep(5000);
        //Assert.assertFalse(sortBy.alertAddToWishListIsDisplayed());
        Assert.assertEquals(sortBy.gerUrl(), stringUrlWomenPage);
    }

    @Test // does not work correctly, failed (real bug), but shows error as:
//    java.lang.AssertionError: Lists differ at element [0]: Faded Short Sleeve T-shirts != Faded Short Sleeve T-shirts
//    Expected :Faded Short Sleeve T-shirts
//    Actual   :Faded Short Sleeve T-shirts
    public void sortProductsNames(){
        List<ProductObject> expected = sortBy.getListOfAllElementsWomenPageInitial();
        sortBy.selectValueDropDownNameAZ();

        Wrapper.getFindFluentWait();

        //expected.sort();
        //expected.stream().sorted(Comparator.comparing(ProductObject::getNameOfProduct)).forEach(System.out::println);

        List<ProductObject> actual = sortBy.getListOfAllElementsWomenPageSecond();

        int getFirstProduct = 0;
        Assert.assertEquals(actual.get(getFirstProduct)
                .getNameOfProduct(), expected.stream()
                .sorted(Comparator.comparing(ProductObject::getNameOfProduct)));
    }

//   @Test // test is executed only if one of the @Override of "Product" class is commented.
//    // There are one for "nameOfProduct" and one for "price"
//    public void sortProductsPrices() throws InterruptedException {
//        List<ProductObject> products = new ArrayList<>();
//        //for (int i=0; i<=texts.length(); i++) //{text.get(i)}
//        for (ProductObject takeTextOfEach : sortBy.getListOfAllElementsWomenPagePrice()) {
//            List<String> separateItems = Arrays.asList(takeTextOfEach.split("\n"));
//            String getPriceString = separateItems.get(1);
//
//            float price = Float.parseFloat(getPriceString
//                    .replace("$", "")
//                    .replace("30.51 -5%", "")
//                    .replace("20.50 -20%", ""));
//
//            products.add(new ProductObject(price));
//        }
//        products.stream().sorted(Comparator.comparing(ProductObject::getPrice))
//                .forEach(System.out::println);
//
//        sortBy.selectValueDropDownPriceLowest();
//        Thread.sleep(5000);
//
//        List<ProductObject> products2 = new ArrayList<>();
//        for (ProductObject takeTextOfEach : sortBy.getListOfAllElementsWomenPagePrice()) {
//            List<String> separateItems = Arrays.asList(takeTextOfEach.split("\n"));
//            String getPriceString = separateItems.get(1);
//
//            float price = Float.parseFloat(getPriceString
//                    .replace("$", "")
//                    .replace("30.51 -5%", "")
//                    .replace("20.50 -20%", ""));
//
//            products2.add(new ProductObject(price));
//        }
//        System.out.println("**********");
//        products2.stream().forEach(System.out::println);
//        Assert.assertEquals(products, products2);
//    }
}

