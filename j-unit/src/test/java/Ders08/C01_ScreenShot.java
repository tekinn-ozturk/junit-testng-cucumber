package Ders08;

import ch.qos.logback.core.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C01_ScreenShot extends TestBaseBeforeAfter {

    //bestbuy sayfasına gidelim tum sayfanın resmini alalim

    @Test
    public void test() throws IOException {

        driver.get("https://www.bestbuy.com/");

        //ScreenShot Kutuphanesini kullan.
        TakesScreenshot ss = (TakesScreenshot) driver;

        //Ekran görüntüsünü al ve bir dosyaya kaydet.
        File fullScreen = ss.getScreenshotAs(OutputType.FILE);


        FileUtils.copyFile(fullScreen,new File("target/ekranGoruntusu/AllPage"+tarih+".jpeg"));
        //(dosya, new File(projede kaydedilecek konum, klasör adı, dosya tam adı(AllPage+format.jpeg)))



    }
}
