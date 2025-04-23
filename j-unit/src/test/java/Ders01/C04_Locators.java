package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Locators {
    public static void main(String[] args) throws InterruptedException {

        //Chromedriver i setup ediniz
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Eğer süre dolduktan sonra da öğe bulunamazsa, NoSuchElementException fırlatılır.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //"www.amazon.com.tr" adresine gidiniz
        driver.get("https://www.amazon.com.tr/");
        //Amazonda notebook aratalim.

        WebElement cookieAccept = driver.findElement(By.id("sp-cc-accept"));
        Thread.sleep(2000);
        cookieAccept.click();
        WebElement textBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        textBox.sendKeys("Notebook", Keys.ENTER);



        //Amazon sayfasindaki taglarin a olanlarinin sayisini yazdiralim
        //sayfayi kapatiniz

    }
}
