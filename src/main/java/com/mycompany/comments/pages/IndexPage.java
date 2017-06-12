package com.mycompany.comments.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class IndexPage {

    SelenideElement newLink = $("#newbutton"),
                    dublicateLink = $(".buttonAsLink:nth-child(2)"),
                    editLink = $(".buttonAsLink:nth-child(3)"),
                    deleteLink = $(".buttonAsLink:nth-child(4)"),
                    selectAnActionDropdown = $("#commandSelect"),
                    categoryNameDropdown = $("#SelectedCateg"),
                    statusDropdown = $("#SelectedStatus"),
                    applyButton = $("#applybutton");


    EditorPage clickNewLink() {
        newLink.click();
        return page(EditorPage.class);
    }

    EditorPage clickDuplicateLink() {
        dublicateLink.click();
        return page(EditorPage.class);
    }

    EditorPage clickEditink() {
        editLink.click();
        return page(EditorPage.class);
    }

    DeleteConfirmationPopup clickDeleteLink() {
        deleteLink.click();
        return new DeleteConfirmationPopup();
    }

}
