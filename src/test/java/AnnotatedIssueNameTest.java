import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static data.TestData.*;

public class AnnotatedIssueNameTest {

    @Test
    @Feature("Issue section in a repository")
    @Story("All the attributes of created issues are shown correctly (annotations)")
    @Owner("a.shomanova")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Issue number to issue name correct mapping (annotations)")
    public void issueHasCorrectTextTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        StepsForAnnotatedTest steps = new StepsForAnnotatedTest();

        steps.openMainPage();
        steps.searchForTestRepository(searchField, REPONAME);
        steps.clickOnTestRepository(REPONAME);
        steps.openIssuesTab();
        steps.checkRepositoryName(ISSUE_NUMBER, ISSUE_NAME);

    }
}
