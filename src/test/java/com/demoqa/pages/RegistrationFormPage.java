package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsTableComponent;
import com.demoqa.pages.components.StateAndCItyComponent;
import com.demoqa.pages.components.SubjectsComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
    private SubjectsComponent subjectsComponent = new SubjectsComponent();
    private StateAndCItyComponent stateAndCItyComponent = new StateAndCItyComponent();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderButton = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            hobbyCheckbox = $("#hobbiesWrapper"),
            uploadButton = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            submitButton = $("#submit");

    private final static String TITLE_TEXT = "Student Registration Form";

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genderButton.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setUserNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        calendarComponent.setDate(day, month, year);

        return this;
    }


    public RegistrationFormPage setSubjects(String value) {
        subjectsComponent.setSubject(value);

        return this;
    }

    public RegistrationFormPage setHobby(String value) {
        hobbyCheckbox.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage uploadPicture(String value) {
        uploadButton.uploadFile(new File(value));

        return this;
    }

    public RegistrationFormPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationFormPage selectStateAndCity(String state, String city) {
        stateAndCItyComponent.setStateAndCity(state, city);

        return this;
    }

    public RegistrationFormPage clickButton() {
        submitButton.click();

        return this;
    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultsTableComponent.checkVisible();

        return this;
    }

    public RegistrationFormPage checkResults(String key, String value) {
        resultsTableComponent.checkResult(key, value);

        return this;
    }

}
