package webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class search {
    @Test
    public void search() {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://demoqa.com/webtables");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);
        js.executeScript("window.scrollBy(0,200)");

        driver.findElement(By.id("searchBox")).sendKeys("cier");

        driver.findElement(By.xpath("//div[.='Cierra']")).isDisplayed();
        WebElement resultRow1 = driver.findElement(By.xpath("(//div[@role='rowgroup'])[1]"));
        resultRow1.isDisplayed();
        System.out.println(resultRow1.getText());
    }
}
