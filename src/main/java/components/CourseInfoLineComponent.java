package components;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
public class CourseInfoLineComponent extends AbsBaseComponent {

    public CourseInfoLineComponent(WebDriver driver) {

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

    /*проверка работает для курсов, у которых одинаковый дизайн страницы, содержащий полную информацию о курсе:
    1. Kotlin QA Engineer
    2. Нагрузочное тестирование
    3. Java QA Engineer. Professional
    4. Автоматизация тестирования OpenStack
    5. JavaScript QA Engineer
    6. Game QA Engineer
    7. Python QA Engineer
    8. Java QA Engineer. Basic */

    public CourseInfoLineComponent collectCourseInfo (CourseInfoLineComponent thisCourse) {

        String infoLineStartDateLocator = "//p[contains(text(), 'Начало занятий:')]/following::p[@class='course-header2-bottom__item-text'][1]";
        String infoLineDurationLocator = "//p[contains(text(), 'Длительность обучения')]/following::p[@class='course-header2-bottom__item-text'][1]";
        String infoLineNameSelector = ".course-header2__title";
        String infoLineFormatLocator = "//p[contains(text(), 'Формат:')]/following::p[@class='course-header2-bottom__item-text'][1]";
        ((JavascriptExecutor) driver)
                .executeScript("document.querySelector('[class=\"course-header2-bottom\"').scrollIntoView()");
        thisCourse.setInfoLineName(driver.findElement(By.cssSelector(infoLineNameSelector)).getText());
        thisCourse.setInfoLineDuration(driver.findElement(By.xpath(infoLineDurationLocator)).getText());
        thisCourse.setInfoLineStartDate(driver.findElement(By.xpath(infoLineStartDateLocator)).getText());
        thisCourse.setInfoLineFormat(driver.findElement(By.xpath(infoLineFormatLocator)).getText());

        return thisCourse;
    }
}




