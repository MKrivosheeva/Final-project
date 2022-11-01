package components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventsTileComponent extends AbsBaseComponent {

    public EventsTileComponent (WebDriver driver) {

        super(driver);
    }

    public List<WebElement> createListOfTiles(String selector){
        List<WebElement> eventTiles = new ArrayList<>();
        ((JavascriptExecutor)driver)
                .executeScript("window.scrollBy(0,document.body.scrollHeight)");
        eventTiles
                .addAll(driver.findElements(By.cssSelector(selector)));
      return eventTiles;
    }


}
