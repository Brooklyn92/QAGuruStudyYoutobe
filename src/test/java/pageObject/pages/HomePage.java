package pageObject.pages;

import org.openqa.selenium.By;
import pageObject.BaseFunc;

public class HomePage {
    private final By ACCEPT_COOKIES = By.xpath("//button[@mode='primary']");
    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc=baseFunc;
    }

    public void acceptCookie() {
        baseFunc.click(ACCEPT_COOKIES);
    }
}
