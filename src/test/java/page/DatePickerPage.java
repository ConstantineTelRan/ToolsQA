package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DatePickerPage {
    WebDriver driver;

    public DatePickerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id=\"datePickerMonthYearInput\"]")
    private WebElement datePickerInput;

    @FindBy(xpath = "//div[@class=\"react-datepicker__month-container\"]")
    private WebElement calendar;

    @FindBy(xpath = "//input[@id=\"dateAndTimePickerInput\"]")
    private WebElement dateTimePickerInput;

    @FindBy(xpath = "//div[@class=\"react-datepicker\"]")
    private WebElement dateTimeCalendar;

    public boolean getCalendar() {
        datePickerInput.click();
        return calendar.isDisplayed();
    }

    public void chooseDate(String date) {
        driver.findElement(By.xpath(String.format("//div[@aria-label='Choose %s']", date))).click();
    }

    public String getDateFromInput() {
        return datePickerInput.getAttribute("value");
    }

    public boolean getDateTimeCalendar() {
        dateTimePickerInput.click();
        return dateTimeCalendar.isDisplayed();
    }

    public void chooseTime(String time) {
        driver.findElement(By.xpath(String.format("//li[normalize-space()='%s']", time))).click();
    }

    public String getDateAndTime() {
        return dateTimePickerInput.getAttribute("value");
    }

}
