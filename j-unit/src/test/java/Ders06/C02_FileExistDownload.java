package Ders06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExistDownload extends TestBaseBeforeAfter {

    @Test
    public void fileExistTest() throws InterruptedException {

        //https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //Sample.txt dosyasını indirelim
        Thread.sleep(1000);
        WebElement sampleFile = driver.findElement(By.xpath("//a[.='sampleFile.txt']"));
        Actions actions = new Actions(driver);
        actions.click(sampleFile).perform();
        Thread.sleep(2000);
        //Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        //dosyayı bilgisayarda bul shift+ sağtık ile yol olarak kopyala seçeneğini seç
        String sampleFilePAth ="C:\\Users\\tekin.ozturk\\Downloads\\sampleFile.txt\\";
        //İndirildiğini konsolda gösterin
        Assert.assertTrue(Files.exists(Paths.get(sampleFilePAth)));

    }
}
