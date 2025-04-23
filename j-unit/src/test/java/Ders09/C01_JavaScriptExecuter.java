package Ders09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C01_JavaScriptExecuter extends TestBaseBeforeAfter {

    @Test
    public void test() throws InterruptedException {

        //Amazon sayfasına git.
        //Kariyer etiketine tıkla.


        Thread.sleep(2000);
        driver.get("https://www.amazon.com.tr/");

        WebElement careerTag = driver.findElement(By.xpath("//a[normalize-space()='Kariyer']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",careerTag);

        js.executeScript("arguments[0].click()",careerTag);



    }
}
