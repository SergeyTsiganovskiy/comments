package com.mycompany.comments.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.mycompany.comments.models.Comment;

import java.util.List;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

// For simplicity all fields are public and there are no any getter

public class EditorPage {
    public SelenideElement refresh = $(byText("Refresh"));
    public SelenideElement save = $(byValue("Save"));
    public SelenideElement saveAndReturn = $(byValue("Save & Return"));
    public SelenideElement returnLink = $(byText("Return"));
    public SelenideElement incorectCommentFieldsMessage = $("#errorfield");
    public SelenideElement commentText = $("#Text");
    public SelenideElement commentNumber = $("#Number");
    public SelenideElement iscommentActive = $("#Active");
    public SelenideElement moveAllToSelectedCategories = $(byValue(">>"));
    public SelenideElement moveCheckedToSelectedCategories = $(byValue(">"));
    public SelenideElement moveAllToAvailableCategories = $(byValue("<<"));
    public SelenideElement moveCheckedToAvailableCategories = $(byValue("<"));

    public ElementsCollection availableCategoryItems =
            $("#alvailablecategories").findAll(".categoryitem");
    public ElementsCollection selectedCategoryItems =
            $("#selectedCategories").findAll(".categoryitem");

    public void fillNewCommentsFields(Comment comment) {
        commentText.setValue(comment.getCommentText());
        commentNumber.setValue(comment.getNumber());
        if (!comment.isActive()) iscommentActive.click();
        setCategories(comment);
        moveCheckedToSelectedCategories.click();
    }

    private void setCategories(Comment comment) {
        List<String> categories = comment.getCategories();
        for (int i = 0; i < categories.size(); i++) {
            for (int j = 0; j < availableCategoryItems.size(); j++)
                if (categories.get(i).equals(availableCategoryItems.get(j).getText()))
                    availableCategoryItems.get(j).find("#Categories").click();
        }
    }
}


