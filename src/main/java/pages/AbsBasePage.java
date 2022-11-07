package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.AbsPageObject;


public abstract class AbsBasePage extends AbsPageObject{

    private final static String BASE_URL = System.getProperty("base.url");

    public AbsBasePage(WebDriver driver) {

        super(driver);
    }

       public void open(String path) {
       driver.get(BASE_URL + path);

    }
    protected String expectedHeader;
    @FindBy(tagName = "h1")
    WebElement header;
    public void pageHeaderShouldBeSameAs(WebElement header,String expectedHeader) {
        Assertions.assertEquals(expectedHeader,
                header.getText(),
                String.format("Header should be %s", expectedHeader));
        logger.info("Заголовок страницы корректный");
    }

}

