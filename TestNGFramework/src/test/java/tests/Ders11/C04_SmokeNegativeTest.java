package tests.Ders11;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticePage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_SmokeNegativeTest {

PracticePage practicePage;
    @Test
    public void yanlisKullanici() throws InterruptedException {

        //https://demo1.alo-tech.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("practiceURL"));
        //Email,Password,Login elementlerini locate ediniz
        practicePage=new PracticePage();
        practicePage.email.sendKeys(ConfigReader.getProperty("wrongUser"));
        practicePage.password.sendKeys(ConfigReader.getProperty("password"));
        Thread.sleep(1000);
        practicePage.loginBtn.click();
        Thread.sleep(1000);


        //Degerleri girildiginde sayfaya girilemedigini test et
        String errorMsg=practicePage.errorPopUpUsername.getText();
        Assert.assertTrue(errorMsg.contains("invalid"),"Hata Mesajı Eşleşmiyor !");
        Thread.sleep(1000);

        //Sayfayı kapatınız
        Driver.quitDriver();

    }

    @Test
    public void yanlisSifre() throws InterruptedException {
        //https://demo1.alo-tech.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("practiceURL"));
        //Email,Password,Login elementlerini locate ediniz
        practicePage=new PracticePage();
        practicePage.email.sendKeys(ConfigReader.getProperty("user"));
        practicePage.password.sendKeys(ConfigReader.getProperty("wrongPassword"));
        Thread.sleep(1000);
        practicePage.loginBtn.click();
        Thread.sleep(1000);


        //Degerleri girildiginde sayfaya girilemedigini test et
        String errorMsg=practicePage.errorPopUpPassword.getText();
        Assert.assertTrue(errorMsg.contains("invalid"),"Hata Mesajı Eşleşmiyor !");
        Thread.sleep(1000);

        //Sayfayı kapatınız
        Driver.quitDriver();


    }

    @Test
    public void yanlisKullaniciveSifre() throws InterruptedException {

        //https://demo1.alo-tech.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("practiceURL"));
        practicePage=new PracticePage();
        //Email,Password,Login elementlerini locate ediniz
        practicePage.email.sendKeys(ConfigReader.getProperty("wrongUser"));
        practicePage.password.sendKeys(ConfigReader.getProperty("wrongPassword"));
        Thread.sleep(1000);
        practicePage.loginBtn.click();
        Thread.sleep(1000);


        //Degerleri girildiginde sayfaya girilemedigini test et
        String errorMsg=practicePage.errorPopUpUsername.getText();
        Assert.assertTrue(errorMsg.contains("invalid"),"Hata Mesajı Eşleşmiyor !");
        Thread.sleep(1000);

        //Sayfayı kapatınız
        Driver.quitDriver();

    }
}
