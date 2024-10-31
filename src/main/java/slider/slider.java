package slider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class slider {
    static EdgeDriver driver = new EdgeDriver();
    @Test
    public void slider() throws InterruptedException {
        WebDriverManager.edgedriver().setup();

        driver.get("https://demoqa.com/slider");
        driver.manage().window().maximize();

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);
        js.executeScript("window.scrollBy(0,300)");

        //Move Slider
        moveSlider("96");
        moveSlider("35");
        moveSlider("87");
        moveSlider("19");
        moveSlider("62");
        moveSlider("41");
    }

    private static void moveSlider(String value) throws InterruptedException {
        Actions act = new Actions(driver);
        WebElement from = driver.findElement(By.xpath("//input[@type='range']"));

        //Move to 0
        act.dragAndDropBy(from,-500,0).build().perform();

        //Move to Value
        int val = Integer.valueOf(value);

        if (val > 75) {
            act.dragAndDropBy(from, 105, 0).build().perform();
            for (int i = 1; i <= val-75 ; i++) {
            from.sendKeys(Keys.ARROW_RIGHT);
            }
        } else if (val > 50) {
            act.dragAndDropBy(from, 0, 0).build().perform();
            for (int i = 1; i <= val-50 ; i++) {
                from.sendKeys(Keys.ARROW_RIGHT);
            }
        } else if (val > 25) {
            act.dragAndDropBy(from, -104, 0).build().perform();
            for (int i = 1; i <= val-25 ; i++) {
                from.sendKeys(Keys.ARROW_RIGHT);
            }
        } else {
            for (int i = 1; i <= val ; i++) {
            from.sendKeys(Keys.ARROW_RIGHT);
            }
        }

        Thread.sleep(1000);
        WebElement sv = driver.findElement(By.id("sliderValue"));
        System.out.println(sv.getAttribute("value"));
        Assertions.assertEquals(value,sv.getAttribute("value"));
    }
}
