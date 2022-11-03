package components;

public class CourseInfoLineComponent { //здесь будет получение данных из строки с описанием курса на странице курса
//аналогично массив строк для сравнения с полученными из тайла данными
//
//    //sc-10wn8wt-3 - для QA Lead, QA Basic
//    //course-header2-bottom__content-items -   //JavaQABasic, Python QA, Game Qa, Kotlin QA Engineer, Нагрузочное тестирование, JavaQAPro, автоматизация OpenStack, JS QA
//    //выбор профессии - надо по xpath, QAPro,
//    //ручное тестирование, буткемп питон - нет данных таких

 //здесь пока просто строки для проверки работы метода, далее надо будет заменить на получение данных из компонента
   public String[] trainingInfoData () {
       String[] trainigData= new String[3];
       trainigData[0] = "Java QA Engineer. Basic";
       trainigData[1] = "C 27 декабря"; //здесь надо будет убирать букву с в методе получения данных из тайла
       trainigData[2] = "4 месяца";
       return trainigData;
   }


}
