package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:host/${deviceHost}.properties"
})
public interface HostConfig extends Config {

    @Key("host.url")
    @DefaultValue("http://hub.browserstack.com/wd/hub")
    String hostUrl();

    @Key("device.name")
    @DefaultValue("Samsung Galaxy S21")
    String deviceName();

    @Key("platform.version")
    @DefaultValue("11.0")
    String platformVersion();

    @Key("app.url")
    @DefaultValue("bs://5c281e6a79ca426e2837d24d6d2a6cbacccbc1ac")
    String appUrl();
}
