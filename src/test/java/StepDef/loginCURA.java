package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.Appointment;
import pages.Homepage;
import pages.Login;
import utils.DriverManager;
import utils.ScreenshotUtil;


import java.io.IOException;

public class loginCURA {

    WebDriver driver = DriverManager.getDriver();
    ScreenshotUtil ss = new ScreenshotUtil(driver);
    Login login = new Login(driver);
    Homepage home = new Homepage(driver);

    @Given("User Open website CURA Healthcare with browser")
    public void userOpenWebsiteCURAHealthcareWithBrowser() throws IOException {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }

    @When("User input username {string}, password {string} and Click Sign In")
    public void userInputUsernamePasswordAndClickSignIn(String user, String pass) throws IOException {
        login.clickMenuLogin();
        login.enterUsername(user);
        login.enterPassword(pass);
        ss.takeScreenshotWithResizedHeight("Login Page");
        login.clickLogin();
    }

    @Then("User verify Homepage")
    public void userVerifyHomepage() throws IOException, InterruptedException {
        home.verifyHomepage();
    }

    @And("User Click Appointment")
    public void userClickAppointment() throws InterruptedException, IOException {
        home.clickMakeAppointment();
    }

    @And("User Go To Make Appointment")
    public void userGoToMakeAppointment() throws InterruptedException, IOException {
        home.goToMakeAppointment();
    }

    @And("User fill the Data {string}, {string}, {string}, {string} about Appointment")
    public void userFillTheDataAboutAppointment(String city, String hc, String date, String com) throws IOException, InterruptedException {
        home.verifyHomepage();
        home.facility(city);
        home.hospitalReadmission();
        home.healthcareProgram(hc);
        ss.takeScreenshotWithResizedHeight("Fill The Data");
        home.date(date);
        home.comment(com);
        ss.takeScreenshotWithResizedHeight("Fill The Data");
        home.submitBookAppointment();
    }

    @Then("User verify Appointment")
    public void userVerifyAppointment() throws IOException {
        Appointment appointment = new Appointment(driver);
        appointment.verifyAppointment();
        ss.takeScreenshotWithResizedHeight("Appointment Confirmation");
    }

    @And("User fill the Date {string} about Appointment")
    public void userFillTheDateAboutAppointment(String date) throws IOException, InterruptedException {
        home.verifyHomepage();
        home.date(date);
        ss.takeScreenshotWithResizedHeight("Fill The Data");
        home.submitBookAppointment();
    }

}
