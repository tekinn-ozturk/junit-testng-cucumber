package Ders02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {

    //Her test case'ini aynı browser üzerinde gerçekleştirir. Before, After'dan farkı budur. ve static çalışırlar.
    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void Test1() {
        driver.get("https://www.amazon.com.tr/");
    }

    @Test
    public void Test2() {
        driver.get("https://tr-tr.facebook.com/login/device-based/regular/login");
    }


    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
