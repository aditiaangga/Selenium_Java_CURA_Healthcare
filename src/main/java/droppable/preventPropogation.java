package droppable;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class preventPropogation {
    @Test
    public void dragndrop() {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://demoqa.com/droppable");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);
        jsExecutor.executeScript("window.scrollBy(0,200)");

        driver.findElement(By.id("droppableExample-tab-preventPropogation")).click();
        Actions act = new Actions(driver);
        WebElement from = driver.findElement(By.id("dragBox"));
        WebElement to1 = driver.findElement(By.xpath("//div[@id='notGreedyDropBox']/p[.='Outer droppable']"));
        System.out.println(from.getText());
        System.out.println(to1.getText());
        act.dragAndDrop(from, to1).perform();

        System.out.println(to1.getText());
        Assertions.assertEquals("Dropped!", to1.getText());

        WebElement to2 = driver.findElement(By.id("notGreedyInnerDropBox"));
        System.out.println(to2.getText());
        act.dragAndDrop(from, to2).perform();

        System.out.println(to2.getText());
        Assertions.assertEquals("Dropped!", to2.getText());

        WebElement to3 = driver.findElement(By.xpath("//p[.='Outer droppable']"));
        System.out.println(to3.getText());
        act.dragAndDrop(from, to3).perform();

        System.out.println(to3.getText());
        Assertions.assertEquals("Dropped!", to3.getText());

        jsExecutor.executeScript("window.scrollBy(0,300)");

        WebElement to4 = driver.findElement(By.id("greedyDropBoxInner"));
        System.out.println(to4.getText());
        act.dragAndDrop(from, to4).perform();

        System.out.println(to4.getText());
        Assertions.assertEquals("Dropped!", to4.getText());
    }
}
