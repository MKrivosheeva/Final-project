package eventsTests;

import pages.events.EventsSchedulePage;
import preconditions.BeforeTestsCommonPreconditions;
import org.junit.jupiter.api.Test;


public class EventsDatesValidationTest extends BeforeTestsCommonPreconditions {

    @Test
    public void validateEventsDate() {
        EventsSchedulePage eventsSchedulePage = new EventsSchedulePage(driver);
        eventsSchedulePage
                .openEventSchedulePageFromMainMenu();
     eventsSchedulePage.checkIfEventDateInFuture();
    }
}
