package droppable;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class accept {
    @Test
    public void dragndrop() {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://demoqa.com/droppable");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);
        jsExecutor.executeScript("window.scrollBy(0,200)");

        driver.findElement(By.id("droppableExample-tab-accept")).click();
        Actions act = new Actions(driver);
        WebElement from = driver.findElement(By.id("acceptable"));
        WebElement to = driver.findElement(By.xpath("//div[@id='acceptDropContainer']/div[@id='droppable']"));
        System.out.println(from.getText());
        System.out.println(to.getText());
        act.dragAndDrop(from, to).perform();

        System.out.println(to.getText());
        Assertions.assertEquals("Dropped!", to.getText());
    }
}
