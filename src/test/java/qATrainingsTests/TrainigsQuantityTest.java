package qATrainingsTests;

import org.junit.jupiter.api.Test;
import pages.trainings.QATrainingsPage;
import preconditions.BeforeTestsCommonPreconditions;


public class TrainigsQuantityTest extends BeforeTestsCommonPreconditions {

    @Test
    public void testQATrainingsQauntity(){
        QATrainingsPage qaTrainingsPage = new QATrainingsPage(driver);
        qaTrainingsPage.openTrainingsPageFromMainMenu();
        qaTrainingsPage.countTrainigsTilesOnPage();
    }
}
