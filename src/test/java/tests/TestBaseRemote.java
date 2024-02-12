package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.DriverConfig;
import config.ProjectConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBaseRemote {
    @BeforeAll
    static void beforeAll() {
        System.setProperty("environment", System.getProperty("environment", "stage"));
        ProjectConfig projectConfig = ConfigFactory.create(ProjectConfig.class);
        DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class);

        Configuration.baseUrl = projectConfig.webUrl();
        Configuration.browserSize = driverConfig.browserSize();
        Configuration.browser = driverConfig.browserName();
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

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }

}
