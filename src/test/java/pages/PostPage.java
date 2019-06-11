package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class PostPage extends BasePage {
    public PostPage(WebDriver driver) {
        super(driver);
    }

     By add = By.xpath("//div[@aria-label='Верхняя панель']//span[contains (text(), 'Добавить')]");
     By addNote = By.xpath("//li[@class='menupop']//a[contains(text(),'Запись')]");
     By textHeadline = By.xpath("//div[@class='editor-post-title']//textarea");
     By textBodyline = By.xpath("//textarea[contains(@class, 'editor-default-block-appender')]");
     By textBodyBox = By.xpath("//p[@role='textbox']");
     By btnPublish = By.xpath("//div[@class='edit-post-header__settings']//button[contains(text(),'Опубликовать')]");

    public void clickBtnAddNote() {
        Actions actions = new Actions(driver);
        actions.moveToElement(toWebElement (add)).build().perform();
        wait.until(ExpectedConditions.visibilityOf(toWebElement (addNote))).click();
    }

    public void writeTitleAndBody(String Title, String BodyText) {
        writeText(textHeadline, Title);
        (toWebElement (textBodyline)).click();
        writeText(textBodyBox,BodyText);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        (toWebElement (btnPublish)).click();
        (toWebElement (btnPublish)).click();
    }
    public String getLastTitle() {
        String lastTitle = driver.findElement(By.xpath("//article[position()=1]//header//a"))
                .getText();
        return lastTitle;
    }
    public String getLastTextBody() {
        String lastText = driver.findElement(By.xpath("//article[position()=1]" +
                "//div[contains(@class,'entry-content')]//p"))
                .getText();
        return lastText;
    }
    private WebElement toWebElement(By element){
        return driver.findElement(element);
    }

}
