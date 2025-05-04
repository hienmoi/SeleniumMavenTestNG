package Bai13_Alert_PopupWindown_IFrame;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Demo_Iframe extends BaseTest {
    @Test
    public void testIFrame01() throws InterruptedException {

        driver.get("https://demoqa.com/frames");
        Thread.sleep(2000);

        //Chuyển hướng đến iframe
        driver.switchTo().frame(driver.findElement(By.id("frame1")));
        //driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        Thread.sleep(2000);

        driver.switchTo().parentFrame();//Chuyển hướng về page ban đầu
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
    }
}
