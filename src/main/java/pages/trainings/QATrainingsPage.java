package pages.trainings;

import components.MainMenuComponent;
import components.TrainigsTileComponent;
import data.MainMenuItemsData;
import data.trainigs.TrainigsData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbsBasePage;

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

    public void countTrainigsTilesOnPage() {
        TrainigsTileComponent qaTrainigsTails = new TrainigsTileComponent(driver);
        int trainingsOnPage = qaTrainigsTails.countTrainigsTiles();
        Assertions.assertEquals(14, trainingsOnPage, "Должно быть 14");
        logger.info("Количество карточек в разделе " +trainingsOnPage);
    }

public void openTrainigPage (String tileName) {
      String tileLocatorByNamePatter = "//div[@class='lessons__new-item-title  lessons__new-item-title_with-bg js-ellipse'][contains(text(), '"+ tileName +"')]";
      driver.findElement(By.xpath(tileLocatorByNamePatter)).click();
    }

  public String[] collectTrainingDataFromTile(String tileName) {
      TrainigsTileComponent qaTrainigTail = new TrainigsTileComponent(driver);
      ((JavascriptExecutor)driver)
              .executeScript("window.scrollBy(0,document.body.scrollHeight)");
    //  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='lessons__new-item-title  lessons__new-item-title_with-bg js-ellipse'][contains(text(), '"+ tileName +"')]"))));
      String[] courseInfo = qaTrainigTail.collectDataFromTile(tileName);

      return courseInfo;
  }

}






