package accordian;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class section {
    @Test
    public void section() {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/accordian");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);
        js.executeScript("window.scrollBy(0,300)");

//        driver.findElement(By.id("section1Heading")).click();
        WebElement section1 = driver.findElement(By.id("section1Content"));
        section1.isDisplayed();
        System.out.println(section1.getText());

        driver.findElement(By.id("section2Heading")).click();
        WebElement section2 = driver.findElement(By.id("section2Content"));
        section2.isDisplayed();
        System.out.println(section2.getText());

        js.executeScript("window.scrollBy(0,200)");

        driver.findElement(By.id("section3Heading")).click();
        WebElement section3 = driver.findElement(By.id("section3Content"));
        section3.isDisplayed();
        System.out.println(section3.getText());
    }
}
