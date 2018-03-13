package modle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class brower {
    private WebDriver driver;
    public WebDriver firefoxbrower(){
        driver = new FirefoxDriver();
        return driver;
    }
    public WebDriver chromebrower(){
        driver = new ChromeDriver();
        return driver;
    }
    public  WebDriver iebrower(){
        driver = new InternetExplorerDriver();
        return driver;
    }
}
