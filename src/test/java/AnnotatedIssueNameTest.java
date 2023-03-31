import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
public class AnnotatedIssueNameTest {
    private static final String REPONAME = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 80;
    private static final String ISSUE_NAME = "e.sh";
    SelenideElement searchField = $(".header-search-input");

    @Test
    public void testIssue80() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        StepsForAnnotatedTest steps = new StepsForAnnotatedTest();

        steps.openMainPage();
        steps.searchForTestRepository(searchField, REPONAME);
        steps.clickOnTestRepository(REPONAME);
        steps.openIssuesTab();
        steps.checkRepositoryName(ISSUE_NUMBER, ISSUE_NAME);

    }
}
