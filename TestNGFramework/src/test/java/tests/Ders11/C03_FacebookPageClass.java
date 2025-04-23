package tests.Ders11;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_FacebookPageClass {

    Faker faker;
    @Test
    public void test01() throws InterruptedException {

        //locate'ini aldığım WebElementleri kullanabilmek için instance'ını aldım.
        FacebookPage facebookPage = new FacebookPage();
        //https://www.facebook.com/ adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookURL"));
        //POM’a uygun olarak email, sifre kutularini ve giris yap
        //butonunu locate edin
        //Faker class’ini kullanarak email ve sifre degerlerini
        //yazdirip, giris butonuna basin

        faker=new Faker();
        facebookPage.email.sendKeys(faker.internet().emailAddress());
        facebookPage.password.sendKeys(faker.internet().password());
        Thread.sleep(2000);
        facebookPage.loginButton.click();
        //Basarili giris yapilamadigini test edin
    }
}
