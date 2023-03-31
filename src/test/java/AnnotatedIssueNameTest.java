import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static data.TestData.*;

public class AnnotatedIssueNameTest {

    @Test
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
