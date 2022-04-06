package tvnet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomeWorkLesson8 {
    private final String HOME_PAGE_URL = "https://www.tvnet.lv/";
    private final By ACCEPT_COOKIES = By.xpath("//button[@mode='primary']"); // принятие cookies
    private final By ARTICLE_TITLE = By.xpath(".//span[@itemprop='headline name']");// все статьи на галвной странице
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[@itemprop = 'headline name']"); // заголовок в самой статье
    private final String GIVEN_TITLE = "TVNET pēta ⟩ Sektu anatomija: no Čārlza Mensona ģimenes līdz dievišķajam DNS (8)"; // определенно искомая статья
    private final By COUNT_COMMENTS_IN_ARTICLE = By.xpath(".//span[contains(@class,'count' )]");// колличество комментариев в статье
    WebDriver driver;

    @Test
    public void titleCheck() {
        System.setProperty("webdriver.chrome.driver", "C://webdrivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(2000, 0));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // в параметрах указывается объект браузерного окна и параметр объекта продолжительности ожидания.
        // Данное ожидаение является не ЯВНЫМ

        //================ВХОД НА ГЛАВНУЮ СТРАНИЦУ И ПРИНЯТИЕ КУКОВ=====================================
        driver.get(HOME_PAGE_URL);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES));// в методе until( ждать ДО) указываем в параметраъ объект ExpectedConditions(ожидаемые условия)
        driver.findElement(ACCEPT_COOKIES).click();

        //================================FOR EACH====================================================
//        List<WebElement> titles = driver.findElements(ARTICLE_TITLE);
//        for (WebElement title : titles) {
//            if (title.getText().startsWith(GIVEN_TITLE)) { // прогоняет текс до тех пор, пока значение title не будет начинаться с искомого локатора GIVEN_TITLE
//                title.click();
//                break; // после успешного нахождения tittle, выходим из цикла
//            }
//        }
//
//        WebElement firstTitle = driver.findElement(ARTICLE_PAGE_TITLE);
//        Assertions.assertEquals(GIVEN_TITLE, firstTitle.getText(), "Wrong title"); //GIVEN_TITLE-ожидаемый результат, firstTitle - фактический результат

        List<WebElement> checks = driver.findElements(ARTICLE_TITLE);

        for (WebElement check: checks) {
            if (check.getText().startsWith(GIVEN_TITLE)) { // прогоняет текс до тех пор, пока значение title не будет начинаться с искомого локатора GIVEN_TITLE
                check.click();
                break; // после успешного нахождения tittle, выходим из цикла
            }
        }
            String count = driver.findElement(COUNT_COMMENTS_IN_ARTICLE).getText();
            Assertions.assertEquals("8", count);

    }
}
