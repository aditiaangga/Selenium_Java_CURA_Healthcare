package links;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class badRequest {
    @Test
    public void badRequest() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://demoqa.com/links");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);
        jsExecutor.executeScript("window.scrollBy(0,400)");

        driver.findElement(By.linkText("Bad Request")).click();
        Thread.sleep(1000);
        WebElement linkresponse = driver.findElement(By.id("linkResponse"));
        linkresponse.isDisplayed();
        System.out.println(linkresponse.getText());
        Assertions.assertEquals("Link has responded with staus 400 and status text Bad Request", linkresponse.getText());
    }
}
