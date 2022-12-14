package components;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.AbsPageObject;

public abstract class AbsBaseComponent extends AbsPageObject {

   public AbsBaseComponent(WebDriver driver) {
        super(driver);
    }

    protected AbsBaseComponent() {
    }

    protected WebDriverWait wait = new WebDriverWait(driver,5);;
    protected JavascriptExecutor js = (JavascriptExecutor)driver;

}









