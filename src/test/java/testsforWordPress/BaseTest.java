package testsforWordPress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.HomePage;

public class BaseTest {
    public WebDriver driver;
 //   protected String username="test_olga";
 //   protected String password="123456";
    protected String Title="New Title";
    protected String BodyText="BodyText";

    @BeforeTest
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        System.setProperty("webdriver.chrome.driver", "src/main/tools/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @BeforeTest(dependsOnMethods = "setup")
    @Parameters({"username", "password"} )
    public void login(String username, String password){ ;
        HomePage homepage = new HomePage(driver);
        homepage.openHomePage()
                .loginTocabinet(username, password);
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
