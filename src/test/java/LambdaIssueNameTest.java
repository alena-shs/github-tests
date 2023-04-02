import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

import static data.TestData.*;

public class LambdaIssueNameTest {

    @Test
    @Feature("Issue section in a repository - tests with lambda")
    @Story("Attributes of issues are correct")
    @Owner("a.shomanova")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Issue number to issue name correct mapping")
    public void issueHasCorrectTextTest() {
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
