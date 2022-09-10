package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.demoqa.tests.TestData.*;
import static com.demoqa.utils.RandomUtils.*;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

public class RegistrationFormWithPageObjectsTests extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void fillForm() {

        step("Open Registration form page", () -> {
            registrationFormPage.openPage();
                });

        step("Fill registration form", () -> {
            registrationFormPage
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setBirthDate(day, month, year)
                .setSubjects(subject1).setSubjects(subject2)
                .setHobby(hobby)
                .uploadPicture(picturePath)
                .setAddress(userAddress)
                .selectStateAndCity(state, city)
                .clickButton();
                });

        step("Check filled results in the table", () -> {
        registrationFormPage.
                checkResultsTableVisible()
                .checkResults("Student Name", expectedFullName)
                .checkResults("Student Email", userEmail)
                .checkResults("Gender", userGender)
                .checkResults("Mobile", userNumber)
                .checkResults("Date of Birth", expectedDateOfBirth)
                .checkResults("Subjects", expectedSubjects)
                .checkResults("Hobbies", hobby)
                .checkResults("Picture", picture)
                .checkResults("Address", userAddress)
                .checkResults("State and City", expectedStateAndCity);
                });
    }

    @Test
    void fillFormWithMinimumDataTest() {

        step("Open Registration form page", () -> {
        registrationFormPage.openPage();
    });

        step("Fill mandatory fields in registration form", () -> {
        registrationFormPage
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .clickButton();
        });

        step("Check filled results in the table", () -> {
            registrationFormPage
                .checkResultsTableVisible()
                .checkResults("Student Name", expectedFullName)
                .checkResults("Gender", userGender)
                .checkResults("Mobile", userNumber);
        });
    }
}
