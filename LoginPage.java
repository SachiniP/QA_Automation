package Page;


/**
 * Created by EF on 08/03/2017.
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class LoginPage {

    private By lnkLogin= By.xpath("//a[contains(.,'Log in')]");
    private By txtUsername = By.id("username");
    private By txtPassword = By.id("password");
    private By btnLogin = By.id("loginbtn");
    private By lblLoginErrorMessage = By.xpath("//div[@class='alert alert-danger ng-binding']");
    private By lblLogo=By.id("page-header");
    private By lnkRequestForms=By.xpath("//a[contains(.,'Request Forms')]");
    private By lnkCertificateType= By.xpath("//span[contains(.,'TRANSCRIPT / RESULT SHEET REQUEST FORM')]");
    private By txtName=By.name("name_with_initials");
    private By txtregNo=By.name("student_registration_number");
    private By radioTranscriptType=By.id("advanced_diploma");
    private By radioCampus=By.id("metro");
    private By radioFaculty= By.id("computing");
    private By radioYear=By.id("year_2");
    private By txtAddress=By.name("present_address");
    private By txtcontactNumber=By.name("contact_number");
    private By txtEmail=By.name("student_email");
    private By radioAl=By.name("no");
    private By btnSubmit=By.xpath("//button[contains(.,'Submit')]");





    WebDriver driver = null;

    public LoginPage(){
        System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chrome_driver\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.navigate().to("http://courseweb.sliit.lk/");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }
    public void clickLoginLink()
    {
        driver.findElement(lnkLogin).click();
    }

    public void enterUsername(String username){
        driver.findElement(txtUsername).clear();
        driver.findElement(txtUsername).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(txtPassword).clear();
        driver.findElement(txtPassword).sendKeys(password);

    }

    public void clickLogin(){
        driver.findElement(btnLogin).click();
    }


    public boolean checkElement()
    {
        boolean element = false;
        if (driver.findElement(lblLogo).isDisplayed())
        {
            element= true;
            System.out.println("--------------Start of Check Element Present Status----------------");
             System.out.println(element);
            System.out.println("--------------End of Check Element Present Status------------------");
            return element;
        }
        else {
            System.out.println("--------------Start of Check Element Present Status----------------");
            System.out.println(element);
            System.out.println("--------------End of Check Element Present Status------------------");
            return element;
        }
    }

    public void fromParentToChild()
    {
        String Parent_Window=driver.getWindowHandle();
        for (String Child_Window : driver.getWindowHandles())
        {
            driver.switchTo().window(Child_Window);
            System.out.println("Done");
        }
    }

    public void fromChildToParent()
    {
        String Child_Window=driver.getWindowHandle();
        for (String Parent_Window : driver.getWindowHandles())
        {
            driver.switchTo().window(Parent_Window);
        }
    }


    public void fillRequestForm(String Name,String regNo ,String Address,String contactNumber,String Email)
    {

        driver.findElement(lnkRequestForms).click();
        driver.findElement(lnkCertificateType).click();
       // driver.switchTo().window(myWindow);
        fromParentToChild();
        driver.findElement(txtName).sendKeys(Name);
        driver.findElement(txtregNo).sendKeys(regNo);
        driver.findElement(radioTranscriptType).click();
        driver.findElement(radioCampus).click();
        driver.findElement(radioFaculty).click();
        driver.findElement(radioYear).click();
        driver.findElement(txtAddress).sendKeys(Address);
        driver.findElement(txtcontactNumber).sendKeys(contactNumber);
        driver.findElement(txtEmail).sendKeys(Email);
        driver.findElement(radioAl).click();
        driver.quit();
        fromChildToParent();

    }

    public String getErrorMessage(){
        return   driver.findElement(lblLoginErrorMessage).getText();
    }

    public void closeBrowser(){
        driver.quit();
    }
}
