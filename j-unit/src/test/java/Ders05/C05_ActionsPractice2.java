package Ders05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C05_ActionsPractice2 extends TestBaseBeforeAfter {

    @Test
    public void Test() throws InterruptedException {
        //https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Thread.sleep(1000);
        WebElement dragMe = driver.findElement(By.xpath("//div[@id='draggable']"));


        Thread.sleep(1000);
        WebElement dropHere = driver.findElement(By.xpath("//div[@id='simpleDropContainer']/div[@id='droppable']"));
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(dragMe).dragAndDrop(dragMe,dropHere).perform();
    }
}
