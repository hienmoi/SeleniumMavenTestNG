package Bai11_Assertion;

import Common.BaseTest;
import Common.LocatorCRM;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo_HardAssertion extends BaseTest {

    @Test
    public void testLoginSuccessful() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");
        Thread.sleep(1000);

        //Kiểm tra đối tượng header và giá trị header
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerLogin)).isDisplayed(), "Header login page not display");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.headerLogin)).getText(), "Login", "Header không đúng");

        driver.findElement(By.xpath(LocatorCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorCRM.buttonLogin)).click();

        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashBoard)).isDisplayed(), "Menu Dashboard not display");
        System.out.println(driver.findElement(By.xpath(LocatorCRM.menuDashBoard)).getText());
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashBoard)).getText().contains("12345"), "Menu Dashboard not display");
    }
}
