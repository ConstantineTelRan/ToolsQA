package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SelectPage extends PageBase{
    public SelectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select[@id=\"oldSelectMenu\"]")
    private WebElement selectField;

    public void getSelect(String text) {
        Select select = new Select(selectField);
        select.selectByVisibleText(text);
    }

}
