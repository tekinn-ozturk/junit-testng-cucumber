package tests.Ders11;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_AmazonPageClass {

    @Test
    public void Test() throws InterruptedException {

        AmazonPage amazonPage = new AmazonPage();
        //Amazona git.
        Driver.getDriver().get(ConfigReader.getProperty("amazonURL"));
        Thread.sleep(1000);
        amazonPage.cookie.click();

        //Selenium aratalım.
        amazonPage.searchbox.sendKeys("Selenium", Keys.ENTER);
        





    }
}
