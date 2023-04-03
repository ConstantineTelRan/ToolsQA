package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

}
