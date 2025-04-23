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

public class C01_Assertions {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com.tr/");


    }

    @Test
    public void Test1() {
    String actualUrl = driver.getCurrentUrl();
    String expectedUrl ="amazon";
    /*
    * assertTrue
    * Eğer test fail olursa message'ı terminal'e basar.
    * Eğer test pass ise message ile bi işimiz yok.
    * Message terminale, false durumda basılır.
    * */
    //Assert.assertTrue("Url amazon kelimesini içermiyor",actualUrl.contains(expectedUrl));


        /*
        * assertFalse
        * istenilen bool senaryo gerçekleşmezse assert true döner, çünkü assertFalse.
        * istenilen bool senaryo gerçekleşirse false döner ve message terminale basılır.
        * Message terminale, false durumda basılır.
        * */
        Assert.assertFalse("Url amazon kelimesini içeriyor",actualUrl.contains(expectedUrl));


    }

    @Test
    public void Test2() {
        driver.get("https://www.facebook.com/?locale=tr_TR");
        WebElement facebookLogo = driver.findElement(By.xpath("//img[@alt='Facebook']"));
        Assert.assertTrue("Logo Görünmüyor",facebookLogo.isDisplayed());
        /*
        * logo görünüyor ise message basılmaz.
        * logo görünmüyor ise message basılır.
        * */

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
