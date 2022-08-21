package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.demoqa.tests.TestData.*;
import static com.demoqa.utils.RandomUtils.*;
import static java.lang.String.format;

public class RegistrationFormWithPageObjectsTests extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void fillForm() {

        registrationFormPage
                .openPage()
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
                .clickButton()

                .checkResultsTableVisible()
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

    }

    @Test
    void fillFormWithMinimumDataTest() {

        registrationFormPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .clickButton()

                .checkResultsTableVisible()
                .checkResults("Student Name", expectedFullName)
                .checkResults("Gender", userGender)
                .checkResults("Mobile", userNumber);

    }
}
