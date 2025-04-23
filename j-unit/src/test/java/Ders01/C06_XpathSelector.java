package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_XpathSelector {
    public static void main(String[] args) {

        //Chrome'u import et
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Eğer süre dolduktan sonra da öğe bulunamazsa, NoSuchElementException fırlatılır.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //Add Element butonuna basiniz
        WebElement addElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        addElement.click();


        //Delete butonu nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.xpath("//*[text()='Delete']"));
        deleteButton.isDisplayed(); // görünür mü değil mi kontrolü



        //Delete butonuna basiniz
        //"Add/Remove Elements" yazisinin gorunur oldugunu test edin
        //Browser i kapatalim

    }
}
