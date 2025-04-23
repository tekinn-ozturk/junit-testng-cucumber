package Ders06;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_FileExistUpload extends TestBaseBeforeAfter {

    @Test
    public void test() throws InterruptedException {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //Dosyasec butonuna basalim
        Thread.sleep(1000);
        WebElement fileSelectButton = driver.findElement(By.xpath("//input[@id='file-upload']"));
        Actions actions = new Actions(driver);
        actions.click(fileSelectButton);
        //Yuklemek istediginiz dosyayi secelim.
        //dosyayı bilgisayarda bul shift+ sağtık ile yol olarak kopyala seçeneğini seç
        String uploadFile = "C:\\Users\\tekin.ozturk\\Desktop\\instance-id-iceren-tables.txt";
        fileSelectButton.sendKeys(uploadFile);
        Thread.sleep(1000);
        //Upload butonuna basalim.
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        //“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement successWarning = driver.findElement(By.xpath("//h3[.='File Uploaded!']"));
        String tag = successWarning.getText();
        Thread.sleep(1000);
        Assert.assertTrue("Uyarıyı alamadık", tag.contains("File Uploaded"));

    }
}
