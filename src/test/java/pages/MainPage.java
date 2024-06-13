package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

public class MainPage {

    private final SelenideElement loginButton = $(id("logo.com.mbanking:id/flContent")),
            backButton = $(className("android.widget.ImageButton"));


    @Step("Проверка появления кнопки Войти.")
    public MainPage checkLoginButton() {
        loginButton.should(exist);
        return this;
    }

    @Step("Нажатие кнопки Войти.")
    public MainPage clickEnter() {
        loginButton.click();
        return this;
    }

    @Step("Нажатие кнопки Назад для выхода из раздела Предложение о кредите.")
    public MainPage clickBackButton() {
        backButton.click();
        return this;
    }
}
