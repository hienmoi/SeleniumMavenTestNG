package Bai17_Page_Object_Model.TestCase;

import Bai17_Page_Object_Model.Pages.loginPage;
import Common.BaseTest;
import org.testng.annotations.Test;

public class loginTest extends BaseTest {

    loginPage loginPage;

    @Test(priority = 1)
    public void loginSuccess() {
        loginPage = new loginPage(driver);
        loginPage.loginCRM("https://crm.anhtester.com/admin/authentication", "admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
    }

    @Test(priority = 2)
    public void loginfail_emailInvalid() throws InterruptedException {
        loginPage = new loginPage(driver);
        loginPage.loginCRM("https://crm.anhtester.com/admin/authentication", "bdmin@example.com", "123456");
        Thread.sleep(2000);
        loginPage.verifyLoginFail();
    }

    @Test(priority = 4)
    public void loginfail_passwordNull() throws InterruptedException {
        loginPage = new loginPage(driver);
        loginPage.loginCRM("https://crm.anhtester.com/admin/authentication", "admin@example.com", "");
        Thread.sleep(2000);
        loginPage.verifyLoginFail("The Password field is required.");
    }
    @Test(priority = 3)
    public void loginfail_emailNull() throws InterruptedException {
        loginPage = new loginPage(driver);
        loginPage.loginCRM("https://crm.anhtester.com/admin/authentication", "", "123456");
        Thread.sleep(2000);
        loginPage.verifyLoginFail("The Email Address field is required.");
    }
}
