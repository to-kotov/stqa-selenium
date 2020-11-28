import com.sun.source.tree.AssertTree;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class StickerTest extends BaseTest {
    @Test
    public void stickerTest() {
        driver.navigate().to("http://192.168.64.3/litecart/en/");
        List<WebElement> list = driver.findElements(By.xpath("//li[@class='product column shadow hover-light']"));
        list.forEach(
                webElement -> assertTrue(
                        webElement.findElements(By.xpath(".//div[contains(@class,'sticker ')]")).size() == 1
                ));
    }
}
