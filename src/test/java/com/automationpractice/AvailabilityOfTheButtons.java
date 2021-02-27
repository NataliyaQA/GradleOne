package com.automationpractice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

//6 tests created

public class AvailabilityOfTheButtons extends BaseTestAbstract {

    @Test
    public void availableSearchButton(){
        driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]")).isEnabled();
        System.out.println("Button 'Search' is available");
    }

    @Test
    public void availableLeftArrow(){
        driver.findElement(By.xpath("//a[contains(text(),'Prev')]")).isEnabled();
        System.out.println("Button 'LeftArrow' is available");
    }

    @Test
    public void availableRightArrow(){
        driver.findElement(By.xpath("//a[contains(text(),'Next')]")).isEnabled();
        System.out.println("Button 'RightArrow' is available");
    }

    @Test
    public void availablePopularButton(){
        driver.findElement(By.xpath("//a[contains(text(),'Popular')]")).isEnabled();
        System.out.println("Button 'Popular' is available");
    }

    @Test
    public void availableBestSellersButton(){
        driver.findElement(By.xpath("//a[contains(text(),'Best Sellers')]")).isEnabled();
        System.out.println("Button 'BestSellers' is available");
    }

    @Test
    public void availableEyeButton(){
        driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[3]/div/div[1]/div/div[1]/a/i")).isEnabled();
        System.out.println("Button 'Eye' is available");
    }
}

