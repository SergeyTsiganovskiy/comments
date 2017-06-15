package com.mycompany.comments.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class DeleteConfirmationPopup {
    private SelenideElement message = $("#msgText");
    private SelenideElement yesButton = $(byText("Yes"));
    private SelenideElement noButton = $(byText("Yes"));

    public IndexPage clickYes() {
        yesButton.click();
        return page(IndexPage.class);
    }

    public IndexPage clickNo() {
        noButton.click();
        return page(IndexPage.class);
    }

    public String getMessageText(){
        return message.getText();
    }

}
