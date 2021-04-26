package com.automationpractice;

import org.testng.annotations.BeforeMethod;
import pageObjects.MyAccountPage;

public class MyAccountPageTest extends BaseTestAbstractClass{
    String myAccountUrl = "http://automationpractice.com/index.php?controller=my-account";
    MyAccountPage myAccountPage;

    @BeforeMethod
    void SetUpMethod() {
        driver.get(myAccountUrl);
        myAccountPage = new MyAccountPage(driver);
    }
}
