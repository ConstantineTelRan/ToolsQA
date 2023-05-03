package page;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DragAndDropPage extends PageBase {
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getDraggable() {
        return draggable;
    }

    public WebElement getDroppable() {
        return droppable;
    }

    public WebElement getRevertable() {
        return revertable;
    }

    @FindBy(xpath = "//div[@id=\"draggable\"]")
    private WebElement draggable;

    @FindBy(xpath = "//div[@id=\"droppable\"]")
    private WebElement droppable;

    @FindBy(xpath = "//a[@id=\"droppableExample-tab-revertable\"]")
    private WebElement revertMenu;

    @FindBy(xpath = "//div[@id=\"revertable\"]")
    private WebElement revertable;

    public WebElement getRevertContainer() {
        return revertContainer;
    }

    @FindBy(xpath = "//div[@id=\"revertableDropContainer\"]//div[@id=\"droppable\"]")
    private WebElement revertContainer;

    public void dragAndDrop(WebElement draggable, WebElement droppable) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).perform();
    }

    public String getDroppableText() {
        return droppable.getText();
    }

    public void clickToRevert() {
        revertMenu.click();
    }

    public Point getPosition(WebElement element) {
        return element.getLocation();
    }

    public String getContainerText() {
        return revertContainer.getText();
    }

    public void waitRevert() {

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.attributeToBe(revertable,
                        "style", "position: relative; left: 0px; top: 0px;"));
    }



}
