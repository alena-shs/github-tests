import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class StepsForAnnotatedTest {
    @Step("Open the main page")
    public void openMainPage() {
        open("https://github.com");
    }
    @Step("Search for the repo {repoName} with the search bar")
    public void searchForTestRepository(SelenideElement searchField, String repoName) {
        searchField.click();
        searchField.sendKeys(repoName);
        searchField.submit();
    }

    @Step("Open the repo with text {repoName}")
    public void clickOnTestRepository(String repoName) {
        $(linkText(repoName)).click();
    }

    @Step("Click on ISSUES tab")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Check if the name of the issue {issueNumber} has the name {issueName}")
    public void checkRepositoryName(int issueNumber, String issueName) {
        $("#issue_"+ issueNumber +"_link").shouldHave(exactText(issueName));
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
