package Bai19_PageNavigation.Pages;

import Keyword.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class loginPage {

    //Khai báo driver cục bộ trong chính class này
    private WebDriver driver;
    public loginPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver);//Khởi tạo giá trị driver cho class WebUI
    }

    //Khai báo cục bộ các element dạng đối tượng By (phương thức tìm kiếm)
    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[contains(@class, 'alert-dange')]");

    //Khai báo hàm xây dựng, để truyền driver từ bên ngoài vào chính class này sử dụng

    private void setEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    private void setPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    private void clickLoginButton() {
        driver.findElement(buttonLogin).click();
    }

    public void verifyLoginSuccess() {
        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"), "FAIL. Vẫn đang ở trang Login");
    }

    public void verifyLoginFail() {
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Error message NOT displays");
        Assert.assertEquals(driver.findElement(errorMessage).getText(), "Invalid email or password", "Content of error massage NOT match.");
    }
    public void verifyLoginFail(String message) {
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Error message NOT displays");
        Assert.assertEquals(driver.findElement(errorMessage).getText(), message, "Content of error massage NOT match.");
    }


    //Các hàm xử lý cho chính trang này
    //Hàm login chỉ phục vụ trang Login
    public void loginCRM(String url, String email, String password) {

        WebUI.open_url(url);
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }
    //Hàm login liên kết với trang Dashboard
    public dashboardPage loginCRM() {

        WebUI.open_url("https://crm.anhtester.com/admin/authentication");
        setEmail("admin@example.com");
        setPassword("123456");
        clickLoginButton();
        verifyLoginSuccess();
        return new dashboardPage(driver);
    }

}
