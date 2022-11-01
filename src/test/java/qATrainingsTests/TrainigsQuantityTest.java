package qATrainingsTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.trainings.QATrainingsPage;
import preconditions.BeforeTestsCommonPreconditions;

import static data.trainigs.TrainigsData.*;

public class TrainigsQuantityTest extends BeforeTestsCommonPreconditions {

    @Test
    public void testQATrainingsQauntity(){ // проверка количества карточек в разделе "Тестирование"
        QATrainingsPage qaTrainingsPage = new QATrainingsPage(driver);
        qaTrainingsPage.openTrainingsPageFromMainMenu();
        qaTrainingsPage.countTrainigsTilesOnPage();
    }
}
