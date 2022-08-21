package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTableComponent {

    private final static String TITLE_TEXT = "Thanks for submitting the form";
    SelenideElement resultsTable = $(".modal-body"),
            titleOfTable = $("#example-modal-sizes-title-lg"),
            tableValue = $(".table-responsive");


    public ResultsTableComponent checkVisible() {
        resultsTable.should(appear);
        titleOfTable.shouldHave(text(TITLE_TEXT));

        return this;
    }

    public ResultsTableComponent checkResult(String key, String value) {
        tableValue.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }
}
