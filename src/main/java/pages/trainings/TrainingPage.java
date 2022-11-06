package pages.trainings;

import components.CourseInfoLineComponent;
import components.MainMenuComponent;
import components.TrainigsTileComponent;
import data.trainigs.TestingTrainigsNames;
import data.trainigs.TrainigsData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.AbsBasePage;

import java.util.HashMap;

public class TrainingPage extends AbsBasePage {  //,будет пример для JavaQABasic

    public TrainingPage(WebDriver driver) {

        super(driver);
    }
 private QATrainingsPage trainingsPage = new QATrainingsPage(driver); //вот тут сделать универсальный клик
 public void openTheTraining () {
     trainingsPage.openTrainigPage(TestingTrainigsNames.JavaQABasic.getName());
     pageHeaderShouldBeSameAs(driver.findElement(By.cssSelector(".course-header2__title")), TestingTrainigsNames.JavaQABasic.getName());
 }




 public void checkCourseInfo (HashMap<String, TrainigsTileComponent> trainingsData){
     CourseInfoLineComponent infoLineComponent = new CourseInfoLineComponent(driver);
     infoLineComponent.collectCourseInfo(infoLineComponent);
     TrainigsTileComponent requestedTile = trainingsData.get("Java QA Engineer. Basic");
     Assertions.assertEquals(requestedTile.getTrainingDuration(), infoLineComponent.getInfoLineDuration(), "длительность не совпадает");
     Assertions.assertEquals(requestedTile.getTrainingStartDate(), infoLineComponent.getInfoLineStartDate(), "даты не совпадают");
     Assertions.assertEquals(requestedTile.getTrainingName(), infoLineComponent.getInfoLineName(), "заголовки не совпадают");
     Assertions.assertEquals("Online", infoLineComponent.getInfoLineFormat(), "формат не совпадает");
 }

}
