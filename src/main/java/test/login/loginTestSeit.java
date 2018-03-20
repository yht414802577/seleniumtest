package test.login;

import logo.SelLogger;
import modle.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class loginTestSeit {
    private static final SelLogger logger = SelLogger.getLogger(loginTestSeit.class);
    private WebDriver driver;
    private String indexUrl;
    private boolean accpetNextAlter = true;
    private StringBuffer verificatError = new StringBuffer();
    FileExlce file = new FileExlce();
    PublicModle pm = new PublicModle();
    brower b = new brower();
    SiteUrl su = new SiteUrl();

//    @BeforeClass
//    public static void setUpBeforeClass() throws Exception{
//
//    }
//
//    @AfterClass
//    public static void tearDownAfterClass() throws Exception {
//
//    }
//
//
//
//    @Test
//    public void Login_Test_case_01(){
//        logger.log("login start");
//        driver.get(indexUrl);
//        Login login = new Login(driver);
//        login.passWord(file.password());
//        login.userName(file.userNaem());
//        login.clickLoginButton();
//        try{
//            Thread.sleep(3000);
//        }catch (InterruptedException a){
//            a.printStackTrace();
//        }
//        login.check();
//        logger.log("login end");
//    }
    @BeforeGroups
    public void setUo() throws Exception{
        driver = b.firefoxbrower();
        indexUrl = su.indexUrl();

    }

    @AfterGroups
    public void  taerdown() throws  Exception{
        driver.quit();
        String verificationerrorString = verificatError.toString();
        if (!"".equals(verificationerrorString)){


        }
    }

    @Test(groups = {"login"})
    public void Login_phone_TestCase_01() throws Exception{
        logger.log("login start!!!");
        driver.get(indexUrl);
        Login login = new Login(driver);
        login.userName(file.userNaem());
        login.passWord(file.password());
        login.clickLoginButton();
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        login.check();
        logger.log("login end!!!");
    }
}
