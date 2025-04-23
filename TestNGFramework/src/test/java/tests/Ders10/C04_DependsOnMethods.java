package tests.Ders10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C04_DependsOnMethods extends TestBaseBeforeClassAfterClass {
    // amazon ana sayfasına gidelim
    //Iphone aratalım
    // Sonuc yazısının amazon içerdiğini test edelim

    //ayrı test metotlarını birbiri ardına bağlamak için kullanılır.

    @Test
    public void test01() {

        driver.get("https://www.amazon.com.tr/");

    }

    @Test(dependsOnMethods = "test01")
    public void test02() {

        WebElement searchBox =driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        searchBox.click();
        searchBox.sendKeys("Iphone", Keys.ENTER);
    }

    @Test(dependsOnMethods = "test02")
    public void test03() {

        WebElement tag = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        String checkIphone = tag.getText();

        Assert.assertTrue(checkIphone.contains("Iphone"),"uyarılar eşleşmiyor");
    }
}
