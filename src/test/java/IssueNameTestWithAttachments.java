import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static data.TestData.*;

public class IssueNameTestWithAttachments {

    @Test
    public void IssueHasCorrectTextTestScreenshot() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        StepsForAnnotatedTest steps = new StepsForAnnotatedTest();

        steps.openMainPage();
        steps.takeScreenshot();
        steps.searchForTestRepository(searchField, REPONAME);
        steps.takeScreenshot();
        steps.clickOnTestRepository(REPONAME);
        steps.takeScreenshot();
        steps.openIssuesTab();
        steps.takeScreenshot();
        steps.checkRepositoryName(ISSUE_NUMBER, ISSUE_NAME);
        steps.takeScreenshot();
    }

    @Test
    public void IssueHasCorrectTextTestSource() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open the main page", () -> {
            open("https://github.com");
        });
        attachment("Source", webdriver().driver().source());
        step("Search for the repo "+ REPONAME +" with the search bar", () -> {
            searchField.click();
            searchField.sendKeys(REPONAME);
            searchField.submit();
        });
        attachment("Source", webdriver().driver().source());        step("Open the repo with text "+ REPONAME, () -> {
            $(linkText(REPONAME)).click();
        });
        step("Click on ISSUES tab", () -> {
            $("#issues-tab").click();
        });
        attachment("Source", webdriver().driver().source());
        step("Check if the name of the issue #"+ ISSUE_NUMBER +" has the name "+ ISSUE_NAME, () -> {
            $("#issue_"+ ISSUE_NUMBER +"_link").shouldHave(exactText(ISSUE_NAME));
        });
        attachment("Source", webdriver().driver().source());
    }
}
