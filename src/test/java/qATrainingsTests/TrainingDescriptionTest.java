package qATrainingsTests;

import data.trainigs.TestingTrainigsNames;
import org.junit.jupiter.api.Test;
import pages.trainings.QATrainingsPage;
import pages.trainings.TrainingPage;
import preconditions.BeforeTestsCommonPreconditions;

public class TrainingDescriptionTest extends BeforeTestsCommonPreconditions {
    @Test
    public void testCourseInfoLine(){
        QATrainingsPage qaTrainingsPage = new QATrainingsPage(driver);
        qaTrainingsPage.openTrainingsPageFromMainMenu();
        String a[] = qaTrainingsPage.collectTrainingDataFromTile(TestingTrainigsNames.JavaQABasic.getName());
        TrainingPage trainingPage = new TrainingPage (driver);

}
