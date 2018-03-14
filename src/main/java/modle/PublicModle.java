package modle;

import logo.SelLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PublicModle {
    private static final SelLogger logger = SelLogger.getLogger(PublicModle.class);
    public void CaptureScreenshot(String fileName, WebDriver driver){
        String dirname = "test-output/screenshot";
        if (!(new File(dirname).isDirectory())){
            new File(dirname).mkdir();
        }
        SimpleDateFormat sdf = new SimpleDateFormat( "yy/MM/dd-HH:mm");
        String time = sdf.format(new Date());
        TakesScreenshot ts = (TakesScreenshot)driver;
        File image = new File(dirname + File.separator + time + "_" + fileName + ".png");
        ts.getScreenshotAs(OutputType.FILE).renameTo(image);
    }
    public void waitForDriverByID(final String ID , WebDriver driver){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(new ExpectedCondition<WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.id(ID));
                }
            });
            if (null == wait) {
                this.CaptureScreenshot(Thread.currentThread().getId() + "ID", driver);
                driver.quit();
            }
        }catch (Exception a){
            a.printStackTrace();
            this.CaptureScreenshot(Thread.currentThread().getId() + "ID" , driver);
            driver.quit();
        }
    }

}

}
