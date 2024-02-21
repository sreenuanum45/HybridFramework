package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    RemoteWebDriver driver;
    @FindBy(linkText = "Edit your account information")
    private WebElement edityouraccountinformation;

    public AccountPage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public Boolean edityouraccountinformation(){
        return edityouraccountinformation.isDisplayed();
    }

}
