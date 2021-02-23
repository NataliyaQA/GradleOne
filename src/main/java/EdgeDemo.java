import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("EdgeDriver execution on Windows!!");
        System.setProperty("webdriver.edge.driver", "C:\\Data\\Temp\\GradleOne\\src\\main\\resources\\Drivers\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("http://automationpractice.com/");
        Thread.sleep(3000);
        driver.quit();
        System.out.println("Execution complete on Windows");

    }

}
