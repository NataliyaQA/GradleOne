package com.automationpractice;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.SortBy;
import pageObjects.objects.Product;

import java.util.List;

public class SortByTest extends BaseTestAbstractClass {
    String stringUrlWomenPage = "http://automationpractice.com/index.php?id_category=3&controller=category";
    SortBy sortBy;

    @BeforeMethod
    void setUpMethod() throws InterruptedException {
        driver.get(stringUrlWomenPage);
        sortBy = new SortBy(driver);
    }

    @Test // does not work correctly, always Passed
    public void sortProductsNames() throws InterruptedException {
//        List<Product> products = new ArrayList<>();
//        //for (int i=0; i<=texts.length(); i++) //{text.get(i)}
//        for (String takeTextOfEach : sortBy.getListOfAllElementsWomenPage()) {
//            List<String> separateItems = Arrays.asList(takeTextOfEach.split("\n"));
//            String getTitleString = separateItems.get(0);
//
//            products.add(new Product(getTitleString));
//        }
//        products.stream().sorted(Comparator.comparing(Product::getNameOfProduct))
//                .forEach(System.out::println);

        List<Product> expected = sortBy.getListOfAllElementsWomenPageInitial();
        sortBy.selectValueDropDownNameAZ();
        Thread.sleep(5000);

        List<Product> actual = sortBy.getListOfAllElementsWomenPageSecond();
        Assert.assertEquals(actual, expected);
   }

//    @Test
//    public void sortProductsPrices() {
//        List<Product> products = new ArrayList<>();
//        //for (int i=0; i<=texts.length(); i++) //{text.get(i)}
//        for (String takeTextOfEach : sortBy.getListOfAllElements("//*[@id='center_column']/ul/li")) {
//            List<String> separateItems = Arrays.asList(takeTextOfEach.split("\n"));
//            String getPriceString = separateItems.get(1);
//
//            float price = Float.parseFloat(getPriceString
//                    .replace("$", "")
//                    .replace("30.51 -5%", "")
//                    .replace("20.50 -20%", ""));
//
//            products.add(new Product(price));
//        }
//        products.stream().sorted(Comparator.comparing(Product::getPrice))
//                .forEach(System.out::println);

        //        sortBy.selectValueDropDownPriceLowest();
//        Thread.sleep(5000);
//        sortBy.selectValueDropDownPriceHighest();
//        Thread.sleep(5000);
    }

