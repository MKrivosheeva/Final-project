package preconditions;

import driver.DriverFactory;
import exception.DriverNotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class BeforeTestsCommonPreconditions {

    protected WebDriver driver;
    public static org.apache.logging.log4j.Logger logger = LogManager.getLogger(BeforeTestsCommonPreconditions.class);

    @BeforeAll
    public static void load() {

        WebDriverManager.chromedriver().setup();
        logger.info("Выполнена загрузка драйвера");
    }

    @BeforeEach
    public void init() throws DriverNotSupportedException {
        this.driver = new DriverFactory().getDriver();
        new MainPage(driver)
                .open("/");
        logger.info("Открыта главная страница");
        driver.findElement(By.cssSelector("button[class='js-cookie-accept cookies__button']")).click();
        logger.info("Куки одобрены");
    }

    @AfterEach
    public void close() {
        if (this.driver != null) {
            this.driver.close();
            this.driver.quit();
        }
    }



}
