package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.python.antlr.ast.Assert;
import utilities.Utilites_1;

public class RegisterPage {
    RemoteWebDriver driver;
    @FindBy(css = "#input-firstname")
    private WebElement firstname;
    @FindBy(css = "#input-lastname")
    private WebElement lastname;
    @FindBy(css = "#input-email")
    private WebElement email;
    @FindBy(name = "telephone")
    private WebElement telephone;
    @FindBy(id = "input-password")
    private WebElement password;
    @FindBy(id = "input-confirm")
    private WebElement confirmpassword;
    @FindBy(name = "agree")
    private WebElement agree;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement continuebutton;
    @FindBy(xpath = "(//input[@type='radio'])[2]")
    private WebElement newsletter_chechbox;
    @FindBy(xpath = "//div[@class='text-danger']")
    private WebElement passwordmismatchWarningMessage;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement duplicateemailwarningmessage;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement PrivacyPolicyWarningMessage;
    @FindBy(xpath = "//input[@id='input-firstname']//following::div[1]")
    private WebElement FirstnameWarningMessage;
    @FindBy(xpath = "//input[@id='input-lastname']//following::div[1]")
    private WebElement LastnameWarningMessage;
    @FindBy(xpath = "//input[@id='input-email']//following::div[1]")
    private WebElement EmailAddressWarningmessage;
    @FindBy(xpath = "//input[@id='input-telephone']//following::div[1]")
    private WebElement telephoneWarningMessage;
    @FindBy(xpath = "//input[@id='input-password']//following::div[1]")
    private WebElement passwordWarningmessage;

    public RegisterPage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void firstnameField(String firstnamefield){
        firstname.sendKeys(firstnamefield);
    }
    public void lastnameField(String lastnamefield){
        lastname.sendKeys(lastnamefield);
    }
    public  void emailField(String emailfield){
        email.sendKeys(emailfield);
    }
    public void telephoneField(String telephonefield){
        telephone.sendKeys(telephonefield);
    }
    public void passwordField(String passwordfield){
        password.sendKeys(passwordfield);
    }
    public void confirmpasswordField(String confirmpasswordfield){
        confirmpassword.sendKeys(confirmpasswordfield);
    }
    public void agreecheckbox(){
        agree.click();
    }
    public SucessPage continuebuttonClick(){
        continuebutton.click();
        return new SucessPage(driver);
    }
    public void newsletter_chechbox(){
        newsletter_chechbox.click();
    }
    public String passwordmismatchWarningMessage(){
        return passwordmismatchWarningMessage.getText();
    }
    public String duplicateemailwarningmessage(){
        return duplicateemailwarningmessage.getText();
    }
    public String PrivacyPolicyWarningMessage(){
        return PrivacyPolicyWarningMessage.getText();
    }
    public String FirstnameWarningMessage(){
        return FirstnameWarningMessage.getText();
    }
    public String LastnameWarningMessage(){
        return LastnameWarningMessage.getText();
    }
    public String EmailAddressWarningmessage(){
        return EmailAddressWarningmessage.getText();
    }
    public String telephoneWarningMessage(){
        return telephoneWarningMessage.getText();
    }
    public String passwordWarningmessage(){
        return passwordWarningmessage.getText();
    }
    public void registerAccountWithMandatoryFields(String firstname, String lastname, String email, String telephone, String password, String confirmpassword){
        firstnameField(firstname);
   lastnameField(lastname);
        emailField(email);
    telephoneField(telephone);
       passwordField(password);
   confirmpasswordField(confirmpassword);
      agreecheckbox();
    }
    public void registerwithAccountWithAllFields(String firstname, String lastname, String email, String telephone, String password, String confirmpassword){
        firstnameField(firstname);
        lastnameField(lastname);
        emailField(email);
        telephoneField(telephone);
        passwordField(password);
        confirmpasswordField(confirmpassword);
        agreecheckbox();
        newsletter_chechbox.click();
    }
    public String registerwithPassswordAndConfirmFieldsame(String firstname, String lastname, String email, String telephone, String password, String confirmpassword)
    {
        firstnameField(firstname);
        lastnameField(lastname);
        emailField(email);
        telephoneField(telephone);
        passwordField(password);
        confirmpasswordField(confirmpassword);
        agreecheckbox();
        newsletter_chechbox.click();
    continuebuttonClick();
    return passwordWarningmessage.getText();

    }
    public String registerwithProvidingTheExistingAccountDetails(String firstname, String lastname, String email, String telephone, String password, String confirmpassword){
        firstnameField(firstname);
        lastnameField(lastname);
        emailField(email);
        telephoneField(telephone);
        passwordField(password);
        confirmpasswordField(confirmpassword);
        agreecheckbox();
        newsletter_chechbox.click();
        continuebuttonClick();
        String s=duplicateemailwarningmessage.getText();
        return s;
    }

}
