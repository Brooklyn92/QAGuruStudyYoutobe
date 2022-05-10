package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseFunc {

    public WebDriver browser;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().setPosition(new Point(2000,0));
        browser.manage().window().maximize();
    }

    public void openUrl(String url) {
        if (!url.startsWith("https://")) {
            url = "https://" + url;
        }
        browser.get(url);
    }

    public void click(By locator) { //  в параметр метода передаётся тип данных локатора
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public List<WebElement> findElements(By locator) {
        return browser.findElements(locator);
    }

    public List<WebElement> findElements(WebElement parent, By child) {
        return parent.findElements(child);
    }

    public String getText(WebElement parent, By child) {

    }
}
