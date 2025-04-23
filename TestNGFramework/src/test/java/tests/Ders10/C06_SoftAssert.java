package tests.Ders10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C06_SoftAssert extends TestBaseBeforeMethodAfterMethod {

    //Test hata çıkmasına rağmen devam eder ve test sonlandığında toplu bi hata verir.

    @Test()
    public void test() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        //1-amazon anasayfaya gidin
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='sp-cc-rejectall-link']")).click();
        //2-title in Amazon içerdigini test edin
        softAssert.assertTrue(driver.getTitle().contains("Amazon"),"Girdiğiniz kelimeyi içermemektedir.");
        //3-arama kutusnun erişilebilir oldugunu test edin
        WebElement aramakutusu= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        softAssert.assertTrue(aramakutusu.isEnabled(), "Aradığınız Web Elementi erişilememektedir.");
        //4-arama kutusuna Iphone yazıp aratın
        aramakutusu.sendKeys("Iphone"+ Keys.ENTER);
        //5-arama yapıldıgını test edin
        WebElement sonuc=driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        softAssert.assertTrue(sonuc.isDisplayed(), "arama yapılamadı");
        //6-arama sonucunun Iphone içerdigini test
        softAssert.assertFalse(sonuc.getText().contains("Iphone"), "Iphone içermemektedir");

        softAssert.assertAll();
        //Test hata çıkmasına rağmen devam eder ve test sonlandığında toplu bi hata verir.

    }
}
