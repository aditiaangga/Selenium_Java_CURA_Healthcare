package dynamicProperties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class dynamicProperties {
    @Test
    public void dynamicProperties() {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://demoqa.com/dynamic-properties");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);
        js.executeScript("window.scrollBy(0,300)");

        WebElement colorChange = driver.findElement(By.id("colorChange"));
        String textColor = colorChange.getText();
        String rgbaColor = colorChange.getCssValue("color");
        String hexColor = Color.fromString(rgbaColor).asHex();
        System.out.println(textColor);
        System.out.println("The Color is: "+rgbaColor);
        System.out.println("Hex Code for Color is: "+hexColor +"\n");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement enableAfter = wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
        enableAfter.isEnabled();
        System.out.println(enableAfter.getText());

        WebElement visibleAfter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        visibleAfter.isEnabled();
        System.out.println(visibleAfter.getText() +"\n");

        WebElement colorChangeAfter = driver.findElement(By.id("colorChange"));
        String textColorAfter = colorChangeAfter.getText();
        String rgbaColorAfter = colorChangeAfter.getCssValue("color");
        String hexColorAfter = Color.fromString(rgbaColorAfter).asHex();
        System.out.println(textColorAfter);
        System.out.println("The Color is: "+rgbaColorAfter);
        System.out.println("Hex Code for Color is: "+hexColorAfter);

    }
}
