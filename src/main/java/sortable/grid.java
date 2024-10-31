package sortable;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class grid {
    @Test
    public void grid() {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/sortable");
        driver.findElement(By.id("demo-tab-grid")).click();

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);
        js.executeScript("window.scrollBy(0,300)");

        Actions act = new Actions(driver);
        WebElement one = driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[text()='One']"));
        WebElement six = driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[text()='Six']"));

        System.out.println(one.getText()+ " to "+six.getText());
        act.dragAndDrop(one, six).perform();

        WebElement three = driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[text()='Three']"));
        WebElement five = driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[text()='Five']"));

        System.out.println(five.getText()+ " to "+three.getText());
        act.dragAndDrop(five, three).perform();

        WebElement two = driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[text()='Two']"));
        WebElement four = driver.findElement(By.xpath("//div[@id='demo-tabpane-grid']//div[text()='Four']"));

        System.out.println(two.getText()+ " to "+four.getText());
        act.dragAndDrop(two, four).perform();
    }
}
