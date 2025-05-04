package Bai18_Page_Factory.Pages;

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
        PageFactory.initElements(driver, this);
    }


    //Khai báo cục bộ các element dạng đối tượng By (phương thức tìm kiếm)
//    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
//    private By inputEmail = By.xpath("//input[@id='email']");
//    private By inputPassword = By.xpath("//input[@id='password']");
//    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
//    private By errorMessage = By.xpath("//div[contains(@class, 'alert-dange')]");
@FindAll({
    @FindBy(xpath = "//h1[normalize-space()='Login'"),
    @FindBy(id = "header")
})
    private WebElement headerPage;


    @FindBy(xpath = "//input[@id='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//div[contains(@class, 'alert-dange')]")
    private WebElement errorMessage;


    //Khai báo hàm xây dựng, để truyền driver từ bên ngoài vào chính class này sử dụng

    private void setEmail(String email) {
        //driver.findElement(inputEmail).sendKeys(email);
        inputEmail.sendKeys(email);
    }

    private void setPassword(String password) {
        //driver.findElement(inputPassword).sendKeys(password);
        inputPassword.sendKeys(password);
    }

    private void clickLoginButton() {
        //driver.findElement(buttonLogin).click();
        buttonLogin.click();
    }

    public void verifyLoginSuccess() {
        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"), "FAIL. Vẫn đang ở trang Login");
    }

    public void verifyLoginFail() {
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        //Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Error message NOT displays");
        //Assert.assertEquals(driver.findElement(errorMessage).getText(), "Invalid email or password", "Content of error massage NOT match.");
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message NOT displays");
        Assert.assertEquals(errorMessage.getText(), "Invalid email or password", "Content of error massage NOT match.");

    }
    public void verifyLoginFail(String message) {
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        //Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Error message NOT displays");
        //Assert.assertEquals(driver.findElement(errorMessage).getText(), message, "Content of error massage NOT match.");
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message NOT displays");
        Assert.assertEquals(errorMessage.getText(), message, "Content of error massage NOT match.");

    }

    //Các hàm xử lý cho chính trang này
    public void loginCRM(String url, String email, String password) {

        //https://crm.anhtester.com/admin/authentication
       // driver.get(url); //Gọi từ class ConfigData dạng biến static
        WebUI.open_url(url);
        setEmail(email);
        setPassword(password);
        clickLoginButton();
        //WebUI.open_url(url);
//        WebUI.clearText(inputEmail);
//        WebUI.setText(inputEmail, email);
//        WebUI.clearText(inputPassword);
//        WebUI.setText(inputPassword, password);
//        WebUI.clickElement(buttonLogin);
    }
}
