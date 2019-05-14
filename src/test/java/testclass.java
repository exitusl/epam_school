import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class testclass {

    private WebDriver driver;

    @BeforeTest
    public void createDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/tools/chromedriver.exe");
        driver = new ChromeDriver();
 //       driver.navigate().to("http://127.0.0.1/wordpress/wp-login.php");
 //       driver.navigate().to("http://localhost/wordpress/wp-login.php");
        driver.navigate().to("http://v999140x.beget.tech/wp-login.php");

    }

    @Test
    public void login() {

        WebElement loginUser = driver.findElement(By.xpath("//input[@id='user_login']"));
  //      loginUser.sendKeys("user1");
        loginUser.sendKeys("test_olga");
        WebElement loginPassword = driver.findElement(By.xpath("//*[@id='loginform']//input[@id='user_pass']"));
  //      loginPassword.sendKeys("user1@gmail.com");
        loginPassword.sendKeys("123456");
        WebElement btnEnter = driver.findElement(By.xpath("//p[@class='submit']/input[@type='submit']"));
        btnEnter.click();
        WebElement displayName = driver.findElement(By.xpath("//a[contains(text(),'Привет']/span"));
        Assert.assertEquals("User1", displayName.getText());
    }

 /*   public void addArticle() {
        WebElement add = driver.findElement(By.xpath("//div[@aria-label='Верхняя панель']//span[contains (text(), 'Добавить')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(add).build().perform();
        WebElement addNote = driver.findElement(By.xpath("//li[@class='menupop']//a[contains(text(),'Запись')]"));
        addNote.click();
        WebElement btnPublish =driver.findElement(By.xpath("//div[@class='edit-post-header__settings']//button[contains(text(),'Опубликовать')]"));
        btnPublish.isDisplayed();
        WebElement textHeadline =driver.findElement(By.xpath("//div[@class='editor-post-title']//textarea"));
        textHeadline.click();
        textHeadline.sendKeys("New Headline");
        WebElement textBodyline =driver.findElement(By.xpath("////div[@class='editor-rich-text']//p"));
        textBodyline.click();
        textBodyline.sendKeys("This is your new post.");
        btnPublish.isEnabled();
        btnPublish.click();
        btnPublish.click();
    }

    public void checkArticle() {
        driver.navigate().to("http://127.0.0.1/wordpress/wp-login.php");

    }

*/

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }
}
