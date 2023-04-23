        import io.qameta.allure.Description;
        import io.qameta.allure.junit4.DisplayName;
        import io.restassured.response.ValidatableResponse;
        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;
        import org.example.API.UserClient;
        import org.example.API.Registration;
        import org.example.PageObject.MainPage;
        import org.example.utils.BrowserConfig;
        import org.example.utils.UserGeneration;

        import static com.codeborne.selenide.Configuration.baseUrl;
        import static com.codeborne.selenide.Selenide.open;
        import static org.junit.Assert.assertTrue;

        public class CheckLinkTest {

        private UserGeneration userGeneration;
        private UserClient userClient;
        private Registration registration;
        private String accessToken;

        @Before
        public void startUp() {
        BrowserConfig browserConfig = new BrowserConfig();
        browserConfig.setBrowserName("yandex");

        userClient = new UserClient();
        userGeneration = new UserGeneration();
        registration = new Registration(userGeneration.userName(),userGeneration.userEmail(),userGeneration.userPassword());

        ValidatableResponse userCreateResponse = userClient.register(new Registration(registration.getName(), registration.getEmail(), registration.getPassword()));
        accessToken = userCreateResponse.extract().path("accessToken");

        }

        @After
        public void tearDown() {
        userClient.deleteForLogin(accessToken);
        }


        @Test
        @DisplayName("Тест на проверку переход по клику на «Личный кабинет» - авторизированный пользователь") // имя теста
        @Description("Тест на проверку переход по клику на «Личный кабинет» на главной странице, в случае, когда пользователь авторизирован в системе") // описание теста
        public void userCheckLinkPersonalCabinet()  {
        String userEmail = registration.getEmail();
        String  userPassword = registration.getPassword();

        MainPage mainPage = open(baseUrl, MainPage.class);
        boolean  isConfirmThatPersonalCabinetLinkIsSuccessful = mainPage.clickButtonGotoLoginForm()
        .fillLoginForm(userEmail,userPassword)
        .clickButtonLoginEnter()
        .clickLinkToAccountAuthorization()
        .isConfirmThatAccountPageIsDisplayed();

        assertTrue("Сожалею,что то пошло не так. Переход по клику на «Личный кабинет» не удался", isConfirmThatPersonalCabinetLinkIsSuccessful);
        }

        @Test
        @DisplayName("Тест на проверку перехода из «Личного кабинета» по нажатию на логотип «Stellar Burgers» ")
        @Description("Тест на проверку перехода из «Личного кабинета» по нажатию на логотип «Stellar Burgers» на главную страницу")
        public void userCheckLinkLogoStellarBurgers()  {

        String userEmail = registration.getEmail();
        String  userPassword = registration.getPassword();

        MainPage mainPage = open(baseUrl, MainPage.class);
        boolean  isConfirmLogoStellarBurgersIsSuccessful = mainPage.clickLinkToAccount()
        .fillLoginForm(userEmail,userPassword)
        .clickButtonLoginEnter()
        .clickLinkToAccountAuthorization()
        .clickLogoStellarBurgers()
        .isConfirmThatMainPageIsDisplayed();

        assertTrue("Сожалею,что то пошло не так.Переход по нажатию на логотип «Stellar Burgers» не удался", isConfirmLogoStellarBurgersIsSuccessful);
        }

        @Test
        @DisplayName("Тест на проверку перехода из «Личного кабинета» в «Конструктор»")
        @Description("Тест на проверку переход перехода из «Личного кабинета» в «Конструктор»")
        public void userCheckLinkConstructor()  {
        String userEmail = registration.getEmail();
        String  userPassword = registration.getPassword();

        MainPage stellarBurgersMainPage = open(baseUrl, MainPage.class);
        boolean  isConfirmThatButtonConstructorPushIsSuccessful = stellarBurgersMainPage.clickLinkToAccount()
        .fillLoginForm(userEmail,userPassword)
        .clickButtonLoginEnter()
        .clickLinkToAccountAuthorization()
        .clickButtonConstructor()
        .isConfirmThatMainPageIsDisplayed();

        assertTrue("Сожалею,что то пошло не так. Переход по клику на кнопке «Конструктор» не удался", isConfirmThatButtonConstructorPushIsSuccessful);
        }


        @Test
        @DisplayName("Тест на проверку выхода пользователя по кнопке «Выйти» из «Личного кабинета»")
        @Description("Тест на проверку выхода пользователя по кнопке «Выйти» из «Личного кабинета» и проверка перехода на страницу логина")
        public void userLogout()  {

        String userEmail = registration.getEmail();
        String  userPassword = registration.getPassword();

        MainPage mainPage = open(baseUrl, MainPage.class);
        boolean  isConfirmThatLogoutIsOk = mainPage.clickButtonGotoLoginForm()
        .fillLoginForm(userEmail,userPassword)
        .clickButtonLoginEnter()
        .clickLinkToAccountAuthorization()
        .clickButtonLogout()
        .isConfirmThatLoginPageIsDisplayed();

        assertTrue("Сожалею,что то пошло не так. Выход из «Личного кабинета» в систему не удался", isConfirmThatLogoutIsOk);
        }
        }