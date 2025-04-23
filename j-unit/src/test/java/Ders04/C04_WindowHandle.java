package Ders04;

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
import java.util.ArrayList;
import java.util.List;

public class C04_WindowHandle {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void Test1() throws InterruptedException {

        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Thread.sleep(2000);
        WebElement firstPageTitle = driver.findElement(By.xpath("//h3[.='Opening a new window']"));
        String title = "Opening a new window";
        Thread.sleep(1000);
        Assert.assertEquals("Başlıklar uyumsuz :(",firstPageTitle.getText(), title);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Thread.sleep(1000);
        String windowTitle = driver.getTitle();
        String exceptedWindowtitle = "The Internet";
        Assert.assertEquals("Başlıklar uyumsuz",windowTitle,exceptedWindowtitle );
        //Click Here butonuna basın.
        Thread.sleep(1000);
        WebElement clickHere =driver.findElement(By.cssSelector("[href='/windows/new']"));
        clickHere.click();
        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        List<String> handleCodeList = new ArrayList<>(driver.getWindowHandles());
        //test başlangıcında açılan ilk web sayfası index 0.
        // click here'a bastıktan sonra açılan web sayfası index 1.
        // handleCodeList listesindeki indexi 1 olan sayfaya geçiş yaptık.
        driver.switchTo().window(handleCodeList.get(1));


        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        Thread.sleep(1000);
        WebElement text = driver.findElement(By.xpath("//h3[.='New Window']"));
        String expectedText = "New Window";
        Assert.assertEquals("Textler uyumsuz",text.getText(),expectedText);

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        Thread.sleep(1000);
        driver.switchTo().window(handleCodeList.get(0));
        String windowTitle2 = driver.getTitle();
        String exceptedWindowtitle2 = "The Internet";
        Assert.assertEquals("Başlıklar uyumsuz",windowTitle2,exceptedWindowtitle2 );



    }





    @After
    public void tearDown() {

        driver.quit();
    }
}
