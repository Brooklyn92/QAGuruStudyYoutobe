package pageObject;

import org.junit.jupiter.api.Test;
import pageObject.pages.BaseFunc;
import pageObject.pages.HomePage;

public class ArticleTests {
    private final String HOME_PAGE_URL = "tvnet.lv";

    @Test
    public void titleAndCommentCountCheck() {

        //Open browser window (maximize it)
        BaseFunc baseFunc = new BaseFunc();

        //Open home page
        baseFunc.openUrl(HOME_PAGE_URL);

        //Accept cookies


        //Get 3rd article title

        //Get 3rd article comments count

        //Open 3rd article

        //Get title

        //Get comments count

        //Compare titles

        //Compare comments counts

    }
}
