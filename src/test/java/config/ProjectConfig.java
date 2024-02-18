package config;

import org.aeonbits.owner.Config;


@Config.Sources("classpath:config/${environment}.properties")
public interface ProjectConfig extends Config{
    @Config.Key("first.name")
    @DefaultValue("ivan")
    String firstName();
    @Config.Key("last.name")
    @DefaultValue("ivanov")
    String lastName();
}
