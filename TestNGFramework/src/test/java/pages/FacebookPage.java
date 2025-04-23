package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="email")
    public WebElement email;

    @FindBy(id="pass")
    public WebElement password;

    @FindBy(xpath="(//button[contains(text(),'Giriş Yap')])[1]")
    public WebElement loginButton;

}
