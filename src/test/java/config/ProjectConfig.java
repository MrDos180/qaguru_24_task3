package config;

import org.aeonbits.owner.Config;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${environment}.properties"})
public interface ProjectConfig extends Config{
    @Config.Key("first.name")
    String firstName();
    @Config.Key("last.name")
    String lastName();
}
