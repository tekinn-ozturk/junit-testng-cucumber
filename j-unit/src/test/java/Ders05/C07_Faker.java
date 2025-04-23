package Ders05;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C07_Faker extends TestBaseBeforeAfter {

    @Test
    public void Test() throws InterruptedException {
        //1- https://www.facebook.com adresine gidelim
        //2- Yeni hesap olustur butonuna basalim
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim

        driver.get("https://www.facebook.com");
        Thread.sleep(2000);
        WebElement createAccountButton = driver.findElement(By.xpath("//a[.='Yeni hesap oluştur']"));
        createAccountButton.click();

        Actions actions = new Actions(driver);

        Faker faker =new Faker();
        WebElement nameInput= driver.findElement(By.xpath("//input[@name='firstname']"));
        Thread.sleep(2000);
        actions.click(nameInput).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).sendKeys(faker.internet().password()).perform();


    }
}
