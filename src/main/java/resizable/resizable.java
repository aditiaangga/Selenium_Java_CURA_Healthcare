package resizable;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class resizable {
    @Test
    public void resizable() {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/resizable");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);
        js.executeScript("window.scrollBy(0,300)");

        Actions act = new Actions(driver);
        WebElement box1 = driver.findElement(By.id("resizableBoxWithRestriction"));
        System.out.println(box1.getText());
        WebElement from1 = driver.findElement(By.xpath("//div[@id='resizableBoxWithRestriction']/span"));
        act.dragAndDropBy(from1, 150,80).perform();

        js.executeScript("window.scrollBy(0,300)");

        WebElement box2 = driver.findElement(By.id("resizable"));
        System.out.println(box2.getText());
        WebElement from2 = driver.findElement(By.xpath("//div[@id='resizable']/span"));
        act.dragAndDropBy(from2, 200,180).perform();
    }
}
