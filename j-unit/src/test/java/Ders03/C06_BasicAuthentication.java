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

public class C06_BasicAuthentication {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    //https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    //    asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    //
    //    Html komutu : https://username:password@URL
    //    Username	: admin
    //    password	: admin
    //
    //    Basarili sekilde sayfaya girildigini dogrulayin


    @Test
    public void basicAuthenticationTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        WebElement validation = driver.findElement(By.xpath("//p[contains(.,'Congratulations! You must have the proper credentials.')]"));

        String validationText = validation.getText();
        Thread.sleep(1000);
        Assert.assertTrue("Doğrulama Başarısız !",validationText.contains("Congratulations"));
    }




    @After
    public void tearDown() {
        driver.quit();
    }
}
