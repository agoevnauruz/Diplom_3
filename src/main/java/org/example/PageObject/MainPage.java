package org.example.PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    @FindBy(how = How.XPATH, using = "//p[@class='AppHeader_header__linkText__3q_va ml-2'][text()='Личный Кабинет']")
    private SelenideElement linkToPersonalCabinet;

    @FindBy(how = How.XPATH, using = "//div[@class = 'AppHeader_header__logo__2D0X2']")
    private SelenideElement logoStellarBurgers;

    @FindBy(how = How.XPATH, using = "//button[@class= 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    private SelenideElement buttonGoToLoginForm;

    @FindBy(how = How.XPATH, using = "//button[text() = 'Оформить заказ']")
    private SelenideElement buttonCreateOrder;

    @FindBy(how = How.XPATH, using = "//h1 [text()= 'Соберите бургер']")
    private SelenideElement headerCreateBurger;

    @FindBy(how = How.XPATH, using = "//span[@class= 'text text_type_main-default'][text()='Булки']")
    private SelenideElement linkOrderBun;

    @FindBy(how = How.XPATH, using = "//span[@class= 'text text_type_main-default'][text()='Соусы']")
    private SelenideElement linkOrderSauces;

    @FindBy(how = How.XPATH, using = "//span[@class= 'text text_type_main-default'][text()='Начинки']")
    private SelenideElement linkOrderFilling;

    @FindBy(how = How.XPATH, using = "//h2[text()= 'Булки']")
    private SelenideElement headerLocatorBun;

    @FindBy(how = How.XPATH, using = "//h2[text()= 'Соусы']")
    private SelenideElement headerLocatorSauces;

    @FindBy(how = How.XPATH, using = "//h2[text()= 'Начинки']")
    private SelenideElement headerLocatorFilling;

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

    public MainPage clickLinkOrderBun() {
        linkOrderBun.click();
        return this;
    }

    public MainPage clickLinkOrderSauces() {
        linkOrderSauces.click();
        return this;
    }

    public MainPage clickLinkOrderFilling() {
        linkOrderFilling.click();
        return this;
    }

    public boolean isConfirmThatHeaderBunIsDisplayed() {
        headerLocatorBun.shouldBe(Condition.visible);
        return headerLocatorBun.isDisplayed();
    }

    public boolean isConfirmThatHeaderSaucesIsDisplayed() {
        headerLocatorSauces.shouldBe(Condition.visible);
        return headerLocatorSauces.isDisplayed();
    }

    public boolean isConfirmThatHeaderFillingIsDisplayed() {
        headerLocatorFilling.shouldBe(Condition.visible);
        return headerLocatorFilling.isDisplayed();
    }

}

