
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.selenium.factory.WebDriverPool;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class BaseTest {
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        if (tlDriver.get() != null) {
            driver = tlDriver.get();
            wait = new WebDriverWait(driver, 10);
            return;
        }

        //driver = WebDriverPool.DEFAULT.getDriver(new FirefoxOptions());
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        tlDriver.set(driver);
        System.out.println(((HasCapabilities) driver).getCapabilities());
        wait = new WebDriverWait(driver, 10);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
                    driver.quit();
                    //WebDriverPool.DEFAULT.dismissDriver(driver);
                    driver = null;
                }));
    }

    @After
    public void stop() {
        //driver.quit();
        //driver = null;
    }


    @Test
    public void myFirstTest() throws InterruptedException {
//        FirefoxOptions options =  new FirefoxOptions();
//        options.setBinary("/Applications/Firefox Nightly.app/Contents/MacOS/firefox");
//        WebDriver driver1 = new FirefoxDriver(options);
//        driver1.navigate().to("http://www.google.com");
//        driver1.findElement(By.name("q")).sendKeys("webdriver");
//        driver1.findElement(By.name("q")).submit();

        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("q")).submit();
        wait.until(titleIs("webdriver - Поиск в Google"));
    }

}
