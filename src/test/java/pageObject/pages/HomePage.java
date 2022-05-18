package pageObject.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObject.BaseFunc;
import pageObject.model.Article;
import java.util.List;

public class HomePage {

    private final By ACCEPT_COOKIES = By.xpath("//button[@mode='primary']");
    private final By COMMENT_COUNT = By.xpath(".//span[contains(@class, 'article__comment')]");
    private final By ARTICLE = By.tagName("article");
    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc=baseFunc;
    }

    public void acceptCookie() {
        baseFunc.click(ACCEPT_COOKIES);
    }

    public Article getArticleById(int articleNumber) {
        List<WebElement> articlesElements= baseFunc.findElements(ARTICLE); // формируется список статей на главной странице
        Assertions.assertFalse(articlesElements.isEmpty(), "There are no articles"); //проверка на содержании статьи на странице
        WebElement currentArticle = articlesElements.get(articleNumber - 1); // посколько мы считаем с 1, а индексы с 0, то делаем articleNumber - 1
        mapArticle(currentArticle);
    }

    private Article mapArticle(WebElement we) {
        Article article = new Article();

        if (baseFunc.findElements(we,COMMENT_COUNT).isEmpty()) {
            article.setCommentCount(0); // if there is no element with comments count -> commentsCount = 0
        }
        else {
            baseFunc.findElements(we, COMMENT_COUNT).get(0).getText(); // else we are getting webElement with comments count, parse  to int and store it
        }

        article.setCommentCount();
        article.setTitle();
        return article;

    }
}
