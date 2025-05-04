package Bai11_Assertion;

import Common.BaseTest;
import Common.LocatorCRM;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Demo_SoftAssertion extends BaseTest {
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void testLoginSuccessful() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");
        Thread.sleep(1000);

        //Kiểm tra đối tượng header và giá trị header
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerLogin)).isDisplayed(), "Header login page not display");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.headerLogin)).getText(), "Login123", "Header không đúng");

        driver.findElement(By.xpath(LocatorCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorCRM.buttonLogin)).click();

        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashBoard)).isDisplayed(), "Menu Dashboard not display");
        System.out.println(driver.findElement(By.xpath(LocatorCRM.menuDashBoard)).getText());
        softAssert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashBoard)).getText().contains("12345"), "Menu Dashboard not display");

        softAssert.assertAll();

    }
}