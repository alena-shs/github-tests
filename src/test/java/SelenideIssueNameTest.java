import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

import static data.TestData.*;

public class SelenideIssueNameTest {

    @Test
    public void issueHasCorrectTextTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        searchField.click();
        searchField.sendKeys(REPONAME);
        searchField.submit();
        $(linkText(REPONAME)).click();
        $("#issues-tab").click();
        $("#issue_"+ISSUE_NUMBER+"_link").shouldHave(exactText(ISSUE_NAME));
    }
}
