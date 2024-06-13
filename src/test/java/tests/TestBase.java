package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.DeviceConfig;
import drivers.BrowserstackDriver;
import drivers.EmulatorDriver;
import drivers.RealDeviceDriver;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
        Configuration.browser = BrowserstackDriver.class.getName();
        if ("browserstack".equals(System.getProperty("deviceHost")))
            Configuration.browser = BrowserstackDriver.class.getName();
        if ("emulation".equals(System.getProperty("deviceHost")))
            Configuration.browser = EmulatorDriver.class.getName();
        if ("real".equals(System.getProperty("deviceHost"))) Configuration.browser = RealDeviceDriver.class.getName();
    }

    DeviceConfig deviceConfig = ConfigFactory.create(DeviceConfig.class, System.getProperties());

    @BeforeEach
    void beforeEach() {
        System.out.println("Запуск тестов осуществлён на " + System.getProperty("deviceHost") + ".");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        System.out.println("Тест успешно выполнен на " + deviceConfig.platformName() + " (устройство " + System.getProperty("deviceHost") + ").");
        String sessionId = Selenide.sessionId().toString();

        Attachments.pageSource();
        if ("emulation".equals(System.getProperty("deviceHost"))
                || "real".equals(System.getProperty("deviceHost"))) {
            Attachments.screenshotAs("Скриншот");
            closeWebDriver();
        } else {
            closeWebDriver();
            Attachments.addVideo(sessionId);
        }
    }
}

