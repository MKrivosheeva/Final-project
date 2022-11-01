package components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.AbsPageObject;

public abstract class AbsBaseComponent extends AbsPageObject {

   public AbsBaseComponent(WebDriver driver) {
        super(driver);
    }


   public By LocatorType (String locator) {
    if(locator.startsWith("/")) {
        return By.xpath(locator);
    }
    return By.cssSelector(locator);
}

    protected WebDriverWait wait = new WebDriverWait(driver,10);;
    protected JavascriptExecutor js = (JavascriptExecutor)driver;

}




//   public AbsBaseComponent chooseLocatorType (String locator) {
//       if () {
//
//
//       }
//
//       else {
//
//
//       }





