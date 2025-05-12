package Bai22_23_Ham_chung.TestCase;

import Bai22_23_Ham_chung.Pages.loginPage;
import Common.BaseTest;
import org.testng.annotations.Test;

public class loginTest extends BaseTest {

    Bai22_23_Ham_chung.Pages.loginPage loginPage;

    @Test(priority = 1)
    public void loginSuccess() {
        loginPage = new loginPage(driver);
        loginPage.loginCRM("https://crm.anhtester.com/admin/authentication", "admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
    }

    @Test(priority = 2)
    public void loginfail_emailInvalid() {
        loginPage = new loginPage(driver);
        loginPage.loginCRM("https://crm.anhtester.com/admin/authentication", "bdmin@example.com", "123456");
        loginPage.verifyLoginFail();
    }

    @Test(priority = 4)
    public void loginfail_passwordNull() {
        loginPage = new loginPage(driver);
        loginPage.loginCRM("https://crm.anhtester.com/admin/authentication", "admin@example.com", "");
        loginPage.verifyLoginFail("The Password field is required.");
    }
    @Test(priority = 3)
    public void loginfail_emailNull()  {
        loginPage = new loginPage(driver);
        loginPage.loginCRM("https://crm.anhtester.com/admin/authentication", "", "123456");
        loginPage.verifyLoginFail("The Email Address field is required.");
    }
}
