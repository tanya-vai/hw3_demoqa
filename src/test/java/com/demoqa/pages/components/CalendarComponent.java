package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CalendarComponent {

    SelenideElement
            dateOfBirthInput = $("#dateOfBirthInput"),
            monthDropdown = $(".react-datepicker__month-select"),
            yearDropdown = $(".react-datepicker__year-select");


    public CalendarComponent setDate(String day, String month, String year) {
        dateOfBirthInput.click();
        monthDropdown.selectOption(month);
        yearDropdown.selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();

        return this;
    }
}
