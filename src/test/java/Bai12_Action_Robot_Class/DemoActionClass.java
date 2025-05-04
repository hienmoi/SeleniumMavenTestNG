package Bai12_Action_Robot_Class;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoActionClass extends BaseTest {

    @Test
    public void TestSendKeys() throws InterruptedException {

        //driver kế thừa từ class SetupBrowser
        driver.get("https://www.google.com/");

        // Element search box
        WebElement element = driver.findElement(By.xpath("//textarea[@name='q']"));

        // Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        // Dùng action để gọi hàm sendkeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(element, "Anh Tester").sendKeys(Keys.ENTER).perform();

        //action.sendKeys(Keys.ENTER).perform();

        // Get element title of page
        WebElement elementTitlePage = driver.findElement(By.xpath("//h3[normalize-space()='Anh Tester Automation Testing']"));

        // Gọi hàm click để click element trên
        action.click(elementTitlePage).perform();

        Thread.sleep(2000);

    }
}
