package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:config/driver.properties"})
public interface DriverConfig extends Config{
    @Config.Key("browser.name")
    @DefaultValue("chrome")
    String browserName();
    @Config.Key("browser.version")
    String browserVersion();
    @Config.Key("browser.size")
    String browserSize();
    @Config.Key("remote.url")
    String remoteUrl();
}
