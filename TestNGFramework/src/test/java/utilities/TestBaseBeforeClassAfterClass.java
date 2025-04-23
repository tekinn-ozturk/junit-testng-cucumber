package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBaseBeforeClassAfterClass {

    public WebDriver driver;
    public String tarih;


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("YYYYMMDDHHmmss");
        tarih = date.format(dateTimeFormatter);


    }



    @AfterClass
    public void tearDown(){
        //driver.quit();
    }
}
