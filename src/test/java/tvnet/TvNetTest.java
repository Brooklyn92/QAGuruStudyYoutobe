package tvnet;

import org.junit.jupiter.api.AfterEach;
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

public class TvNetTest {
    private final String HOME_PAGE_URL = "https://www.tvnet.lv/";
    private final By ACCEPT_COOKIES = By.xpath("//button[@mode='primary']");
    private final By ARTICLE_TITLE = By.xpath(".//span[@itemprop='headline name']");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[@itemprop = 'headline name']");
    private final String GIVEN_TITLE = "Latvijas slimnīcās samazinājies Covid-19 pacientu skaits";
    private WebDriver driver;

    @Test
    public void titleCheck() {
        System.setProperty("webdriver.chrome.driver", "C://webdrivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(2000,0));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));  // в параметрах указывается объект браузерного окна и параметр объекта продолжительности ожидания.
                                                                                // Данное ожидаение является не ЯВНЫМ

        //================ВХОД НА ГЛАВНУЮ СТРАНИЦУ И ПРИНЯТИЕ КУКОВ=====================================
        driver.get(HOME_PAGE_URL);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES));// в методе until( ждать ДО) указываем в параметраъ объект ExpectedConditions(ожидаемые условия)
        driver.findElement(ACCEPT_COOKIES).click();

        List<WebElement> titles = driver.findElements(ARTICLE_TITLE);

        //================================FOR EACH====================================================
        for (WebElement title : titles) {
            if (title.getText().startsWith(GIVEN_TITLE)) { // прогоняет текс до тех пор, пока значение title не будет начинаться с искомого локатора GIVEN_TITLE
                title.click();
                break; // после успешного нахождения tittle, выходим из цикла
            }
        }

        WebElement firstTitle = driver.findElement(ARTICLE_PAGE_TITLE);
        Assertions.assertEquals(GIVEN_TITLE, firstTitle.getText(), "Wrong title"); //GIVEN_TITLE-ожидаемый результат, firstTitle - фактический результат


       /*
        //================ПОЛУЧЕНИЕ ТЕКСТА ЗАГОЛОВКА  и ПОЛУЧЕНИЕ ТЕКСТА ЗАГОЛОВКА ЧЕРЕЗ КОЛЛЕКЦИЮ LIST И МЕТОДА findElements======================================
        WebElement firstTitle = driver.findElement(ARTICLE_TITLE);
        System.out.println(firstTitle.getText());
        List<WebElement> titles = driver.findElements(ARTICLE_TITLE);

        List<WebElement> titles = driver.findElements(ARTICLE_TITLE);
        System.out.println(titles.get(0).getText());
        System.out.println(titles.get(0).getText().equals(firstTitle.getText()));



        //================ПОЛУЧЕНИЕ И ПЕЧАТЬ ВСЕХ НАЙДЕННЫЙХ ЗАГОЛОВКОВ=============================================
        for (WebElement title:titles) {
            System.out.println(title.getText());
        }


        //================================FOR====================================================
//        for (int i = 0; i<titles.size(); i++ ) {
//            System.out.println(i+1 + ": " + titles.get(i).getText());
//        }

        //==========================================WHILE================================================
//        int i = 0;
//        while (i<titles.size()) {
//            System.out.println(i+1 + ": " + titles.get(i).getText());
//            i++;
//        }

        */
    }

    @AfterEach // аннтотация, которая помечает,что метод запускается после отработки кажого метода.
    public void closeBrowser() {
        //driver.close();
    }
}
