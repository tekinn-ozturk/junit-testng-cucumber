package Ders05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C06_ActionsPractice3 extends TestBaseBeforeAfter {

    @Test
    public void Test() throws InterruptedException {
        //1- https://www.facebook.com adresine gidelim
//        driver.get("https://www.facebook.com");
        //2- Yeni hesap olustur butonuna basalim
        Thread.sleep(2000);
        WebElement createAccountButton = driver.findElement(By.xpath("//a[.='Yeni hesap oluştur']"));
        createAccountButton.click();

        //List<String> windowHandleCode = new ArrayList<>(driver.getWindowHandles());
        //driver.switchTo().window(windowHandleCode.get(1));


        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement nameInput= driver.findElement(By.xpath("//input[@name='firstname']"));
        WebElement surnameInput =driver.findElement(By.xpath("//input[@name='lastname']"));

        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));

        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));

        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='reg_email__']"));

        WebElement manRadioButton = driver.findElement(By.xpath("//label[.='Erkek']"));

        WebElement password = driver.findElement(By.xpath("//input[@id='password_step_input']"));

        Thread.sleep(2000);
        Actions actions = new Actions(driver);

        actions.click(nameInput).keyDown(Keys.SHIFT).sendKeys("t").keyUp(Keys.SHIFT).sendKeys("ekin").click(surnameInput).keyDown(Keys.SHIFT).sendKeys("o").keyUp(Keys.SHIFT).sendKeys("zturk").click(day).sendKeys("8").click(month).sendKeys("May").click(year).sendKeys("1998").click(manRadioButton).click(phoneNumber).sendKeys("5061367971").click(password).sendKeys("123456789").perform();





    }
}
