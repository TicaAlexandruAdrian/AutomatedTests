package Tests;

import Pages.DemoBlazeCheckoutElements;
import Pages.DemoBlazeLoginPage;
import Pages.SoundcloudLoginPage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoBlazeCheckout {

    public ChromeDriver ChDvr;

    @BeforeMethod
    public void before()
    {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        ChDvr = new ChromeDriver();
    }

    @Test
    public  void verifyCheckoutStream () throws InterruptedException {

        DemoBlazeLoginPage Login = new DemoBlazeLoginPage (ChDvr);
        DemoBlazeCheckoutElements CheckoutPage = new DemoBlazeCheckoutElements (ChDvr);

        Login.fastLogin();
        CheckoutPage.addProduct("MacBook air");
        CheckoutPage.addProduct("s6");
        CheckoutPage.addProduct("ASUS Full HD");
        CheckoutPage.PlaceOrder();

    }

    @AfterMethod
    public void after() {
        ChDvr.quit();
    }
}
