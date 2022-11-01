package components;

import data.trainigs.TestingTrainigsNames;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TrainigsTileComponent extends AbsBaseComponent{

    public TrainigsTileComponent(WebDriver driver) {
        super(driver);
    }


    public Integer countTrainigsTiles() { //нужно добавить прокрутку до конца страницы?
        List<WebElement> tiles = new ArrayList<>();
        tiles.addAll(driver.findElements(By.cssSelector(".lessons>a")));
        int tilesQuantity = tiles.size();
        return tilesQuantity;
    }
  // String tileName = TestingTrainigsNames.JavaQABasic.getName();
   public String [] collectDataFromTile(String tileName) {
       String [] tileProperties = new String[3];
       String tileLocatorByName = "//div[@class = 'lessons__new-item-container']/div[3][contains(text(), '" + tileName + "')]";
       WebElement tile = driver.findElement(By.xpath(tileLocatorByName));//нужна привязка к конкретному
       tileProperties[0] = tile.getText(); //нулевой элемент содержит имя
       String trainingDateLocator = tileLocatorByName+"/../div[4]//span[@class='lessons__new-item-calendar']";
 //надо сконструировать локатор с привязкой от имени вниз
       tileProperties[1] = driver.findElement(By.xpath(trainingDateLocator)).getText();; //первый элемент получает дату
       String trainingDurationLocator = tileLocatorByName+ "/../div[4]//div[2]//div[@class='lessons__new-item-time']";
    //надо сконструировать локатор с привязкой от имени вниз
       tileProperties[2] = driver.findElement(By.xpath(trainingDurationLocator)).getText();//второй элемент получает длительность
     return tileProperties;
    }
   // "//div[@class = 'lessons__new-item-container']/div[3][contains(text(), 'Java QA Engineer. Basic')]";
    //div[@class = 'lessons__new-item-container']/div[3][contains(text(), 'Java QA Engineer. Basic')]/../div[4]//span[@class='lessons__new-item-calendar']
////div[@class = 'lessons__new-item-container']/div[3][contains(text(), 'Java QA Engineer. Basic')]/../div[4]//div[2]//div[@class='lessons__new-item-time']
}


