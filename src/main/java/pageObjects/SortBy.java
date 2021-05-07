package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public List<String> getListOfAllElements(String xPath) {
        List<WebElement> elementName = driver.findElements(By.xpath(xPath));
        List<String> texts = elementName
                .stream()
                .map(WebElement::getText)
                .collect(toList());
        return texts;
    }
}
