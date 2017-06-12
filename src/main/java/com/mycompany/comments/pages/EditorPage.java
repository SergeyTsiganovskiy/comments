package com.mycompany.comments.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EditorPage {
    SelenideElement refresh = $(byText("Refresh")),
                    save = $(byValue("Save")),
                    saveAndReturn = $(byValue("Save & Return")),
                    returnLink = $(byText("Return")),
                    incorectCommentFieldsMessage = $("#errorfield"),
                    commentText = $("#Text"),
                    commentNumber = $("#Number"),
                    iscommentActive = $("#Active"),
                    moveAllToSelectedCategories = $(byValue(">>")),
                    moveCheckedToSelectedCategories = $(byValue(">")),
                    moveAllToAvailableCategories = $(byValue("<<")),
                    moveCheckedToAvailableCategories = $(byValue("<"));
    ElementsCollection  availableCategories = $("#alvailablecategories").findAll("#Categories"),
                        selectedCategories = $("#selectedCategories").findAll("#Categories");
}


