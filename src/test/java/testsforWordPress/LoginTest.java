package testsforWordPress;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.ITestContext;

import pages.BasePage;
import pages.HomePage;

public class LoginTest extends BaseTest {


    @Test(description = "авторизация")
    @Parameters({"username", "password"} )
    public void successLogin(String username, String password){
         }
}
