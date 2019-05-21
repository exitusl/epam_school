import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class testclass {

    private WebDriver driver;
    private String login="test_olga";
    private String password="123456";

    @BeforeMethod
    public void createDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/tools/chromedriver.exe");
        driver = new ChromeDriver();
 //       driver.navigate().to("http://127.0.0.1/wordpress/wp-login.php");
 //       driver.navigate().to("http://localhost/wordpress/wp-login.php");
        driver.navigate().to("http://v999140x.beget.tech/wp-login.php");
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test
  //  @Parameters({"login, password"})
    public void Authorization() {

        WebElement loginUser = driver.findElement(By.xpath("//input[@id='user_login']"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  //      loginUser.sendKeys("user1");
        loginUser.sendKeys(login);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement loginPassword = driver.findElement(By.xpath("//input[@id='user_pass']"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  //      loginPassword.sendKeys("user1@gmail.com");
        loginPassword.sendKeys(password);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement btnEnter = driver.findElement(By.xpath("//p[@class='submit']/input[@type='submit']"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        btnEnter.click();
        WebElement displayName = driver.findElement(By.xpath("//a[contains(text(),'Привет')]/span"));
  /*      Actions actions = new Actions(driver);
        actions.moveToElement(displayName).build().perform();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement usernameDisplay = driver.findElement(By.xpath("//span[@class='username']"));
       actions.moveToElement(usernameDisplay).build().perform();
  */
        Assert.assertEquals(displayName.getText(), login);

    }

    @Test ()
   public void addArticle() {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Authorization();
        WebElement add = driver.findElement(By.xpath("//div[@aria-label='Верхняя панель']//span[contains (text(), 'Добавить')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(add).build().perform();
        WebElement addNote = driver.findElement(By.xpath("//li[@class='menupop']//a[contains(text(),'Запись')]"));
        addNote.click();
     //   add.click();
        WebElement btnPublish =driver.findElement(By.xpath("//div[@class='edit-post-header__settings']//button[contains(text(),'Опубликовать')]"));
        btnPublish.isDisplayed();
        if (driver.findElement(By.xpath("//div[@class='components-popover__content']")).isDisplayed())
        {
            driver.findElement(By.xpath("//div[@class='components-popover__content']")).click();
        }

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


    @AfterMethod
    public void quitDriver() {
        if (driver!=null) {
            driver.quit();
        }
    }
}
