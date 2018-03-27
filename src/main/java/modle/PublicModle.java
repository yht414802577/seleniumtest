package modle;

import logo.SelLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class PublicModle {
    private static final SelLogger logger = SelLogger.getLogger(PublicModle.class);
    //截屏方法
    public void CaptureScreenshot(String fileName, WebDriver driver){
        String dirname = "test-output/screenshot";
        if (!(new File(dirname).isDirectory())){
            new File(dirname).mkdir();
        }
        SimpleDateFormat sdf = new SimpleDateFormat( "yy/MM/dd-HH:mm");   //时间格式化
        String time = sdf.format(new Date());
        TakesScreenshot ts = (TakesScreenshot)driver;
        File image = new File(dirname + File.separator + time + "_" + fileName + ".png");    //截屏保存图片名称
        ts.getScreenshotAs(OutputType.FILE).renameTo(image);
    }
    //根据ID等待页面元素
    public void waitForDriverByID(final String ID , WebDriver driver){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);  //浏览地超时等待时间设为10秒
            wait.until(new ExpectedCondition<WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.id(ID));
                }
            });
            if (null == wait) {
                this.CaptureScreenshot(Thread.currentThread().getId() + "ID", driver);   //超时自动截屏保存图片
                driver.quit();
            }
        }catch (Exception a){
            a.printStackTrace();
            this.CaptureScreenshot(Thread.currentThread().getId() + "ID" , driver);
            driver.quit();
        }
    }
    //根据css等待页面元素
    public void waitForDriverByCss(final String CSS , WebDriver driver){
        try {
            WebDriverWait wait = new WebDriverWait(driver,10);
            if(null == wait){
                this.CaptureScreenshot(Thread.currentThread().getId() + "CSS" , driver);
                driver.quit();
            }
        }catch (Exception a){
            a.printStackTrace();
            this.CaptureScreenshot(Thread.currentThread().getId() + "CSS" , driver);
            driver.quit();
        }
    }

    //根据name等待页面元素
    public void waitForDriverByName(final String Name , WebDriver driver){
        try {
            WebDriverWait wait = new WebDriverWait(driver,10);
            if(null == wait){
                this.CaptureScreenshot(Thread.currentThread().getId() + "Name" , driver);
                driver.quit();
            }
        }catch (Exception a){
            a.printStackTrace();
            this.CaptureScreenshot(Thread.currentThread().getId() + "Name" , driver);
            driver.quit();
        }
    }

    //根据linkText等待页面元素
    public void waitForDriverBylinkText(final String linkText , WebDriver driver){
        try{
            WebDriverWait wait = new WebDriverWait(driver , 10);
            wait.until(new ExpectedCondition<WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.linkText(linkText));
                }
            });
            if (null == wait){
                this.CaptureScreenshot(Thread.currentThread().getId() + "linkText" , driver);
                driver.quit();
            }
        }catch (Exception a){
            a.printStackTrace();
            this.CaptureScreenshot(Thread.currentThread().getId() + "linkText" , driver);
            driver.quit();
        }
    }
    //根据Title切换窗口
    public boolean switchToWindow_Title(WebDriver driver , String windowTitle) {
        boolean flag = false;
        try {
            String currentHandle = driver.getWindowHandle(); //获取当前窗口
            Set<String> handles = driver.getWindowHandles(); //获取当前多个窗口
            for (String s : handles) {
                if (s.equals(currentHandle)) {
                    continue;
                }
                else {
                    driver.switchTo().window(s);
                    if (driver.getTitle().contains(windowTitle)) {
                        flag = true;
                        break;
                    } else {
                        continue;
                    }
                }
            }
        } catch (NegativeArraySizeException a) {
            System.out.print("Window:" + windowTitle + "cound not find!!!" + a.fillInStackTrace());
            flag = false;
        }
        return flag;
    }
    //根据url切换窗口
    public boolean switchToWindow_Url(WebDriver driver , String windowUrl){
        boolean flag = false;
        try{
            String currentHandle = driver.getWindowHandle();
            Set<String> handle = driver.getWindowHandles();
            for (String s:handle){
                if (s.equals(currentHandle)){
                    continue;
                }else{
                    driver.switchTo().window(s);
                    if (driver.getCurrentUrl().contains(windowUrl)){
                        flag = true;
                        break;
                    }else{
                        continue;
                    }
                }
            }
        }catch (NegativeArraySizeException a){
            System.out.print("Window:" + windowUrl + "cound not find!!!" + a.fillInStackTrace());
            flag = false;
        }
        return flag;
    }

}


