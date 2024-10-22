package tests;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebTest extends TestBase {
    @Step("Открыть Github")
    public void openMainPage() {
        open("/");
    }

    @Step("Поиск репозитория {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-button").click();
        $("#query-builder-test").setValue(repo).pressEnter();
    }

    @Step("Пеерейти в репозиторий {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Проверка наличия Issue")
    public void shouldSeeIssue() {
        $("#issues-tab").shouldHave(text("Issues"));
    }

}
