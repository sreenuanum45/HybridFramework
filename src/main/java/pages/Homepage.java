package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Homepage {
    RemoteWebDriver driver;
    @FindBy(xpath = "(//li[@class='dropdown']//a)[1]")
    private WebElement myAccountDropDown;
    @FindBy(xpath = "//a[text()='Login']")
    private WebElement login;
    @FindBy(linkText = "Register")
    private WebElement register;
    @FindBy(name = "search")
    private WebElement searchfield;
    @FindBy(xpath = "//div[@id='search']//button")
    private WebElement searchbutton;

    public Homepage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickOnmyAccount(){
        myAccountDropDown.click();

    }
    public LoginPage login(){
        login.click();
        return new LoginPage(driver);
    }
    public RegisterPage registerbutton(){
        register.click();
        return new RegisterPage(driver);

    }
    public void searchproductname(String product){
        searchfield.sendKeys(product);

    }
    public SearchPage searchbutton(){
        searchbutton.click();
        return new SearchPage(driver);
    }

}
