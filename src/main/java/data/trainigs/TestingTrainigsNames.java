package data.trainigs;


public enum TestingTrainigsNames {

    ChooseITProffesion("Выбор профессии в IT", TrainigsData.Testing),
    QALead("QA Lead", TrainigsData.Testing),
    KotlinQAEngineer ("Kotlin QA Engineer", TrainigsData.Testing),
    LoadTesting ("Нагрузочное тестирование", TrainigsData.Testing),
    QABasic ("QA Engineer. Basic", TrainigsData.Testing),
    JAVAQAProf ("Java QA Engineer. Professional", TrainigsData.Testing),
    OpenStack ("Автоматизация тестирования OpenStack", TrainigsData.Testing),
    JSQA ("JavaScript QA Engineer", TrainigsData.Testing),
    GameQA ("Game QA Engineer", TrainigsData.Testing),
    PythinQa ("Python QA Engineer", TrainigsData.Testing),
    JavaQABasic ("Java QA Engineer. Basic", TrainigsData.Testing),
    JavaQAPro ("Специализация QA Automation Engineer", TrainigsData.Testing),
    ManualTesting ("Ручное тестирование", TrainigsData.Testing),
    PythonBootCamp ("Буткемп Python QA Engineer", TrainigsData.Testing);

    private String name;
    private TrainigsData trainigsData;//это из основного меню
    TestingTrainigsNames(String name, TrainigsData trainigsDataData) { //название метода своё внутри тип осн.меню
        this.name = name;
        this.trainigsData = trainigsDataData;
    }
    public String getName() {

        return name;
    }
    public TrainigsData getTrainigsData() {

        return trainigsData;
    }




}
