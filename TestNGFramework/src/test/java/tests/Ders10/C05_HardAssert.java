package tests.Ders10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C05_HardAssert extends TestBaseBeforeMethodAfterMethod {


    //1-amazon anasayfaya gidin
    //2-title in Amazon içerdigini test edin
    //3-arama kutusnun erişilebilir oldugunu test edin
    //4-arama kutusuna Iphone yazıp aratın
    //5-arama yapıldıgını test edin
    //6-arama sonucunun Iphone içerdigini test



    //HER ZAMAN YAPTIĞIMIZ ASSERTION ASLINDA BİR HARD ASSERTION'DUR.

    @Test()
    public void test() throws InterruptedException {
        //1-amazon anasayfaya gidin
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='sp-cc-rejectall-link']")).click();
        //2-title in Amazon içerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        //3-arama kutusnun erişilebilir oldugunu test edin
        WebElement aramakutusu= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        Assert.assertTrue(aramakutusu.isEnabled());
        //4-arama kutusuna Iphone yazıp aratın
        aramakutusu.sendKeys("Iphone"+ Keys.ENTER);
        //5-arama yapıldıgını test edin
        WebElement sonuc=driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        Assert.assertTrue(sonuc.isDisplayed());
        //6-arama sonucunun Iphone içerdigini test
        Assert.assertTrue(sonuc.getText().contains("Iphone"));
    }

}
