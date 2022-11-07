package components;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrainigsTileComponent extends AbsBaseComponent{

    public TrainigsTileComponent(WebDriver driver) {
        super(driver);
    }
    @Setter
    @Getter
    private String trainingStartDate;
    @Setter
    @Getter
    private String trainingDuration;
    @Setter
    @Getter
    private String trainingName;

    private String trainingTileBaseSelector = "a[class$='lessons__new-item_hovered']";

    public TrainigsTileComponent collectTrainingDataFromTile (int i) {
     TrainigsTileComponent training = new TrainigsTileComponent(driver);
     String thisTileSelector = trainingTileBaseSelector +  ":nth-child("+(i+1) +")";
     String tileNameSelector = thisTileSelector + " [class^='lessons__new-item-title']";
     String tileStartDateSelector = thisTileSelector + " [class='lessons__new-item-start']";
     String tileDurationSelector = thisTileSelector + " [class='lessons__new-item-time']";
     training.setTrainingName((driver.findElement(By.cssSelector(tileNameSelector)).getText().trim()));
     try {
         driver.findElement(By.cssSelector(tileDurationSelector));
         training.setTrainingDuration(driver.findElement(By.cssSelector(tileDurationSelector)).getText());
     }
     catch (Exception NoSuchElementException )
        {
         training.setTrainingDuration("Нет данных");
        }
     try {
         driver.findElement(By.cssSelector(tileStartDateSelector));

         String trainingDateFromTile = driver.findElement(By.cssSelector(tileStartDateSelector)).getText();
         String trainingDate =trainingDateFromTile.substring(2).trim();
         training.setTrainingStartDate(trainingDate);
     }
    catch (Exception NoSuchElementException)  {

        training.setTrainingStartDate("Дата начала не указана");

    }
       return training;
    }

}


