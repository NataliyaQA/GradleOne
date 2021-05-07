package com.automationpractice;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.SortBy;
import pageObjects.objects.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortByTest extends BaseTestAbstractClass {
    String stringUrlWomenPage = "http://automationpractice.com/index.php?id_category=3&controller=category";
    SortBy sortBy;

    @BeforeMethod
    void setUpMethod() throws InterruptedException {
        driver.get(stringUrlWomenPage);
        sortBy = new SortBy(driver);
    }

    @Test
    public void sortTest() {
        List<String> texts = sortBy.getListOfAllElements("//*[@id='center_column']/ul/li");
        //texts.forEach(System.out::println);

        List<Product> products = new ArrayList<>();
        //List<String> separateItems;
        //for (int i=0; i<=texts.length(); i++) //{text.get(i)}
        for (String text : texts) {
            List<String> separateItems = Arrays.asList(text.split("\n"));
            String getTitleString = separateItems.get(0);
            String getPriceString = separateItems.get(1);

            float price = Float.parseFloat(getPriceString
                    .replace("$", "")
                    .replace("30.51 -5%", "")
                    .replace("20.50 -20%", ""));

            products.add(new Product(getTitleString, price));
        }
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("**********");
        products.stream().sorted(Comparator.comparing(Product::getPrice))
                .forEach(System.out::println);
    }
}
