package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.objects.WishListObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class WishListPage {
    public WebDriver driver;
    MyAccountPage myAccountPage;

    //Constants
    public static final String NAME_OF_WISHLIST_ONE = "Name Of WishList One";
    public static final String NAME_OF_WISHLIST_TWO = "Name Of WishList Two";
    
    //Constructor
    public WishListPage(WebDriver driver){
        this.driver = driver;

    }
    //Methods
    public void sendKey(String xPath, String value) {
        driver.findElement(By.xpath(xPath)).sendKeys(value);
    }

    public void nameSendKeyOne() {
        sendKey("//input[@id='name']", NAME_OF_WISHLIST_ONE);
    }

    public void nameSendKeyTwo() {
        myAccountPage.sendKey("//input[@id='name']", NAME_OF_WISHLIST_TWO);
    }

    public void submitForm(String xPath) {
        driver.findElement(By.xpath(xPath)).submit();
    }

    public void nameSubmitForm() {
        submitForm("//input[@id='name']");
    }

    public List<WishListObject> wishListTable(String xPath) {
        List<WishListObject> tableValues = new ArrayList<>();
        List<WebElement> tableColumnAndValue = driver.findElements(By.xpath(xPath));
        List<String> texts = tableColumnAndValue
                .stream()
                .map(WebElement::getText)
                .collect(toList());
        for (String takeTextOfEach : texts) {
            List<String> separateItems = Arrays.asList(takeTextOfEach.split("\n"));
            String getName = separateItems.get(0);

            tableValues.add(new WishListObject(getName));
        }
        System.out.println("**********");
        tableValues.stream().forEach(System.out::println);
        return tableValues;
    }

    public List<WishListObject> getListOfAllElementsTableWishList() {
        return wishListTable("//*[@id='block-history']");
    }

    //General click
    public void elementClick(String xPath) {
        driver.findElement(By.xpath(xPath)).click();
    }

    public void saveButtonClick() {
        elementClick("//button[@id='submitWishlist']");
    }

}
