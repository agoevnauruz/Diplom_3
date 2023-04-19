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
    @DisplayName("Check links to menu 'Bun', 'Sauces', 'Filling'")
    @Description("Check transitions by clicking on the links 'Bun', 'Sauces', 'Filling' in the menu sections")
    public void checkLinksToMenus() {
        boolean isHeaderBunDisplayed = mainPage
                .clickLinkOrderFilling()
                .clickLinkOrderBun()
                .isConfirmThatHeaderBunIsDisplayed();
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofMillis(10000));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class= 'text text_type_main-default'][text()='Булки']")));
        assertTrue("Transition to the menu section 'Bun' failed", isHeaderBunDisplayed);

        boolean isHeaderSaucesDisplayed = mainPage
                .clickLinkOrderSauces()
                .isConfirmThatHeaderSaucesIsDisplayed();
        assertTrue("Transition to the menu section 'Sauces' failed", isHeaderSaucesDisplayed);

        boolean isHeaderFillingDisplayed = mainPage
                .clickLinkOrderFilling()
                .isConfirmThatHeaderFillingIsDisplayed();
        assertTrue("Transition to the menu section 'Filling' failed", isHeaderFillingDisplayed);
    }
}
