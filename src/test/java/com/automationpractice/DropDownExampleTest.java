package com.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class DropDownExampleTest extends BaseTestAbstractClass {
//    String stringUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
//
//    SignInPage signInPage = new SignInPage(driver);
//
//    //wrap dropDownDays element into Select Object
//    Select dropDownDays = new Select(driver.findElement(By.xpath("//*[@id='days']"));
//
//    // Select the option with value "6"
//    List<WebElement> options1 = dropDownDays.selectByValue("6");
//
//    // Get all the options of the dropdown
//    List<WebElement> options = dropDownDays.getOptions();
//
//    // Get the first selected option of the dropdown
//    WebElement firstSelectedOption = dropDownDays.getFirstSelectedOption();
//
//    // Get all the selected option of the dropdown
//    List<WebElement> selectedOptions = dropDownDays.getAllSelectedOptions();

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe"); // moved to Wrapper
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

        //Step#3- Selecting the dropdown element by locating its id
        Select select = new Select(driver.findElement(By.xpath("//*[@id='days']")));

        //Step#4- Printing the options of the dropdown
        //Get list of web elements
        List<WebElement> lst = select.getOptions();

        //Looping through the options and printing dropdown options
        System.out.println("The dropdown options are:");
        for(WebElement options: lst)
            System.out.println(options.getText());

        //Step#5- Selecting the option as 'Purple'-- selectByIndex
        System.out.println("Select the Option by Index 4");
        select.selectByIndex(4);
        System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

        //Step#6- Selecting the option as '-'-- selectByVisibleText
        System.out.println("Select the Option by Text Magenta");
        select.selectByVisibleText("-");
        System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

        //Step#7- Selecting an option by its value
        System.out.println("Select the Option by value 6");
        select.selectByValue("6");
        System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

        driver.quit();
    }




}
