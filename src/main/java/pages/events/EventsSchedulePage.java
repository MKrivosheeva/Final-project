package pages.events;

import components.EventsTileComponent;
import components.MainMenuComponent;
import data.MainMenuItemsData;
import data.events.EventsData;
import data.events.EventsTypes;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbsBasePage;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


import static data.events.EventsData.EventsSchedule;

public class EventsSchedulePage extends AbsBasePage {

    public EventsSchedulePage(WebDriver driver) {
        super(driver);
    }

    public void openEventSchedulePageFromMainMenu() {

        new MainMenuComponent(driver)
                .moveCursorToItem(MainMenuItemsData.Events)
                .clickEventTypeByName(EventsSchedule);
        logger.info("Открыт раздел " + EventsSchedule.getName());
        pageHeaderShouldBeSameAs(driver.findElement(By.cssSelector(".dod_new-header__title")),
                EventsData.EventsSchedule.getName());
    }

    private EventsTileComponent futureEvents = new EventsTileComponent(driver);

    public void checkIfAnyEventsOnPage() {
        List<WebElement> allFutureEvents = futureEvents
                .createListOfTiles(".div.dod_new-events__list.js-dod_new_events>a");
        Assertions.assertNotNull(allFutureEvents, "Мероприятия отображаются на странице");
     }

     private String tilesByDateSelector = "span[class='dod_new-event__icon dod_new-event__calendar-icon']+span";
     public void checkIfEventDateInFuture() {
        List<WebElement> eventsDates = futureEvents.createListOfTiles(tilesByDateSelector);
        logger.info("Всего запланировано мероприятий: " + eventsDates.size());
         LocalDate nowDate = LocalDate.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");
        for (WebElement element : eventsDates) {
            String eventDateFromTile = element.getText()+" "+nowDate.getYear();
            LocalDate eventDate = LocalDate.parse(eventDateFromTile, formatter);
            Assertions.assertTrue(eventDate.compareTo(nowDate)>=0);
            logger.info("Дата мероприятия " +  eventDate + " больше или равна текущей даты");
        }
    }
    private String dropdownLocator = "(//span[@class='dod_new-events-dropdown__input-selected'][contains(text(),'Все мероприятия')])[1]";

    public void filterEvents(String filterItemLocator) {
    driver.findElement(By.xpath(dropdownLocator)).click();
    driver.findElement(By.xpath(filterItemLocator)).click();
    }

    private String tilesByTypeSelector = "[class='dod_new-type__text']";
    public void filterOpenWebinars() {
        EventsTileComponent filteredEvents = new EventsTileComponent(driver);
        String openWebinarsLocator = "(//a[@title='" + EventsTypes.OPENWEBINARS.getName() + "'])[1]";
        filterEvents(openWebinarsLocator);
        List<WebElement> openWebinars = filteredEvents.createListOfTiles(tilesByTypeSelector);
        for (WebElement element : openWebinars) {
        String textFromTile = element.getText();
        Assertions.assertEquals(EventsTypes.OPENWEBINARS.getName(), textFromTile, "Тип мероприятия соответсвует выбранному фильтру");
        logger.info("Тип мероприятия соответсвует выбранному фильтру");
        }
    }
}

