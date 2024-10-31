package button;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class click {
    @Test
    public void dynamic(){
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://demoqa.com/buttons");

        driver.findElement(By.xpath("//button[text()='Click Me']")).click();
        WebElement popup = driver.findElement(By.id("dynamicClickMessage"));
        popup.isDisplayed();
        Assertions.assertEquals("You have done a dynamic click",popup.getText());

    }
}
