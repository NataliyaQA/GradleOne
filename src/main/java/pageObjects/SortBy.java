package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class SortBy {
    public WebDriver driver;

    //Constants

    //Constructor
    public SortBy(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    // General create list of elements
    public List<String> getListOfAllElements(String xPath) {
        List<WebElement> elementName = driver.findElements(By.xpath(xPath));
        List<String> texts = elementName
                .stream()
                .map(WebElement::getText)
                .collect(toList());
        return texts;

        //List<String> texts = sortBy.getListOfAllElements("//*[@id='center_column']/ul/li");
        //texts.forEach(System.out::println);
    }

    public List<String> getListOfAllElementsWomenPage() {
        return getListOfAllElements("//*[@id='center_column']/ul/li");
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
