package com.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.objects.Product;

import java.util.ArrayList;
import java.util.List;

public class TestTest extends BaseTestAbstractClass{
    String stringUrlMainPage = "http://automationpractice.com/index.php?id_category=8&controller=category";

    @BeforeMethod
    void setUpMethod() throws InterruptedException {
        driver.get(stringUrlMainPage);
    }

    @Test
    public void sortTest() {
        List<WebElement> elementName = driver.findElements(By.xpath("//*[@id='center_column']/ul/li"));
        List<String> strings = new ArrayList<>();
        List<Product> products = new ArrayList();
        for (WebElement eachElement : elementName) {
            System.out.println(eachElement.getText());
            System.out.println("***");
            strings.add(eachElement.getText());

            //products.add(new Product(eachElement.getText(), (float) 1.1));
        }
        //products.forEach(System.out::println);

    }
}
