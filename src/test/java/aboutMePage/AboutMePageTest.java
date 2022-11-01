//package aboutMePage;
//
//import driver.DriverFactory;
//import exception.DriverNotSupportedException;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.apache.logging.log4j.LogManager;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.WebDriver;
//import pages.AboutMePage;
//import pages.MainPage;
//
//public class AboutMePageTest {
//
//    private static WebDriver driver;
//    public static org.apache.logging.log4j.Logger logger = LogManager.getLogger(AboutMePageTest.class);
//    private static String testLogin = System.getProperty("testStudent.login");
//    private static String testPassword = System.getProperty("testStudent.password");
//
//    @BeforeAll
//    public static void load() {
//        WebDriverManager.chromedriver().setup();
//    }
//
//    @BeforeEach
//    public void init() throws DriverNotSupportedException {
//        this.driver = new DriverFactory().getDriver();
//    }
//
//    @AfterEach
//    public void close() {
//        if (this.driver != null) {
//            this.driver.close();
//            this.driver.quit();
//        }
//    }
//
//    public static void accessViaMainPage(String login, String password) {
//        new MainPage(driver)
//                .open("");
//
//        MainPage.signIn(login, password);
//        new AboutMePage(driver)
//                .open("/lk/biography/personal/");
//        logger.info("Открыта страница Персональные данные");
//    }
//
//    @Test
//    public void testAboutMePage() {
//     AboutMePageTest.accessViaMainPage(testLogin, testPassword);
//     AboutMePage.fillPersonalData();
//    // AboutMePage.fillGeneralInformation();
//     AboutMePage.continueLaterButton();
//     logger.info("поля заполнены, данные сохранены");
//
//   //  AboutMePage.unSign(); - необходимо разлогиниться
//     //AboutMePageTest.accessViaMainPage(testLogin, testPassword); - необходимо залогиниться и зайти на страницу
////далее проверки:
////     AboutMePage.firstNameRuIsTheSame();
////     AboutMePage.lastNameRuIsTheSame();
////     AboutMePage.lastNameRuIsTheSame();
////     AboutMePage.lastNameEnIsTheSame();
////     AboutMePage.blogNameIsTheSame();
// //    logger.info("сведения сохранены корректно");
//     }
//
//}