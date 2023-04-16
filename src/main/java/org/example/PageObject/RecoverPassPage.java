package org.example.PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RecoverPassPage {

    @FindBy(how = How.XPATH, using = "//input[@name = 'name']")
    private SelenideElement inputLoginEmail;

    @FindBy(how = How.XPATH, using = "//button[text() = 'Восстановить']")
    private SelenideElement buttonToResetPasswordForm;

    @FindBy(how = How.XPATH, using = "//a[@href='/login']")
    private SelenideElement linkToLoginForm;

    public LoginPage clickLinkToLoginForm() {
        linkToLoginForm.click();
        return page(LoginPage.class);
    }


}