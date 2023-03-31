package data;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TestData {
    public static final String REPONAME = "selenide/selenide";
    public static final int ISSUE_NUMBER = 2238;
    public static final String ISSUE_NAME = "Add support for webkit (safari) browser type";
    public static SelenideElement searchField = $(".header-search-input");
}
