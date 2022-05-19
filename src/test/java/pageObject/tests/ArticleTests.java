package pageObject.tests;
import org.junit.jupiter.api.Test;
import pageObject.BaseFunc;
import pageObject.model.Article;
import pageObject.pages.HomePage;

public class ArticleTests {
    private final String HOME_PAGE_URL = "tvnet.lv";

    @Test
    public void titleAndCommentCountCheck() {

        //Open browser window (maximize it)
        BaseFunc baseFunc1 = new BaseFunc();

        //Open home page
        baseFunc1.openUrl(HOME_PAGE_URL);
        HomePage homePage = new HomePage(baseFunc1); // в параметре конструктора указываем текущее браузерное окно

        //Accept cookies
        homePage.acceptCookie();


        //Get 3rd article
        Article article = homePage.getArticleById(16);
        System.out.println(article.getCommentCount());

        //Open 3rd article

        //Get title

        //Get comments count

        //Compare titles

        //Compare comments counts

    }
}
