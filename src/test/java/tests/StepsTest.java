package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;


public class StepsTest extends TestBase {
    private static final String repName = "Jen0v/homework-9";

    @Feature("Поиск Issue в репозитории")
    @DisplayName("Проверка наличия Issues в репозитории")
    @Owner("Jen0v")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "issue", url = "https://github.com/Jen0v/homework-9")
    @Test
    public void lambdaStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открыть Github.", () -> {
            open("/");
        });
        step("Поиск репозитория " + repName, () -> {
            $(".header-search-button").click();
            $("#query-builder-test").setValue(repName).pressEnter();
        });
        step("Пеерейти в репозиторий " + repName, () ->
                $(linkText(repName)).click());

        step("Проверка наличия Issue", () -> {
            $("#issues-tab").shouldHave(text("Issues"));
        });
    }

    @Feature("Поиск Issue в репозитории")
    @DisplayName("Проверка наличия Issues в репозитории")
    @Owner("Jen0v")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "issue", url = "https://github.com/Jen0v/homework-9")
    @Test
    public void annotatedStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebTest steps = new WebTest();

        steps.openMainPage();
        steps.searchForRepository(repName);
        steps.clickOnRepositoryLink(repName);
        steps.shouldSeeIssue();
    }

}
