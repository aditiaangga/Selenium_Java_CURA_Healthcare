package progressBar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class progressBar {
    @Test
    public void tabs() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/progress-bar");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);
        js.executeScript("window.scrollBy(0,300)");

        WebElement info = driver.findElement(By.cssSelector(".progress-bar"));
        System.out.println(info.getAttribute("aria-valuenow") +"%");

        WebElement startStop = driver.findElement(By.id("startStopButton"));
        startStop.isDisplayed();
        System.out.println(startStop.getText());
        startStop.click();

        System.out.println(startStop.getText());

        Thread.sleep(4900);
        startStop.click();
        System.out.println(info.getAttribute("aria-valuenow") +"%");
        startStop.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement progressBarSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='100%' and @role='progressbar']")));
        progressBarSuccess.isDisplayed();
        System.out.println(info.getAttribute("aria-valuenow") +"%");

        WebElement reset = driver.findElement(By.id("resetButton"));
        reset.isDisplayed();
        System.out.println(reset.getText());
        reset.click();
    }
}
