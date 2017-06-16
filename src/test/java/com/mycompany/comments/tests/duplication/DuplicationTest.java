package com.mycompany.comments.tests.duplication;

import com.mycompany.comments.models.Comment;
import com.mycompany.comments.pages.EditorPage;
import com.mycompany.comments.pages.IndexPage;
import com.mycompany.comments.pages.Table;
import com.mycompany.comments.tests.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class DuplicationTest extends BaseTest {

    @Test
    public void testDuplication() {
        Table table = new Table();
        int commentNumber = 3;
        Comment testComment = table.getCommentObjFromTable(commentNumber);
        table.getTableRows().get(commentNumber).getCheckbox().click();
        EditorPage editorPage = new IndexPage().clickDuplicateLink();
        assertEquals(editorPage.commentText.val(),String.format("Copy of %s", testComment.getCommentText()));
        assertEquals(editorPage.commentNumber.val(), testComment.getNumber());
        assertEquals(editorPage.iscommentActive.isSelected(), testComment.isActive());
        assertEquals(editorPage.getSelectedCategoriesNames(),testComment.getCategories());

    }
}