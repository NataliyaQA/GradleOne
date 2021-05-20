package wrapper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import utils.Propertiator;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Wrapper {
    private static WebDriver driver = null;
    private static FluentWait<WebDriver> wait = null;

    private Wrapper() throws InterruptedException {
        EventFiringWebDriver eDriver = null;
        String type = Propertiator.getPropertie("driver");
        switch (type) {
            case "Chrome":

                ChromeDriverService service = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File(System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\chromedriver.exe"))
                        .usingAnyFreePort()
                        .build();
                try {
                    service.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                eDriver = new EventFiringWebDriver(new RemoteWebDriver(service.getUrl(),
                        DesiredCapabilities.chrome()));
                break;

            case "Firefox":
                GeckoDriverService serviceGecko = new GeckoDriverService.Builder()
                        .usingDriverExecutable(new File(System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\geckodriver.exe"))
                        .usingAnyFreePort()
                        .build();
                try {
                    serviceGecko.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                eDriver = new EventFiringWebDriver(new RemoteWebDriver(serviceGecko.getUrl(),
                        DesiredCapabilities.firefox()));
                break;

            case "Edge":
                EdgeDriverService serviceEdge = new EdgeDriverService.Builder()
                        .usingDriverExecutable(new File(System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\msedgedriver.exe"))
                        .usingAnyFreePort()
                        .build();
                try {
                    serviceEdge.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                eDriver = new EventFiringWebDriver(new RemoteWebDriver(serviceEdge.getUrl(),
                        DesiredCapabilities.edge()));
                break;
        }
        driver = eDriver;
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        } else {
            try {
                new Wrapper();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return driver;
        }
    }

    public static FluentWait<WebDriver> getFindFluentWait() {
        getFluentWait().withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        return wait;
    }

    public static FluentWait<WebDriver> getFluentWait() {
        if (wait != null) {
            return wait;
        } else {
            wait = new FluentWait<WebDriver>(driver);
            return wait;
        }
    }

//    var wait = new WebDriverWait(driver,timeout);
//     wait.IgnoreExceptionTypes(typeof(NoSuchElementException));
//     return wait.Until(x=>condition(element));
}

