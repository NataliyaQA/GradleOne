package com.automationpractice;

import org.testng.Assert;
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

    @Test // does not work correctly, failed (real bug), but shows error as:
//    java.lang.AssertionError: Lists differ at element [0]: Faded Short Sleeve T-shirts != Faded Short Sleeve T-shirts
//    Expected :Faded Short Sleeve T-shirts
//    Actual   :Faded Short Sleeve T-shirts
    public void sortProductsNames() throws InterruptedException {
        List<Product> expected = sortBy.getListOfAllElementsWomenPageInitial();
        sortBy.selectValueDropDownNameAZ();
        Thread.sleep(5000);

        List<Product> actual = sortBy.getListOfAllElementsWomenPageSecond();
        Assert.assertEquals(actual, expected);
   }

    @Test // test is executed only if one of the @Override of "Product" class is commented.
    // There are one for "nameOfProduct" and one for "price"
    public void sortProductsPrices() throws InterruptedException {
        List<Product> products = new ArrayList<>();
        //for (int i=0; i<=texts.length(); i++) //{text.get(i)}
        for (String takeTextOfEach : sortBy.getListOfAllElementsWomenPagePrice()) {
            List<String> separateItems = Arrays.asList(takeTextOfEach.split("\n"));
            String getPriceString = separateItems.get(1);

            float price = Float.parseFloat(getPriceString
                    .replace("$", "")
                    .replace("30.51 -5%", "")
                    .replace("20.50 -20%", ""));

            products.add(new Product(price));
        }
        products.stream().sorted(Comparator.comparing(Product::getPrice))
                .forEach(System.out::println);

        sortBy.selectValueDropDownPriceLowest();
        Thread.sleep(5000);

        List<Product> products2 = new ArrayList<>();
        for (String takeTextOfEach : sortBy.getListOfAllElementsWomenPagePrice()) {
            List<String> separateItems = Arrays.asList(takeTextOfEach.split("\n"));
            String getPriceString = separateItems.get(1);

            float price = Float.parseFloat(getPriceString
                    .replace("$", "")
                    .replace("30.51 -5%", "")
                    .replace("20.50 -20%", ""));

            products2.add(new Product(price));
        }
        System.out.println("**********");
        products2.stream().forEach(System.out::println);
        Assert.assertEquals(products, products2);
    }
}

