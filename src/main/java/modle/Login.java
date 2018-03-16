package modle;

import logo.SelLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

public class Login {
    private static final SelLogger logger = SelLogger.getLogger(Login.class);
    private WebDriver dirver;
    PublicModle p = new PublicModle();

    @FindBy(how = How.ID , using = "loginname")
    public static WebElement loginnameInputbox;

    @FindBy(how = How.ID , using = "loginpwd")
    public static WebElement loginpwdInputbox;

    @FindBy(how = How.ID , using = "btn_login")
    public static WebElement loginBtn;

    @FindBy(how = How.LINK_TEXT , using = "退出")
    public static WebElement loginResult;

    public Login(WebDriver driver){
        this.dirver = driver;
        ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver , 120);
        PageFactory.initElements(finder , this);     //隐身等待

//        PageFactory.initElements(new AjaxElementLocatorFactory(driver , 120) , this);

        driver.manage().window().maximize();
    }

    public String userName(String userNameTxy){
        loginnameInputbox.clear();
        loginnameInputbox.sendKeys(userNameTxy);
        return userNameTxy;
    }

    public String passWord(String userPwdTxt){
        loginpwdInputbox.clear();
        loginpwdInputbox.sendKeys(userPwdTxt);
        return userPwdTxt;
    }

    public void clickLoginButton(){
        p.waitForDriverByID("btn_login" , dirver);
        loginBtn.click();
    }

    public void check(){

    }
}
