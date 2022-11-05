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
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    private String tileSelector = "[class='dod_new-event']";
    public List<EventsTileComponent> createListOfTiles(String tileSelector){
        List <EventsTileComponent> listOfFutureEvents = new ArrayList<>();

        int a=0; //вот это надо переделать в какой-то другой способ или условие завершения прокрутки
        while (a<5) {
          ((JavascriptExecutor) driver)
                  .executeScript("$('html,body').animate({scrollTop: document.body.scrollHeight},\"fast\");");
          wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector(tileSelector))));

       a++;
      }
        int quantity =  driver.findElements(By.cssSelector(tileSelector)).size();
         for (int i=0; i< quantity; i++) {
         EventsTileComponent tempEvent = new EventsTileComponent(driver);
         tempEvent.collectEventData(tempEvent, i);
         listOfFutureEvents.add(i, tempEvent);
       }
        logger.info("Всего запланировано мероприятий: " + listOfFutureEvents.size());
        return listOfFutureEvents;
    }

//    public void checkIfAnyEventsOnPage() {
//      List allFutureEvents = createListOfTiles(tileSelector);
//      int quantity =  allFutureEvents.size();
//      Assertions.assertTrue(quantity>0, "Мероприятия отображаются на странице");
//      logger.info("Всего мероприятий " + quantity);
//     }

    public void checkIfEventDateInFuture() {
        List<EventsTileComponent> events = createListOfTiles(tileSelector);
      //  logger.info("Всего запланировано мероприятий: " + events.size());
        LocalDateTime thisEventDate;
        for (EventsTileComponent element : events) {
        thisEventDate = element.getEventDateTime(element);
        Assertions.assertTrue(thisEventDate.compareTo(LocalDateTime.now())>=0);
        logger.info("Дата мероприятия " +  thisEventDate + " больше или равна текущей даты");
        }
    }
    private String dropdownLocator = "(//span[@class='dod_new-events-dropdown__input-selected'][contains(text(),'Все мероприятия')])[1]";
    public void filterEvents(String filterItemLocator) {
    driver.findElement(By.xpath(dropdownLocator)).click();
    driver.findElement(By.xpath(filterItemLocator)).click();
    }

   public void filterOpenWebinars() {
        String openWebinarsLocator = "(//a[@title='" + EventsTypes.OPENWEBINARS.getName() + "'])[1]";
        filterEvents(openWebinarsLocator);
        List<EventsTileComponent> openWebinars = createListOfTiles(tileSelector);
        for (EventsTileComponent element : openWebinars) {
        String textFromTile = element.getEventType();
        Assertions.assertEquals(EventsTypes.OPENWEBINARS.getName(), textFromTile, "Тип мероприятия соответсвует выбранному фильтру");
        logger.info("Тип мероприятия соответсвует выбранному фильтру");
        }
    }
}

