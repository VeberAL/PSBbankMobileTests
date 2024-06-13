package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.SafetyPage;

public class PSBOnlineLoginTest extends TestBase {

    SafetyPage safetyPage = new SafetyPage();
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();

    @Test
    @DisplayName("Проверка доступности кнопки Войти при вводе в поле логина трёх символов.")
    void threeSimbolsLoginTest() {
        safetyPage.clickSafetyButton()
                .clickAllowButton();
        mainPage.checkLoginButton()
                .clickEnter()
                .clickBackButton();
        loginPage.clickLoginPageButton()
                .clickLoginPage()
                .enterThreeSimbols()
                .checkLoginEnterButtonAccess();
    }

    @Test
    @DisplayName("Проверка недоступности кнопки Войти при вводе в поле логина двух символов.")
    void twoSimbolsLoginTest() {
        safetyPage.clickSafetyButton()
                .clickAllowButton();
        mainPage.checkLoginButton()
                .clickEnter()
                .clickBackButton();
        loginPage.clickLoginPageButton()
                .clickLoginPage()
                .enterTwoSimbols()
                .checkLoginEnterButtonNotAccess();
    }
}