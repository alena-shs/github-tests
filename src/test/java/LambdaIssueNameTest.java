import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaIssueNameTest {
    private static final String REPONAME = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 80;
    private static final String ISSUE_NAME = "e.sh";
    SelenideElement searchField = $(".header-search-input");

    @Test
    public void testIssue80() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open the main page", () -> {
            open("https://github.com");
        });
        step("Search for the repo "+REPONAME+" with the search bar", () -> {
            searchField.click();
            searchField.sendKeys(REPONAME);
            searchField.submit();
        });
        step("Open the repo with text "+REPONAME, () -> {
            $(linkText(REPONAME)).click();
        });
        step("Click on ISSUES tab", () -> {
            $("#issues-tab").click();
        });
        step("Check if the name of the issue #"+ ISSUE_NUMBER +" has the name "+ ISSUE_NAME, () -> {
            $("#issue_"+ ISSUE_NUMBER +"_link").shouldHave(exactText(ISSUE_NAME));
        });
    }
}