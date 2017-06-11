package com.mycompany.comments.uimaps;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class IndexPageUIMap {
    SelenideElement newLink;
    SelenideElement dublicateLink;
    SelenideElement editLink;
    SelenideElement deleteLink;
    SelenideElement selectAnActionDropdown;
    SelenideElement categoryNameDropdown;
    SelenideElement statusDropdown;
    SelenideElement applyButton;


    public SelenideElement getNewLink() {
        if (newLink==null){
            newLink = $(By.cssSelector("#newbutton"));
        }
        return newLink;
    }

    public SelenideElement getDublicateLink() {
        if (newLink==null){
            newLink = $(By.cssSelector(".buttonAsLink:nth-child(2)"));
        }
        return dublicateLink;
    }

    public SelenideElement getEditLink() {
        if (newLink==null){
            newLink = $(By.cssSelector(".buttonAsLink:nth-child(3)"));
        }
        return editLink;
    }

    public SelenideElement getDeleteLink() {
        if (newLink==null){
            newLink = $(By.cssSelector(".buttonAsLink:nth-child(4)"));
        }
        return deleteLink;
    }

    public SelenideElement getSelectAnActionDropdown() {
        if (newLink==null){
            newLink = $(By.cssSelector("#commandSelect"));
        }
        return selectAnActionDropdown;
    }

    public SelenideElement getCategoryNameDropdown() {
        if (newLink==null){
            newLink = $(By.cssSelector("#SelectedCateg"));
        }
        return categoryNameDropdown;
    }

    public SelenideElement getStatusDropdown() {
        if (newLink==null){
            newLink = $(By.cssSelector("#SelectedStatus"));
        }
        return statusDropdown;
    }

    public SelenideElement getApplyButton() {
        if (newLink==null){
            newLink = $(By.cssSelector("#applybutton"));
        }
        return applyButton;
    }

}

