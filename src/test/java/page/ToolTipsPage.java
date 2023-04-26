package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ToolTipsPage extends PageBase {
    public ToolTipsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id=\"toolTipButton\"]")
    private WebElement toolTipButton;

    @FindBy(css = ".tooltip-inner")
    private WebElement toolTip;


    public String getButtonToolTipText() {
        Actions actions = new Actions(driver);
        actions.moveToElement(toolTipButton).perform();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(toolTip));
        return toolTip.getText();
    }


}
