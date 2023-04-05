package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.ProgressBarPage;

public class ProgressBarTest extends TestBase {
    ProgressBarPage progressBarPage;
    String url = "https://demoqa.com/progress-bar";
    String percent = Integer.toString(faker.number().numberBetween(10, 99));
    String expectedProgressValue = percent + "%";
    String actualProgressValue;

    @BeforeMethod
    public void openUrl() {
        driver.get(url);
    }

    @Test
    public void progressBarTest() {
        progressBarPage = new ProgressBarPage(driver);
        progressBarPage.clickToStart();
        progressBarPage.clickToStop(percent);
        actualProgressValue = progressBarPage.getText();
        Assert.assertEquals(actualProgressValue, expectedProgressValue);
    }

}
