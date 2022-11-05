package components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EventsTileComponent extends AbsBaseComponent {



    public EventsTileComponent (WebDriver driver) {

        super(driver);
    }
    private String eventType;
    private String eventDate;
    private String eventTime;
    private String tileBaseLocator = "[class='dod_new-event']";//убрать или поменять на цсс
    private LocalDateTime dateTime = LocalDateTime.now();

public EventsTileComponent(String eventType, String eventTime, String eventDate) {
       this.eventDate = eventDate;
       this.eventTime = eventTime;
       this.eventType = eventType;
   }
    public String getTileBaseLocator () {
        return getTileBaseLocator();
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public EventsTileComponent() {

    }

    public LocalDateTime getEventDateTime (EventsTileComponent eventTile) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy HH:mm");
    String eventDateFromTile = eventTile.getEventDate() + " " +dateTime.getYear() + " "+ eventTile.eventTime;
    LocalDateTime eventDateFormatted = LocalDateTime.parse(eventDateFromTile, formatter);
    return eventDateFormatted;
    }
    

}
