package eventsTests;

import org.openqa.selenium.By;
import pages.events.EventsSchedulePage;
import preconditions.BeforeTestsCommonPreconditions;
import data.events.EventsData;
import org.junit.jupiter.api.Test;


public class EventsDatesValidationTest extends BeforeTestsCommonPreconditions {

    @Test
    public void validateEventsDate() {
        EventsSchedulePage eventsSchedulePage = new EventsSchedulePage(driver);
        eventsSchedulePage
                .openEventSchedulePageFromMainMenu();
   //     eventsSchedulePage.checkIfAnyEventsOnPage();
     eventsSchedulePage.checkIfEventDateInFuture();
    }
}
