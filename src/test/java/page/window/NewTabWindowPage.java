package page.window;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.PageBase;

public class NewTabWindowPage extends PageBase {
    public NewTabWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[@id=\"sampleHeading\"]")
    private WebElement newTabWindowHeader;

    public boolean shouldBeVisible() {
        return newTabWindowHeader.isDisplayed();
    }
}
