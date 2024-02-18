package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.DriverConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBaseRemote {


    @BeforeAll
    static void beforeAll() {
        DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class, System.getProperties());
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = driverConfig.browserSize();
        Configuration.browser = driverConfig.browserName();
        Configuration.browserVersion = driverConfig.browserVersion();
        Configuration.timeout = 10000;
//        Configuration.holdBrowserOpen = true;
        Configuration.remote = driverConfig.remoteUrl();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }

    @BeforeEach
    void beforeEach() {
        System.setProperty("environment", System.getProperty("environment", "stage"));
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}
