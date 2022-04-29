package pageObject.pages;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
}
