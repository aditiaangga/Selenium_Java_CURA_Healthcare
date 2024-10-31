package iframes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class iframe {
    @Test
    public void iframe() {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/frames");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);
        js.executeScript("window.scrollBy(0,400)");

        //Switch to Frame using Name or ID
        driver.switchTo().frame("frame1");

        //Locate the frame1 heading
        WebElement frame1Heading= driver.findElement(By.id("sampleHeading"));

        //Finding the text of the frame1 heading
        String frame1Text=frame1Heading.getText();

        //Print the heading
        System.out.println("Text of the frame1 heading is:"+frame1Text);

        //Switch to Parent Frame
        driver.switchTo().defaultContent();

        //Switch to frame2
        driver.switchTo().frame("frame2");

        WebElement frame2Heading= driver.findElement(By.id("sampleHeading"));

        //Finding the text of the frame1 heading
        String frame2Text=frame2Heading.getText();

        //Print the heading
        System.out.println("Text of the frame2 heading is:"+frame2Text);
    }
}
