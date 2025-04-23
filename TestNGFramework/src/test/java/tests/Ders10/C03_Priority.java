package tests.Ders10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C03_Priority extends TestBaseBeforeMethodAfterMethod {

    //ÖNCE AMAZON SONRA HEPSİBURADA EN SON BESTBUY ÇALIŞTIRILIR.(SAYI DOĞRUSUNDA HANGİSİ ÖNCEYSE O İLK ÇALIŞIR.)
    @Test(priority = -5)
    public void testAmazon() {
        driver.get("https://www.amazon.com.tr/");


    }

    @Test(priority = 100)
    public void testBestBuy() {
        driver.get("https://www.bestbuy.com/");




    }

    @Test(priority = 1)
    public void testHepsiBurada() {
        driver.get("https://www.hepsiburada.com/");


    }

}
