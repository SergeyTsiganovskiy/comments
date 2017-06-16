package com.mycompany.comments.tests.deletion;

import com.mycompany.comments.pages.DeleteConfirmationPopup;
import com.mycompany.comments.pages.IndexPage;
import com.mycompany.comments.pages.Table;
import com.mycompany.comments.tests.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DeletionSomeTest extends BaseTest {

    @Test
    public void testDeleteSomeComment() {
        Table table = new Table();
        String FIRST_NUMBER_OF_DELETED_COMMENT = table.getTableRows().get(1).getCommentNumber().getText();
        String SECOND_NUMBER_OF_DELETED_COMMENT = table.getTableRows().get(2).getCommentNumber().getText();
        table.getTableRows().get(1).getCheckbox().click();
        table.getTableRows().get(2).getCheckbox().click();
        new IndexPage().clickDeleteLink();
        new DeleteConfirmationPopup().clickYes();
        assertFalse(table.areCommentsInTable(FIRST_NUMBER_OF_DELETED_COMMENT, SECOND_NUMBER_OF_DELETED_COMMENT ));
    }
}
