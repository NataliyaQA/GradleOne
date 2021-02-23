import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDemo {

    public static void main(String[] args) throws InterruptedException {

            //Creating a driver object referencing WebDriver interface
            WebDriver driver;

            //Setting webdriver.gecko.driver property
            System.setProperty("webdriver.gecko.driver", "C:\\Data\\Temp\\GradleOne\\src\\main\\resources\\Drivers\\geckodriver.exe");

            //Instantiating driver object and launching browser
            driver = new FirefoxDriver();

            //Using get() method to open a webpage
            driver.get("http://automationpractice.com/");

            //Closing the browser
        Thread.sleep(3000);
        driver.quit();
        System.out.println("Execution complete on Windows");
    }
}
