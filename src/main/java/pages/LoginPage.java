package pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    RemoteWebDriver driver;
    @FindBy(id = "input-email")
    private WebElement email;
    @FindBy(id = "input-password")
    private WebElement password;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement login;
@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
private WebElement warningmessage;
    public LoginPage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
   public void emailtext(String emailaddres){
        email.sendKeys(emailaddres) ;
    }
    public void passwordtext(String password1){

        password.sendKeys(password1);
    }
    public void loginbutton(){
        login.click();
    }
    public String actualwarningmessage(){
        return warningmessage.getText();
    }
    public Boolean warningmessageDisplay(){
        return warningmessage.isDisplayed();
    }
    public void login(String emailaddres, String password1)throws ElementClickInterceptedException {
        email.sendKeys(emailaddres);
        password.sendKeys(password1);
        login.click();

    }
}
