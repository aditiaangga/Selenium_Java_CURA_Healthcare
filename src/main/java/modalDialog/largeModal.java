package modalDialog;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class largeModal {
    @Test
    public void largeModal() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://demoqa.com/modal-dialogs");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);

        driver.manage().window().maximize();

        driver.findElement(By.id("showLargeModal")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modalContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));
        System.out.println(modalContainer.getText());

        WebElement modalTittle = modalContainer.findElement(By.id("example-modal-sizes-title-lg"));
        System.out.println(modalTittle.getText());
        Assertions.assertEquals("Large Modal",modalTittle.getText());

        WebElement modalBody = modalContainer.findElement(By.className("modal-body"));
        System.out.println(modalBody.getText());
        Assertions.assertEquals("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", modalBody.getText());

    }
}
