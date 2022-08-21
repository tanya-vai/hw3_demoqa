package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class CalendarComponent {

    SelenideElement
            dateOfBirthInput = $("#dateOfBirthInput"),
            monthDropdown = $(".react-datepicker__month-select"),
            yearDropdown = $(".react-datepicker__year-select");

    String dayButton = ".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)";


    public CalendarComponent setDate(String day, String month, String year) {
        dateOfBirthInput.click();
        monthDropdown.selectOption(month);
        yearDropdown.selectOption(year);
        $(format(dayButton, day)).click();

        return this;
    }
}
