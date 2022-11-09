package pages.trainings;

import components.CourseInfoLineComponent;
import components.TrainigsTileComponent;
import data.trainigs.TestingTrainigsNames;
import data.trainigs.TrainingFormat;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.AbsBasePage;

import java.util.HashMap;

public class TrainingPage extends AbsBasePage {

    public TrainingPage(WebDriver driver) {

        super(driver);
    }
 private QATrainingsPage trainingsPage = new QATrainingsPage(driver);


    public void checkCourseInfo (HashMap<String, TrainigsTileComponent> trainingsData, String trainingName){
        CourseInfoLineComponent infoLineComponent = new CourseInfoLineComponent(driver);
        if ((trainingName.equals(TestingTrainigsNames.QABasic.getName()) |
                   trainingName.equals(TestingTrainigsNames.QALead.getName()) |
                   trainingName.equals(TestingTrainigsNames.JavaQAPro.getName()) |
                   trainingName.equals(TestingTrainigsNames.ManualTesting.getName()) |
                   trainingName.equals(TestingTrainigsNames.ChooseITProffession.getName()) |
                   trainingName.equals(TestingTrainigsNames.PythonBootCamp.getName()))) {

         Assertions.assertNotNull(trainingsData.get(trainingName), "данные отсутствуют");
         logger.info("Страница курса " + trainingName + " не содержит необходимое полное описание");

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
