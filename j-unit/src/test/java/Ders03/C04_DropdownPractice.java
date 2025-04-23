package Ders03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_DropdownPractice {

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.amazon.com.tr/");

    }
    //https://www.amazon.com.tr/ adresine gidiniz
    //Cerezleri "kabul etmeden devam et" secenegine tiklayiniz(bizde çerez çıkmıyor)
    //Arama kutusunun yanindaki kategori menusunun kategori sayisinin 40 oldugunu test ediniz
    //Kategori menusunden Kitaplar seceneginin secin
    //arama kutusuna Java yazin ve aratin



    @Test
    public void categoryCountTest() {
        WebElement categoryCount = driver.findElement(By.cssSelector("#searchDropdownBox"));
        Select select = new Select(categoryCount);
        List<WebElement> options = select.getOptions();
        int optionsSize = options.size();
        System.out.println(optionsSize);
        Assert.assertTrue("Toplamda 40 adet kategori yok", optionsSize==40);




    }

    @Test
    public void clickBookTest() throws InterruptedException {
        WebElement categoryCount = driver.findElement(By.cssSelector("#searchDropdownBox"));
        Select select = new Select(categoryCount);

        categoryCount.click();
        Thread.sleep(1000);
        select.selectByValue("search-alias=stripbooks");
        Thread.sleep(2000);

    }

    @Test
    public void writeJava() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.click();
        Thread.sleep(2000);
        searchBox.sendKeys("Java", Keys.ENTER);


    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
