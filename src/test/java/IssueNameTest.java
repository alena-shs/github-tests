import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class IssueNameTest {
    @Test
    public void testIssue80() {
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
