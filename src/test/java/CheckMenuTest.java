
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.utils.BrowserConfig;
import org.junit.Before;
import org.junit.Test;
import org.example.PageObject.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    @DisplayName("Check link to menu 'Bun'")
    @Description("Check transition by clicking on the link 'Bun' in the menu section 'Bun'")
    public void checkLinkToMenuBun() {
        boolean isHeaderBunDisplayed = mainPage
                .clickLinkOrderFilling()
                .clickLinkOrderBun()
                .isConfirmThatHeaderBunIsDisplayed();

        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofMillis(10000));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class= 'text text_type_main-default'][text()='Булки']")));

        assertTrue("Transition to the menu section 'Bun' failed", isHeaderBunDisplayed);
    }


    @Test
    @DisplayName("Check link to menu 'Sauces'")
    @Description("Check transition by clicking on the link 'Sauces' in the menu section 'Sauces'")
    public void checkLinkToMenuSauces() {
        boolean isHeaderSaucesDisplayed = mainPage
                .clickLinkOrderSauces()
                .isConfirmThatHeaderSaucesIsDisplayed();

        assertTrue("Transition to the menu section 'Sauces' failed", isHeaderSaucesDisplayed);
    }

    @Test
    @DisplayName("Check link to menu 'Filling'")
    @Description("Check transition by clicking on the link 'Filling' in the menu section 'Filling'")
    public void checkLinkToMenuFilling() {
        boolean isHeaderFillingDisplayed = mainPage
                .clickLinkOrderFilling()
                .isConfirmThatHeaderFillingIsDisplayed();

        assertTrue("Transition to the menu section 'Filling' failed", isHeaderFillingDisplayed);
    }
}
