package com.automationpractice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.MyAccountPage;
import pageObjects.SortBy;
import pageObjects.WishListPage;

public class WishListTest extends BaseTestAbstractClass{
    String stringUrlWomenPage = "http://automationpractice.com/index.php?id_category=3&controller=category";
    SortBy sortBy;
    MyAccountPage myAccountPage;
    WishListPage wishListPage;

    @BeforeMethod
    void setUpMethod() throws InterruptedException {
        driver.get(stringUrlWomenPage);
        sortBy = new SortBy(driver);
        myAccountPage = new MyAccountPage(driver);
        wishListPage = new WishListPage(driver);

        myAccountPage.signInButtonHeaderClick();
        myAccountPage.emailSendKey();
        myAccountPage.passwordSendKey();
        myAccountPage.signInButtonClick();
    }

    @AfterMethod
    void signOut() {
        myAccountPage.signOutButtonClick();
    }

    @Test //does not work correctly, returns all Strings with null
    //WishListObject{name='null', quantity=0, viewed=0, created='null', directLink='null', delete='null'}
    public void wishListPage() throws InterruptedException {
        myAccountPage.wishListClick();
        wishListPage.nameSendKeyOne();
        Thread.sleep(5000);
        wishListPage.saveButtonClick();

        wishListPage.getListOfAllElementsTableWishList();
    }
}

