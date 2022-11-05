package eventsTests;

import org.junit.jupiter.api.Test;
import pages.events.EventsSchedulePage;
import preconditions.BeforeTestsCommonPreconditions;

public class OpenWebinarsTest extends BeforeTestsCommonPreconditions {

    @Test
    public void openWebinarsTest() {
     EventsSchedulePage eventsSchedulePage = new EventsSchedulePage(driver);
     eventsSchedulePage
                .openEventSchedulePageFromMainMenu();
     eventsSchedulePage.filterOpenWebinars();

    }
}
