package Bai9_TestNGFramework;

import org.testng.annotations.Test;

public class DemoTestNG_03 {

    @Test (priority = 2)
    public void testLoginCRM(){
        System.out.println("Login thành công");
    }

    @Test (priority = 3)
    public void testLogoutCRM(){

        System.out.println("Logout thành công");
    }
    @Test (priority = 1, description = "test thứ tự")
    public void createAccount(){

        System.out.println("Tạo thành công");
    }
}
