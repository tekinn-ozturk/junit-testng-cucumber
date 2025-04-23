package Ders04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_WindowHandlePractice {
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
        //1- Amazon Sayfasina girelim
        driver.get("https://www.amazon.com.tr/");
        String amazonHandleCode = driver.getWindowHandle();


        Thread.sleep(2000);
        //2- Url'nin amazon içerdiğini test edelim
        String amazonUrl = driver.getCurrentUrl();
        Assert.assertTrue("Url'ler uyumsuz", amazonUrl.contains("amazon"));

        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        //Yeni bir browser açar.Yeni bir tab değil bak yeni bir browser.
        Thread.sleep(1000);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        Thread.sleep(1000);
        String bestBuyHandleCode = driver.getWindowHandle();
        //4- title'in Best Buy içerdiğini test edelim
        String bestBuyTitle = driver.getTitle();
        Assert.assertTrue("Başlık Best Buy içermiyor!",bestBuyTitle.contains("Best Buy"));

        //5- İlk sayfaya dönüp sayfada java aratalım.
        Thread.sleep(1000);
        driver.switchTo().window(amazonHandleCode);
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        Thread.sleep(1000);
        searchBox.sendKeys("Java", Keys.ENTER);

        //6- Arama sonuclarının java içerdiğini test edelim
        Thread.sleep(2000);
        WebElement textarea = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        String textAreaText =textarea.getText();
        Assert.assertTrue("Doğrulama sonucu Java kelimesini içermemekte!",textAreaText.toLowerCase().contains("java"));
        //7- Yeniden bestbuy sayfasına gidelim
        Thread.sleep(1000);
        driver.switchTo().window(bestBuyHandleCode);
        //8- Logonun görünürlüğünü test edelim
        Thread.sleep(1000);
        WebElement logo = driver.findElement(By.xpath("//div[@class='content']/div[1]/img[@alt='Best Buy Logo']"));
        Assert.assertTrue("Logo görünür değil", logo.isDisplayed());
    }




    @After
    public void tearDown() {
        driver.quit();
    }
}
