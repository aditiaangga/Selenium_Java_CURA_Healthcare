package alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class simpleAlert {
    @Test
    public void simple(){
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.id("alertButton")).click();
        driver.switchTo().alert().accept();
    }
}
