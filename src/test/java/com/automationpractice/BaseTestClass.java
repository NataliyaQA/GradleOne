package com.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import wrapper.Wrapper;

import java.util.concurrent.TimeUnit;

public class BaseTestClass {
    public WebDriver driver = Wrapper.getDriver();

    @BeforeMethod
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe"); // moved to Wrapper

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.quit();
//    }

}
