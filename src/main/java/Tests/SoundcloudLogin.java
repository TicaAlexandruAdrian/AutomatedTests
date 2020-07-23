package Tests;

import Pages.SoundcloudLoginPage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SoundcloudLogin {

    public ChromeDriver ChDvr;

    @BeforeMethod
    public void before()
    {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        ChDvr = new ChromeDriver();
    }

    @Test
    public  void verifyValidLogin () throws InterruptedException {

        SoundcloudLoginPage Login = new SoundcloudLoginPage (ChDvr);
        Login.fastLogin();

    }

    @AfterMethod
    public void after()
    {
        ChDvr.quit();
    }

}
