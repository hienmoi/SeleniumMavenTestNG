package Bai17_Page_Object_Model.TestCase;

import Bai17_Page_Object_Model.Pages.dashboardPage;
import Bai17_Page_Object_Model.Pages.loginPage;
import Common.BaseTest;
import org.testng.annotations.Test;

public class dashboardTest extends BaseTest {
   loginPage loginPage;
   dashboardPage dashboardPage;

   @Test
   public void checkTotalInvoicesAwaitingPayment(){
  loginPage = new loginPage(driver);
  loginPage.loginCRM("https://crm.anhtester.com/admin/authentication", "admin@example.com", "123456");

  dashboardPage = new dashboardPage(driver);
  dashboardPage.verifytotalInvoicesAwaitingPayment("0 / 2");
 }

}
