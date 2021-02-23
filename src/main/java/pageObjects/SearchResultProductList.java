package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultProductList {

    public WebDriver driver;

    WebElement firstProductName;

    public String getFirstProductName() {
        return firstProductName.getText();
    }

    public SearchResultProductList(WebDriver driver) {
        this.driver = driver;
        firstProductName = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a[1]"));
    }
}
