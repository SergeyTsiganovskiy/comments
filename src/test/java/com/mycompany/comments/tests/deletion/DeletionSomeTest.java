package com.mycompany.comments.tests.deletion;

import com.mycompany.comments.pages.DeleteConfirmationPopup;
import com.mycompany.comments.pages.IndexPage;
import com.mycompany.comments.pages.Table;
import com.mycompany.comments.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletionSomeTest extends BaseTest {

    @Test
    public void testDeleteSomeComment() {
        IndexPage indexPage = new IndexPage();
        Table table = new Table();
        String FIRST_NUMBER_OF_DELETED_COMMENT = table.getTableRows().get(1).getCommentNumber().getText();
        String SECOND_NUMBER_OF_DELETED_COMMENT = table.getTableRows().get(2).getCommentNumber().getText();
        table.getTableRows().get(1).getCheckbox().click();
        table.getTableRows().get(2).getCheckbox().click();
        indexPage.clickDeleteLink();
        new DeleteConfirmationPopup().clickYes();
        Assert.assertFalse(table.isCommentOnPage(FIRST_NUMBER_OF_DELETED_COMMENT));
        Assert.assertFalse(table.isCommentOnPage(SECOND_NUMBER_OF_DELETED_COMMENT));
    }
}
