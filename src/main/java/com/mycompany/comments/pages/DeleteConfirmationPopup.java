package com.mycompany.comments.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DeleteConfirmationPopup {
    SelenideElement title = $("#ui-dialog-title-dialog"),
            message = $("#msgText"),
            yesButton = $(byText("Yes")),
            noButton = $(byText("Yes"));

    public IndexPage clickYes() {
        yesButton.click();
        return new IndexPage();
    }

    public IndexPage clickNo() {
        noButton.click();
        return new IndexPage();
    }

}
