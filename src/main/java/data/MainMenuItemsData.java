package data;

public enum MainMenuItemsData { //основное меню

    Trainigs("Курсы"),
    Events("События"),
    ForTeachers("Преподавателям"),
    ForCompanies("Компаниям"),
    AboutUs("О нас");

    private String name;

    MainMenuItemsData(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}



