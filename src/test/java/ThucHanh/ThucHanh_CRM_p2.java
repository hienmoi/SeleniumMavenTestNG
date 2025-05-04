package ThucHanh;

import Common.BaseTest;
import Common.LocatorCRM;
import Keyword.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ThucHanh_CRM_p2 extends BaseTest {

    @Test
   public void testCRM() throws InterruptedException {

        new WebUI(driver); //Khởi tạo class WebUI để truền driver vào
       driver.get("https://crm.anhtester.com/admin/authentication");

     WebUI.clearText(By.xpath(LocatorCRM.inputEmail));
       //driver.findElement(By.xpath(LocatorCRM.inputEmail)).clear();
     WebUI.clearText(By.xpath(LocatorCRM.inputPassword));
       //driver.findElement(By.xpath(LocatorCRM.inputPassword)).clear();
     WebUI.setText(By.xpath(LocatorCRM.inputEmail), "admin@example.com");
       //driver.findElement(By.xpath(LocatorCRM.inputEmail)).sendKeys("admin@example.com");
     WebUI.setText(By.xpath(LocatorCRM.inputPassword), "123456");
       //driver.findElement(By.xpath(LocatorCRM.inputPassword)).sendKeys("123456");
     WebUI.clickElement(By.xpath(LocatorCRM.buttonLogin));
       //driver.findElement(By.xpath(LocatorCRM.buttonLogin)).click();
//Mở màn Customer
        WebUI.clickElement(By.xpath(LocatorCRM.menuCustomer));
        //driver.findElement(By.xpath(LocatorCRM.menuCustomer)).click();
        WebUI.getText(By.xpath(LocatorCRM.headerCustomer));
        //System.out.println(driver.findElement(By.xpath(LocatorCRM.headerCustomer)).getText());
//Tạo mới customer
        WebUI.clickElement(By.xpath(LocatorCRM.AddNewCustomer));
        //driver.findElement(By.xpath(LocatorCRM.AddNewCustomer)).click();
        WebUI.setText(By.xpath(LocatorCRM.inputCompany), "Đá quý 6" );
        //driver.findElement(By.xpath(LocatorCRM.inputCompany)).sendKeys("Đá quý 4");
        WebUI.setText(By.xpath(LocatorCRM.inputPhone),"123456789" );
        //driver.findElement(By.xpath(LocatorCRM.inputPhone)).sendKeys("09876543");
        WebUI.setText(By.xpath(LocatorCRM.inputVAT), "09876543");
        //driver.findElement(By.xpath(LocatorCRM.inputVAT)).sendKeys("09876543");
        WebUI.setText(By.xpath(LocatorCRM.inputWebsite), "https://crm.anhtester.com/admin/clients/client");
        //driver.findElement(By.xpath(LocatorCRM.inputWebsite)).sendKeys("https://crm.anhtester.com/admin/clients/client");
        WebUI.clickElement(By.xpath(LocatorCRM.dropdownGroup));
        //driver.findElement(By.xpath(LocatorCRM.dropdownGroup)).click();
        WebUI.setText(By.xpath(LocatorCRM.inputSearchGroup), "VIP" );
        //driver.findElement(By.xpath(LocatorCRM.inputSearchGroup)).sendKeys("VIP");
        WebUI.clickElement(By.xpath(LocatorCRM.optionVIP));
        //driver.findElement(By.xpath(LocatorCRM.optionVIP)).click();
        WebUI.clickElement(By.xpath(LocatorCRM.dropdownGroup));
        //driver.findElement(By.xpath(LocatorCRM.dropdownGroup)).click();
        WebUI.clickElement(By.xpath(LocatorCRM.dropdownLanguage));
        //driver.findElement(By.xpath(LocatorCRM.dropdownLanguage)).click();
        WebUI.clickElement(By.xpath(LocatorCRM.optionVietnamese));
        //driver.findElement(By.xpath(LocatorCRM.optionVietnamese)).click();
        WebUI.setText(By.xpath(LocatorCRM.inputAddress), "Hà Nội" );
        //driver.findElement(By.xpath(LocatorCRM.inputAddress)).sendKeys("Hà Nội");
        WebUI.setText(By.xpath(LocatorCRM.inputCity), "HN" );
        //driver.findElement(By.xpath(LocatorCRM.inputCity)).sendKeys("HN");
        WebUI.setText(By.xpath(LocatorCRM.inputState), "Vui vẻ" );
        //driver.findElement(By.xpath(LocatorCRM.inputState)).sendKeys("Vui vẻ");
        WebUI.setText(By.xpath(LocatorCRM.inputZipCode), "12345678" );
        //driver.findElement(By.xpath(LocatorCRM.inputZipCode)).sendKeys("12345678");
        WebUI.clickElement(By.xpath(LocatorCRM.dropdownCountry));
        //driver.findElement(By.xpath(LocatorCRM.dropdownCountry)).click();
        WebUI.setText(By.xpath(LocatorCRM.inputSearchCountry), "Vietnam" );
        //driver.findElement(By.xpath(LocatorCRM.inputSearchCountry)).sendKeys("Vietnam");
        WebUI.clickElement(By.xpath(LocatorCRM.optionVietnam));
        //driver.findElement(By.xpath(LocatorCRM.optionVietnam)).click();
        WebUI.clickElement(By.xpath(LocatorCRM.buttonSave));
        //driver.findElement(By.xpath(LocatorCRM.buttonSave)).click();
        //Thread.sleep(3000);

//Kiểm tra customer đã tạo ở màn List customer
        WebUI.clickElement(By.xpath(LocatorCRM.menuCustomer));
        //driver.findElement(By.xpath(LocatorCRM.menuCustomer)).click();
        WebUI.setText(By.xpath(LocatorCRM.searchListCustomer), "Đá quý 6" );
        //driver.findElement(By.xpath(LocatorCRM.searchListCustomer)).sendKeys("Đá quý 4");
        Thread.sleep(2000);
        WebUI.waitElementVisible(By.xpath(LocatorCRM.itemCustomerFirst), 5);
        //driver.findElement(By.xpath(LocatorCRM.itemCustomerFirst)).isDisplayed();
        WebUI.getText(By.xpath(LocatorCRM.itemCustomerFirst));
        //driver.findElement(By.xpath(LocatorCRM.itemCustomerFirst)).getText();

//Kểm tra customer mới add đúng thông tin đã nhập
        WebUI.clickElement(By.xpath(LocatorCRM.itemCustomerFirst));
//        driver.findElement(By.xpath(LocatorCRM.itemCustomerFirst)).click();
//        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputCompany)).getAttribute("value"), "Đá quý 6", "The company name not match");
        //System.out.println(driver.findElement(By.xpath(LocatorCRM.inputCompany)).getAttribute("value"));
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputPhone)).getAttribute("value"), "123456789", "Them phone not match");
        //System.out.println(driver.findElement(By.xpath(LocatorCRM.inputPhone)).getAttribute("value"));
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputVAT)).getAttribute("value"), "09876543");
        //System.out.println(driver.findElement(By.xpath(LocatorCRM.inputVAT)).getAttribute("value"));
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputWebsite)).getAttribute("value"), "https://crm.anhtester.com/admin/clients/client");
//        System.out.println(driver.findElement(By.xpath(LocatorCRM.inputWebsite)).getAttribute("value"));
//        System.out.println(driver.findElement(By.xpath(LocatorCRM.dropdownGroup)).getAttribute("title"));
//        System.out.println(driver.findElement(By.xpath(LocatorCRM.dropdownLanguage)).getAttribute("title"));

        closeDriver();
    }

}
