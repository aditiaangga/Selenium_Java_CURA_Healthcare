package autoComplete;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class autoComplete {
    @Test
    public void autoComplete() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://demoqa.com/auto-complete");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);
        jsExecutor.executeScript("window.scrollBy(0,200)");

        WebElement multi = driver.findElement(By.id("autoCompleteMultipleInput"));
        multi.sendKeys("E");
        driver.findElement(By.xpath("//div[.='White']")).click();
        multi.sendKeys("E");
        driver.findElement(By.xpath("//div[.='Red']")).click();
        multi.sendKeys("E");
        driver.findElement(By.xpath("//div[.='Blue']")).click();

        WebElement single = driver.findElement(By.id("autoCompleteSingleInput"));
        single.sendKeys("A");
        driver.findElement(By.xpath("//div[.='Black']")).click();

    }
}
