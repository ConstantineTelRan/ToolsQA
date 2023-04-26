package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.TextBoxPage;

public class TextBoxTest extends TestBase {
    TextBoxPage textBoxPage;
    String url = "https://demoqa.com/text-box";
    String fullName = faker.name().fullName();
    String email = faker.internet().emailAddress();
    String currentAddress = faker.address().fullAddress();
    String permanentAddress = faker.address().fullAddress();

    @BeforeMethod
    public void openUrl() {
        driver.get(url);
    }

    @Test
    public void TextBoxResultTest() {
        textBoxPage = new TextBoxPage(driver);
        textBoxPage.fillTextBox(fullName, email, currentAddress, permanentAddress);
        Assert.assertTrue(textBoxPage.getResultText("name").contains(fullName));
        Assert.assertEquals(textBoxPage.getResultText("name"), "Name:" + fullName);
    }


}
