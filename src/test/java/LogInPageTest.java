import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LogInPageTest {
    private WebDriver driver;
    private LogInPage logInPage;

    @Before
    public void setUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mark\\Desktop\\Учеба\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        DesiredCapabilities caps = DesiredCapabilities.chrome();
       // driver =new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com/login");
        logInPage = new LogInPage(driver);
    }

    @Test
    public void LogInWithEmptyCredsTest(){
        LogInPage newLoginPage =logInPage.loginWithInvalidCreds("","");
      String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.",error);
    }
    @Test
    public void LogInWithIncorrectCredsTest(){
        LogInPage newLoginPage =logInPage.loginWithInvalidCreds("fdsfasfa","dasdasdas");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.",error);
    }
    @Test
    public void CreateAccountTest(){
        SignUpPage signUpPage = logInPage.createAccount();
       String heading= signUpPage.getHeadingText();
       Assert.assertEquals("Join GitHub",heading);
    }


        @After
        public void tearDown(){
            driver.quit();
        }




    }










