package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {

        super(driver);
    }

    By loginButton = By.id("wp-submit");
    By loginField = By.id("user_login");
    By passField = By.id("user_pass");

    public LoginPage loginTocabinet (String username, String password){
        writeText(loginField, username);
        writeText(passField, password);
        click(loginButton);
        return this;
    }
}
