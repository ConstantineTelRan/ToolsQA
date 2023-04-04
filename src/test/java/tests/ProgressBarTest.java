package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.ProgressBarPage;
import page.ProgressBarPage2;

public class ProgressBarTest extends TestBase {
    ProgressBarPage progressBarPage;
    String url = "https://demoqa.com/progress-bar";

    String percent = Integer.toString(faker.number().numberBetween(10, 99));
    String expectedProgressValue = percent + "%";
    String actualProgressValue;
    ProgressBarPage2 progressBar;

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
        System.out.println(percent);
    }

    @Test
    public void setProgressBarCopyTest() {
        progressBar = new ProgressBarPage2(driver);
        progressBar.clickToStartStopButton();
        progressBar.clickToStop(percent);
        actualProgressValue = progressBar.getAttributeValue();
        Assert.assertEquals(actualProgressValue, percent);
        System.out.println(percent);
    }

}
