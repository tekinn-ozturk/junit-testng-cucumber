package Ders05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C04_ActionsPractice1 extends TestBaseBeforeAfter {

    @Test

    public void Test() throws InterruptedException {
        //https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");


        //Cizgili alan bölümün uzerinde sag click yapalim
        WebElement squareArea = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.moveToElement(squareArea).contextClick().perform();
        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        Thread.sleep(2000);
        String expectedAlertText = "You selected a context menu";
        String alertText=driver.switchTo().alert().getText();
        Assert.assertEquals("Metinler Eşit Değil!",expectedAlertText,alertText);


        Thread.sleep(1000);
        //Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //Elemental Selenium linkine tiklayalim
        WebElement link = driver.findElement(By.xpath("//a[.='Elemental Selenium']"));
        link.click();

        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        //YENİ AÇILAN SAYFALARDA İŞLEM YAPABİLMEK İÇİN WİNDOWHANDLE'I KULLANMAK GEREK YOKSA YENİ SAYFA AÇILMASINA RAĞMEN İLK SAYFADA ÇALIŞMAYA DEVAM EDER.
        Thread.sleep(1000);

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));


        Thread.sleep(1000);
        WebElement h1TTag = driver.findElement(By.xpath("//h1[@class='hero__title']"));
        String h1TagText = h1TTag.getText();
        String expectedH1Tag = "Elemental Selenium";
        Assert.assertEquals("Metinler Eşit Değil",h1TagText, expectedH1Tag);

    }
}
