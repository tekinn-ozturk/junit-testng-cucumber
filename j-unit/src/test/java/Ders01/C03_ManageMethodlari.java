package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class C03_ManageMethodlari {
    public static void main(String[] args) throws InterruptedException {
        //Chromedriver i setup ediniz
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //"www.amazon.com.tr" adresine gidiniz
        driver.get("https://www.amazon.com.tr/");
        //Sayfanin konumunu  ve boyutlarini yazdirin
        Point konum= driver.manage().window().getPosition(); //sayfanın konumu
        System.out.println("Maximize Konum: "+ konum);
        Dimension size= driver.manage().window().getSize(); //sayfanın boyutu
        System.out.println("Maximize Size: "+ size);
        //Sayfayi simge durumuna getirin
        driver.manage().window().minimize();
        //Simge durumunda 2 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(2000);
        driver.manage().window().maximize();

        Thread.sleep(2000);
        //Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();
        //Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin

        Point fsKonum=driver.manage().window().getPosition();//sayfanın konumu
        System.out.println("FullScreen Konum: "+fsKonum);
        Dimension fsSize = driver.manage().window().getSize();
        System.out.println("FullScreen Size: "+fsSize);//sayfanın boyutu
        //Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        //Sayfanin istenilen konum boyutta ayarlandigini test ediniz
        //Sayfayi kapatiniz
        driver.quit();

    }
}
