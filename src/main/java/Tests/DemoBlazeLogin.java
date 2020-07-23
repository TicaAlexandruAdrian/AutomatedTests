package Tests;

import Pages.DemoBlazeLoginPage;
import Pages.SoundcloudLoginPage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoBlazeLogin {


    @Test
    public  void verifyValidLogin () throws InterruptedException {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        ChromeDriver ChDvr = new ChromeDriver();

        DemoBlazeLoginPage Login = new DemoBlazeLoginPage (ChDvr);

        Login.getLogin();
        Login.LoginLandVerify();
        Login.inputSubmitEmail();
        Login.inputSubmitPassword();
        Login.seeUserLoggedIn();
        ChDvr.quit();
    }


}
