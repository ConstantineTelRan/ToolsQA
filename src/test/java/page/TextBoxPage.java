package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends PageBase {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='userName']")
    private WebElement fullNameInput;

    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement emailInput;

    @FindBy(xpath = "//textarea[@id=\"currentAddress\"]")
    private WebElement currentAddressInput;

    @FindBy(xpath = "//textarea[@id=\"permanentAddress\"]")
    private WebElement permanentAddressInput;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement submitButton;


    public void fillTextBox(String fullName, String email, String currentAddress, String permanentAddress) {
        fullNameInput.clear();
        fullNameInput.sendKeys(fullName);
        emailInput.clear();
        emailInput.sendKeys(email);
        currentAddressInput.clear();
        currentAddressInput.sendKeys(currentAddress);
        permanentAddressInput.clear();
        permanentAddressInput.sendKeys(permanentAddress);
        submitButton.click();
    }

    public String getResultText(String id) {
        return driver.findElement(By.xpath(String.format("//p[@id='%s']", id))).getText();
    }



}
