package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    //  EXTEND MENU 
    private By extendMenu =
            By.xpath("(//span[@class='wp-block-navigation-item__label'])[4]");

    private By getWordPressLink =
            By.xpath("(//a[@class='global-header__desktop-get-wordpress global-header__get-wordpress'])");

    private By getWordPressHeader =
            By.xpath("//h1[text()='Get WordPress']");

    private By communityMenu =
            By.xpath("//span[text()='Community']");

    private By photoDirectoryLink =
            By.xpath("//span[text()='Photo Directory']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.actions = new Actions(driver);
    }

    public void open() {
        driver.get("https://wordpress.org/");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    //  EXTEND → GET WORDPRESS
    public void hoverExtendAndClickGetWordPress() {

        WebElement extend =
                wait.until(ExpectedConditions.visibilityOfElementLocated(extendMenu));
        actions.moveToElement(extend).perform();

        WebElement getWP =
                wait.until(ExpectedConditions.elementToBeClickable(getWordPressLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWP);
    }

    public String getGetWordPressHeaderText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getWordPressHeader))
                .getText().trim();
    }

    //  COMMUNITY → PHOTO DIRECTORY
    public void openPhotoDirectory() {

        //  Hover on Community
        WebElement community =
                wait.until(ExpectedConditions.visibilityOfElementLocated(communityMenu));
        actions.moveToElement(community).perform();

        // Click Photo Directory after submenu opens
        WebElement photoDir =
                wait.until(ExpectedConditions.visibilityOfElementLocated(photoDirectoryLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", photoDir);
    }

}
