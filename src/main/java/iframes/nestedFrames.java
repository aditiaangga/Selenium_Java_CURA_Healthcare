package iframes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class nestedFrames {
    @Test
    public void nestedFrames() {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/nestedframes");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);
        js.executeScript("window.scrollBy(0,400)");

        driver.switchTo().frame("frame1");
        WebElement frame1 = driver.findElement(By.tagName("body"));
        System.out.println("frame1 is: "+frame1.getText());

        int countIframesInPage = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of Frames on a Page:" + countIframesInPage);

        driver.switchTo().frame(0);
        WebElement frame2 = driver.findElement(By.tagName("p"));
        System.out.println("frame2 is: "+frame2.getText());

        int countIframesInFrame2 =driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iFrames inside the Frame2:" + countIframesInFrame2);

        driver.switchTo().parentFrame();
        WebElement parentFrame = driver.findElement(By.tagName("body"));
        System.out.println("frame1 is: "+parentFrame.getText());

        driver.switchTo().defaultContent();
        WebElement defaultContent = driver.findElement(By.tagName("body"));
        System.out.println("frame is: "+defaultContent.getText());

        int countIframesInMain = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iFrames:"+countIframesInMain);

    }
}
