package webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class addSuccess {
    @Test
    public void addSuccess(){
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://demoqa.com/webtables");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);

        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.id("firstName")).sendKeys("Aditia");
        driver.findElement(By.id("lastName")).sendKeys("Perdana");
        driver.findElement(By.id("userEmail")).sendKeys("aditia.perdana@test.id");
        driver.findElement(By.id("age")).sendKeys("26");
        driver.findElement(By.id("salary")).sendKeys("1000");
        driver.findElement(By.id("department")).sendKeys("IT");
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.xpath("//div[.='Aditia']")).isDisplayed();

    }
}
