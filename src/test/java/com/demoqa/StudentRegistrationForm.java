package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm {

    @BeforeAll
    static void congigure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void fillForm() {
        open("/automation-practice-form");
        $("#firstName").setValue("Tanya");
        $("#lastName").setValue("Vai");
        $("#userEmail").setValue("tanyavai@test.com");
        $("[for=gender-radio-2]").click();
        $("#userNumber").setValue("1234567897");
        $("#dateOfBirthInput").sendKeys(Keys.chord(Keys.CONTROL, "a"));
        $("#dateOfBirthInput").sendKeys("01.02.2001");
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("[for=\"hobbies-checkbox-2\"]").click();
         $("#uploadPicture").uploadFile(new File("src/test/java/../resources/PC.png"));
         $("#currentAddress").setValue("Minsk, Vostochnaya street");
         executeJavaScript("$('footer').remove()");
         executeJavaScript("$('#fixedban').remove()");
         $("#state").click();
         $(byText("NCR")).click();
         $("#city").click();
         $(byText("Gurgaon")).click();
         $("#submit").click();
         $(".modal-body").shouldHave(text("Tanya Vai"), text("tanyavai@test.com"), text("Female"),
                 text("1234567897"), text("02 January,2001"), text("Maths"), text("Reading"), text("PC.png"),
                 text("Minsk, Vostochnaya street"), text("NCR Gurgaon"));
    }
}
