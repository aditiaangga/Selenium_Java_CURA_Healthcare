package uploadAndDownload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class upload {
    @Test
    public void upload() {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://demoqa.com/upload-download");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);
        js.executeScript("window.scrollBy(0,200)");

        WebElement upload = driver.findElement(By.id("uploadFile"));
        String dir = System.getProperty("user.dir") + "/picture/sampleFile.jpeg";
        System.out.println(dir);
        upload.sendKeys(dir);

        String path = driver.findElement(By.id("uploadedFilePath")).getText();
        System.out.println(path);

        driver.quit();
    }

}
