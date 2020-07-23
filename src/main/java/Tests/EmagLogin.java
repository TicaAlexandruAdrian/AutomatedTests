package Tests;

import Pages.EmagLoginPage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmagLogin {

    public ChromeDriver ChDvr;

    @BeforeMethod
    public void before()
    {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        ChDvr = new ChromeDriver();
    }

    @Test
    public  void verifyValidLogin () throws InterruptedException {

        EmagLoginPage Login = new EmagLoginPage(ChDvr);

        Login.getLogin();
        Login.LoginLandVerify();
        Thread.sleep( 4000);
        Login.inputSubmitEmail();
        Login.inputSubmitPassword();
        Login.seeUserLoggedIn();
    }

    @AfterMethod
    public void after()
    {
        ChDvr.quit();
    }


}
