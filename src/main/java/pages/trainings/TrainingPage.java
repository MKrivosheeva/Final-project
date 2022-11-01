package pages.trainings;

import components.MainMenuComponent;
import data.trainigs.TestingTrainigsNames;
import data.trainigs.TrainigsData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AbsBasePage;

public class TrainingPage extends AbsBasePage {  //,будет пример для JavaQABasic

    public TrainingPage(WebDriver driver) {

        super(driver);
    }

 public void openTheTraining () {
     new QATrainingsPage(driver).openTrainigPage(TestingTrainigsNames.JavaQABasic.getName());
     pageHeaderShouldBeSameAs(driver.findElement(By.cssSelector(".course-header2__title")), TestingTrainigsNames.JavaQABasic.getName());
 }
   public void checkCourseInfo() {


   }

}
