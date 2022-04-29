package pageObject.pages;

import org.openqa.selenium.By;

public class HomePage extends BaseFunc {
    private final By ACCEPT_COOKIES = By.xpath("//button[@mode='primary']");

    public void acceptCookie() {
        browser.findElement(ACCEPT_COOKIES).click();
    }
}
