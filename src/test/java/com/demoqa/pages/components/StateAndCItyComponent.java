package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateAndCItyComponent {

    SelenideElement stateAndCityDropdowns = $("#stateCity-wrapper");

    public StateAndCItyComponent setStateAndCity(String state, String city) {
        $("#state").click();
        stateAndCityDropdowns.$(byText(state)).click();
        $("#city").click();
        stateAndCityDropdowns.$(byText(city)).click();

        return this;
    }
}
