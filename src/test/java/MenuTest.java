import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.BooleanUtils.and;

public class MenuTest extends BaseTest {

    @Test
    public void test() throws InterruptedException {
        driver.navigate().to("http://192.168.64.2/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        List<WebElement> listMenuElements = driver.findElements(By.cssSelector("#box-apps-menu li"));
        List<String> menuNames = new ArrayList<>();
        for (WebElement listMenuElement : listMenuElements) {
            menuNames.add(listMenuElement.getText());
        };

        for (String name : menuNames) {
            driver.findElement(By.xpath("//td[@id='sidebar']//span[contains(text(),'" + name + "')]")).click();
            driver.findElement(By.cssSelector("#content > h1"));

            List<WebElement> listElements = driver.findElements(By.xpath("//td[@id='sidebar']//ul[@class='docs']//span"));
            if (listElements.size() > 0) {
                List<String> subMenuNames = new ArrayList<>();
                for (WebElement element : listElements) {
                    subMenuNames.add(element.getText());
                }

                for (int i = 1; i < subMenuNames.size(); i++) {
                    driver.findElement(By.xpath("//td[@id='sidebar']//li[@class='selected']//span[contains(text(),'" + subMenuNames.get(i) + "')]")).click();
                    driver.findElement(By.cssSelector("#content > h1"));
                }

            }
        }
    }
}
