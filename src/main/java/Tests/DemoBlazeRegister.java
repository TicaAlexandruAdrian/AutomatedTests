package Tests;

import Pages.DemoBlazeLoginPage;
import Pages.DemoBlazeRegisterPage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoBlazeRegister {

    @Test
    public  void verifyValidSignIn () throws InterruptedException {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        ChromeDriver ChDvr = new ChromeDriver();

        DemoBlazeRegisterPage Register = new DemoBlazeRegisterPage(ChDvr);
        DemoBlazeLoginPage LoginPage = new DemoBlazeLoginPage(ChDvr);

        Register.getSignIn();
        Register.SignUpLandVerify();
        Register.inputSubmitEmail();
        Register.inputSubmitPassword();
        LoginPage.fastLogin();
        Register.seeUserSignedUp();

        ChDvr.quit();
    }


}


