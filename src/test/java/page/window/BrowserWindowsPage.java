package page.window;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.PageBase;

public class BrowserWindowsPage extends PageBase {
    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id=\"tabButton\"]")
    private WebElement newTabButton;

    @FindBy(xpath = "//div[@class=\"main-header\"]")
    private WebElement mainHeader;

    public void clickToNewTabButton() {
        newTabButton.click();
    }

    public boolean shouldBeVisible() {
        return mainHeader.isDisplayed();
    }

}
