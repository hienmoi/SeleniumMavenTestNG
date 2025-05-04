package Bai13_Alert_PopupWindown_IFrame;

import Common.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Demo_Alert extends BaseTest {

@Test
        public void demoAlertOK() throws InterruptedException {
    driver.get("https://demoqa.com/alerts");
    Thread.sleep(3000);

    //Mở alert
    driver.findElement(By.id("alertButton")).click();
    Thread.sleep(2000);

    //Khởi tạo class Alert thứ nhất
    Alert alert1 = driver.switchTo().alert();
    alert1.accept();
}
@Test
    public void demoAlertCancle() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        Thread.sleep(3000);

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("confirmButton")));
    //Mở alert
    driver.findElement(By.id("confirmButton")).click();
    Thread.sleep(2000);

    //Khởi tạo class Alert
    Alert alert2 = driver.switchTo().alert();
    alert2.dismiss();
    }
    @Test
    public void demoAlertPromt() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("promtButton")));
        //Mở alert
        driver.findElement(By.id("promtButton")).click();
        Thread.sleep(2000);

        //Khởi tạo class Alert
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Anh Tester Demo Alert");
        alert3.accept();
        
        Thread.sleep(2000);
    }

}

