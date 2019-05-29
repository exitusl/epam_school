package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostPage extends BasePage {
    public PostPage(WebDriver driver) {
        super(driver);
    }

    By btnPublish = By.xpath("//div[@class='edit-post-header__settings']//button[contains(text(),'Опубликовать')]");
    By add = By.xpath("//div[@aria-label='Верхняя панель']//span[contains (text(), 'Добавить')]");
    By addNote = By.xpath("//li[@class='menupop']//a[contains(text(),'Запись')]");
    By textHeadline = By.xpath("//div[@class='editor-post-title']//textarea");
    By textBodyline = By.xpath("//textarea[contains(@class, 'editor-default-block-appender')]");

}
