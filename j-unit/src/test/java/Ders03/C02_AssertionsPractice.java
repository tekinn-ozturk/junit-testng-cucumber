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

public class C02_AssertionsPractice {

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com");

    }

    //https://www.youtube.com adresine gidin
    //Asagidadki adlari lullanarak 4 test methou olusturun ve gerekli testleri yapin
    //titleTest => Sayfa basliginin "YouTube" oldugunu test edin
    //imageTest => yotube resminin goruntulendigini test edin
    //SearchBox in erisilebilir oldugunu test edin
    //wrongTitleTest => Sayfa basliginin "youtube" olmadigini test edin
    @Test
    public void titleTest() throws InterruptedException {
        String youtubeTitle = driver.getTitle();
        Assert.assertTrue("Başlık Uyumsuz",youtubeTitle.equals("YouTube"));
        Thread.sleep(2000);

    }

    @Test
    public void imageTest() throws InterruptedException {
        WebElement youtubeImage= driver.findElement(By.xpath("//ytd-topbar-logo-renderer[@id='logo']//div[@class='style-scope ytd-topbar-logo-renderer']//div[1]"));

        Assert.assertTrue("Youtube logosu görüntülenmiyor :(",youtubeImage.isDisplayed());
        Thread.sleep(2000);


    }

    @Test
    public void wrongTitleTest() throws InterruptedException {

        String youtubeTitle = driver.getTitle();
        Assert.assertFalse("Başlık Uyumsuz",!youtubeTitle.equals("YouTube"));
        Thread.sleep(2000);

    }

    @Test
    public void SearchBoxControl() throws InterruptedException {

        WebElement searchBox = driver.findElement(By.xpath("//input[@class='ytSearchboxComponentInput yt-searchbox-input title']"));
        searchBox.click();
        Thread.sleep(1000);
        searchBox.sendKeys("Tekon");


    }







    @After
    public void tearDown() {
        driver.quit();
    }
}
