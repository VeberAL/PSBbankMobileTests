package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class SafetyPage {

    private final SelenideElement safetyButtonOk = $(id("logo.com.mbanking:id/btnPrimary")),
            allowButton = $(id("com.android.permissioncontroller:id/permission_allow_button")),
            onlyThisTimeButton = $(id("com.android.permissioncontroller:id/permission_allow_one_time_button")),
            permMessage = $(id("com.android.permissioncontroller:id/permission_message"));

    String locationMessage = "Allow ПСБ to access this device’s location?";

    @Step("Нажатие кнопки Продолжить на странице Настройки системы безопасности.")
    public SafetyPage clickSafetyButton() {
        safetyButtonOk.click();
        return this;
    }

    @Step("Нажатие кнопок подтверждения в сплывающих в случайном порядке окнах.")
    public SafetyPage clickAllowButton() {
        if ("browserstack".equals(System.getProperty("deviceHost")))
            for (int i = 0; i < 3; i++) {
                if (permMessage.getText().equals(locationMessage)) onlyThisTimeButton.click();
                else allowButton.click();
            } else {
        for (int i = 0; i < 5; i++) {
            if (permMessage.getText().equals(locationMessage)) onlyThisTimeButton.click();
            else allowButton.click();
        }}
        return this;
    }
}