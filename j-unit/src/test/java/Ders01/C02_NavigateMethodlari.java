package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_NavigateMethodlari {
    public static void main(String[] args) throws InterruptedException {
        //Chromedriver i setup ediniz
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // "www.amazon.com.tr" adresine gidiniz
        //navigate.to, get metoduna göre daha performanslı ve pratik metotlara sahip.
        //istediğimiz siteye gidilir.
        driver.navigate().to("https://www.amazon.com.tr/");
        //google ana sayfasina gidiniz.
        driver.navigate().to("https://www.google.com.tr/");
        //Tekrar amazon sayfasina gidiniz
        Thread.sleep(2000);
        //google'dan önce amazondaydık, google'da iken back'lersen amazona döner.
        driver.navigate().back();
        //Tekrar google sayfasina gidiniz
        Thread.sleep(2000);
        //amazonda iken forward dersen google'a gider.
        driver.navigate().forward();
        //Sayfayi yenileyiniz
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        //Sayfayi kapatiniz.
        driver.quit();


    }
}
