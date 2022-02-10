package tvnet;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TvNetTest {
    private final String HOME_PAGE_URL = "https://www.tvnet.lv/";
    private final By ACCEPT_COOKIES = By.xpath("//button[@mode='primary']");
    @Test
    public void titleCheck() {
        System.setProperty("webdriver.chrome.driver", "C://webdrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get(HOME_PAGE_URL);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES));
        driver.findElement(ACCEPT_COOKIES).click();
    }
}
