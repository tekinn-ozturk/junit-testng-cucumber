package Ders08;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C02_WebElementScreenShoot extends TestBaseBeforeAfter {
    //Amazon sayfasına gidelim

    //Iphone aratalım
    //Arama sonuc yazısının resmini alalım

    @Test
    public void test() throws InterruptedException, IOException {

        Thread.sleep(2000);
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.id("sp-cc-accept")).click();
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Iphone", Keys.ENTER);

        Thread.sleep(2000);
        WebElement result = driver.findElement(By.xpath("//h2[normalize-space()='Sonuçlar']"));


        File resultWebElement = result.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(resultWebElement, new File("target/WebElementScreenShoot/WebElementSS"+tarih+".jpeg"));






    }
}
