import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MainClassTest {


    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() throws MalformedURLException {
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mark\\Desktop\\Учеба\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        //driver =new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/");
        mainPage = new MainPage(driver);

    }




    @Test
    public void signInTest(){
        LogInPage logInPage = mainPage.clickSignIn();
        String heading = logInPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }
    @Test
    public void registerFailTest(){
      SignUpPage signUpPage = mainPage.register("fiasd421","4fdfs@vd.dw","111111111111111");
        String error = signUpPage.getMainTextError();
        Assert.assertEquals("There were problems creating your account.",error);


    }
    @Test
    public void signUpEmplyLoginTest(){
        SignUpPage signUpPage= mainPage.register("","4fdfs@vd.dw","111111111111111");
        String error =signUpPage.getUserNameError();
        Assert.assertEquals("Username can't be blank",error);

    }
    @Test
    public void signUpInvalidEmailTest(){
        SignUpPage signUpPage= mainPage.register("fsafsfafs","43123123","111111111111111");
        String error =signUpPage.getEmailError();

        Assert.assertEquals("Email is invalid or already taken",error);

    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
