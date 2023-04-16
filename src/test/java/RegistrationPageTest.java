import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.API.UserClient;
import org.example.PageObject.LoginPage;
import org.example.PageObject.MainPage;
import org.example.utils.BrowserConfig;
import org.example.utils.UserGeneration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class RegistrationPageTest {

    private UserGeneration userGeneration;
    private UserClient userClient;
    private String accessToken;

    @Before
    public void startUp() {
        userClient = new UserClient();
        BrowserConfig browserConfig = new BrowserConfig();
        browserConfig.setBrowserName("yandex");
    }

    @After
    public void tearDown() {
        userClient.delete(accessToken);
    }

    @Test
    @DisplayName("Test for checking user creation")
    @Description("Test for checking user creation with correct parameters")
    public void userRegisterWithCorrectParameter() throws InterruptedException {
        userGeneration = new UserGeneration();
        String userName = userGeneration.userName();
        String userEmail = userGeneration.userEmail();
        String userPassword = userGeneration.userPassword();

        MainPage mainPage = open(baseUrl, MainPage.class);
        LoginPage loginPage = new LoginPage();

        boolean isRegistrationSuccessful = mainPage.clickLinkToAccount()
                .clickLinkRegistration()
                .fillRegistrationForm(userName, userEmail, userPassword)
                .clickButtonUserRegistration()
                .confirmThatLoginWebPageIsDisplayed();

        loginPage.fillLoginForm(userEmail, userPassword)
                .clickButtonLoginEnter()
                .isConfirmThatMainPageIsDisplayed();

        accessToken = waitForLocalStorage();

        assertTrue("Сожалею, что-то пошло не так. Регистрация не успешна", isRegistrationSuccessful);
    }

    @Test
    @DisplayName("Test for checking user creation with incorrect password")
    @Description("Test for checking user creation with a password that has fewer than 6 characters")
    public void userRegisterWithIncorrectParameter() {
        userGeneration = new UserGeneration();
        String userName = userGeneration.userName();
        String userEmail = userGeneration.userEmail();
        String userWrongPassword = userGeneration.userWrongPassword();

        MainPage mainPage = open(baseUrl, MainPage.class);

        mainPage.clickLinkToAccount()
                .clickLinkRegistration()
                .fillRegistrationForm(userName, userEmail, userWrongPassword)
                .clickButtonUserRegistration()
                .isConfirmThatRegistrationFalls();
    }

    public String waitForLocalStorage() throws InterruptedException {

        long start_time = System.currentTimeMillis();
        long wait_time = 60000;
        long end_time = start_time + wait_time;

        while (localStorage().getItem("accessToken") != null) {
            Thread.sleep(100);

            if (System.currentTimeMillis() < end_time) {
                break;
            }
        }
        return localStorage().getItem("accessToken").substring(7);
    }
}
