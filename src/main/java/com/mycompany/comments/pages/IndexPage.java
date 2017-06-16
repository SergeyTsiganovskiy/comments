package com.mycompany.comments.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class IndexPage {

    private SelenideElement newLink = $("#newbutton");
    private SelenideElement dublicateLink = $(".buttonAsLink:nth-child(2)");
    private SelenideElement editLink = $(".buttonAsLink:nth-child(3)");
    private SelenideElement deleteLink = $(".buttonAsLink:nth-child(4)");
    private SelenideElement selectAnActionDropdown = $("#commandSelect");
    private SelenideElement categoryNameDropdown = $("#SelectedCateg");
    private SelenideElement statusDropdown = $("#SelectedStatus");
    private SelenideElement applyButton = $("#applybutton");


    public EditorPage clickNewLink() {
        newLink.click();
        return page(EditorPage.class);
    }

    public EditorPage clickDuplicateLink() {
        dublicateLink.click();
        return page(EditorPage.class);
    }

    public EditorPage clickEditink() {
        editLink.click();
        return page(EditorPage.class);
    }

    public DeleteConfirmationPopup clickDeleteLink() {
        deleteLink.click();
        return page(DeleteConfirmationPopup.class);
    }

    public void selectAction(String value){
        selectAnActionDropdown.selectOptionByValue(value);
    }

    public void selectCategoryName(String value){
        categoryNameDropdown.selectOptionByValue(value);
    }

    public void selectStatus(String value){
        statusDropdown.selectOptionByValue(value);
    }

    public void clickApply(){
        applyButton.click();
    }
}
