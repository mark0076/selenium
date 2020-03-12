import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
    private WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    private By usernameField =By.xpath("//input[@id=\"login_field\"]");

    private By passwordField = By.xpath("//input[@id='password']");

    private By SignInButton = By.xpath("//input[@type='submit']");

    private By heading = By.xpath("//h1[text()='Sign in to GitHub']");
    private By error = By.xpath("//div[@class=\"auth-form-header p-0\"]/following-sibling::div[@id=\"js-flash-container\"]");
    private By createAnAccount = By.xpath("//a[text()='Create an account']");

    public  LogInPage typeUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public LogInPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LogInPage submitData(){
        driver.findElement(SignInButton).click();
        return this ;
    }

    public LogInPage loginWithInvalidCreds(String username,String password){
        this.typeUsername(username);
        this.typePassword(password);
        driver.findElement(SignInButton).click();
        return new LogInPage(driver);
    }
    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }
    public String getErrorText(){
        return driver.findElement(error).getText();
    }
    public SignUpPage createAccount(){
        driver.findElement(createAnAccount).click();
        return new SignUpPage(driver);
    }
}
