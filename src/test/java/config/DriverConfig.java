package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:config/driver.properties"})
public interface DriverConfig extends Config{
    @DefaultValue("chrome")
    String browserName();
    String browserVersion();
    String browserSize();
    String remoteUrl();
}
