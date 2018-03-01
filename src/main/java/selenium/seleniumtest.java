package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public abstract class seleniumtest {

//    private WebDriver driver;

//    public WebDriver brower(){
//        driver = new FirefoxDriver();
//        System.setProperty("webdriver.gecko.driver","D:\\Program Files\\Mozilla Firefox\\geckodriver.exe");
//        System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");
//        return driver;
//    }

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver","D:\\Program Files\\Mozilla Firefox\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver.get("http://www.baidu.com");
    }
}
