package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends TestBase {
    @Test
    public void searchIssueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("/");
        $(".header-search-button").click();
        $("#query-builder-test").setValue("Jen0v/homework-9").pressEnter();
        $(linkText("Jen0v/homework-9")).click();
        $("#issues-tab").shouldHave(text("Issues"));
    }
}
