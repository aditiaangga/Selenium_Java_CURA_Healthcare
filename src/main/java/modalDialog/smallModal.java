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
import java.util.Iterator;
import java.util.Set;

public class smallModal {
    @Test
    public void smallModal() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://demoqa.com/modal-dialogs");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);

        driver.manage().window().maximize();

        driver.findElement(By.id("showSmallModal")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modalContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));
        System.out.println(modalContainer.getText());

        WebElement modalTittle = modalContainer.findElement(By.id("example-modal-sizes-title-sm"));
        System.out.println(modalTittle.getText());
        Assertions.assertEquals("Small Modal",modalTittle.getText());

        WebElement modalBody = modalContainer.findElement(By.className("modal-body"));
        System.out.println(modalBody.getText());
        Assertions.assertEquals("This is a small modal. It has very less content", modalBody.getText());

    }
}
