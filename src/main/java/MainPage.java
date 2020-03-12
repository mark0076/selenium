import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    private By signInButton = By.xpath("//a[@class='HeaderMenu-link no-underline mr-3']");
    private By signUpButton = By.xpath("//a[@class='HeaderMenu-link no-underline mr-3']\");\n[@class=\"HeaderMenu-link d-inline-block no-underline border border-gray-dark rounded-1 px-2 py-1\"]");
    private By userNameField = By.xpath("//input[@id=\"user[login]\"]");
    private By userEmaliField = By.xpath("//input[@id=\"user[email]\"]");
    private By userPasswordField = By.xpath("//input[@id=\"user[password]\"]");
    private By signUpForGitHub = By.xpath("//button[@class=\"btn-mktg btn-primary-mktg btn-large-mktg f4 btn-block my-3\"]");

    public LogInPage clickSignIn(){
        driver.findElement(signInButton).click();
        return new LogInPage(driver);

    }
public SignUpPage clickSighUp(){
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);

}
    public SignUpPage clickSignUpButton(){
        driver.findElement(signUpForGitHub).click();
        return new SignUpPage(driver);

    }
    public MainPage typeUserName(String userName){
        driver.findElement(userNameField).sendKeys(userName);
        return this;

    }
    public MainPage typeEmailField(String email){
        driver.findElement(userEmaliField).sendKeys(email);
        return this;
    }
    public MainPage typePasswird(String password){
        driver.findElement(userPasswordField).sendKeys(password);
        return this;

    }
    public SignUpPage register(String userName,String email,String password){
        this.typeUserName(userName);
        this.typeEmailField(email);
        this.typePasswird(password);
        this.clickSignUpButton();
        return new SignUpPage(driver);

    }






}
