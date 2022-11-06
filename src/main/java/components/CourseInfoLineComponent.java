package components;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
public class CourseInfoLineComponent extends AbsBaseComponent {

    public CourseInfoLineComponent (WebDriver driver) {

        super(driver);
    }

    private String infoLineStartDate;
    private String infoLineDuration;
    private String infoLineFormat;
    private String infoLineName;

    public CourseInfoLineComponent(String infoLineStartDate, String infoLineDuration, String infoLineFormat, String infoLineName) {
        this.infoLineStartDate = infoLineStartDate;
        this.infoLineDuration = infoLineDuration;
        this.infoLineFormat = infoLineFormat;
        this.infoLineName = infoLineName;
    }

   public CourseInfoLineComponent collectCourseInfo (CourseInfoLineComponent thisCourse) {
       String infoLineStartDateLocator = "//p[contains(text(), 'Начало занятий:')]/following::p[@class='course-header2-bottom__item-text'][1]";
       String infoLineDurationLocator = "//p[contains(text(), 'Длительность обучения')]/following::p[@class='course-header2-bottom__item-text'][1]";
       String infoLineNameSelector = ".course-header2__title";
       String infoLineFormatLocator = "//p[contains(text(), 'Формат:')]/following::p[@class='course-header2-bottom__item-text'][1]";

   //    CourseInfoLineComponent thisCourse = new CourseInfoLineComponent(driver);
       ((JavascriptExecutor) driver)
               .executeScript("document.querySelector('[class=\"course-header2-bottom\"').scrollIntoView()");
      thisCourse.setInfoLineName(driver.findElement(By.cssSelector(infoLineNameSelector)).getText());
      thisCourse.setInfoLineDuration(driver.findElement(By.xpath(infoLineDurationLocator)).getText());
      thisCourse.setInfoLineStartDate(driver.findElement(By.xpath(infoLineStartDateLocator)).getText());
      thisCourse.setInfoLineFormat(driver.findElement(By.xpath(infoLineFormatLocator)).getText());

    return thisCourse;
   }


//
//    //sc-10wn8wt-3 - для QA Lead, QA Basic
//    //course-header2-bottom__content-items -   //JavaQABasic, Python QA, Game Qa, Kotlin QA Engineer, Нагрузочное тестирование, JavaQAPro, автоматизация OpenStack, JS QA
//    //выбор профессии - надо по xpath, QAPro,
//    //ручное тестирование, буткемп питон - нет данных таких

}


