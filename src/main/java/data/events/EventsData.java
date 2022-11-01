package data.events;

import data.IMenuData;
import data.MainMenuItemsData;

public enum EventsData implements IMenuData {

    TrainingStartSchedule ("Календарь запуска курсов", MainMenuItemsData.Events),
    EventsSchedule ("Календарь мероприятий", MainMenuItemsData.Events),
    Intensives ("Интенсивы", MainMenuItemsData.Events);

    private String name;
    private MainMenuItemsData mainMenuItemsData;//это из основного меню
    EventsData(String name, MainMenuItemsData mainMenuItemsData) { //название метода своё внутри тип осн.меню
        this.name = name;
        this.mainMenuItemsData = mainMenuItemsData;
    }
    public String getName() {
        return name;
    }
    public MainMenuItemsData getMainMenuItemsData() {
        return mainMenuItemsData;
    }

}
