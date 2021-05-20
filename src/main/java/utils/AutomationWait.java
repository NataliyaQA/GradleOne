package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wrapper.Wrapper;

import java.util.concurrent.TimeUnit;

public class AutomationWait {

    public static void waitPageLoad() {
        Wrapper.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public static WebElement waitForElementClickable(WebElement element) {
        new WebDriverWait( Wrapper.getDriver(), 10).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public static WebElement waitForElementVisible(WebElement element) {
        new WebDriverWait( Wrapper.getDriver(), 15).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static WebElement waitForElementNested(WebElement element) {
        new WebDriverWait( Wrapper.getDriver(), 15).until(ExpectedConditions.visibilityOfElementLocated((By) element));
        return element;
    }

    public static WebElement waitVisibleClickable(WebElement element) {
        return waitForElementVisible(waitForElementClickable(element));
    }

    public static void waitTitleContains(String title) {
        new WebDriverWait(Wrapper.getDriver(), 10).until(ExpectedConditions.titleContains(title));
    }

    public static void wait(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

