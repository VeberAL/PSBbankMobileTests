package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

public class LoginPage {
    private final ElementsCollection loginField = $$(AppiumBy.className("android.widget.TextView"));
    private final SelenideElement loginPageButton = $(id("logo.com.mbanking:id/navigation_bar_item_icon_view")),
            loginEnterButton = $(id("logo.com.mbanking:id/btnEnter")),
            loginTextViewBrowserstack = $(className("android.widget.EditText"));
    private final SelenideElement loginTextView = $x("//android.widget.AutoCompleteTextView");

    @Step("Выбор раздела Войти в меню.")
    public LoginPage clickLoginPageButton() {
        loginPageButton.click();
        return this;
    }

    @Step("Выбор раздела Войти по логину.")
    public LoginPage clickLoginPage() {
        loginField.findBy(text("ЛОГИН")).click();
        return this;
    }

    @Step("Ввод двух символов в поле ввода логина.")
    public LoginPage enterTwoSimbols() {
        if ("browserstack".equals(System.getProperty("deviceHost")))
            loginTextViewBrowserstack.sendKeys("qw");
        else loginTextView.sendKeys("qw");
        return this;
    }

    @Step("Ввод трёх символов в поле ввода логина.")
    public LoginPage enterThreeSimbols() {
        if ("browserstack".equals(System.getProperty("deviceHost")))
            loginTextViewBrowserstack.sendKeys("qwe");
        else loginTextView.sendKeys("qwe");
        return this;
    }

    @Step("Проверка активности кнопки Войти.")
    public LoginPage checkLoginEnterButtonAccess() {
        loginEnterButton.shouldBe(enabled);
        return this;
    }

    @Step("Проверка неактивности кнопки Войти.")
    public LoginPage checkLoginEnterButtonNotAccess() {
        loginEnterButton.shouldBe(not(enabled));
        return this;
    }
}

