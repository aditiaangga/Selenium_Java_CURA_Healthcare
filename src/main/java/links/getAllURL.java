package links;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class getAllURL {
    @Test
    public void getAllURL() throws IOException {
        //Create WebDriver instance and open the website.
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/links");

        String links="";
        List<WebElement> allURLs = driver.findElements(By.tagName("a"));
        System.out.println("Total links on the Wb Page: " + allURLs.size());

        //We will iterate through the grid and will check the elements in the grid.
        Iterator<WebElement> iterator = allURLs.iterator();
        while (iterator.hasNext()) {
            links = iterator.next().getText();
            System.out.println(links);
        }

        //Close the browser session
        driver.quit();
    }
}
