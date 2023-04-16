
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.example.API.UserClient;
import org.example.API.Registration;
import org.example.PageObject.MainPage;
import org.example.utils.BrowserConfig;
import org.example.utils.UserGeneration;

import java.io.IOException;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class LoginTest {

    private UserGeneration userGeneration;
    private UserClient userApiClient;
    private Registration userRegister;
    private String accessToken;
    WebDriver driver;
    @Before
    public void startUp() throws IOException {
        BrowserConfig browserConfig = new BrowserConfig();
        browserConfig.setBrowserName("yandex");

//      Создание пользователя
        userApiClient = new UserClient();
        userGeneration = new UserGeneration();
        userRegister = new Registration(userGeneration.userName(),userGeneration.userEmail(),userGeneration.userPassword());

        ValidatableResponse userCreateResponse = userApiClient.register(new Registration(userRegister.getName(), userRegister.getEmail(), userRegister.getPassword()));
        accessToken = userCreateResponse.extract().path("accessToken");

    }

    @After
    public void tearDown() {
        userApiClient.deleteForLogin(accessToken);
        BrowserConfig browserConfig = new BrowserConfig();
        browserConfig.setYandexBrowserProperties();
    }


    @Test
    @DisplayName("Test to check user login - 'Login through the 'Login to Account' button on the main page'")
    @Description("Test to check user login into the system through the 'Login to Account' button on the main page'")
    public void userLoginEnterToSystem()  {

        String userEmail = userRegister.getEmail();
        String  userPassword = userRegister.getPassword();

        MainPage stellarBurgersMainPage = open(baseUrl, MainPage.class);
        boolean  isConfirmThatLoginSuccessful = stellarBurgersMainPage.clickButtonGotoLoginForm()
                .fillLoginForm(userEmail,userPassword)
                .clickButtonLoginEnter()
                .isConfirmThatMainPageIsDisplayed();

        assertTrue("Сожалею,что то пошло не так. Вход в систему не удался", isConfirmThatLoginSuccessful);
    }

    @Test
    @DisplayName("Test to check user login through the 'Account' button")
    @Description("Test to check user login into the system through the 'Account' button on the main page'")
    public void userLoginPersonalCabinet()  {

        String userEmail = userRegister.getEmail();
        String  userPassword = userRegister.getPassword();

        MainPage stellarBurgersMainPage = open(baseUrl, MainPage.class);
        boolean  isConfirmThatLoginSuccessful = stellarBurgersMainPage.clickLinkToAccount()
                .fillLoginForm(userEmail,userPassword)
                .clickButtonLoginEnter()
                .isConfirmThatMainPageIsDisplayed();

        assertTrue("Сожалею,что то пошло не так. Вход в систему не удался", isConfirmThatLoginSuccessful);
    }


    @Test
    @DisplayName("est to check user login through the 'Already registered? Login' link")
    @Description("Test to check user login into the system through the 'Already registered? Login' link on the registration page")
    public void userLoginAlreadyRegistryLink()  {
        String userEmail = userRegister.getEmail();
        String  userPassword = userRegister.getPassword();

       MainPage stellarBurgersMainPage = open(baseUrl, MainPage.class);
        boolean  isConfirmThatLoginSuccessful = stellarBurgersMainPage.clickLinkToAccount()
                .clickLinkRegistration()
                .clickLinkToLoginForm()
                .fillLoginForm(userEmail,userPassword)
                .clickButtonLoginEnter()
                .isConfirmThatMainPageIsDisplayed();

        assertTrue("Сожалею,что то пошло не так. Вход в систему не удался", isConfirmThatLoginSuccessful);
    }

    @Test
    @DisplayName("Test to check user login through the 'Forgot password? Login' link")
    @Description("Test to check user login into the system through the 'Forgot password? Login' link on the password recovery page")
    public void userLoginForgotPasswordLink()  {

        String userEmail = userRegister.getEmail();
        String  userPassword = userRegister.getPassword();

        MainPage mainPage = open(baseUrl, MainPage.class);
        boolean  isConfirmThatLoginSuccessful = mainPage.clickLinkToAccount()
                .clickLinkRecoverPassword()
                .clickLinkToLoginForm()
                .fillLoginForm(userEmail,userPassword)
                .clickButtonLoginEnter()
                .isConfirmThatMainPageIsDisplayed();

        assertTrue("Сожалею,что то пошло не так. Вход в систему не удался", isConfirmThatLoginSuccessful);
    }
}