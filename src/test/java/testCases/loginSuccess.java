package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import pages.Homepage;
import pages.Login;

public class loginSuccess {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://katalon-demo-cura.herokuapp.com/");

        Login login = new Login(driver);
        login.clickMenuLogin();
        login.enterUsername("John Doe");
        login.enterPassword("ThisIsNotAPassword");
        login.clickLogin();

        Homepage home = new Homepage(driver);
        home.verifyHomepage();

    }
}
