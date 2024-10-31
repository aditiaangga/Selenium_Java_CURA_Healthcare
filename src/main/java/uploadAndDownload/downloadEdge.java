package uploadAndDownload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.util.HashMap;

public class downloadEdge {
    private String downloadFileLocation = "C:\\Users\\anggaad\\automation_testing\\CURA_Healthcare\\picture\\";


    @Test
    //using ChromeDriver
    public void download() throws InterruptedException {
        WebDriverManager.edgedriver().setup();

        HashMap<String, Object> edgePrefs = new HashMap<String, Object>();
        edgePrefs.put("download.default_directory", downloadFileLocation); //setup disini

        EdgeOptions options = new EdgeOptions(); //cara panggil setup
        HashMap<String, Object> edgeOptionsMap = new HashMap<String, Object>();
        options.setExperimentalOption("prefs", edgePrefs);

        EdgeDriver driver = new EdgeDriver(options);

        driver.get("https://demoqa.com/upload-download");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);
        js.executeScript("window.scrollBy(0,200)");
        driver.findElement(By.id("downloadButton")).click();
        Thread.sleep(3000);

        Boolean result = isFileDownloaded(downloadFileLocation, "sampleFile.jpeg");

        Assertions.assertTrue(result);
    }

    private boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
                System.out.println("hasil file: " + dirContents[i].getName());
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }
}
