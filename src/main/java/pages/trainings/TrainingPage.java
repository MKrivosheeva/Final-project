package pages.trainings;

import components.CourseInfoLineComponent;
import components.TrainigsTileComponent;
import data.trainigs.TestingTrainigsNames;
import data.trainigs.TrainingFormat;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AbsBasePage;

import java.util.HashMap;

public class TrainingPage extends AbsBasePage {

    public TrainingPage(WebDriver driver) {

        super(driver);
    }
 private QATrainingsPage trainingsPage = new QATrainingsPage(driver);

// public void openTheTraining (String trainingName) {
//     trainingsPage.openTrainigPage(trainingName);
//     pageHeaderShouldBeSameAs(driver.findElement(By.cssSelector(".course-header2__title")), TestingTrainigsNames.JavaQABasic.getName());
// }


// public void checkCourseInfo (HashMap<String, TrainigsTileComponent> trainingsData){
//     CourseInfoLineComponent infoLineComponent = new CourseInfoLineComponent(driver);
//     infoLineComponent.collectCourseInfo(infoLineComponent);
//     TrainigsTileComponent requestedTile = trainingsData.get("Java QA Engineer. Basic");
//     Assertions.assertEquals(requestedTile.getTrainingDuration(), infoLineComponent.getInfoLineDuration(), "длительность не совпадает");
//     Assertions.assertEquals(requestedTile.getTrainingStartDate(), infoLineComponent.getInfoLineStartDate(), "даты не совпадают");
//     Assertions.assertEquals(requestedTile.getTrainingName(), infoLineComponent.getInfoLineName(), "заголовки не совпадают");
//     Assertions.assertEquals("Online", infoLineComponent.getInfoLineFormat(), "формат не совпадает");
// }

    public void checkCourseInfo (HashMap<String, TrainigsTileComponent> trainingsData, String trainingName){
        CourseInfoLineComponent infoLineComponent = new CourseInfoLineComponent(driver);
       if ((trainingName.equals("QA Engineer. Basiс") |
                trainingName.equals("QA Lead") |
                trainingName.equals("QA Engineer. Basic") |
                trainingName.equals("Специализация QA Automation Engineer") |
                trainingName.equals("Ручное тестирование") |
                trainingName.equals("Выбор профессии в IT") |
                trainingName.equals("Буткемп Python QA Engineer"))) {
         Assertions.assertNotNull(trainingsData.get(trainingName), "данные отсутствуют");
         logger.info("Страница курса не содержит необходимое полное описание");

        }
        else {
            infoLineComponent.collectCourseInfo(infoLineComponent);
            TrainigsTileComponent requestedTile = trainingsData.get(trainingName);
            Assertions.assertEquals(requestedTile.getTrainingDuration(), infoLineComponent.getInfoLineDuration(), "длительность не совпадает");
            logger.info("Длительность курса " + trainingName + " корректна");
            Assertions.assertEquals(requestedTile.getTrainingStartDate(), infoLineComponent.getInfoLineStartDate(), "даты не совпадают");
            logger.info("Дата начала курса " + trainingName + " корректна");
            Assertions.assertEquals(requestedTile.getTrainingName(), infoLineComponent.getInfoLineName(), "заголовки не совпадают");
            logger.info("Наименование курса " + trainingName + " корректно");
            Assertions.assertEquals(TrainingFormat.ONLINE.toString().toLowerCase(), infoLineComponent.getInfoLineFormat().toLowerCase(), "формат не совпадает");
            logger.info("Формат курса " + trainingName + " корректный");
        }
    }



}
