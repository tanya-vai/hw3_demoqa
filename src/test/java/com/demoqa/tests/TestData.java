package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;

import static com.demoqa.utils.RandomUtils.*;
import static com.demoqa.utils.RandomUtils.getRandomHobby;
import static java.lang.String.format;

public class TestData {

    static Faker faker = new Faker();

    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String expectedFullName = format("%s %s", firstName, lastName);
    public static String userEmail = getRandomEmail();
    public static String userGender = getRandomGender();
    public static String userNumber = getRandomPhone();
    public static String day = faker.number().numberBetween(10, 30) + "";
    public static String month = getRandomMonth();
    public static String year = getRandomYear();
    public static String expectedDateOfBirth = format("%s %s,%s", day, month, year);
    public static String subject1 = "Maths";
    public static String subject2 = "English";
    public static String   expectedSubjects = format("%s, %s", subject1, subject2);
    public static String   hobby = getRandomHobby();
    public static String   userAddress = faker.address().fullAddress();
    public static String   state = "NCR";
    public static String    city = "Gurgaon";
    public static String    expectedStateAndCity = format("%s %s", state, city);
    public static String   picturePath = "src/test/resources/PC.png";
    public static String    picture = "PC.png";

    }
