package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SucessPage {

    RemoteWebDriver driver;
    @FindBy(xpath = "(//h1)[2]")
    private WebElement success;
    public SucessPage(RemoteWebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public  String registrationSuccessHeading(){
        String s=success.getText();
       return s ;
    }
}
