package testsforWordPress;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;

public class LoginTest extends BaseTest {

    @Test(description = "авторизация")
  //  @Parameters({"username", "password"})
    public void successLogin(){
        HomePage homepage = new HomePage(driver);
        homepage.openHomePage()
                .loginTocabinet(username, password);
    }
}
