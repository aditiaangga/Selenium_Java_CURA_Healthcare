package tooltip;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class tooltip {
    @Test
    public void tooltip() {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://demoqa.com/tool-tips");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);

        Actions act = new Actions(driver);
        WebElement greenButton = driver.findElement(By.id("toolTipButton"));

        act.moveToElement(greenButton).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement buttonToolTip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buttonToolTip")));
        buttonToolTip.isDisplayed();
        String buttonToolTipText = buttonToolTip.getText();

        System.out.println("Button ToolTip Text is: " +buttonToolTipText);
        js.executeScript("window.scrollBy(0,400)");

        WebElement textField = driver.findElement(By.id("toolTipTextField"));

        act.moveToElement(textField).perform();

        WebElement textFieldToolTip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("textFieldToolTip")));
        textFieldToolTip.isDisplayed();
        String FieldToolTip = textFieldToolTip.getText();
        System.out.println("Field Text ToolTip is: "+FieldToolTip);

        WebElement Contrary = driver.findElement(By.xpath("//a[.='Contrary']"));

        act.moveToElement(Contrary).perform();
        WebElement ContraryTooltip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contraryTexToolTip")));
        System.out.println("Text Contrary ToolTip is: "+ContraryTooltip.getText());

        WebElement section = driver.findElement(By.xpath("//a[.='1.10.32']"));

        act.moveToElement(section).perform();
        WebElement sectionToolTip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sectionToolTip")));
        sectionToolTip.isDisplayed();
        System.out.println("Section Text ToolTip is: "+sectionToolTip.getText());
    }
}
