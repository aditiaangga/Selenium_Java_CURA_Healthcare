package droppable;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class revertDraggable {
    @Test
    public void dragndrop() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://demoqa.com/droppable");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);
        jsExecutor.executeScript("window.scrollBy(0,200)");

        driver.findElement(By.id("droppableExample-tab-revertable")).click();
        Actions act = new Actions(driver);
        WebElement from1 = driver.findElement(By.id("revertable"));
        WebElement to = driver.findElement(By.xpath("//div[@id='revertableDropContainer']/div[@id='droppable']"));
        System.out.println(from1.getText());
        int willrevertXOffset = from1.getLocation().getX();
        int willrevertYOffset = from1.getLocation().getY();
        System.out.println("xOffset--->" + willrevertXOffset + " yOffset--->" + willrevertYOffset);
        System.out.println(to.getText());
        act.dragAndDrop(from1, to).perform();
        System.out.println(to.getText());


        WebElement from2 = driver.findElement(By.id("notRevertable"));
        System.out.println(from2.getText());
        int notrevertXOffset = from2.getLocation().getX();
        int notrevertYOffset = from2.getLocation().getY();
        System.out.println("xOffset--->" + notrevertXOffset+ " yOffset--->" + notrevertYOffset);
        System.out.println(to.getText());
        act.dragAndDrop(from2, to).perform();
        System.out.println(to.getText());
        Thread.sleep(1000);
        act.dragAndDropBy(to, notrevertXOffset, notrevertYOffset);
    }
}
