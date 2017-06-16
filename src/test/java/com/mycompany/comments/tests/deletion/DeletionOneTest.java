package com.mycompany.comments.tests.deletion;

import com.mycompany.comments.pages.DeleteConfirmationPopup;
import com.mycompany.comments.pages.IndexPage;
import com.mycompany.comments.pages.Table;
import com.mycompany.comments.tests.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class DeletionOneTest extends BaseTest {

    @Test
    public void testDeleteOneComment() {
        Table table = new Table();
        String NUMBER_OF_DELETED_COMMENT = table.getTableRows().get(1).getCommentNumber().getText();
        table.getTableRows().get(1).getCheckbox().click();
        new IndexPage().clickDeleteLink();
        new DeleteConfirmationPopup().clickYes();
        assertFalse(table.isCommentInTable(NUMBER_OF_DELETED_COMMENT));
    }
}

