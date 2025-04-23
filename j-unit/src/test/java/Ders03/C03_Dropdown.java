package Ders03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_Dropdown {

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");

    }


    //https://the-internet.herokuapp.com/dropdown adresine gidin
    //Index kullanarak Option 1 i secin ve yazdirin
    //Value kullanarak Option 2 i secin ve yazdirin
    //Visible Text kullanarak Option 1 i  ve Option 2 i secin ve yazdirin
    //Tum dropdown degerleri yazddirin
    //Dropdown un boyutunu bulun, Dropdown da 4 oge varsa konsolda true, degilse false yazdirin

    @Test
    public void Test1() throws InterruptedException {

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);

        //0. index --> Please select an option
        //1.index --> Option 1
        //2. index --> Option 2
        select.selectByIndex(1);
        Thread.sleep(2000);

        String selectedItemText = select.getFirstSelectedOption().getText();
        System.out.println("Seçilen şey: "+selectedItemText);


    }

    @Test
    public void Test2() {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);

        select.selectByValue("2");

        String selectedItemText = select.getFirstSelectedOption().getText();
        System.out.println("Seçilen öge: "+selectedItemText);
    }

    @Test
    public void Test3() {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);


        select.selectByVisibleText("Option 2");

        String selectedItemText = select.getFirstSelectedOption().getText();
        System.out.println("Seçilen öge: "+selectedItemText);
    }

    @Test
    public void Test4()  {
        /*
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Thread.sleep(2000);
        Select select = new Select(dropdown);

        List<WebElement> options = select.getAllSelectedOptions();
        for( WebElement opt : options){
            System.out.println("Dropdown içersindeki seçenekler :"+opt.getText());
        }
        */

        List<WebElement> tumddm = driver.findElements(By.xpath("//option"));
        for(WebElement w : tumddm){
            System.out.println(w.getText());
        }

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
