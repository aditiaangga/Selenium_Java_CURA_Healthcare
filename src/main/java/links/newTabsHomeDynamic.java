package links;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class newTabsHomeDynamic {
    @Test
    public void dynamic() {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://demoqa.com/links");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);

        WebElement dynamic = driver.findElement(By.id("dynamicLink"));
        System.out.println(dynamic.getText());
        dynamic.click();
        driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']")).isDisplayed();
    }
}
