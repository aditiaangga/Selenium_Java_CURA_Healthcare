package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SeleniumHelper {
    private WebDriver driver;

    // Ambil driver dari DriverManager
    public SeleniumHelper(WebDriver driver) {
        this.driver = DriverManager.getDriver();
    }

    public WebElement waitForElementClickable(By element, int timeoutInSeconds) {
        int retries = 0;
        int maxRetries = 5;  // Maksimum 5 kali percobaan

        while (retries < maxRetries) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
                return wait.until(ExpectedConditions.elementToBeClickable(element));
            } catch (Exception e) {
                retries++;
                System.out.println("Percobaan ke-" + retries + ": Elemen belum terlihat, mencoba kembali...");

                if (retries == maxRetries) {
                    throw new RuntimeException("Gagal menemukan elemen setelah " + maxRetries + " percobaan.", e);
                }
            }
        }
        return null;
    }

    public void clickWithJS(By locator, int timeoutInSeconds) {
        try {
            WebElement element = waitForElementClickable(locator, timeoutInSeconds);

            if (element != null) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", element);
                System.out.println("✅ Klik berhasil pada elemen: " + locator.toString());
            } else {
                System.out.println("❌ Elemen tidak ditemukan: " + locator.toString());
            }
        } catch (Exception e) {
            System.out.println("❌ Gagal klik dengan JS: " + e.getMessage());
        }
    }
}
