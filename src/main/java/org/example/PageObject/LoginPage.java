package org.example.PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    @FindBy(how = How.XPATH, using = "//input[@name = 'name']")
    private SelenideElement inputLoginEmail;
    @FindBy(how = How.XPATH, using = "//input[@name = 'Пароль']")
    private SelenideElement inputLoginPassword;

    @FindBy(how = How.XPATH, using = "//button[text() = 'Войти']")
    private SelenideElement buttonLoginEnter;

    @FindBy(how = How.XPATH, using = "//a[text() = 'Зарегистрироваться']")
    private SelenideElement linkRegistration;

    @FindBy(how = How.XPATH, using = "//a[@href='/forgot-password']")
    private SelenideElement linkForgotPassword;

    @Step("Fill login form with email {userEmail} and password {userPassword}")
    public LoginPage fillLoginForm(String userEmail, String userPassword) {
        setLoginEmail(userEmail);
        setLoginPassword(userPassword);
        return this;
    }
    @Step("Set login email to {userEmail}")
    public LoginPage setLoginEmail(String loginEmail) {
        if (this.inputLoginEmail != null) {
            this.inputLoginEmail.shouldBe(visible).setValue(loginEmail);
        }
        return this;
    }

    @Step("Set login password to {userPassword}")
    public LoginPage setLoginPassword(String userPassword) {
        inputLoginPassword.shouldBe(visible).click();
        inputLoginPassword.setValue(userPassword);
        return this;
    }
    @Step("Click Login button")
    public MainPage clickButtonLoginEnter() {
        buttonLoginEnter.shouldBe(visible).click();
        return page(MainPage.class);
    }
    @Step("Click Registration button")
    public RegistrationPage clickLinkRegistration() {
        linkRegistration.click();
        return page(RegistrationPage.class);
    }
    @Step("Click link to Forgot Password page")
    public RecoverPassPage clickLinkRecoverPassword() {
        linkForgotPassword.click();
        return page(RecoverPassPage.class);
    }
    @Step("Confirm that login page is displayed")
    public boolean isConfirmThatLoginPageIsDisplayed() {
        return inputLoginEmail.isDisplayed();
    }

    @Step("Check that Login page is displayed")
    public boolean confirmThatLoginWebPageIsDisplayed() {
        return inputLoginEmail.isDisplayed();
    }

    @Step("Check that Registration failed")
    public boolean isConfirmThatRegistrationFalls() {
        return linkRegistration.isDisplayed();
    }
}