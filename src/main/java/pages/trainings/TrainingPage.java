package pages.trainings;

import components.CourseInfoLineComponent;
import components.MainMenuComponent;
import data.trainigs.TestingTrainigsNames;
import data.trainigs.TrainigsData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AbsBasePage;

public class TrainingPage extends AbsBasePage {  //,будет пример для JavaQABasic

    public TrainingPage(WebDriver driver) {

        super(driver);
    }
   private QATrainingsPage trainingsPage = new QATrainingsPage(driver);
 public void openTheTraining () {
     trainingsPage.openTrainigPage(TestingTrainigsNames.JavaQABasic.getName());
     pageHeaderShouldBeSameAs(driver.findElement(By.cssSelector(".course-header2__title")), TestingTrainigsNames.JavaQABasic.getName());
 }

    private String [] c = trainingsPage.collectTrainingDataFromTile(TestingTrainigsNames.JavaQABasic.getName());
   public void checkCourseInfo(String [] c) {
        CourseInfoLineComponent coursInfo = new CourseInfoLineComponent();
      String [] b = coursInfo.trainingInfoData();
       Assertions.assertEquals(c[0], b[0], "название совпадает");
       Assertions.assertEquals(c[1], b[1], "дата совпадает");
       Assertions.assertEquals(c[2], b[2], "длительность совпадает");

    }



}
