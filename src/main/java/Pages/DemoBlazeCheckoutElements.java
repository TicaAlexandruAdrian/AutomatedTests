package Pages;

import Tests.DemoBlazeRegister;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Vector;
import Pages.DemoBlazeLoginPage;

public class DemoBlazeCheckoutElements {

    private WebDriver DemoBlazeDriver;
    private By Cart = By.id ("cartur");
    private By Product;
    private By AddtoCart = By.xpath ("//*[@id=\"tbodyid\"]/div[2]/div/a");
    private By PhonesButton = By.xpath ("/html/body/div[5]/div/div[1]/div/a[2]");
    private By LaptopsButton = By.xpath("/html/body/div[5]/div/div[1]/div/a[3]");
    private By MonitorsButton = By.xpath("/html/body/div[5]/div/div[1]/div/a[4]");
    private By PlaceOrder = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");
    private By NextButton = By.id ("next2");
    private By OrderName = By.id("name");
    private By OrderCountry = By.id("country");
    private By OrderCity = By.id("city");
    private By OrderCC = By.id("card");
    private By OrderMonth = By.id("month");
    private By OrderYear = By.id("year");
    private By PurchaseButton = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
    private Vector <By> ObjectVector = new Vector <By>(3);
    private By CheckOrderStatus = By.xpath("/html/body/div[10]");
    private int resetFlag;

    public DemoBlazeCheckoutElements(WebDriver driver)
    {
        this.DemoBlazeDriver = driver;
    }

    public void addProduct(String product) throws InterruptedException
    {

        if(resetFlag==1)
        {
            DemoBlazeDriver.get("https://www.demoblaze.com");
            resetFlag = 0;
        }

        if (!DemoBlazeDriver.findElements(By.xpath("//*[contains(text(),'"+ product +"')]")).isEmpty())
        {
            DemoBlazeDriver.findElement(By.xpath("//*[contains(text(),'" + product + "')]")).click();

            WebDriverWait wait2 = new WebDriverWait(DemoBlazeDriver, 3);
            wait2.until(ExpectedConditions.visibilityOfElementLocated(AddtoCart));


            DemoBlazeDriver.findElement(AddtoCart).click();
            new WebDriverWait(DemoBlazeDriver, 3).until(ExpectedConditions.alertIsPresent());
            Alert alert = DemoBlazeDriver.switchTo().alert();

            if (alert.getText().contains("added"))
            {
                DemoBlazeDriver.switchTo().alert().accept();
            }
        }
         else
         {
                if (!DemoBlazeDriver.findElements(NextButton).isEmpty())
                {
                    DemoBlazeDriver.findElement(NextButton).click();
                    Thread.sleep(1000);
                    addProduct(product);
                    resetFlag=1;
                }
         }
    }



    public void inputOrderName()
    {
        DemoBlazeDriver.findElement(OrderName).sendKeys("OrderTest1");
    }
    public void inputOrderCountry()
    {
        DemoBlazeDriver.findElement(OrderCountry).sendKeys("OrderTest1");
    }

    public void inputOrderCity()
    {
        DemoBlazeDriver.findElement(OrderCity).sendKeys("OrderTest1");
    }

    public void inputOrderCC()
    {
        DemoBlazeDriver.findElement(OrderCC).sendKeys("OrderTest1");
    }
    public void inputOrderMonth()
    {
        DemoBlazeDriver.findElement(OrderMonth).sendKeys("OrderTest1");
    }
    public void inputOrderYear()
    {
        DemoBlazeDriver.findElement(OrderYear).sendKeys("OrderTest1");
    }
    public void PurchaseButton()
    {
        DemoBlazeDriver.findElement(PurchaseButton).click();
    }

    public void CheckOrder()
    {
        DemoBlazeDriver.findElement(CheckOrderStatus);
    }

    public void PlaceOrder() throws InterruptedException
    {
           DemoBlazeDriver.get("https://www.demoblaze.com");
           DemoBlazeDriver.findElement(Cart).click();
           Thread.sleep(1000);
           DemoBlazeDriver.findElement(PlaceOrder).click();
           Thread.sleep(1000);
           inputOrderName();
           inputOrderCountry();
           inputOrderCity();
           inputOrderCC();
           inputOrderMonth();
           inputOrderYear();
           PurchaseButton();
           CheckOrder();
    }

}
