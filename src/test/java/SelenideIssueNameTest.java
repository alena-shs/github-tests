import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
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
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Issue number to issue name correct mapping")
        );
        Allure.feature("Issue section in a repository - standard");
        Allure.story("Attributes of issues are correct");
        Allure.label("owner", "a.shomanova");
        Allure.label("severity", SeverityLevel.NORMAL.value());

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
