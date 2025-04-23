package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_Practice {
    public static void main(String[] args) throws InterruptedException {
        //Chrome'u import et
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Facebook sayfasina gidin ve sayfa basliginin(title) "facebook" oldugunu dogrulayin
        driver.get("https://facebook.com/?locale=tr_TR");
        Thread.sleep(2000);
        String facebookTitle = driver.getTitle();
        //Sayfa basligi dogru degilse basligi yazdirin
        if (facebookTitle.toLowerCase().contains("facebook")){
            System.out.println("Sayfa Yüklendi");
        }else{
            System.out.println("Giriş Başarısız - "+facebookTitle);
        }
        Thread.sleep(2000);
        //Sayfa URL inin "facebook" kelimesi icerdigini dogrulayin,icermiyorsa "actual" URL i yazdirin
        String facebookUrl= driver.getCurrentUrl();
        if(facebookUrl.toLowerCase().contains("facebook")){
            System.out.println("Url doğru formatta :)");
        }else{
            System.out.println(facebookUrl);
        }

        Thread.sleep(2000);
        //https://www.walmart.com/ sayfasina gidin
        driver.navigate().to("https://www.walmart.com/");
        //Sayfanin basliginin "Walmart.com" icerdigini dogrulayin
        String walmartTitle = driver.getTitle();
        if (walmartTitle.toLowerCase().contains("walmart")){
            System.out.println("title walmart kelimesini içeriyor");
        }else{
            System.out.println("title walmart kelimesini içermiyor");
        }
        Thread.sleep(2000);
        //Tekrar "facebook" sayfasina donun
        driver.navigate().back();
        //Sayfayi yenileyin
        Thread.sleep(2000);
        driver.navigate().refresh();
        //Sayfayi maximize yapin
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        //Browser i kapatin
        driver.quit();
    }
}
