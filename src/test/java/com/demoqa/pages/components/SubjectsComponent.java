package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SubjectsComponent {

    SelenideElement subjectInput = $("#subjectsInput");

    public SubjectsComponent setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }
}
