package Bai18_Page_Factory.TestCase;

import Bai18_Page_Factory.Pages.dashboardPage;
import Bai18_Page_Factory.Pages.loginPage;
import Common.BaseTest;
import org.testng.annotations.Test;

public class dashboardTest extends BaseTest {
   Bai18_Page_Factory.Pages.loginPage loginPage;
   Bai18_Page_Factory.Pages.dashboardPage dashboardPage;

   @Test
   public void checkTotalInvoicesAwaitingPayment(){
  loginPage = new loginPage(driver);
  loginPage.loginCRM("https://crm.anhtester.com/admin/authentication", "admin@example.com", "123456");

  dashboardPage = new dashboardPage(driver);
  dashboardPage.verifytotalInvoicesAwaitingPayment("0 / 2");
 }

}
