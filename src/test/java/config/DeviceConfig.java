package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${platform}.properties"
})
public interface DeviceConfig extends Config {

    @Key("platform.name")
    @DefaultValue("android")
    String platformName();

    @Key("device.name")
    @DefaultValue("Samsung Galaxy S21")
    String deviceName();

    @Key("platform.version")
    @DefaultValue("11.0")
    String platformVersion();

}