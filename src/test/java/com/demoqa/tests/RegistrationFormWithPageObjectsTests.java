package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormWithPageObjectsTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();


    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillForm() {

        registrationFormPage
                .openPage()
                .setFirstName("Tanya")
                .setLastName("Vai")
                .setEmail("tanyavai@test.com")
                .setGender("Female")
                .setUserNumber("1234567897")
                .setBirthDate("02", "January", "2001")
                .setSubjects("Maths").setSubjects("English")
                .setHobby("Reading")
                .uploadPicture("src/test/resources/PC.png")
                .setAddress("Minsk, Vostochnaya street")
                .selectStateAndCity("NCR", "Gurgaon")
                .clickButton()

                .checkResultsTableVisible()
                .checkResults("Student Name", "Tanya Vai")
                .checkResults("Student Email", "tanyavai@test.com")
                .checkResults("Gender", "Female")
                .checkResults("Mobile", "1234567897")
                .checkResults("Date of Birth", "02 January,2001")
                .checkResults("Subjects", "Maths, English")
                .checkResults("Hobbies", "Reading")
                .checkResults("Picture", "PC.png")
                .checkResults("Address", "Minsk, Vostochnaya street")
                .checkResults("State and City", "NCR Gurgaon");

    }

    @Test
    void fillFormWithMinimumDataTest() {

        registrationFormPage
                .openPage()
                .setFirstName("Tanya")
                .setLastName("Vai")
                .setGender("Female")
                .setUserNumber("1234567897")
                .clickButton()

                .checkResultsTableVisible()
                .checkResults("Student Name", "Tanya Vai")
                .checkResults("Gender", "Female")
                .checkResults("Mobile", "1234567897");

    }
}
