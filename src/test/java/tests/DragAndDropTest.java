package tests;

import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.DragAndDropPage;

public class DragAndDropTest extends TestBase{
    DragAndDropPage dragAndDropPage;
    String url = "https://demoqa.com/droppable";


    @BeforeMethod
    public void openUrl() {
        driver.get(url);
    }

    @Test
    public void setDragAndDropTest() {
        dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.dragAndDrop(dragAndDropPage.getDraggable(), dragAndDropPage.getDroppable());
        Assert.assertEquals(dragAndDropPage.getDroppableText(), "Dropped!");
    }

    @Test
    public void revertTest() throws InterruptedException {
        dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.clickToRevert();
        Point initLoc = dragAndDropPage.getPosition(dragAndDropPage.getRevertable());
        dragAndDropPage.dragAndDrop(dragAndDropPage.getRevertable(), dragAndDropPage.getRevertContainer());
        String text = dragAndDropPage.getContainerText();
        Assert.assertEquals(text, "Dropped!");
        dragAndDropPage.waitRevert();
        Point endLoc = dragAndDropPage.getPosition(dragAndDropPage.getRevertable());
        Assert.assertEquals(initLoc, endLoc);
    }
}
