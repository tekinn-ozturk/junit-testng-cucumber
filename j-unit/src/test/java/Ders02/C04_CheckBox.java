package Ders02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBox {


    /*
      a. Verilen web sayfasına gidin.
      https://the-internet.herokuapp.com/checkboxes
      b. Checkbox1 ve checkbox2 elementlerini locate edin.
      c. Checkbox1 seçili değilse onay kutusunu tıklayın
      d. Checkbox2 seçili değilse onay kutusunu tıklayın
*/

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
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement chk1 = driver.findElement(By.xpath("//input[1]"));
        WebElement chk2 = driver.findElement(By.xpath("//input[2]"));
        Thread.sleep(2000);
        if (!chk1.isSelected()){
            chk1.click();
        }
        if (chk2.isSelected()){
            System.out.println("check box 2 seçilmiş durumda");
        }






    }


    @After
    public void tearDown() throws InterruptedException {
    driver.quit();

    }
}
