package com.mycompany.comments.pages;

import com.codeborne.selenide.SelenideElement;
import com.mycompany.comments.models.Comment;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Table {

    private SelenideElement nextPaginationLink = $(By.xpath("//a[contains(text(), \">\")]"));
    private List<TableRow> tableRows = setTableRows();

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
            return $(String.format("tbody > tr:nth-child(%d)", numberOfRow)).find(".numbercolumn");
        }

        private SelenideElement setCommentText(int numberOfRow) {
            return $(String.format("tbody > tr:nth-child(%d)", numberOfRow)).find(".textcolumn");
        }

        private SelenideElement setActiveStatus(int numberOfRow) {
            return $(String.format("tbody > tr:nth-child(%d)", numberOfRow)).find(".inactivecolumn");
        }

        private SelenideElement setCateqoryString(int numberOfRow) {
            return $(String.format("tbody > tr:nth-child(%d)", numberOfRow)).find(".categorycolumn");
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

        public List<String> getCategories() {
            List<String> categories = new ArrayList<>();
            String categoryString = getCategoriesString().getText().trim();
            StringTokenizer st = new StringTokenizer(categoryString, ";");
            while (st.hasMoreTokens()) {
                categories.add(st.nextToken().trim());
            }

            return categories;
        }
    }

    public List<TableRow> getTableRows() {
        return tableRows;
    }

    public SelenideElement getNextPaginationLink() {
        return nextPaginationLink;
    }

    private List<TableRow> setTableRows() {
        List<TableRow> content = new ArrayList<>();
        int numberOfRows = $$("tbody > tr").size();
        for (int i = 1; i <= numberOfRows; i++) {
            content.add(new TableRow(i));
        }
        return content;
    }


    public boolean isCommentOnPage(String commentNumber) {
        Table table = new Table();
        boolean isCommentInTable = false;
        for (int i = 0; i < table.getTableRows().size(); i++) {
            if (table.getTableRows().get(i).getCommentNumber().getText().equals(commentNumber)) {
                isCommentInTable = true;
                break;
            }
        }
        return isCommentInTable;
    }

    public boolean isCommentInTable(String commentNumber) {
        boolean isCommentInTable = false;

        while (true) {
            if (isCommentOnPage(commentNumber)) {
                isCommentInTable = true;
                break;
            }

            if (getNextPaginationLink().is(visible)) {
                getNextPaginationLink().click();
            } else break;
        }
        return isCommentInTable;
    }

    public boolean areCommentsInTable(String firstComment, String secondComment) {
        boolean isCommentInTable = false;

        while (true) {
            if (isCommentOnPage(firstComment) && isCommentOnPage(secondComment)) {
                isCommentInTable = true;
                break;
            }

            if (getNextPaginationLink().is(visible)) {
                getNextPaginationLink().click();
            } else break;
        }
        return isCommentInTable;
    }

    public Comment getCommentObjFromTable(int commentNumber) {
        Comment comment = null;
        for (int i = 0; i < this.getTableRows().size(); i++) {
            if (this.getTableRows().get(i).getCommentNumber().getText().equals(String.valueOf(commentNumber))) {
                boolean activeStatus = false;
                if (this.getTableRows().get(i).getActiveCommentText().getText().equals("V")) {
                    activeStatus = true;
                }

                comment = new Comment(this.getTableRows().get(i).getCommentNumber().getText(),
                        this.getTableRows().get(i).getCommentText().getText(),
                        activeStatus,
                        this.getTableRows().get(i).getCategories());
            }
        }
        if (comment == null) {
            throw new RuntimeException("No such comment");
        } else return comment;
    }
}

