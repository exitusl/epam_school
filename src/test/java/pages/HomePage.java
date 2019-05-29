package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver){

        super(driver);
    }
    By loginButton = By.id("wp-submit");
    By loginField = By.id("user_login");
    By passField = By.id("user_pass");


    public HomePage loginTocabinet (String username, String password){
        writeText(loginField, username);
        writeText(passField, password);
        click(loginButton);
        return this;
    }
    public HomePage openHomePage() {
        driver.get("http://v999140x.beget.tech/wp-login.php");
        return this;
    }

    /*   String baseURL ="http://test:test_123@localhost/wordpress/";
       By loginLink = By.xpath("http://v999140x.beget.tech/wp-login.php");

       public HomePage goToMainPage(){
           driver.get(baseURL);
           return this;
       }

    public LoginPage goToLoginPage(){
        click(loginLink);
        return new LoginPage(driver);
    }
     */
}

