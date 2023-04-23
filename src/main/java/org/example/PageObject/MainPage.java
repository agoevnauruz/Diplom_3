package org.example.PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    @FindBy(how = How.XPATH, using = "//p[@class='AppHeader_header__linkText__3q_va ml-2'][text()='Личный Кабинет']")
    private SelenideElement linkToPersonalCabinet;

    @FindBy(how = How.XPATH, using = "//button[@class= 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    private SelenideElement buttonGoToLoginForm;

    @FindBy(how = How.XPATH, using = "//h1 [text()= 'Соберите бургер']")
    private SelenideElement headerCreateBurger;

    // вкладка Булки
    @FindBy(how = How.CSS, using = ".tab_tab__1SPyG:nth-child(1)")
    private SelenideElement bunsTab;


    // вкладка Соусы
    @FindBy(how = How.CSS, using = ".tab_tab__1SPyG:nth-child(2)")
    private SelenideElement saucesTab;


    // вкладка Начинки
    @FindBy(how = How.CSS, using = ".tab_tab__1SPyG:nth-child(3)")
    private SelenideElement toppingsTab;

    // сохранить в переменную активную секцию
    @FindBy(how = How.CSS, using = ".tab_tab_type_current__2BEPc")
    public SelenideElement activeSection;



    public LoginPage clickLinkToAccount() {
        linkToPersonalCabinet.click();
        return page(LoginPage.class);
    }

    public AccountPage clickLinkToAccountAuthorization() {
        linkToPersonalCabinet.click();
        return page(AccountPage.class);
    }

    public LoginPage clickButtonGotoLoginForm() {
        buttonGoToLoginForm.click();
        return page(LoginPage.class);
    }

    public boolean isConfirmThatMainPageIsDisplayed() {
        headerCreateBurger.shouldBe(Condition.visible);
        return headerCreateBurger.isDisplayed();
    }

    @Step("текст Начинки")
    public boolean isFillingsTabActive() {
        return activeSection.getText().contentEquals("Начинки");
    }

    @Step("вытаскиваем текст активного таба (Соусы)")
    public boolean isSaucesTabActive() {
        return activeSection.getText().contentEquals("Соусы");
    }

    @Step("вытаскиваем текст активной вкладки (Булки)")
    public boolean isBunsTabActive() {
        return activeSection.getText().contentEquals("Булки");
    }

    @Step("клик на вкладку Булки")
    public void clickBunsTab() {
        bunsTab.shouldBe(enabled).doubleClick();
    }

    @Step("клик на вкладку Соусы")
    public void clickSauceTab() {
        saucesTab.shouldBe(enabled).click();
    }

    @Step("клик на вкладку Начинки")
    public void clickToppingsTab() {
        toppingsTab.click();

    }
}

