package pages.trainings;

import components.EventsTileComponent;
import components.MainMenuComponent;
import components.TrainigsTileComponent;
import data.MainMenuItemsData;
import data.trainigs.TrainigsData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbsBasePage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static data.trainigs.TrainigsData.Testing;

public class QATrainingsPage extends AbsBasePage {

    public QATrainingsPage(WebDriver driver) {
        super(driver);
     }


    public void openTrainingsPageFromMainMenu() {

       new MainMenuComponent(driver)
                .moveCursorToItem(MainMenuItemsData.Trainigs)
                .clickTrainingTypeByName(TrainigsData.Testing);
       logger.info("Открыт раздел " + TrainigsData.Testing.getName());
        pageHeaderShouldBeSameAs(driver.findElement(By.tagName("h1")),
                Testing.getName());
    }

  public Integer countTrainigsTilesOnPage() {
        TrainigsTileComponent qaTrainigsTails = new TrainigsTileComponent(driver);
        List<WebElement> tiles = new ArrayList<>();
        tiles.addAll(driver.findElements(By.cssSelector(".lessons>a")));
        int tilesQuantity = tiles.size();
        Assertions.assertEquals(14, tilesQuantity, "Должно быть 14");
        logger.info("Количество карточек в разделе " +tilesQuantity);
        return tilesQuantity;
    }

public void openTrainigPage (String tileName) {
      String tileLocatorByNamePatter = "//div[@class='lessons__new-item-title  lessons__new-item-title_with-bg js-ellipse'][contains(text(), '"+ tileName +"')]";
      driver.findElement(By.xpath(tileLocatorByNamePatter)).click();
    }

  public HashMap<String, TrainigsTileComponent> collectTrainingsDataFromTiles() {
      HashMap<String, TrainigsTileComponent> trainingsInfo = new HashMap<>(14);
      TrainigsTileComponent temp = new TrainigsTileComponent(driver);
      ((JavascriptExecutor)driver)
              .executeScript("window.scrollBy(0,document.body.scrollHeight)");
  // for (int i=0; i<countTrainigsTilesOnPage(); i++) { //получать количество
      for (int i=0; i<12; i++) {
         temp = temp.collectTrainingDataFromTile(i);
         trainingsInfo.put(temp.getTrainingName(), temp);
     }
      return trainingsInfo;
  }
}






