package Ders03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Allerts {
    /*
    Bir web sitesine girdiğimizde karşımıza bir uyarı mesayı yada bir buttona tıkladığımızda bir uyarı(alert)
    çıkabilir. Eğer bu uyarıya incele(mause sağ tik-inspect) yapabiliyorsak bu tür alert'lere HTML alert denir
    ve istediğimiz locate'i alabiliriz. Ama gelen uyarı kutusuna müdehale(Sağ tik-incele) edemiyorsak bu tür
    alert'lere js alert denir. js alert'lere müdehale edebilmek için
    - tamam yada ok için driver.switchTo().alert().accept() kullanılır
    - iptal için driver.switchTo().alert().dismiss() methodu kullanılır
    - Alert içindeki mesajı almak için driver.switchTo().alert().getText() kullanılır
    - Alert bizden bir metin istiyorsa driver.switchTo().alert().sendKeys("") kullanılır
*/

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");


    }

    //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //Bir metod olusturun: acceptAlert
    //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    //Bir metod olusturun: dismissAlert
    //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //“successfuly” icermedigini test edin. Alert üzerindeki mesajı yazdırınız
    //Bir metod olusturun: sendKeysAlert
    //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.



    @Test
    public void acceptAlert() throws InterruptedException {
        WebElement button1 = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        button1.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        WebElement result1 = driver.findElement(By.xpath("//p[@id='result']"));
        String resultText = result1.getText();
        Thread.sleep(2000);
        Assert.assertTrue("Uyarılar eşleşmiyor",resultText.equals("You successfully clicked an alert"));

    }

    @Test
    public void dismissAlert() throws InterruptedException {
        WebElement button2 = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        button2.click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        WebElement result2 = driver.findElement(By.xpath("//p[@id='result']"));
        String resultText= result2.getText();
        Thread.sleep(2000);


        Assert.assertFalse("Uyarılar eşleşmiyor",resultText.contains("successfuly"));
        if (!resultText.contains("successfuly")){
            System.out.println(resultText);
        }



    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
    WebElement button3 = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));

    button3.click();

    Thread.sleep(2000);
    driver.switchTo().alert().sendKeys("Tekon");
    driver.switchTo().alert().accept();

    WebElement result3 = driver.findElement(By.xpath("//p[@id='result']"));

    String resultText = result3.getText();

    Assert.assertTrue("Result, Adını içermiyor",resultText.contains("Tekin"));

    }



    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }



}
