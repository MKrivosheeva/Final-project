package components;

import data.IMenuData;
import data.MainMenuItemsData;
import data.events.EventsData;
import data.trainigs.TrainigsData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.events.EventPage;
import pages.events.EventsSchedulePage;
import pages.trainings.QATrainingsPage;
import pages.trainings.TrainingPage;

public class MainMenuComponent extends AbsBaseComponent {

    public MainMenuComponent(WebDriver driver) {
        super(driver);
    }

   private String mainMenuLocator = "//*[contains(@class, 'header2-menu_main')]/*[contains(@class, 'header2-menu__item')][.//*[text()='%s']]";
   private String subMenuLocator = mainMenuLocator + "//a[@title='%s']";

    public MainMenuComponent moveCursorToItem(MainMenuItemsData mainMenuItemsData) {
        String locator = String.format(mainMenuLocator, mainMenuItemsData.getName());
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locator))));

        actions.moveToElement(driver.findElement(By.xpath(locator))).build().perform();
        logger.info("Курсор наведён на раздел " + mainMenuItemsData.getName());
        return this;
    }

    public QATrainingsPage clickTrainingTypeByName(IMenuData trainingsData) { //тип объекта по названию страницы должен быть
        String locator = String.format(subMenuLocator, MainMenuItemsData.Trainigs.getName(), TrainigsData.Testing.getName());
        WebElement subMenu = driver.findElement(By.xpath(locator));
        actions.moveToElement(subMenu).click().perform();
        logger.info("Инициирован переход в раздел " + TrainigsData.Testing.getName() );
        return new QATrainingsPage(driver);
 }

    public EventsSchedulePage clickEventTypeByName(IMenuData eventsData) { //тип объекта по названию страницы должен быть
        String locator = String.format(subMenuLocator, MainMenuItemsData.Events.getName(), EventsData.EventsSchedule.getName());
        WebElement subMenu = driver.findElement(By.xpath(locator));
        actions.moveToElement(subMenu).click().perform();
        logger.info("Инициирован переход в раздел " +  EventsData.EventsSchedule.getName() );
        return new EventsSchedulePage(driver);
    }


   /* public CoursePage clickCurseByName(ICourseData courceData) { //тип объекта по названию страницы должен быть
        String locator = String.format(subMenuLocator, MainMenuItemsData.Courses.getName(), courceData.getCourcesData().getName());
        WebElement subMenu = driver.findElement(By.xpath(locator));

        String copurceLocator = String.format(
                "//*[contains(@class, 'header2-menu__subdropdown-item')][contains(text(), '%s')]",
                courceData.getName()
        );

        actions
                .moveToElement(subMenu, 40, 0)
                .click(driver.findElements(By.xpath(copurceLocator)).get(1)).build().perform();

        return new CoursePage(driver);
    }
    */

}
