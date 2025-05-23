package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {


    static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver==null){
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    driver= new ChromeDriver();
                    break;
                case "edge":
                    driver= new EdgeDriver();
                case "mozilla":
                    driver= new FirefoxDriver();
                default:
                    driver=new ChromeDriver();
            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;

    }


    public static void closeDriver(){

        //bu metodu kullanıyosan driver'ı kapamak istiyosundur ve driver null değildir.
        if(driver !=null){
            driver.close();
            driver=null;
        }
    }

    public static void quitDriver(){
        if(driver !=null){
            driver.quit();
            driver=null; /*
             driver.quit(); tarayıcıyı kapatsa bile, Java'da driver referansı hâlâ bellekte tutulur.
             Eğer driver referansını null yapmazsak, program driver değişkeninin hâlâ geçerli bir nesneye
             işaret ettiğini sanabilir.*/
        }
    }


}
