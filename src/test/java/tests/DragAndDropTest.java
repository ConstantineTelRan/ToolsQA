package tests;

import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.DragAndDropPage;

public class DragAndDropTest extends TestBase {
    DragAndDropPage dragAndDropPage;
    String url = "https://demoqa.com/droppable";

    @BeforeMethod
    public void openUrl() {
        driver.get(url);
    }

    @Test
    public void dragAndDropTest() {
        dragAndDropPage = new DragAndDropPage(driver);
        Point startLoc = dragAndDropPage.getLoc(dragAndDropPage.draggable);
        dragAndDropPage.dragAndDrop(dragAndDropPage.draggable, dragAndDropPage.droppable);
        String actualText = dragAndDropPage.getElementText(dragAndDropPage.droppable);
        Point finishLoc = dragAndDropPage.getLoc(dragAndDropPage.draggable);
        Assert.assertEquals(actualText, "Dropped!");
        Assert.assertNotEquals(startLoc, finishLoc);
    }


    @Test
    public void revertDDTest() {
        dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.clickTo(dragAndDropPage.revertDraggableTab);
        Point startLoc = dragAndDropPage.getLoc(dragAndDropPage.getRevertable());
        dragAndDropPage.dragAndDrop(dragAndDropPage.getRevertable(),
                dragAndDropPage.getSimpleDropContainer());
        Point finishLoc = dragAndDropPage.getLoc(dragAndDropPage.getRevertable());
        Assert.assertEquals(startLoc, finishLoc);
    }

}
