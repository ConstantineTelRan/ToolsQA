package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.ToolTipsPage;

public class ToolTipsTest extends TestBase {
    ToolTipsPage toolTipsPage;
    String url = "https://demoqa.com/tool-tips";
    String expectedText = "You hovered over the Button";
    String actualText;

    @BeforeMethod
    public void openUrl() {
        driver.get(url);
    }

    @Test
    public void toolTipsTest() {
        toolTipsPage = new ToolTipsPage(driver);
        actualText = toolTipsPage.getButtonToolTipText();
        Assert.assertEquals(actualText, expectedText);
    }
}
