package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.HostConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class RealDeviceDriver implements WebDriverProvider {

    HostConfig hostConfig = ConfigFactory.create(HostConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion(hostConfig.platformVersion())
                .setDeviceName(hostConfig.deviceName())
                .setApp(getAppPath())
                .setAppPackage("logo.com.mbanking")
                .setAppActivity("psb.com.mbanking.common.preloader.PreLoaderActivity");

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    public URL getAppiumServerUrl() {
        try {
            return new URL(hostConfig.hostUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAppPath() {
        String appPath = "src/test/resources/apps/psbmobile.apk";
        File app = new File(appPath);
        return app.getAbsolutePath();
    }
}