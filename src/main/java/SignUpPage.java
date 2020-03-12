import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }


    private By headnig = By.xpath("//div[@class=\"text-mono text-center text-gray-light text-normal mb-3\"]");
    private By userName = By.xpath("//input[@name=\"user[login]\"]");
    private By email = By.xpath("//input[@name=\"user[email]\"]");
    private By password = By.xpath("//input[@id='user_password']");
    private By button= By.xpath("//button[@type=\"submit\"]");
    private By userNameError = By.xpath("//dl[@class=\"form-group my-3 errored required\"]//dd[@class='error']");
    private By invalidEmail= By.xpath("//label[@name='user[email]']//parent::dt//following-sibling::dd[@class=\"error\"]");
    private By underPassword15 = By.xpath("//p[@class=\"note mb-3\"]/span[@class=\"text-red text-bold\" and text()='at least 15 characters']");
    private By underPassword8 = By.xpath("//p[@class=\"note mb-3\"]/span[@class=\"text-red text-bold\" and text()='at least 8 characters']");
    private By underPasswordIncN = By.xpath("//p[@class=\"note mb-3\"]/span[@class=\"text-red text-bold\" and text()='including a number']");
    private By underPasswordLowLet = By.xpath("//p[@class=\"note mb-3\"]/span[@class=\"text-red text-bold\" and text()='and a lowercase letter']");
    private By userNameTakenMessage =By.xpath("//input[@id=\"user_login\"]/../following-sibling::dd//div[@class=\"mb-1 \"]");
    private By emailTakenMessage = By.xpath("//input[@id=\"user_email\"]/../following-sibling::dd[@class='error']");

    private By mainError = By.xpath("//div[@class=\"flash flash-error my-3\"]");
public String checkEmail(String email1){
    typeEmail(email1);
    return driver.findElement(emailTakenMessage).getText();
}

public String checkUserName(String user1){
    typeUserName(user1);
   return driver.findElement(userNameTakenMessage).getText();


}
    public String  checkUnderPassword15(){
        return driver.findElement(underPassword15).getText();
    }
    public String checkUnderPassword8(){
        return driver.findElement(underPassword8).getText();
    }
    public String checkUnderPasswordIncN(){
        return driver.findElement(underPasswordIncN).getText();
    }
    public String checkUnderPasswordLowLet(){
        return driver.findElement(underPasswordLowLet).getText();
    }

    public SignUpPage typeUserName(String user1) {
        driver.findElement(userName).sendKeys(user1);
        return this;

    }

    public SignUpPage typeEmail(String email1) {
        driver.findElement(email).sendKeys(email1);
        return this;
    }

    public SignUpPage typePassword(String password1) {
        driver.findElement(password).sendKeys(password1);
        return this;

    }

    public SignUpPage registerWithIndalidCreds(String user, String email, String password) {
        this.typeUserName(user);
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(button).click();
        return new SignUpPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(headnig).getText();
    }

    public String getMainTextError() {
        return driver.findElement(mainError).getText();
    }

    public String getUserNameError(){
        return driver.findElement(userNameError).getText();
    }
    public String getEmailError(){
        String error = driver.findElement(invalidEmail).getText();
        return error;
    }

}

















