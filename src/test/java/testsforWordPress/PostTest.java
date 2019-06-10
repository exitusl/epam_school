package testsforWordPress;

import org.testng.annotations.Test;
import pages.PostPage;

public class PostTest extends BaseTest {

    @Test(description = "добавление статьи", dependsOnMethods = "LoginTest")
    public void addArticle() {
        PostPage postPage = new PostPage(driver);
        postPage.clickBtnAddNote();
        postPage.writeTitleAndBody(Title, BodyText);

    }
}
