package uploadAndDownload;

import org.junit.jupiter.api.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;

public class download {
    private String downloadFileLocation = "C:\\Users\\anggaad\\automation_testing\\CURA_Healthcare\\picture\\";


    @Test
    //using ChromeDriver
    public void download() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", "C:\\Users\\anggaad\\automation_testing\\CURA_Healthcare\\picture\\"); //setup disini

        ChromeOptions options = new ChromeOptions(); //cara panggil setup
        HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
        options.setExperimentalOption("prefs", chromePrefs);

        ChromeDriver chromeDriver = new ChromeDriver(options);

        chromeDriver.get("https://demoqa.com/upload-download");

        WebElement fixedban = chromeDriver.findElement(By.id("fixedban"));
        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
        js.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);
        js.executeScript("window.scrollBy(0,200)");
        chromeDriver.findElement(By.id("downloadButton")).click();
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
