package com.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

//3 tests

public class AddProductToTheCart extends AbstractClass {

    String buttonAddToCart = "Add to cart";

    @Test
    public void findProduct() {
        driver.findElements(By.linkText("Printed Dress")); //1st product to SearchResultProductList
        System.out.println("123");

        Actions actions = new Actions(driver);
        WebElement mousehover = driver.findElement(By.linkText("Printed Dress")); //1st product from SearchResultProductList
        actions.moveToElement(mousehover);
        actions.perform();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//buttonAddToCart1 to Search(Home)
        String buttonAddToCart1 = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[3]/div/div[2]/div[2]/a[1]/span")).getText();
        assertTrue(buttonAddToCart1.toLowerCase().contains(buttonAddToCart.toLowerCase()),
                "Name of the button is correct");
        System.out.println("Name of the button is correct");
    }

    @Test
    public void clickAddToCartFromPlpGetModalWindow() {
        driver.findElements(By.linkText("Printed Dress"));
        System.out.println("456");

        Actions actions = new Actions(driver);
        WebElement mousehover = driver.findElement(By.linkText("Printed Dress"));
        actions.moveToElement(mousehover);
        actions.perform();

        try {
           Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.linkText("Add to cart")).click();
        System.out.println("Modal window is shown");
    }

    @Test
    public void clickAddToCartFromPdp() {
        driver.findElement(By.linkText("Printed Dress")).click();

        try {
           Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
    }


}
