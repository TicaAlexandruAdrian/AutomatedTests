package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;


public class EmagLoginPage {

    private WebDriver Emagdriver;
    private By Email = By.id ("user_login_email");
    private By Continue = By.id ("user_login_continue");
    private By Password = By.id ("user_login_password");
    private By Avatar = By.xpath("//*[@id=\"emg-user-menu\"]/div/div");

    public EmagLoginPage(WebDriver driver)
    {
        this.Emagdriver = driver;
    }

    public void getLogin()
    {
        Emagdriver.get("https://emag.ro/user/login");
        System.out.println("Reached Page");
    }

    public void LoginLandVerify()
    {
        Emagdriver.getCurrentUrl().contains("login");
        System.out.println("Logging In");
    }

    public void inputSubmitEmail() throws InterruptedException
    {
        WebDriverWait wait = new WebDriverWait(Emagdriver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Email));
        Emagdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Emagdriver.findElement(Email).sendKeys("testusername442@gmail.com");
        Thread.sleep( 4000);
        Emagdriver.findElement(Continue).click();
    }

    public void inputSubmitPassword()
    {
        WebDriverWait wait = new WebDriverWait(Emagdriver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Password));
        Emagdriver.findElement(Password).sendKeys("Pass1234!");
        Emagdriver.findElement(Continue).click();
    }

    public void seeUserLoggedIn()
    {
        WebDriverWait wait = new WebDriverWait(Emagdriver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Avatar));
    }

    public void fastLogin() throws InterruptedException
    {
        this.getLogin();
        this.inputSubmitEmail();
        this.inputSubmitPassword();
        this.seeUserLoggedIn();
    }

}
