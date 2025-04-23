package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PracticePage {

    //bu sınıftan bir nesne oluşturulduğunda otomatik olarak constructor metot çalışır.
    public PracticePage(){
        //Selenium'un sağladığı bir yardımcı sınıf olan PageFactory, web elementlerini kolayca başlatmak için kullanılır.,@FindBy gibi anotasyonlarla tanımlanan elementleri otomatik olarak bulur ve sınıfa enjekte eder.
        PageFactory.initElements(Driver.getDriver(),this);
        //this ise PracticePage class'ının kendisini temsil eder.

    }

    @FindBy (xpath = "//input[@id='username']")
    public WebElement email;

    @FindBy (xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy (xpath = "//button[@id='submit']")
    public WebElement loginBtn;

    @FindBy (xpath = "//div[@id='error']")
    public WebElement errorPopUpUsername;


    @FindBy (xpath = "//div[@id='error']")
    public WebElement errorPopUpPassword;


}
