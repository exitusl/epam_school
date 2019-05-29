package testsforWordPress;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;

public class LoginTest extends BaseTest {

    @Test(description = "авторизация")
    public void successLogin(){
        HomePage homepage = new HomePage(driver);
        homepage.goToLoginPage()
                .loginTocabinet("test_olga", "123456");
    }
}
