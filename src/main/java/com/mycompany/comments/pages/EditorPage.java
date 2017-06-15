package com.mycompany.comments.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EditorPage {
    private SelenideElement refresh = $(byText("Refresh"));
    private SelenideElement save = $(byValue("Save"));
    private SelenideElement saveAndReturn = $(byValue("Save & Return"));
    private SelenideElement returnLink = $(byText("Return"));
    private SelenideElement incorectCommentFieldsMessage = $("#errorfield");
    private SelenideElement commentText = $("#Text");
    private SelenideElement commentNumber = $("#Number");
    private SelenideElement iscommentActive = $("#Active");
    private SelenideElement moveAllToSelectedCategories = $(byValue(">>"));
    private SelenideElement moveCheckedToSelectedCategories = $(byValue(">"));
    private SelenideElement moveAllToAvailableCategories = $(byValue("<<"));
    private SelenideElement moveCheckedToAvailableCategories = $(byValue("<"));

    private ElementsCollection  availableCategories =
            $("#alvailablecategories").findAll("#Categories");
    private ElementsCollection  selectedCategories =
            $("#selectedCategories").findAll("#Categories");



}


