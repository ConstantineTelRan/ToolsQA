package page;


import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

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
    private WebElement revertable;

    @FindBy(xpath = "//div[@id=\"simpleDropContainer\"]//div[@id=\"droppable\"]")
    private WebElement simpleDropContainer;

    public WebElement getRevertable() {
        return revertable;
    }

    public WebElement getSimpleDropContainer() {
        return simpleDropContainer;
    }


    public void dragAndDrop(WebElement elementDraggable, WebElement elementDroppable) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(elementDraggable, elementDroppable).perform();
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

}
