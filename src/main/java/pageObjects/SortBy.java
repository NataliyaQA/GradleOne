package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageObjects.objects.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class SortBy {
    public WebDriver driver;

    //Constants
    List<Product> products = new ArrayList<>();

    //Constructor
    public SortBy(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    // General create list of elements
    public List<Product> getListOfAllElementsInitial(String xPath) {
        List<WebElement> elementName = driver.findElements(By.xpath(xPath));
        List<String> texts = elementName
                .stream()
                .map(WebElement::getText)
                .collect(toList());

        //List<String> texts = sortBy.getListOfAllElements("//*[@id='center_column']/ul/li");
        //texts.forEach(System.out::println);

        for (String takeTextOfEach : texts) {
            List<String> separateItems = Arrays.asList(takeTextOfEach.split("\n"));
            String getTitleString = separateItems.get(0);

            products.add(new Product(getTitleString));
        }
        System.out.println("**********");
        products.stream().sorted(Comparator.comparing(Product::getNameOfProduct))
                .forEach(System.out::println);
        return products;
    }

    public List<Product> getListOfAllElementsWomenPageInitial() {
        return getListOfAllElementsInitial("//*[@id='center_column']/ul/li");
    }

    //General create a new list of elements after sorting
    public List<Product> getListOfAllElementsSecond(String xPath) {
        List<WebElement> elementName = driver.findElements(By.xpath(xPath));
        List<String> texts = elementName
                .stream()
                .map(WebElement::getText)
                .collect(toList());

        //List<String> texts = sortBy.getListOfAllElements("//*[@id='center_column']/ul/li");
        //texts.forEach(System.out::println);

        for (String takeTextOfEach : texts) {
            List<String> separateItems = Arrays.asList(takeTextOfEach.split("\n"));
            String getTitleString = separateItems.get(0);

            products.add(new Product(getTitleString));
        }
        System.out.println("**********");
        products.stream().forEach(System.out::println);
        return products;
    }

    public List<Product> getListOfAllElementsWomenPageSecond() {
        return getListOfAllElementsSecond("//*[@id='center_column']/ul/li");
    }

    //General select sort option
    public void selectValueFromDropDown(String xPath, String value) {
        Select dropDown = new Select(driver.findElement(By.xpath(xPath)));
        dropDown.selectByVisibleText(value);
    }

    public void selectValueDropDownPriceLowest() {
        selectValueFromDropDown("//*[@id='selectProductSort']", "Price: Lowest first");
    }

    public void selectValueDropDownPriceHighest() {
        selectValueFromDropDown("//*[@id='selectProductSort']", "Price: Highest first");
    }

    public void selectValueDropDownNameAZ() {
        selectValueFromDropDown("//*[@id='selectProductSort']", "Product Name: A to Z");
    }

    public void selectValueDropDownNameZA() {
        selectValueFromDropDown("//*[@id='selectProductSort']", "Product Name: Z to A");
    }

    public void selectValueDropDownInStock() {
        selectValueFromDropDown("//*[@id='selectProductSort']", "In stock");
    }

    public void selectValueDropDownReferenceOne() {
        selectValueFromDropDown("//*[@id='selectProductSort']", "Reference: Lowest first");
    }

    public void selectValueDropDownReferenceTwo() {
        selectValueFromDropDown("//*[@id='selectProductSort']", "Reference: Highest first");
    }
}
