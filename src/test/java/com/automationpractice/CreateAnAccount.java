package com.automationpractice;

import org.testng.annotations.Test;
import pageObjects.SignInPage;

public class CreateAnAccount extends BaseTestAbstract{

    @Test
    public void createAnAccount() {
        new SignInPage(driver).clickSignInHeaderButton();
    }

}
