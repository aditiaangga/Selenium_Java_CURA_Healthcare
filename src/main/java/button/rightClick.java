package button;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class rightClick {
    @Test
    public void right(){
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://demoqa.com/buttons");

        Actions act = new Actions(driver);
        act.contextClick(driver.findElement(By.id("rightClickBtn"))).build().perform();

        WebElement popup = driver.findElement(By.id("rightClickMessage"));
        popup.isDisplayed();
        Assertions.assertEquals("You have done a right click",popup.getText());

    }
}
