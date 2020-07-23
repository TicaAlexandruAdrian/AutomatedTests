package Tests;

import Pages.EmagLoginPage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EmagLogin {


    @Test
    public  void verifyValidLogin () throws InterruptedException {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        ChromeDriver ChDvr = new ChromeDriver();

        EmagLoginPage Login = new EmagLoginPage(ChDvr);

        Login.getLogin();
        Login.LoginLandVerify();
        Thread.sleep( 4000);
        Login.inputSubmitEmail();
        Login.inputSubmitPassword();
        Login.seeUserLoggedIn();
        ChDvr.quit();
    }


}
