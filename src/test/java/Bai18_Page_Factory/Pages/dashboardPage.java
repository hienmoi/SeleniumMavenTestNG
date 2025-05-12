package Bai18_Page_Factory.Pages;

import Keyword.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class dashboardPage {

    //Khai báo driver cục bộ trong chính class này
    private WebDriver driver;
    public dashboardPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver);//Khởi tạo giá trị driver cho class WebUI
    }

    //Khai báo cục bộ các element dạng đối tượng By (phương thức tìm kiếm)
    private By totalInvoicesAwaitingPayment = By.xpath("( //span[normalize-space()='Invoices Awaiting Payment']/parent::div)/following-sibling::span");

    public void verifytotalInvoicesAwaitingPayment(String total){
        Assert.assertTrue(driver.findElement(totalInvoicesAwaitingPayment).isDisplayed(), "The Invoices Awaiting Payment not display");
        Assert.assertEquals(WebUI.getElementText(totalInvoicesAwaitingPayment), total, "The Invoices Awaiting Payment not match");
    }
}
