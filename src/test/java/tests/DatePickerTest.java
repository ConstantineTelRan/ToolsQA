package tests;

import org.apache.commons.lang3.time.DateUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.DatePickerPage;

import java.text.SimpleDateFormat;
import java.util.*;

public class DatePickerTest extends TestBase {
    String url = "https://demoqa.com/date-picker";
    DatePickerPage datePickerPage;
    String testDate;
    String expectedDate;
    String actualDate;
    String testTime;

    Date date = DateUtils.addDays(new Date(), 1);

    @BeforeMethod
    public void getUrl() {
        driver.get(url);
    }

    public String getRandomMin() {
        List<String> min = Arrays.asList("00", "15", "30", "45");
        Random random = new Random();
        int randomIndex = random.nextInt(min.size());
        return min.get(randomIndex);
    }

    @Test
    public void datePickerTest() {
        SimpleDateFormat chooseFormatter = new SimpleDateFormat("EEEE, MMMM d'th', yyyy", Locale.ENGLISH);
        SimpleDateFormat actualFormatter = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        testDate = chooseFormatter.format(date);
        expectedDate = actualFormatter.format(date);
        datePickerPage = new DatePickerPage(driver);
        Assert.assertTrue(datePickerPage.getCalendar());
        datePickerPage.chooseDate(testDate);
        actualDate = datePickerPage.getDateFromInput();
        Assert.assertEquals(actualDate, expectedDate);
    }

    @Test
    public void dateTimePickerTest() {
        String randomMin = getRandomMin();
        SimpleDateFormat chooseFormatter = new SimpleDateFormat("EEEE, MMMM d'th', yyyy", Locale.ENGLISH);
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:" + randomMin,  Locale.ENGLISH);
        SimpleDateFormat actualFormatter = new SimpleDateFormat("MMMM d, yyyy h:" + randomMin +" aa");
        testTime = timeFormatter.format(date);
        testDate = chooseFormatter.format(date);
        expectedDate = actualFormatter.format(date);
        datePickerPage = new DatePickerPage(driver);
        Assert.assertTrue(datePickerPage.getDateTimeCalendar());
        datePickerPage.chooseDate(testDate);
        datePickerPage.chooseTime(testTime);
        actualDate = datePickerPage.getDateAndTime();
        Assert.assertEquals(actualDate, expectedDate);
        System.out.println(expectedDate);
    }

}
