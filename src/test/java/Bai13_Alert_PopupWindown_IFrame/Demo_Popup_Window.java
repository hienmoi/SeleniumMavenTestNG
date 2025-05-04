package Bai13_Alert_PopupWindown_IFrame;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Set;

import static java.lang.Thread.sleep;

public class Demo_Popup_Window extends BaseTest {

    @Test
    public void testOpenNewWindow() {

        driver.get("https://anhtester.com");

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://google.com");
    }

    @Test
    public void demoPopupWindow() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        sleep(2);
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        sleep(1);
        // Lưu lại lớp window đầu tiên - mã ID hơi dài, in ra sẽ thấy :)
        String MainWindow = driver.getWindowHandle();
        System.out.println(MainWindow);

        // Lấy tất cả các mã định danh Tab Window.
        Set<String> windows = driver.getWindowHandles();

        //Set là một Collection để lưu các phần tử giá trị KHÔNG trùng lặp.
        //Cách duyệt từng phần tử không trùng lặp trong Collection (Set) - Java Basic
        for (String window : windows) {
            System.out.println(window);
            if (!MainWindow.equals(window)) {
                //So sánh nếu thằng nào khác thằng Chính (đầu tiên) thì chuyển hướng qua nó mới thao tác được
                //Chuyển hướng driver đến Tab mới (Tab con)
                driver.switchTo().window(window);
                sleep(1);
                System.out.println("Đã chuyển đến Tab Window mới");

                //Một số hàm hỗ trợ
                System.out.println(driver.switchTo().window(window).getTitle());
                System.out.println(driver.switchTo().window(window).getCurrentUrl());

                sleep(1);
                //Sau khi chuyển hướng sang Tab mới thì getText cái header
                System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());

                // Tắt cái Tab Window mới.
                sleep(1);
                driver.close();
            }
        }
        // Chuyển hướng về lại tab chính ban đầu (Main Window)
        driver.switchTo().window(MainWindow);
        System.out.println("Đã chuyển về lớp Window chính: " + driver.getCurrentUrl());

        sleep(1);
    }
    @Test (priority = 1)
    public void demoPopupWindowIndex() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        sleep(2);
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        sleep(1);
        // Lưu lại lớp window đầu tiên - mã ID hơi dài, in ra sẽ thấy :)
        String MainWindow = driver.getWindowHandle();
        System.out.println(MainWindow);

        // Lấy tất cả các mã định danh Tab Window.
        Set<String> windows = driver.getWindowHandles();

        String firstWindow = (String)windows.toArray()[0]; //Cửa sổ đầu
        String secondWindow = (String)windows.toArray()[1]; //Cửa sổ thứ hai

        driver.switchTo().window(secondWindow);//chuyển sang cửa số thứ 2
        sleep(2000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        // Chuyển hướng về lại tab chính ban đầu (Main Window)
        driver.switchTo().window(MainWindow);
        System.out.println("Đã chuyển về lớp Window chính: " + driver.getCurrentUrl());

        sleep(1);
}
}
