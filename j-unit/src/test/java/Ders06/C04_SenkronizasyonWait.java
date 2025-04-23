package Ders06;

import org.checkerframework.dataflow.qual.AssertMethod;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C04_SenkronizasyonWait extends TestBaseBeforeAfter {

    @Test


    public void implicityWaitTest() {
        //https://the-internet.herokuapp.com/dynamic_controls adresine gidelim
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //Remove butonuna basin.
        WebElement removeButton = driver.findElement(By.xpath("//button[.='Remove']"));
        removeButton.click();
        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGone= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue("Metin Eşleşmedi",itsGone.getText().contains("It's gone!"));
        //Add buttonuna basin
        WebElement addButton = driver.findElement(By.xpath("//button[.='Add']"));
        addButton.click();
        WebElement itsBack= driver.findElement(By.xpath("//p[@id='message']"));
        //It’s back mesajinin gorundugunu test edin
        Assert.assertTrue("Metin Eşleşmedi",itsBack.getText().contains("It's back!"));

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //implicityWait'i biz testBaseBeforeAfter class'ına gömdük zaten o yüzden bu metodun içinde ayrıca kullanmadık.
        //implicityWait'in olayı kodumuzdaki tüm elementleri verilen sürede bulunana kadar bekler aksi halde NoSuchelementExc fırlatır.

    }

    public void explicityWaitTest() {
        //https://the-internet.herokuapp.com/dynamic_controls adresine gidelim
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //Remove butonuna basin.
        WebElement removeButton = driver.findElement(By.xpath("//button[.='Remove']"));
        removeButton.click();
        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement itsGone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue("Metin Eşleşmedi",itsGone.getText().contains("It's gone!"));
        //Add buttonuna basin
        WebElement addButton = driver.findElement(By.xpath("//button[.='Add']"));
        addButton.click();
        WebElement itsBack= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue("Metin Eşleşmedi",itsBack.getText().contains("It's back!"));


        //explicityWait'in olayı ise find edilen elementten önce tanımlanan WebDriverWait nesnesi sadece o nesnenin bulunmasını bekler girilen süre boyunca.Bulunmazsa hata fırlatır bulunursa o kadar süre beklemeden element bulunduğu an wait'i atlar.
    }
}
