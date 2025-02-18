package StepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import utils.DriverManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class Hooks {
    WebDriver driver;
    private static Scenario currentScenario;

    @Before
    public void browserSetup(Scenario scenario) {
        String browser = System.getProperty("browser", "edge"); // Default Browser
        driver = initializeDriver(browser); // Inisialisasi driver menggunakan method
        DriverManager.setDriver(driver);
        currentScenario = scenario;
    }

    private WebDriver initializeDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-debugging-port=0"); // Hindari konflik port
                chromeOptions.addArguments("--disable-dev-shm-usage");  // Kurangi penggunaan shared memory
                chromeOptions.addArguments("--no-sandbox");             // Hindari sandbox (untuk debugging)
                chromeOptions.addArguments("--headless=new");           // Jalankan di mode headless (opsional)
                return new ChromeDriver(chromeOptions);

            case "safari":
                System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
                SafariOptions safariOptions = new SafariOptions();
                safariOptions.setAutomaticInspection(false); // Disable remote debugging
                safariOptions.setAutomaticProfiling(false);  // Disable unnecessary profiling
                return new SafariDriver(safariOptions);    

            case "edge":
                System.setProperty("webdriver.edge.driver", "/usr/bin/msedgedriver");
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-debugging-port=0");
                edgeOptions.addArguments("--disable-dev-shm-usage");
                edgeOptions.addArguments("--no-sandbox");
                edgeOptions.addArguments("--headless=new");
                return new EdgeDriver(edgeOptions);

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
//                firefoxOptions.setCapability("webSocketUrl", true);
//                firefoxOptions.setCapability("moz:debuggerAddress", true);
//                firefoxOptions.addArguments("--enable-crash-reporter");
//                firefoxOptions.addArguments("--remote-debugging-port=0");
//                firefoxOptions.addArguments("--disable-dev-shm-usage");
//                firefoxOptions.addArguments("--no-sandbox");
                firefoxOptions.addArguments("--headless");
                return new FirefoxDriver(firefoxOptions);

            case "opera":
                System.setProperty("webdriver.chrome.driver", "driver/operadriver.exe");
                ChromeOptions operaOptions = new ChromeOptions();
                operaOptions.setBinary("C:/Users/aditi/AppData/Local/Programs/Opera/opera.exe");
                operaOptions.addArguments("--remote-debugging-port=0"); // Hindari konflik port
                operaOptions.addArguments("--disable-dev-shm-usage");  // Kurangi penggunaan shared memory
                operaOptions.addArguments("--no-sandbox");             // Hindari sandbox (untuk debugging)
//                operaOptions.addArguments("--headless=new");           // Jalankan di mode headless (opsional)
                return new ChromeDriver(operaOptions);

            default:
                throw new IllegalArgumentException("Browser yang dipilih tidak didukung: " + browser);
        }
    }


        public static Scenario getCurrentScenario () {
            return currentScenario; // Mengambil Scenario dari variabel statis
        }


        @After(order = 1)
        public void tearDown () {
//            driver.close();
            driver.quit();
        }

        @After
        public void takeScreenshotFinal (Scenario scenario){
            try {
                WebDriver driver = DriverManager.getDriver();
                if (driver != null) {
                    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                    // Baca screenshot sebagai BufferedImage
                    BufferedImage originalImage = ImageIO.read(screenshotFile);

                    // Ambil ukuran asli gambar
                    int originalWidth = originalImage.getWidth();
                    int originalHeight = originalImage.getHeight();

                    // Hitung lebar baru berdasarkan rasio aspek
                    int newHeight = 700;
                    int newWidth = (int) ((double) originalWidth / originalHeight * newHeight);

                    // Buat image dengan ukuran yang diinginkan
                    BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
                    Graphics2D g2d = resizedImage.createGraphics();
                    g2d.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
                    g2d.dispose();

                    // Konversi resized image ke byte array
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(resizedImage, "png", baos);
                    byte[] resizedScreenshot = baos.toByteArray();

                    // Lampirkan screenshot yang sudah diubah ukurannya ke skenario
//                scenario.attach(resizedScreenshot, "image/png", "Hooks");
                    if (scenario.isFailed()) {
                        scenario.attach(resizedScreenshot, "image/png", "Failed Screenshot");
                        System.out.println("Screenshot taken for failed scenario: " + scenario.getName());
                    } else {
                        // Opsional: ambil screenshot jika skenario berhasil
                        scenario.attach(resizedScreenshot, "image/png", "Passed Screenshot");
                        System.out.println("Screenshot taken for passed scenario: " + scenario.getName());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
