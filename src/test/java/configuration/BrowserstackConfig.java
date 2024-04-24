package configuration;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
        "classpath:config/bsconfig.properties"})
public interface BrowserstackConfig extends Config {

    @Key("app")
    String applId();


    String device();

    @Key("os_version")
    String osVersion();

    @Key("browserstack_url")
    String browserstackURL();

    String project();


    String build();

    @Key("test_name")
    String testName();

}