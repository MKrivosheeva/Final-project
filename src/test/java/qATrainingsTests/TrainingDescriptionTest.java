package qATrainingsTests;

import components.TrainigsTileComponent;
import org.junit.jupiter.api.Test;
import pages.trainings.QATrainingsPage;
import pages.trainings.TrainingPage;
import preconditions.BeforeTestsCommonPreconditions;

import java.util.HashMap;

public class TrainingDescriptionTest extends BeforeTestsCommonPreconditions {
    @Test
    public void testCourseInfoLine() {
        QATrainingsPage qaTrainingsPage = new QATrainingsPage(driver);
        TrainingPage page = new TrainingPage(driver);
        qaTrainingsPage.openTrainingsPageFromMainMenu();
        HashMap<String, TrainigsTileComponent> allAboutTrainings = qaTrainingsPage.collectTrainingsDataFromTiles();
        page.openTheTraining();
        page.checkCourseInfo(allAboutTrainings);
    }
}