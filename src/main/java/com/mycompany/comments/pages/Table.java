package com.mycompany.comments.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class Table {
    private List<SelenideElement> paginationLinks = $$("td > a");
    private List<TableRow> tableContent = setTableContent();

    public class TableRow {
        private int numberOfRow;
        private SelenideElement checkbox;
        private SelenideElement commentNumber;
        private SelenideElement commentText;
        private SelenideElement activeCommentText;
        private SelenideElement categoriesString;

        public TableRow(int numberOfRow) {
            this.numberOfRow = numberOfRow;
            this.checkbox = setRowCheckBox(numberOfRow);
            this.commentNumber = setCommentNumber(numberOfRow);
            this.commentText = setCommentText(numberOfRow);
            this.activeCommentText = setActiveStatus(numberOfRow);
            this.categoriesString = setCateqoryString(numberOfRow);
        }

        private SelenideElement setRowCheckBox(int numberOfRow) {
            return $(String.format("tbody > tr:nth-child(%d)", numberOfRow)).find("input");
        }

        private SelenideElement setCommentNumber(int numberOfRow) {
            return $(String.format("tbody > tr:nth-child(%d)",numberOfRow)).find(".numbercolumn");
        }

        private SelenideElement setCommentText(int numberOfRow) {
            return $(String.format("tbody > tr:nth-child(%d)",numberOfRow)).find(".textcolumn");
        }

        private SelenideElement setActiveStatus(int numberOfRow) {
            return $(String.format("tbody > tr:nth-child(%d)",numberOfRow)).find(".inactivecolumn");
        }

        private SelenideElement setCateqoryString(int numberOfRow) {
            return $(String.format("tbody > tr:nth-child(%d)",numberOfRow)).find(".categorycolumn");
        }

        public int getNumberOfRow() {
            return numberOfRow;
        }

        public SelenideElement getCheckbox() {
            return checkbox;
        }

        public SelenideElement getCommentNumber() {
            return commentNumber;
        }

        public SelenideElement getCommentText() {
            return commentText;
        }

        public SelenideElement getActiveCommentText() {
            return activeCommentText;
        }

        public SelenideElement getCategoriesString() {
            return categoriesString;
        }

        public List<String> getCategories(){
            List<String> categories = new ArrayList<>();
            String categoryString = getCategoriesString().getText();
            StringTokenizer st = new StringTokenizer(categoryString, ";");
            while(st.hasMoreTokens()){
                categories.add(st.nextToken());
            }

            return categories;
        }
    }

    private List<TableRow> setTableContent() {
        List<TableRow> content = new ArrayList<>();
        int numberOfRows = $$("tbody > tr").size();
        for (int i = 1; i <= numberOfRows; i++) {
            content.add(new TableRow(i));
        }
        return content;
    }

}

