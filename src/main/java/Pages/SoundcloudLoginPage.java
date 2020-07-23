package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;


public class SoundcloudLoginPage {

    private WebDriver SoundcloudDriver;
    private By SignIn = By.xpath ("//*[@id=\"content\"]/div/div/div[1]/div/div[2]/button[1]");
    private By Email = By.xpath ("/html/body/div/div/div/div/div/form/div[1]/div/input");
    private By ContinueButton = By.id ("sign_in_up_submit");
    private By PasswordField = By.name ("password");
    private By ContinuePassword = By.id("enter_password_submit");
    private By AvatarBox = By.xpath("//*[@id=\"app\"]/header/div/div[3]/div[2]/a[1]/div[2]");

    public SoundcloudLoginPage (WebDriver driver)
    {
        this.SoundcloudDriver = driver;
    }

    public void getLogin()
    {
        SoundcloudDriver.get("https://soundcloud.com/");
        SoundcloudDriver.findElement(SignIn).click();
        System.out.println("Reached Page");
    }

    public void LoginLandVerify()
    {
        SoundcloudDriver.getCurrentUrl().contains("soundcloud.com");
        System.out.println("Prepairing to Log In");
    }

    public void inputSubmitEmail() throws InterruptedException
    {
        SoundcloudDriver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(SoundcloudDriver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Email));
        SoundcloudDriver.findElement(Email).sendKeys("testusername442@gmail.com");
        SoundcloudDriver.findElement(ContinueButton).click();
    }

    public void inputSubmitPassword()
    {
        WebDriverWait wait = new WebDriverWait(SoundcloudDriver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PasswordField));
        SoundcloudDriver.findElement(PasswordField).sendKeys("Pass1234!");
        if (SoundcloudDriver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]"))!=null)
        {
            SoundcloudDriver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();
        }
        SoundcloudDriver.findElement(ContinuePassword).click();
    }

    public void seeUserLoggedIn()
    {
        WebDriverWait wait = new WebDriverWait(SoundcloudDriver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(AvatarBox));
    }

    public void fastLogin() throws InterruptedException
    {
        this.getLogin();
        this.inputSubmitEmail();
        this.inputSubmitPassword();
        this.seeUserLoggedIn();
    }

}
