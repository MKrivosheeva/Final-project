package pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;


public abstract class AbsPageObject {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    public static org.apache.logging.log4j.Logger logger = LogManager.getLogger(AbsPageObject.class);

    public AbsPageObject(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
     //   this.wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        PageFactory.initElements(driver, this);
    }

//    @FindBy(tagName = "h1")
//    String headerSelector = "[class='title-new__text'] h1";
//    private WebElement header = driver.findElement(By.cssSelector(headerSelector));
//    public void pageHeaderShouldBeSameAs(String expectedHeader) {
//        Assertions.assertEquals(
//                header,
//                this.header.getText(),
//                String.format("Header should be %s", expectedHeader));//нужны вейтеры
//    }

    public WebDriver getDriver() {
        return driver;
    }
    public Actions getActions() {
        return actions;
    }

}





