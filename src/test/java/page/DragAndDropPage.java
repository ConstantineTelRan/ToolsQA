package page;


import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DragAndDropPage extends PageBase{
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id=\"draggable\"]")
    public WebElement draggable;

    @FindBy(xpath = "//div[@id=\"droppable\"]")
    public WebElement droppable;

    @FindBy(xpath = "//a[@id=\"droppableExample-tab-revertable\"]")
    public WebElement revertDraggableTab;



    @FindBy(xpath = "//div[@id=\"revertable\"]")
    public WebElement revertable;

    @FindBy(xpath = "//div[@id=\"revertableDropContainer\"]//div[@id=\"droppable\"]")
    public WebElement revertableDropContainer;

    @FindBy(xpath = "//div[@id=\"notRevertable\"]")
    public WebElement notRevertable;


    public void dragAndDrop(WebElement elementDraggable, WebElement elementDroppable) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(elementDraggable, elementDroppable).perform();
    }

    public void dragAndDropLoc(WebElement elementDraggable, int x, int y) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(elementDraggable, x, y);
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }

    public Point getLoc(WebElement element) {
        return element.getLocation();
    }

    public void clickTo(WebElement element) {
        element.click();
    }

    public void waitRevert() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.attributeToBe(revertable, "style",
                        "position: relative; left: 0px; top: 0px;"));
    }

    public void waitNotRevert() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.attributeToBe(notRevertable, "style",
                        "position: relative; left: 275px; top: -17px;"));
    }






}
