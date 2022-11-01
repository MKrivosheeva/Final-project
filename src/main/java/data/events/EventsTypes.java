package data.events;

public enum EventsTypes {

    ALLEVENTS("Все мероприятия"),
    INTENSIVES("Интенсивы"),
    OPENDOORSDAYS("ДОД"),
    OPENWEBINARS("Открытый вебинар"),
    MEETUPS("Онлайн митап");

    private String name;

    EventsTypes(String name) {
            this.name = name;
        }

    public String getName() {
            return name;
  }
}
