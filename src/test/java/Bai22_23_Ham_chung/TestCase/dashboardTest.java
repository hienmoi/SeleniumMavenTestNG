package Bai22_23_Ham_chung.TestCase;

import Bai22_23_Ham_chung.Pages.loginPage;
import Common.BaseTest;
import org.testng.annotations.Test;

public class dashboardTest extends BaseTest {
    Bai22_23_Ham_chung.Pages.loginPage loginPage;
    Bai22_23_Ham_chung.Pages.dashboardPage dashboardPage;


    @Test
    public void checkTotalInvoicesAwaitingPayment() {
        loginPage = new loginPage(driver);
        //loginPage.loginCRM("https://crm.anhtester.com/admin/authentication", "admin@example.com", "123456");
        //dashboardPage = new dashboardPage(driver);
        dashboardPage = loginPage.loginCRM();
        dashboardPage.verifytotalInvoicesAwaitingPayment("0 / 2");
    }

    @Test
    public void checkTotalConvertedLeads() {
        loginPage = new loginPage(driver);
        //loginPage.loginCRM("https://crm.anhtester.com/admin/authentication", "admin@example.com", "123456");
        //dashboardPage = new dashboardPage(driver);
        dashboardPage = loginPage.loginCRM();
        dashboardPage.verifytotalConvertedLeads("1 / 1");
    }

}
