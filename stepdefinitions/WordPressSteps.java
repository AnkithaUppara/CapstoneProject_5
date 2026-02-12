package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.DownloadPage;
import pages.HomePage;
import pages.PhotoDirectoryPage;

public class WordPressSteps extends BaseTest {

    HomePage homePage;
    DownloadPage downloadPage;
    PhotoDirectoryPage photoPage;

    @Before
    public void setUp() {
        launchBrowser();
        homePage = new HomePage(driver);
        downloadPage = new DownloadPage(driver);
        photoPage = new PhotoDirectoryPage(driver);
    }

    @Given("I launch WordPress")
    public void i_launch_wordpress() {
        openUrl("https://wordpress.org/");
    }

    @Then("I verify the title contains {string}")
    public void i_verify_title(String title) {
        Assert.assertTrue(driver.getTitle().contains(title));
    }

    @When("I hover on Extend and click Get WordPress")
    public void i_hover_extend_and_click() {
        homePage.hoverExtendAndClickGetWordPress();
    }

    @Then("I verify Get WordPress header text is {string}")
    public void verify_header(String text) {
        Assert.assertEquals(downloadPage.getHeaderText(), text);
    }

    @When("I click on Community and select Photo Directory")
    public void open_photo_directory() {
        homePage.openPhotoDirectory();
    }

    @When("I search photo with keyword {string}")
    public void search_photo(String keyword) {
        photoPage.searchPhoto(keyword);
    }

    @Then("I verify photos are displayed")
    public void verify_photos() {
        Assert.assertTrue(photoPage.arePhotosDisplayed());
    }

    @After
    public void tearDown() {
        quitBrowser(); 
    }
}
