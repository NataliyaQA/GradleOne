package com.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

//2 tests

public class PlpTest extends BaseTestAbstractClass {
    String buttonMore = "More";

    @Test
    public void findProduct() {
        driver.findElements(By.linkText("Printed Dress"));
        System.out.println("123");

        Actions actions = new Actions(driver);
        WebElement mousehover = driver.findElement(By.linkText("Printed Dress"));
        actions.moveToElement(mousehover);
        actions.perform();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String buttonMore1 = driver.findElement(By.linkText("More")).getText();
        assertTrue(buttonMore1.toLowerCase().contains(buttonMore.toLowerCase()),
                "Name of the button is correct");
        System.out.println("Name of the button is correct");
    }

    @Test
    public void clickMoreFromPlpGetPdp() {
        driver.findElements(By.linkText("Printed Dress"));
        System.out.println("789");

        Actions actions = new Actions(driver);
        WebElement mousehover = driver.findElement(By.linkText("Printed Dress"));
        actions.moveToElement(mousehover);
        actions.perform();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.linkText("More")).click();
        System.out.println("PDP is shown");
    }
}
