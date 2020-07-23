package Tests;

import Pages.SoundcloudLoginPage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SoundcloudLogin {


    @Test
    public  void verifyValidLogin () throws InterruptedException {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        ChromeDriver ChDvr = new ChromeDriver();

        SoundcloudLoginPage Login = new SoundcloudLoginPage (ChDvr);

        Login.fastLogin();
        ChDvr.quit();
    }


}
