package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        //Configuration.holdBrowserOpen = true;
    }

    @AfterAll
    static void closeAllWindows() {
        Selenide.closeWebDriver();
    }
}