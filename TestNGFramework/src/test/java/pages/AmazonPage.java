package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    //ctor
    //ctor metot, bu sınıftan bir nesne oluşturulduğunda otomatik olarak çalışır
    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(), this);

       // AmazonPage() constructor'ı çağrıldığında PageFactory class'ı kullanarak WebElement’leri başlatır.
       // @FindBy ile tanımlanan elementler, initElements() metodu sayesinde otomatik olarak WebDriver ile ilişkilendirilir.

    }


    @FindBy(id="sp-cc-accept")
    public WebElement cookie;

    @FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
    public WebElement searchbox;




}
