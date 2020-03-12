import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SignUpPageTest {

    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setUp() throws MalformedURLException {
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mark\\Desktop\\Учеба\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        DesiredCapabilities caps = DesiredCapabilities.chrome();
      //  driver =new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com/join");
        signUpPage = new SignUpPage(driver);
    }
    @Test
    public void Test15Ch(){
SignUpPage newSignUpPage =signUpPage.typePassword("12345Lp");
String nd2=newSignUpPage.checkUnderPassword15();
Assert.assertEquals("at least 15 characters",nd2);
    }
    @Test
    public void Test8Ch(){
        SignUpPage newSignUpPage =signUpPage.typePassword("12345Lp");
        String nd2=newSignUpPage.checkUnderPassword8();
        Assert.assertEquals("at least 8 characters",nd2);
    }
    @Test
    public void TestIncN(){
        SignUpPage newSignUpPage =signUpPage.typePassword("lOdasdc@");
        String nd2=newSignUpPage.checkUnderPasswordIncN();
        Assert.assertEquals("including a number",nd2);
    }
    @Test
    public void TestLowLet(){
        SignUpPage newSignUpPage =signUpPage.typePassword("1211111");
        String nd2=newSignUpPage.checkUnderPasswordLowLet();
        Assert.assertEquals("and a lowercase letter",nd2);
    }
    @Test
    public void CheckUserNameField(){
        String user1 ="123123";
     String fs =signUpPage.checkUserName(user1);
      Assert.assertEquals("Username "+user1+" "+"is not available.",fs);
    }
    @Test
    public void CheckEmailField(){
        String email ="rma0076@gmail.com";
        String message =signUpPage.checkEmail(email);
        Assert.assertEquals("Email is invalid or already taken",message);
    }
    @Test
    public void CheckHeading(){
        String heading= signUpPage.getHeadingText();
        Assert.assertEquals("Join GitHub",heading);
    }





    @After
    public void TearDown(){
        driver.quit();
    }
}
