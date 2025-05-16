package Bai24_Parameter_MultiBrowser;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo_Parameter {
    @Test
    @Parameters({"val1", "val2"})
    public void Sum(int v1, int v2) {
        int finalSum = v1 + v2;
        System.out.println("Kết quả là: " + finalSum);
    }

    @Test
    @Parameters({"val1", "val2", "val3"})
    public void Sum(int v1, int v2, int v3) {
        int finalSum = v1 + v2 + v3;
        System.out.println("Kết quả là: " + finalSum);
    }
    @Test
    @Parameters({"email", "password", "roleNumber"})
    public void Login(String email, String password, @Optional("4") String roleNumber) {
        System.out.println("Email là: " + email);
        System.out.println("Password là: " + password);
        System.out.println("roleNumber là: " + roleNumber);
    }

}
