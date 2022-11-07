package data.trainigs;

import data.IMenuData;
import data.MainMenuItemsData;

public enum TrainigsData implements IMenuData {

    Testing("Тестирование", MainMenuItemsData.Trainigs),
    Dev("Программирование", MainMenuItemsData.Trainigs),
    Infrastructure ("Инфраструктура", MainMenuItemsData.Trainigs),
    DataScience ("Data Science", MainMenuItemsData.Trainigs),
    GameDev ("GameDev", MainMenuItemsData.Trainigs),
    Management ("Управление", MainMenuItemsData.Trainigs),
    Analitics ("Аналитика", MainMenuItemsData.Trainigs),
    Corporative ("Корпоративные курсы", MainMenuItemsData.Trainigs),
    Specials ("Специализации", MainMenuItemsData.Trainigs),
    InProsess ("В разработке", MainMenuItemsData.Trainigs),
    Prep ("Подготовительные курсы", MainMenuItemsData.Trainigs),
    Subscription ("Подписка", MainMenuItemsData.Trainigs);


    private String name;
    private MainMenuItemsData mainMenuItemsData;
    TrainigsData(String name, MainMenuItemsData mainMenuItemsData) {
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
