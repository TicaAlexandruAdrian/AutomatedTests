package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DemoBlazeLoginPage {

    private WebDriver DemoBlazeDriver;
    private By LogIn = By.id ("login2");
    private By Username = By.id ("loginusername");
    private By ContinueButton = By.xpath ("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
    private By Password = By.id ("loginpassword");
    private By NameofUser = By.id("nameofuser");


    public DemoBlazeLoginPage(WebDriver driver)
    {
        this.DemoBlazeDriver = driver;
    }

    public void getLogin()
    {

        DemoBlazeDriver.get("https://www.demoblaze.com/");
        DemoBlazeDriver.findElement(LogIn).click();
        System.out.println("Reached Page");
    }

    public void LoginLandVerify()
    {

        DemoBlazeDriver.getCurrentUrl().contains("demoblaze");
        System.out.println("Prepairing to Log In");
    }

    public void inputSubmitEmail() throws InterruptedException
    {
        WebDriverWait wait = new WebDriverWait(DemoBlazeDriver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Username));
        DemoBlazeDriver.findElement(Username).sendKeys("DemoBlazeTest");

    }

    public void inputSubmitPassword()
    {
        WebDriverWait wait = new WebDriverWait(DemoBlazeDriver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Password));
        DemoBlazeDriver.findElement(Password).sendKeys("Test1");
        DemoBlazeDriver.findElement(ContinueButton).click();
    }

    public void seeUserLoggedIn()
    {
        WebDriverWait wait = new WebDriverWait(DemoBlazeDriver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(NameofUser));
    }

    public void fastLogin() throws InterruptedException
    {
        this.getLogin();
        this.inputSubmitEmail();
        this.inputSubmitPassword();
        this.seeUserLoggedIn();
    }

}
