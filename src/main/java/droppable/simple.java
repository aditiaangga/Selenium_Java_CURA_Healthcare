package droppable;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class simple {
    @Test
    public void dragndrop() {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://demoqa.com/droppable");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);
        jsExecutor.executeScript("window.scrollBy(0,400)");

        Actions act = new Actions(driver);
        WebElement from = driver.findElement(By.id("draggable"));
        WebElement to = driver.findElement(By.id("droppable"));
        act.dragAndDrop(from, to).perform();

        String textTo = to.getText();

        if(textTo.equals("Dropped!")) {
            System.out.println("PASS: Source is dropped to target as expected");
        }else {
            System.out.println("FAIL: Source couldn't be dropped to target as expected");
        }

        driver.close();
    }
}
