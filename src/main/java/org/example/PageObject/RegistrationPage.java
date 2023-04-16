package org.example.PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.example.utils.UserGeneration;

import static com.codeborne.selenide.Selenide.page;


public class RegistrationPage {

    @FindBy(how = How.XPATH, using = "//label[text()='Имя']/following::input[1]")
    private SelenideElement inputUserName;

    @FindBy(how = How.XPATH, using = "//label[text()='Email']/following::input[1]")
    private SelenideElement inputUserEmail;

    @FindBy(how = How.XPATH, using = "//input[@name = 'Пароль']")
    private SelenideElement inputUserPassword;

    @FindBy(how = How.XPATH, using = "//button[text() = 'Зарегистрироваться']")
    private SelenideElement buttonUserRegistration;

    @FindBy(how = How.XPATH, using = "//a[@href='/login']")
    private SelenideElement linkToLoginForm;

    @FindBy(how = How.XPATH, using = "//div[@class = 'input__icon input__icon-action']")
    private SelenideElement checkPassword;

    @FindBy(how = How.XPATH, using = "//p[@class = 'input__error text_type_main-default']")
    private SelenideElement errorPasswordMessage;

    public RegistrationPage setUserName (String userName) {
        inputUserName.shouldBe(Condition.enabled);
        inputUserName.click();
        inputUserName.setValue(userName);
        return this;
    }
    public RegistrationPage setUserEmail (String userEmail) {
        inputUserEmail.shouldBe(Condition.enabled);
        inputUserEmail.click();
        inputUserEmail.setValue(userEmail);
        return this;
    }

    public RegistrationPage setUserPassword (String userPassword) {
        inputUserPassword.shouldBe(Condition.enabled);
        inputUserPassword.click();
        inputUserPassword.setValue(userPassword);
        return this;
    }

    public LoginPage clickButtonUserRegistration() {
        buttonUserRegistration.click();

        return page(LoginPage.class);
    }
    public LoginPage clickLinkToLoginForm() {
        linkToLoginForm.click();
        return page(LoginPage.class);
    }

    public RegistrationPage clickCheckPassword() {
        checkPassword.click();
        return this;
    }

    public RegistrationPage fillRegistrationForm(String userName,String userEmail,String  userPassword) {

        setUserName(userName);
        setUserEmail(userEmail);
        setUserPassword(userPassword);
        return this;
    }

}
