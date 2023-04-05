package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.window.BrowserWindowsPage;
import page.window.NewTabWindowPage;

public class WindowTest extends TestBase {
    String url = "https://demoqa.com/browser-windows";
    String originalWindow;
    BrowserWindowsPage browserWindowsPage;
    NewTabWindowPage newTabWindowPage;

    @BeforeMethod
    public void openUrl() {
        driver.get(url);
    }

    @Test
    public void newTabTest() {
        browserWindowsPage = new BrowserWindowsPage(driver);
        originalWindow = browserWindowsPage.getOriginalWindow();
        browserWindowsPage.clickToNewTabButton();
        browserWindowsPage.switchToNewTabOrWindow(originalWindow);
        newTabWindowPage = new NewTabWindowPage(driver);
        Assert.assertTrue(newTabWindowPage.shouldBeVisible());
        newTabWindowPage.closeAndSwitchToOriginalWindow(originalWindow);
        Assert.assertTrue(browserWindowsPage.shouldBeVisible());
    }

}
