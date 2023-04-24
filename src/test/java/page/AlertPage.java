package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertPage extends PageBase{
    public AlertPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id=\"timerAlertButton\"]")
    private WebElement timerAlertButton;


    public void clickToTimerAlertButton() {
        timerAlertButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.alertIsPresent());
    }

    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }


}
