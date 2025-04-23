package Ders05;

import org.junit.Test;
import utilities.TestBaseBeforeAfter;

public class C01_TestBaseBeforeAfter extends TestBaseBeforeAfter {

    //utilities'te oluşturduğumuz testbasebeforeafter class'ı içersinde before ve after metotları tanımladık ve bu before-after metotlarını inheritance sayesinde gerekli her class'a inherit edersek tekrar tekrar before-after metotlarını kurmaya gerek kalmaz.
    //extends keyword'u iki class arasındaki inheritance'i sağlar.
    @Test
    public void Test() throws InterruptedException {
        driver.navigate().to("https://www.amazon.com.tr/");
        Thread.sleep(2000);
    }
}
