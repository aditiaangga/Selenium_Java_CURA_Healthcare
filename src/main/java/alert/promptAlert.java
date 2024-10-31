package alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class promptAlert {
    @Test
    public void prompt() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://demoqa.com/alerts");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

        driver.findElement(By.id("promtButton")).click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Aditia Angga Perdana");
        alert.accept();
        WebElement confirm = driver.findElement(By.id("promptResult"));
        System.out.println(confirm.getText());
        Assertions.assertEquals("You entered Aditia Angga Perdana", confirm.getText());
    }
}
