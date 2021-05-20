package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThreadSleep {

    public static final int WAIT_TIMEOUT_SECONDS = 20;

    public static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebElement waitForElement(WebDriver driver, WebElement webElement) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(webElement));
    }
}

