package Tests;

import Pages.DemoBlazeLoginPage;
import Pages.SoundcloudLoginPage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoBlazeLogin {

    public ChromeDriver ChDvr;

    @BeforeMethod
    public void before()
    {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        ChDvr = new ChromeDriver();
    }


    @Test
    public void verifyValidLogin () throws InterruptedException {

        DemoBlazeLoginPage Login = new DemoBlazeLoginPage (ChDvr);

        Login.getLogin();
        Login.LoginLandVerify();
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
