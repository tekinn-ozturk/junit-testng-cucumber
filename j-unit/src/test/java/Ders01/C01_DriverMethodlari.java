package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethodlari {
    public static void main(String[] args) {
        //Chromedriver i setup ediniz

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // "www.amazon.com.tr" adresine gidiniz
        driver.get("https://www.amazon.com.tr/");
        //sayfayi maximum boyuta getiriniz
        driver.manage().window().maximize();
        //sayfanin basligini yazdiriniz
        String title = driver.getTitle();
        System.out.println("Sitenin Başlığı :"+title);
        //sayfanin URL adresini yazdiriniz
        String url = driver.getCurrentUrl();
        System.out.println("Sitenin URL adresi :"+url);
        //sayfanin kaynak kodlarini yazdiriniz
        String sourceCode = driver.getPageSource();
         System.out.println("Sayfanin kaynak kodlari : "+ sourceCode);
        //Kaynak kodlarin icinde "Gateway" kelimesinin oldugunu test ediniz
        String gateway="Gateway";
        if (sourceCode.contains(gateway)){
            System.out.println("İçeriyor");
        }else{
            System.out.println("İçermiyor");
        }

        //sayfanin window handle kodunu yazdiriniz
        String windowHandleCode = driver.getWindowHandle();
        System.out.println("Handle Code: "+windowHandleCode);
        //sayfayi kapatalim
        driver.close();
    }
}
