package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DemoBlazeRegisterPage
{

    private WebDriver DemoBlazeDriver;
    private By SignIn = By.id ("signin2");
    private By Username = By.id ("sign-username");
    private By ContinueButton = By.xpath ("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");
    private By Password = By.id ("sign-password");
    private By NameofUser = By.id("nameofuser");

    public DemoBlazeRegisterPage(WebDriver driver) {
        this.DemoBlazeDriver = driver;
    }

    public void getSignIn()
    {

        DemoBlazeDriver.get("https://www.demoblaze.com/");
        DemoBlazeDriver.findElement(SignIn).click();
        System.out.println("Reached Page");
    }

    public void SignUpLandVerify()
    {
        DemoBlazeDriver.getCurrentUrl().contains("demoblaze");
        System.out.println("Prepairing to Sign In");
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
        new WebDriverWait(DemoBlazeDriver, 3).until(ExpectedConditions.alertIsPresent());
        Alert alert = DemoBlazeDriver.switchTo().alert();
        if(alert.getText().contains("already"))
        {
            System.out.println("Error: User Already Exists");
        }
        else
        {
            DemoBlazeDriver.switchTo().alert().accept();
        }

    }

    public void seeUserSignedUp()
    {
        WebDriverWait wait = new WebDriverWait(DemoBlazeDriver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(NameofUser));
    }

    public void fastSignUp() throws InterruptedException
    {
        this.getSignIn();
        this.SignUpLandVerify();
        this.inputSubmitEmail();
        this.inputSubmitPassword();
        this.seeUserSignedUp();
    }

}
