package tests.Ders11;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverFirstTest {

    @Test
    public void test() {
        //Static metoda direkt ulaşılabilir metota ulaştık, getDriver metodu ile driver'ı çalıştırdık ardından get ile 'de adresi bastık, get driver başlatmaktan ayrı bi olay o yüzden getDriver() ardından yazıyoruz mecburen.
        Driver.getDriver().get("https://www.amazon.com.tr/");
        Driver.getDriver().get("https://www.bestbuy.com");
        Driver.closeDriver();
        Driver.getDriver().get("https://www.hepsiburada.com/");
        Driver.quitDriver();


    }
}
