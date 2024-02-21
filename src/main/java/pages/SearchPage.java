package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    RemoteWebDriver driver;

    @FindBy(linkText = "HP LP3065")
    private WebElement Searchedproduct;
    @FindBy(xpath = "//input[@id='button-search']//following-sibling::p")
    private WebElement noMatchingProductmessage;
    public SearchPage(RemoteWebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean Searchedproduct(){
        return Searchedproduct.isDisplayed();
    }
    public String noMatchingProductmessage(){
        return noMatchingProductmessage.getText();
    }
}
