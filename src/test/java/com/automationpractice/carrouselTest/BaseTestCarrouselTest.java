package com.automationpractice.carrouselTest;

import com.automationpractice.BaseTestAbstractClass;
import org.testng.annotations.BeforeMethod;

//written for Carrousel Package only, but extends main abstract class "BaseTestClass"
public class BaseTestCarrouselTest extends BaseTestAbstractClass {
    @BeforeMethod
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe"); // moved to Wrapper

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.get("https://google.com/");
    }
}
