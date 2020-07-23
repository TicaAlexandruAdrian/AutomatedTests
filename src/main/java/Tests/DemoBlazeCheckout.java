package Tests;

import Pages.DemoBlazeCheckoutElements;
import Pages.DemoBlazeLoginPage;
import Pages.SoundcloudLoginPage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoBlazeCheckout {


    @Test
    public  void verifyCheckoutStream () throws InterruptedException {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        ChromeDriver ChDvr = new ChromeDriver();

        DemoBlazeLoginPage Login = new DemoBlazeLoginPage (ChDvr);
        DemoBlazeCheckoutElements CheckoutPage = new DemoBlazeCheckoutElements (ChDvr);

        Login.fastLogin();
        CheckoutPage.addProduct("MacBook air");
        CheckoutPage.addProduct("s6");
        CheckoutPage.addProduct("ASUS Full HD");
        CheckoutPage.PlaceOrder();
        ChDvr.quit();
    }


}
