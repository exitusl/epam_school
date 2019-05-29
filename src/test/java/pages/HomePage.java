package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver){
        super(driver);
    }

 //   String baseURL ="http://test:test_123@localhost/wordpress/";
    By loginLink = By.xpath("http://v999140x.beget.tech/wp-login.php");

 /*   public HomePage goToMainPage(){
        driver.get(baseURL);
        return this;
    }
*/
    public LoginPage goToLoginPage(){
        click(loginLink);
        return new LoginPage(driver);
    }
}

