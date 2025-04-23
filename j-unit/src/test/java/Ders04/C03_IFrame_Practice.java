package Ders04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_IFrame_Practice {

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
        driver.get("https://html.com/tags/iframe/");

       List<WebElement> iFrameList = driver.findElements(By.tagName("iframe"));
       //List<WebElement> iFrameList = driver.findElements(By.xpath("//iframe"));
       WebElement firstFrame = iFrameList.get(0);

        driver.switchTo().frame(firstFrame);

        WebElement play = driver.findElement(By.className("ytp-large-play-button-red-bg"));
        play.click();
        Thread.sleep(2000);



    }



    @After
    public void tearDown() {
        //driver.quit();
    }

}
