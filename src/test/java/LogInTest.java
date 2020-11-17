import org.junit.Test;
import org.openqa.selenium.By;

public class LogInTest extends BaseTest{
    @Test
    public void myFirstTest(){
        driver.navigate().to("http://192.168.64.2/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath("//*[@class='fa fa-sign-out fa-lg']"));
    }




}
