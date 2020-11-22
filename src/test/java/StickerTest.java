import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StickerTest extends BaseTest{
    @Test
    public void stickerTest(){
        driver.navigate().to("http://192.168.64.2/litecart/en/");
        List<WebElement> list = driver.findElements(By.xpath("//li[@class='product column shadow hover-light']"));
        list.forEach(webElement -> webElement.findElement(By.xpath(".//div[contains(@class,'sticker ')]")));
    }
}
