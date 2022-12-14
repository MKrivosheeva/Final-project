package components;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventsTileComponent extends AbsBaseComponent {


    public EventsTileComponent (WebDriver driver) {

        super(driver);
    }
    @Getter
    @Setter
    private String eventType;
    @Getter
    @Setter
    private String eventDate;
    @Getter
    @Setter
    private String eventTime;

    private String tileBaseSelector = "[class='dod_new-event']";
    private LocalDateTime dateTime = LocalDateTime.now();

public EventsTileComponent(String eventType, String eventTime, String eventDate) {
       this.eventDate = eventDate;
       this.eventTime = eventTime;
       this.eventType = eventType;
   }

    public LocalDateTime getEventDateTime (EventsTileComponent eventTile) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy HH:mm");
    String eventDateFromTile = eventTile.getEventDate() + " " +dateTime.getYear() + " "+ eventTile.eventTime;
    LocalDateTime eventDateFormatted = LocalDateTime.parse(eventDateFromTile, formatter);
    return eventDateFormatted;
    }

    public EventsTileComponent collectEventData (EventsTileComponent eventTile, int i) {
        String thisTileSelector = tileBaseSelector+":nth-child("+(i+1) +")";
        String tileDateSelector = thisTileSelector +  " span[class='dod_new-event__icon dod_new-event__calendar-icon']+span";
        String tileTimeSelector = thisTileSelector + " span[class='dod_new-event__icon dod_new-event__clock-icon']+span";
        String tileTypeSelector = thisTileSelector + " div[class='dod_new-type__text']";
        eventTile.setEventType(driver.findElement(By.cssSelector(tileTypeSelector)).getText());
        eventTile.setEventDate(driver.findElement(By.cssSelector(tileDateSelector)).getText());
        eventTile.setEventTime(driver.findElement(By.cssSelector(tileTimeSelector)).getText());
      return eventTile;
    }

}
