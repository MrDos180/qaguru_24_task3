package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:config/driver.properties"})
public interface DriverConfig extends Config{
    @Config.Key("browser.name")
    @DefaultValue("chrome")
    String browserName();
    @Config.Key("browser.version")
    @DefaultValue("100.0")
    String browserVersion();
    @Config.Key("browser.size")
    @DefaultValue("1280x720")
    String browserSize();
    @Config.Key("remote.url")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String remoteUrl();
}
