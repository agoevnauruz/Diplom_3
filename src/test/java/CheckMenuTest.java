import io.qameta.allure.junit4.DisplayName;
import org.example.utils.BrowserConfig;
import org.junit.Before;
import org.junit.Test;
import org.example.PageObject.MainPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class CheckMenuTest {
    private MainPage mainPage;

    @Before
    public void startUp() {
        BrowserConfig browserConfig = new BrowserConfig();
        browserConfig.setBrowserName("yandex");
        mainPage = open(baseUrl, MainPage.class);
    }

    @Test
    @DisplayName("Успешный переход к блоку булок")
    public void checkSwitchToBunsSectionTest() {
        mainPage.clickBunsTab();
        boolean isBunsTabActive = mainPage.isBunsTabActive();
        assertTrue("Нет переключения на раздел Булки при клике на таб Булки", isBunsTabActive);
    }

    @Test
    @DisplayName("Успешный переход к блоку соусов")
    public void checkSwitchToSaucesSectionTest() {
        mainPage.clickSauceTab();
        boolean isSaucesTabActive = mainPage.isSaucesTabActive();
        assertTrue("Нет переключения на раздел Соусы при клике на таб Соусы", isSaucesTabActive);
    }

    @Test
    @DisplayName("Успешный переход к блоку начинки")
    public void checkSwitchToToppingsSectionTest() {
        mainPage.clickToppingsTab();
        boolean isFillingsTabActive = mainPage.isFillingsTabActive();
        assertTrue("Нет переключения на раздел Начинки при клике на таб Начинки", isFillingsTabActive);
    }
}
