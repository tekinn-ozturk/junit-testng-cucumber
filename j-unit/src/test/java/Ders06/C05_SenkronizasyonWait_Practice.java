package Ders06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C05_SenkronizasyonWait_Practice extends TestBaseBeforeAfter {

    @Test

    public void test() {
        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement txtBox = driver.findElement(By.xpath("//form[@id='input-example']/input[1]"));
        Assert.assertTrue("Enable", !txtBox.isEnabled());
        //Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebElement enableButton =driver.findElement(By.xpath("//button[.='Enable']"));
        enableButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //element tıklanabilir hale gelene kadar bekle
        wait.until(ExpectedConditions.elementToBeClickable(txtBox));
        Assert.assertTrue("Enable değil", txtBox.isEnabled());
        //“It’s enabled!” mesajinin goruntulendigini dogrulayın.
        //Textbox’in etkin oldugunu(enabled) dogrulayın.

    }
}
