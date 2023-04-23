package org.example.PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class AccountPage {

    @FindBy(how = How.XPATH, using = "//button[text()='Выход']")
    private SelenideElement buttonLogout;

    @FindBy(how = How.XPATH, using = "//a[@href = '/account/profile']")
    private SelenideElement linkToAccountProfile;

    @FindBy(how = How.XPATH, using = "//div[@class = 'AppHeader_header__logo__2D0X2']")
    private SelenideElement logoStellarBurgers;

    @FindBy(how = How.XPATH, using = "//p[text()= 'Конструктор']")
    private SelenideElement buttonConstructor;

    public LoginPage clickButtonLogout() {
        buttonLogout.click();
        return page(LoginPage.class);
    }

    public Boolean isConfirmThatAccountPageIsDisplayed() {
        linkToAccountProfile.shouldBe(Condition.visible);
        linkToAccountProfile.isDisplayed();
        return linkToAccountProfile.isDisplayed();
    }

    public MainPage clickLogoStellarBurgers() {
        logoStellarBurgers.click();
        return page(MainPage.class);
    }

    public MainPage clickButtonConstructor() {
        buttonConstructor.click();
        return page(MainPage.class);
    }
}

