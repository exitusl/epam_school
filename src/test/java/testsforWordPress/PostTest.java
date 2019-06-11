package testsforWordPress;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PostPage;

public class PostTest extends BaseTest {

    @Test(description = "добавление статьи")
    public void addPost() {
        PostPage postPage = new PostPage(driver);
        postPage.clickBtnAddNote();
        postPage.writeTitleAndBody(Title, BodyText);

    }
//
//    @Test(description = "добавление статьи", dependsOnMethods = "addPost")
//    public void checkPost(String title, String bodyText) {
//        PostPage postPage = new PostPage(driver);
//        String getTitle = postPage.getLastTitle();
//        Assert.assertEquals(title, getTitle);
//
//        String getTextBody = postPage.getLastTextBody();
//        Assert.assertEquals(bodyText, getTextBody);
//    }
}
