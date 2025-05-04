package Bai15_Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Demo_ExplicitWait {

    WebDriver driver;

    @BeforeMethod
    public void setupDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void demoImplicitWait2() throws InterruptedException {

        driver.get("https://hrm.anhtester.com/");

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("iusername")));


        driver.findElement(By.id("iusername")).sendKeys("admin_example");
        driver.findElement(By.id("ipassword")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Projects')]")));

        //Click menu dự án
        driver.findElement(By.xpath("//span[contains(text(),'Projects')]")).click();

        driver.quit();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}