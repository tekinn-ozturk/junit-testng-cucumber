package Ders05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.security.KeyStoreSpi;

public class C03_Actions extends TestBaseBeforeAfter {
     //https://www.amazon.com.tr/ sayfasina gidelim
     @Test
     public void Test() throws InterruptedException {
         driver.get("https://www.amazon.com.tr/");
         Thread.sleep(1000);
         WebElement cookiesAccept = driver.findElement(By.id("sp-cc-accept"));
         cookiesAccept.click();

         WebElement accountAndList = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
         WebElement listCreation = driver.findElement(By.xpath("//span[.='Liste Oluşturun']"));
         Actions actions = new Actions(driver);
         actions.moveToElement(accountAndList).click(listCreation).perform();

         WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
         actions.click(searchBox).keyDown(Keys.SHIFT).sendKeys("i").keyUp(Keys.SHIFT).sendKeys("phone").sendKeys(" ").sendKeys("15").sendKeys(" ").keyDown(Keys.SHIFT).sendKeys("p").keyUp(Keys.SHIFT).sendKeys("lus").sendKeys(Keys.ENTER).perform();




     }
    //Hesaplar ve listeler menusunden  liste olusturun linkine tıklayalım
    //Burada hesap ve listeler menüsüne click işlemi yaparsak başka bir yere gidiyor sadece imleci üzerine getirmek gerek bu sebeple Actions class'ı kullanılmalı.







    //Arama kutusuna actions method’larine kullanarak  Iphone 15 Plus yazdirin ve Enter’a basarak arama  yaptirin
    //Aramanin gerceklestigini test edin

}
