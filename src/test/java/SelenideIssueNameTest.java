import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideIssueNameTest {
    @Test
    public void testIssue80() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        SelenideElement searchField = $(".header-search-input");

        open("https://github.com");
        searchField.click();
        searchField.sendKeys("eroshenkoam/allure-example");
        searchField.submit();
        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $("#issue_80_link").shouldHave(exactText("e.sh"));
    }
}
