package Ders04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_IFrame {

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    // ● Bir metod olusturun: iframeTest
    // ● https://the-internet.herokuapp.com/iframe adresine gidin.
    //    ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
    //    ○ Text Box’a “Merhaba Dunya!” yazin.
    //    ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
    //      dogrulayin ve konsolda yazdirin
    // driver.switchTo().parentFrame();//===> 1ust seviyedeki frame e gecis yapar



    @Test
    public void iFrameTest() throws InterruptedException {
    driver.get("https://the-internet.herokuapp.com/iframe");

    //IFrame Handle edilir.
    WebElement iFrameTextBox = driver.findElement(By.id("mce_0_ifr"));
    driver.switchTo().frame(iFrameTextBox);

    //IFrame içersindeki elemente ulaşılır.
    WebElement textBox = driver.findElement(By.xpath("//p[.='Your content goes here.']"));

    textBox.clear();
    Thread.sleep(2000);
    textBox.sendKeys("Tekin Öztürk");

        driver.switchTo().parentFrame(); // 1 üst seviyedeki frame'e geçiş yapar.
        driver.switchTo().defaultContent(); // En üst seviyedeki frame'e geçiş yapar.



    }




    @After
    public void tearDown() {

       // driver.quit();
    }
}
